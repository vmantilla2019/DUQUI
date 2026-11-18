/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

/**
 *
 * @author rinco
 */
public class PanelRanking extends javax.swing.JPanel {

    /**
     * Creates new form PanelRanking
     */
    public PanelRanking() {
        
        
        
        initComponents();
        
        
    // ESTILO DUQUI - FLATLAF

    java.awt.Color MORADO =
            new java.awt.Color(0x6A1B9A);

    java.awt.Color MORADO_OSCURO =
            new java.awt.Color(0x3F1D63);

    java.awt.Color NARANJA =
            new java.awt.Color(0xF7A823);

    java.awt.Color FONDO =
            new java.awt.Color(0xF7F4FB);

    java.awt.Color LILA =
            new java.awt.Color(0xF3EAF8);

    // Fondo general
    setBackground(FONDO);

    // Título
    jLabel1.setFont(new java.awt.Font(
            "Segoe UI", java.awt.Font.BOLD, 26));
    jLabel1.setForeground(MORADO_OSCURO);

    // Título del podio
    jLabel2.setFont(new java.awt.Font(
            "Segoe UI", java.awt.Font.BOLD, 18));
    jLabel2.setForeground(MORADO_OSCURO);

    // Tarjeta de la tabla
    pnTabla.setBackground(FONDO);
    pnTabla.setBorder(
            javax.swing.BorderFactory.createCompoundBorder(
                javax.swing.BorderFactory.createLineBorder(
                    new java.awt.Color(0xE8DDF0)),
                javax.swing.BorderFactory.createEmptyBorder(
                    10, 10, 10, 10)
            )
    );

    // Tabla
    jTable1.setFont(new java.awt.Font(
            "Segoe UI", java.awt.Font.PLAIN, 13));

    jTable1.setRowHeight(55);
    jTable1.setBackground(java.awt.Color.WHITE);
    jTable1.setForeground(MORADO_OSCURO);
    jTable1.setGridColor(new java.awt.Color(0xEEE7F2));
    jTable1.setSelectionBackground(LILA);
    jTable1.setSelectionForeground(MORADO_OSCURO);
    jTable1.setShowVerticalLines(false);
    jTable1.setShowHorizontalLines(true);
    jTable1.setFillsViewportHeight(true);

    // Encabezado de la tabla
    javax.swing.table.JTableHeader encabezado =
            jTable1.getTableHeader();

    encabezado.setFont(new java.awt.Font(
            "Segoe UI", java.awt.Font.BOLD, 13));

    encabezado.setBackground(LILA);
    encabezado.setForeground(MORADO_OSCURO);
    encabezado.setPreferredSize(
            new java.awt.Dimension(0, 40));

    // Scroll de la tabla
    jScrollPane1.setBorder(
            javax.swing.BorderFactory.createEmptyBorder());

    jScrollPane1.getViewport().setBackground(
            java.awt.Color.WHITE);

    // Panel del podio
    

    // Nombres de los estudiantes
    for (javax.swing.JLabel etiqueta :
            new javax.swing.JLabel[]{
                jLabel6, jLabel7, jLabel8}) {

        etiqueta.setFont(new java.awt.Font(
                "Segoe UI", java.awt.Font.BOLD, 12));

        etiqueta.setForeground(MORADO_OSCURO);
    }

    // Números del podio
    for (javax.swing.JLabel numero :
            new javax.swing.JLabel[]{
                jLabel3, jLabel4, jLabel5}) {

        numero.setFont(new java.awt.Font(
                "Segoe UI", java.awt.Font.BOLD, 20));

        numero.setForeground(java.awt.Color.WHITE);

        numero.setHorizontalAlignment(
                javax.swing.SwingConstants.CENTER);
    }


    javax.swing.ImageIcon icono =
        new javax.swing.ImageIcon(
            getClass().getResource("/vista/imagenes/trofeo.png")
        );

    java.awt.Image imagen = icono.getImage()
        .getScaledInstance(100, 100,
            java.awt.Image.SCALE_SMOOTH);

    lblTrofeo.setIcon(new javax.swing.ImageIcon(imagen));
    lblTrofeo.setHorizontalAlignment(
        javax.swing.SwingConstants.CENTER);
    lblTrofeo.setVerticalAlignment(
        javax.swing.SwingConstants.CENTER);
    configurarDistribucion();
}
    
    
private void configurarDistribucion() {

    setLayout(new java.awt.BorderLayout(15, 15));
    setBackground(new java.awt.Color(0xF7F4FB));
    setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));

    // Tarjeta de la tabla
    javax.swing.JPanel panelTabla = new javax.swing.JPanel(new java.awt.BorderLayout());
    panelTabla.setBackground(java.awt.Color.WHITE);
    panelTabla.setBorder(
        javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)
    );
    panelTabla.add(jScrollPane1, java.awt.BorderLayout.CENTER);

    // Tarjeta del podio
    javax.swing.JPanel panelPodio = new javax.swing.JPanel();
    panelPodio.setLayout(new javax.swing.BoxLayout(
        panelPodio, javax.swing.BoxLayout.Y_AXIS));
    panelPodio.setBackground(java.awt.Color.WHITE);
    panelPodio.setBorder(
        javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)
    );

    
jLabel2.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
panelPodio.add(jLabel2);

