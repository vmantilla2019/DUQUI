package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import modelo.Categoria;
import modelo.Encuentro;

public class PanelAdmin extends JPanel {

    private final MenuPrincipal menu;
    private final DefaultTableModel modelo = new DefaultTableModel(
            new String[]{"Encuentro", "Categoría", "Fecha", "Lugar", "DUNAB", "Estado"}, 0) {
        @Override
        public boolean isCellEditable(int fila, int columna) {
            return false;
        }
    };
    private final JTable tabla = new JTable(modelo);
    private final JTextField txtNombre = new JTextField(14);
    private final JComboBox<Categoria> cmbCategoria = new JComboBox<>(Categoria.values());
    private final JTextField txtFecha = new JTextField(8);
    private final JTextField txtLugar = new JTextField(12);
    private final JSpinner spnDunab = new JSpinner(new SpinnerNumberModel(100, 1, 1000, 10));

    public PanelAdmin(MenuPrincipal menu) {
        this.menu = menu;
        setLayout(new BorderLayout(0, 20));
        setBackground(Estilo.FONDO);

        JPanel norte = new JPanel(new BorderLayout(0, 4));
        norte.setOpaque(false);
        norte.add(Estilo.encabezado("Administración"), BorderLayout.NORTH);
        norte.add(Estilo.subtitulo("Crea y elimina encuentros disponibles"), BorderLayout.CENTER);

        JButton agregar = Estilo.boton("Agregar encuentro", true);
        agregar.addActionListener(e -> agregar());

        JPanel formulario = Estilo.tarjeta();
        formulario.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
        formulario.add(new JLabel("Nombre"));
        formulario.add(txtNombre);
        formulario.add(new JLabel("Categoría"));
        formulario.add(cmbCategoria);
        formulario.add(new JLabel("Fecha (dd/MM/aaaa)"));
        formulario.add(txtFecha);
        formulario.add(new JLabel("Lugar"));
        formulario.add(txtLugar);
        formulario.add(new JLabel("DUNAB"));
        formulario.add(spnDunab);
        formulario.add(agregar);

        tabla.setRowHeight(28);
        tabla.setFillsViewportHeight(true);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabla.getTableHeader().setReorderingAllowed(false);
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBorder(BorderFactory.createEmptyBorder());

        JButton eliminar = Estilo.boton("Eliminar seleccionado", false);
        eliminar.addActionListener(e -> eliminar());
        JPanel botones = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        botones.setOpaque(false);
        botones.add(eliminar);

        JPanel lista = Estilo.tarjeta();
        lista.setLayout(new BorderLayout(0, 12));
        lista.add(Estilo.titulo("Encuentros registrados"), BorderLayout.NORTH);
        lista.add(scroll, BorderLayout.CENTER);
        lista.add(botones, BorderLayout.SOUTH);

        JPanel centro = new JPanel(new BorderLayout(0, 20));
        centro.setOpaque(false);
        centro.add(formulario, BorderLayout.NORTH);
        centro.add(lista, BorderLayout.CENTER);

        add(norte, BorderLayout.NORTH);
        add(centro, BorderLayout.CENTER);

        cargar();
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                cargar();
            }
        });
    }

    private void cargar() {
        modelo.setRowCount(0);
        for (Encuentro e : menu.getSistema().getEncuentros()) {
            modelo.addRow(new Object[]{e.getNombre(), e.categoria(), e.getFechaTexto(), e.getLugar(),
                e.getDunab(), menu.getSistema().estadoDe(e)});
        }
    }

    private void agregar() {
        String nombre = txtNombre.getText().trim();
        String fecha = txtFecha.getText().trim();
        String lugar = txtLugar.getText().trim();
        if (nombre.isEmpty() || fecha.isEmpty() || lugar.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Completa nombre, fecha y lugar.", "Administración", JOptionPane.WARNING_MESSAGE);
            return;
        }
        LocalDate dia;
        try {
            dia = LocalDate.parse(fecha, Encuentro.FORMATO);
        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(this, "La fecha debe tener el formato dd/MM/aaaa.", "Administración", JOptionPane.WARNING_MESSAGE);
            return;
        }
        menu.getSistema().agregarEncuentro((Categoria) cmbCategoria.getSelectedItem(), nombre, dia, lugar,
                (Integer) spnDunab.getValue());
        txtNombre.setText("");
        txtFecha.setText("");
        txtLugar.setText("");
        cargar();
        menu.guardarYRefrescar();
    }

    private void eliminar() {
        int fila = tabla.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(this, "Selecciona un encuentro de la tabla.", "Administración", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        int r = JOptionPane.showConfirmDialog(this, "¿Eliminar este encuentro?", "Administración", JOptionPane.YES_NO_OPTION);
        if (r != JOptionPane.YES_OPTION) {
            return;
        }
        List<Encuentro> lista = menu.getSistema().getEncuentros();
        menu.getSistema().eliminarEncuentro(lista.get(fila));
        cargar();
        menu.guardarYRefrescar();
    }
}
