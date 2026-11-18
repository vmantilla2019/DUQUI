package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import modelo.Estudiante;

public class PanelProyeccion extends JPanel {

    private static final Locale CO = Locale.forLanguageTag("es-CO");

    private final MenuPrincipal menu;
    private final JSpinner spnRitmo = new JSpinner(new SpinnerNumberModel(200, 1, 5000, 10));
    private final JLabel lblFaltan = new JLabel();
    private final JLabel lblMeses = new JLabel();
    private final JLabel lblFecha = new JLabel();

    public PanelProyeccion(MenuPrincipal menu) {
        this.menu = menu;
        setLayout(new BorderLayout(0, 20));
        setBackground(Estilo.FONDO);

        JPanel norte = new JPanel(new BorderLayout(0, 4));
        norte.setOpaque(false);
        norte.add(Estilo.encabezado("Proyección"), BorderLayout.NORTH);
        norte.add(Estilo.subtitulo("Estima cuándo alcanzarás los 10.000 DUNAB según tu ritmo mensual"), BorderLayout.CENTER);

        JPanel ritmo = Estilo.tarjeta();
        ritmo.setLayout(new FlowLayout(FlowLayout.LEFT, 12, 0));
        ritmo.add(Estilo.titulo("DUNAB que sumas por mes:"));
        ritmo.add(spnRitmo);

        JPanel fila = new JPanel(new GridLayout(1, 3, 20, 0));
        fila.setOpaque(false);
        fila.add(dato("DUNAB que faltan", lblFaltan, Estilo.NARANJA));
        fila.add(dato("Meses estimados", lblMeses, Estilo.MORADO));
        fila.add(dato("Fecha estimada", lblFecha, Estilo.MORADO));

        JPanel centro = new JPanel(new BorderLayout(0, 20));
        centro.setOpaque(false);
        centro.add(ritmo, BorderLayout.NORTH);
        centro.add(fila, BorderLayout.CENTER);

        JPanel contenedor = new JPanel(new BorderLayout());
        contenedor.setOpaque(false);
        contenedor.add(centro, BorderLayout.NORTH);

        add(norte, BorderLayout.NORTH);
        add(contenedor, BorderLayout.CENTER);

        spnRitmo.addChangeListener(e -> calcular());
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                calcular();
            }
        });
        calcular();
    }

    private JPanel dato(String titulo, JLabel valor, Color color) {
        JPanel p = Estilo.tarjeta();
        p.setLayout(new BorderLayout(0, 6));
        valor.setFont(new Font("Segoe UI", Font.BOLD, 28));
        valor.setForeground(color);
        p.add(Estilo.subtitulo(titulo), BorderLayout.NORTH);
        p.add(valor, BorderLayout.CENTER);
        return p;
    }

    private void calcular() {
        Estudiante est = menu.getSistema().getEstudiante();
        int faltan = est.faltantes();
        int ritmo = (Integer) spnRitmo.getValue();
        lblFaltan.setText(String.format(CO, "%,d", faltan));
        if (faltan == 0) {
            lblMeses.setText("0");
            lblFecha.setText("¡Meta alcanzada!");
            return;
        }
        int meses = (faltan + ritmo - 1) / ritmo;
        lblMeses.setText(String.valueOf(meses));
        lblFecha.setText(LocalDate.now().plusMonths(meses).format(DateTimeFormatter.ofPattern("MMM yyyy", CO)));
    }
}
