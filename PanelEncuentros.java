/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import modelo.Encuentro;
import modelo.OperacionInvalidaException;

/**
 *
 * @author vmant
 */
public class PanelEncuentros extends javax.swing.JPanel {

    private final MenuPrincipal menu;
    private final DefaultTableModel modelo = new DefaultTableModel(
            new String[]{"Encuentro", "Categoría", "Fecha", "Lugar", "DUNAB", "Estado"}, 0) {
        @Override
        public boolean isCellEditable(int fila, int columna) {
            return false;
        }
    };
    private final JTable tabla = new JTable(modelo);

    /**
     * Creates new form PanelEncuentros
     */
    public PanelEncuentros(MenuPrincipal menu) {
        this.menu = menu;
        initComponents();
        construirInterfaz();
    }

    private void construirInterfaz() {
        setLayout(new BorderLayout(0, 20));
        setBackground(Estilo.FONDO);

        JPanel norte = new JPanel(new BorderLayout(0, 4));
        norte.setOpaque(false);
        norte.add(Estilo.encabezado("Encuentros"), BorderLayout.NORTH);
        norte.add(Estilo.subtitulo("Inscríbete y registra tu asistencia para sumar DUNAB"), BorderLayout.CENTER);

        tabla.setRowHeight(28);
        tabla.setFillsViewportHeight(true);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabla.getTableHeader().setReorderingAllowed(false);
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBorder(BorderFactory.createEmptyBorder());

        JButton inscribir = Estilo.boton("Inscribirme", true);
        JButton asistencia = Estilo.boton("Registrar asistencia", false);
        JButton cancelar = Estilo.boton("Cancelar inscripción", true);
        inscribir.addActionListener(e -> ejecutar(Accion.INSCRIBIR));
        asistencia.addActionListener(e -> ejecutar(Accion.ASISTENCIA));
        cancelar.addActionListener(e -> ejecutar(Accion.CANCELAR));

        JPanel botones = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        botones.setOpaque(false);
        botones.add(inscribir);
        botones.add(asistencia);
        botones.add(cancelar);

        JPanel tarjeta = Estilo.tarjeta();
        tarjeta.setLayout(new BorderLayout(0, 12));
        tarjeta.add(Estilo.titulo("Encuentros disponibles"), BorderLayout.NORTH);
        tarjeta.add(scroll, BorderLayout.CENTER);
        tarjeta.add(botones, BorderLayout.SOUTH);

        add(norte, BorderLayout.NORTH);
        add(tarjeta, BorderLayout.CENTER);

        cargar();
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                cargar();
            }
        });
    }

    private enum Accion { INSCRIBIR, ASISTENCIA, CANCELAR }

    private void cargar() {
        int seleccion = tabla.getSelectedRow();
        modelo.setRowCount(0);
        for (Encuentro e : menu.getSistema().getEncuentros()) {
            modelo.addRow(new Object[]{e.getNombre(), e.categoria(), e.getFechaTexto(), e.getLugar(),
                e.getDunab(), menu.getSistema().estadoDe(e)});
        }
        if (seleccion >= 0 && seleccion < modelo.getRowCount()) {
            tabla.setRowSelectionInterval(seleccion, seleccion);
        }
    }

    private void ejecutar(Accion accion) {
        int fila = tabla.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(this, "Selecciona un encuentro de la tabla.", "Encuentros", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        Encuentro e = menu.getSistema().getEncuentros().get(fila);
        try {
            switch (accion) {
                case INSCRIBIR -> menu.getSistema().inscribir(e);
                case ASISTENCIA -> {
                    menu.getSistema().registrarAsistencia(e);
                    JOptionPane.showMessageDialog(this, "Sumaste " + e.getDunab() + " DUNAB.", "Encuentros", JOptionPane.INFORMATION_MESSAGE);
                }
                case CANCELAR -> menu.getSistema().cancelarInscripcion(e);
            }
        } catch (OperacionInvalidaException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Encuentros", JOptionPane.WARNING_MESSAGE);
            return;
        }
        cargar();
        menu.guardarYRefrescar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