lblTrofeo.setPreferredSize(new java.awt.Dimension(100, 100));
lblTrofeo.setMinimumSize(new java.awt.Dimension(100, 100));
lblTrofeo.setMaximumSize(new java.awt.Dimension(100, 100));

lblTrofeo.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
panelPodio.add(lblTrofeo);


    javax.swing.JPanel puestos = new javax.swing.JPanel(
        new java.awt.GridLayout(1, 3, 5, 0));
    puestos.setBackground(java.awt.Color.WHITE);
    
    // Altura de cada puesto
jPanel2.setPreferredSize(new java.awt.Dimension(100, 150)); // Segundo
jPanel3.setPreferredSize(new java.awt.Dimension(100, 200)); // Primero
jPanel1.setPreferredSize(new java.awt.Dimension(100, 120)); // Tercero
    
    // Destacar el primer puesto con borde dorado
jPanel3.setBorder(
    javax.swing.BorderFactory.createCompoundBorder(
        javax.swing.BorderFactory.createLineBorder(
            new java.awt.Color(0xF7A823), 4),
        javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2)
    )
);

// Resaltar el número 1
jLabel4.setForeground(new java.awt.Color(0xF7A823));
jLabel4.setFont(new java.awt.Font(
    "Segoe UI", java.awt.Font.BOLD, 26));
    
    puestos.add(crearPuesto(jLabel6, jPanel2)); // Segundo lugar
    puestos.add(crearPuesto(jLabel7, jPanel3)); // Primer lugar
    puestos.add(crearPuesto(jLabel8, jPanel1)); // Tercer lugar
    puestos.setMaximumSize(
    new java.awt.Dimension(Integer.MAX_VALUE, 250)
);
puestos.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
    panelPodio.add(puestos);

    // División 65 % tabla y 35 % podio
    javax.swing.JSplitPane division = new javax.swing.JSplitPane(
        javax.swing.JSplitPane.HORIZONTAL_SPLIT,
        panelTabla,
        panelPodio
    );

    division.setResizeWeight(0.65);
    division.setDividerLocation(0.65);
    division.setDividerSize(5);
    division.setBorder(null);

    removeAll();
    add(jLabel1, java.awt.BorderLayout.NORTH);
    add(division, java.awt.BorderLayout.CENTER);

    revalidate();
    repaint();
}

private javax.swing.JPanel crearPuesto(
        javax.swing.JLabel nombre,
        javax.swing.JPanel escalon) {

    javax.swing.JPanel columna = new javax.swing.JPanel();
    columna.setLayout(new javax.swing.BoxLayout(
        columna, javax.swing.BoxLayout.Y_AXIS));
    columna.setBackground(java.awt.Color.WHITE);

    nombre.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
    escalon.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);

    columna.add(nombre);
columna.add(escalon);
    

    return columna;
}

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        pnTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        lblTrofeo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        jLabel9.setText("jLabel9");

        jLabel1.setText("Ranking de DUNAB");

        pnTabla.setBackground(new java.awt.Color(245, 243, 243));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Integer(1), "Ana Sofia Ramirez", "ing.Sistemas", "30"},
                { new Integer(2), "Luis Fernando Gomez", "Ing.Sistemas", "28"},
                { new Integer(3), "Camilo Ruiz", "Ing.Sistemas", "24"},
                { new Integer(4), "Daniel Perez", "Ing.Industrial", "23"},
                { new Integer(5), "Tomas Villalobos", "Psicologia", "20"},
                { new Integer(6), "Sofia Hernandez", "Derecho", "18"},
                { new Integer(7), "Alisson Hernandez", "Ing.Sistemas", "16"}
            },
            new String [] {
                "#", "Estudiante", "Carrera", "DUNAB Ganados"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setRowHeight(55);
        jTable1.setSelectionForeground(java.awt.SystemColor.activeCaptionBorder);
        jTable1.setShowHorizontalLines(true);
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setText("TOP 3 DUQUI");

        lblTrofeo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/trofeo.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(167, 55, 238));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel5)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(147, 33, 215));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("2");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(41, 41, 41))
        );

        jPanel3.setBackground(new java.awt.Color(117, 0, 192));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("1");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(57, 57, 57))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel4)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        jLabel6.setText("Luis Gomez");

        jLabel7.setText("Ana Sofia Ramirez");

        jLabel8.setText("Camilo Ruiz");

        javax.swing.GroupLayout pnTablaLayout = new javax.swing.GroupLayout(pnTabla);
        pnTabla.setLayout(pnTablaLayout);
        pnTablaLayout.setHorizontalGroup(
            pnTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
                .addGroup(pnTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnTablaLayout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jLabel2))
                    .addGroup(pnTablaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTrofeo, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnTablaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnTablaLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel6)))
                        .addGap(7, 7, 7)
                        .addGroup(pnTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))))
                .addGap(600, 600, 600))
        );
        pnTablaLayout.setVerticalGroup(
            pnTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTablaLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(319, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTablaLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(24, 24, 24)
                .addComponent(lblTrofeo, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(3, 3, 3)
                .addGroup(pnTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnTablaLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnTablaLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(pnTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(pnTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblTrofeo;
    private javax.swing.JPanel pnTabla;
    // End of variables declaration//GEN-END:variables
}
