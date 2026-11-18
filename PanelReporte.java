package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PanelReporte extends JPanel {

    private final MenuPrincipal menu;
    private final JTextArea area = new JTextArea();

    public PanelReporte(MenuPrincipal menu) {
        this.menu = menu;
        setLayout(new BorderLayout(0, 20));
        setBackground(Estilo.FONDO);

        JPanel norte = new JPanel(new BorderLayout(0, 4));
        norte.setOpaque(false);
        norte.add(Estilo.encabezado("Reporte"), BorderLayout.NORTH);
        norte.add(Estilo.subtitulo("Resumen de tu progreso hacia los 10.000 DUNAB"), BorderLayout.CENTER);

        area.setEditable(false);
        area.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        area.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JScrollPane scroll = new JScrollPane(area);
        scroll.setBorder(BorderFactory.createEmptyBorder());

        JButton actualizar = Estilo.boton("Actualizar", true);
        JButton guardar = Estilo.boton("Guardar como .txt", false);
        actualizar.addActionListener(e -> generar());
        guardar.addActionListener(e -> guardar());

        JPanel botones = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        botones.setOpaque(false);
        botones.add(actualizar);
        botones.add(guardar);

        JPanel tarjeta = Estilo.tarjeta();
        tarjeta.setLayout(new BorderLayout(0, 12));
        tarjeta.add(scroll, BorderLayout.CENTER);
        tarjeta.add(botones, BorderLayout.SOUTH);

        add(norte, BorderLayout.NORTH);
        add(tarjeta, BorderLayout.CENTER);

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                generar();
            }
        });
        generar();
    }

    private void generar() {
        area.setText(menu.getSistema().generarReporte());
        area.setCaretPosition(0);
    }

    private void guardar() {
        generar();
        JFileChooser fc = new JFileChooser();
        fc.setSelectedFile(new File("reporte_duqui.txt"));
        if (fc.showSaveDialog(this) != JFileChooser.APPROVE_OPTION) {
            return;
        }
        try {
            Files.writeString(fc.getSelectedFile().toPath(), area.getText(), StandardCharsets.UTF_8);
            JOptionPane.showMessageDialog(this, "Reporte guardado.", "Reporte", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "No se pudo guardar el archivo: " + ex.getMessage(), "Reporte", JOptionPane.ERROR_MESSAGE);
        }
    }
}
