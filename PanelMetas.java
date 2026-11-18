/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

/**
 *
 * @author rinco
 */
public class PanelMetas extends javax.swing.JPanel {

    /**
     * Creates new form PanelMetas
     */
    public PanelMetas() {
    initComponents();
    configurarInterfaz();
}
    
private void configurarInterfaz() {

    // Colores DUQUI
    java.awt.Color MORADO = new java.awt.Color(0x6A1B9A);
    java.awt.Color MORADO_OSCURO = new java.awt.Color(0x3F1D63);
    java.awt.Color NARANJA = new java.awt.Color(0xF7A823);
    java.awt.Color FONDO = new java.awt.Color(0xF7F4FB);
    java.awt.Color BORDE = new java.awt.Color(0xE8DDF0);

    // Fondo general
    setBackground(FONDO);
    setBorder(javax.swing.BorderFactory.createEmptyBorder(18, 20, 18, 20));
    setLayout(new java.awt.BorderLayout(0, 15));

    // Encabezado
    lbTitulo.setFont(new java.awt.Font("Segoe UI", 1, 26));
    lbTitulo.setForeground(MORADO_OSCURO);

    lbDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 14));
    lbDescripcion.setForeground(new java.awt.Color(100, 100, 100));

    javax.swing.JPanel encabezado = new javax.swing.JPanel();
    encabezado.setOpaque(false);
    encabezado.setLayout(new javax.swing.BoxLayout(
            encabezado, javax.swing.BoxLayout.Y_AXIS));

    encabezado.add(lbTitulo);
    encabezado.add(javax.swing.Box.createVerticalStrut(5));
    encabezado.add(lbDescripcion);

    // Tarjetas superiores
    configurarTarjeta(pnMetasActivas, jLabel4, jLabel3, jLabel2, MORADO);
    configurarTarjeta(pnMetasCumplidas, jLabel1, jLabel8, jLabel6, MORADO);
    configurarTarjeta(pnProgreso, jLabel7, jLabel5, jLabel9, MORADO);

    javax.swing.JPanel tarjetas = new javax.swing.JPanel(
            new java.awt.GridLayout(1, 3, 18, 0));
    tarjetas.setOpaque(false);

    tarjetas.add(pnMetasActivas);
    tarjetas.add(pnMetasCumplidas);
    tarjetas.add(pnProgreso);

    tarjetas.setPreferredSize(new java.awt.Dimension(900, 175));
    tarjetas.setMaximumSize(new java.awt.Dimension(
            Integer.MAX_VALUE, 175));

    // Título de objetivos
    lbObjetivos.setFont(new java.awt.Font("Segoe UI", 1, 19));
    lbObjetivos.setForeground(MORADO_OSCURO);
    lbObjetivos.setAlignmentX(LEFT_ALIGNMENT);

    // Primera meta
    configurarMeta(jPanel3, lbNombreMeta, lbEstadoMeta,
            lbCantidadMeta, barraMeta, lbPorcentaje, MORADO);

    // Segunda meta
    configurarMeta(jPanel4, jLabel10, jLabel12,
            jLabel11, barraMeta1, jLabel14, NARANJA);

    // Botón crear meta
    jPanel2.setBackground(MORADO);
    jPanel2.setLayout(new java.awt.BorderLayout());
    jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

    jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14));
    jLabel13.setForeground(java.awt.Color.WHITE);
    jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

    jPanel2.add(jLabel13, java.awt.BorderLayout.CENTER);
    jPanel2.setMaximumSize(new java.awt.Dimension(
            Integer.MAX_VALUE, 48));
    jPanel2.setPreferredSize(new java.awt.Dimension(300, 48));

    // Contenido desplazable
    javax.swing.JPanel contenido = new javax.swing.JPanel();
    contenido.setOpaque(false);
    contenido.setLayout(new javax.swing.BoxLayout(
            contenido, javax.swing.BoxLayout.Y_AXIS));

    contenido.add(tarjetas);
    contenido.add(javax.swing.Box.createVerticalStrut(22));
    contenido.add(lbObjetivos);
    contenido.add(javax.swing.Box.createVerticalStrut(12));
    contenido.add(jPanel3);
    contenido.add(javax.swing.Box.createVerticalStrut(12));
    contenido.add(jPanel4);
    contenido.add(javax.swing.Box.createVerticalStrut(15));
    contenido.add(jPanel2);

    javax.swing.JScrollPane scroll = new javax.swing.JScrollPane(contenido);
    scroll.setBorder(null);
    scroll.setHorizontalScrollBarPolicy(
            javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    scroll.getViewport().setBackground(FONDO);

    // Distribución final
    removeAll();
    add(encabezado, java.awt.BorderLayout.NORTH);
    add(scroll, java.awt.BorderLayout.CENTER);

    revalidate();
    repaint();
}

private void configurarTarjeta(
        javax.swing.JPanel panel,
        javax.swing.JLabel icono,
        javax.swing.JLabel numero,
        javax.swing.JLabel texto,
        java.awt.Color morado) {

    panel.removeAll();
    panel.setLayout(new javax.swing.BoxLayout(
            panel, javax.swing.BoxLayout.Y_AXIS));

    panel.setBackground(java.awt.Color.WHITE);
    panel.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(
                    new java.awt.Color(0xE8DDF0)),
            javax.swing.BorderFactory.createEmptyBorder(12, 8, 12, 8)));

    icono.setAlignmentX(CENTER_ALIGNMENT);
    numero.setAlignmentX(CENTER_ALIGNMENT);
    texto.setAlignmentX(CENTER_ALIGNMENT);

    icono.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    numero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    texto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

    numero.setFont(new java.awt.Font("Segoe UI", 1, 34));
    numero.setForeground(morado);

    texto.setFont(new java.awt.Font("Segoe UI", 1, 13));
    texto.setForeground(new java.awt.Color(0x3F1D63));

    panel.add(icono);
    panel.add(javax.swing.Box.createVerticalStrut(5));
    panel.add(numero);
    panel.add(javax.swing.Box.createVerticalStrut(3));
    panel.add(texto);
}

private void configurarMeta(
        javax.swing.JPanel panel,
        javax.swing.JLabel nombre,
        javax.swing.JLabel estado,
        javax.swing.JLabel cantidad,
        javax.swing.JProgressBar barra,
        javax.swing.JLabel porcentaje,
        java.awt.Color color) {

    panel.removeAll();
    panel.setLayout(new javax.swing.BoxLayout(
            panel, javax.swing.BoxLayout.Y_AXIS));

    panel.setBackground(java.awt.Color.WHITE);
    panel.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(
                    new java.awt.Color(0xE8DDF0)),
            javax.swing.BorderFactory.createEmptyBorder(12, 14, 12, 14)));

    // Nombre y estado
    javax.swing.JPanel fila = new javax.swing.JPanel(
            new java.awt.BorderLayout());
    fila.setOpaque(false);

    nombre.setFont(new java.awt.Font("Segoe UI", 1, 16));
    nombre.setForeground(new java.awt.Color(0x3F1D63));

    estado.setFont(new java.awt.Font("Segoe UI", 1, 12));

    fila.add(nombre, java.awt.BorderLayout.WEST);
    fila.add(estado, java.awt.BorderLayout.EAST);

    // Cantidad
    cantidad.setFont(new java.awt.Font("Segoe UI", 0, 13));

    // Barra de progreso
    barra.setForeground(color);
    barra.setBackground(new java.awt.Color(0xE8DDF0));
    barra.setBorderPainted(false);
    barra.setStringPainted(true);
    barra.setMaximumSize(new java.awt.Dimension(
            Integer.MAX_VALUE, 16));
    barra.setPreferredSize(new java.awt.Dimension(300, 16));

    porcentaje.setForeground(color);
    porcentaje.setFont(new java.awt.Font("Segoe UI", 0, 12));

    panel.add(fila);
    panel.add(javax.swing.Box.createVerticalStrut(8));
    panel.add(cantidad);
    panel.add(javax.swing.Box.createVerticalStrut(10));
    panel.add(barra);
    panel.add(javax.swing.Box.createVerticalStrut(7));
    panel.add(porcentaje);

    panel.setPreferredSize(new java.awt.Dimension(700, 125));
    panel.setMaximumSize(new java.awt.Dimension(
            Integer.MAX_VALUE, 125));
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lbDescripcion = new javax.swing.JLabel();
        pnMetasActivas = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pnMetasCumplidas = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        pnProgreso = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbObjetivos = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lbCantidadMeta = new javax.swing.JLabel();
        lbPorcentaje = new javax.swing.JLabel();
        lbNombreMeta = new javax.swing.JLabel();
        barraMeta = new javax.swing.JProgressBar();
        lbEstadoMeta = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        barraMeta1 = new javax.swing.JProgressBar();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        lbTitulo.setText("Metas");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lbDescripcion.setText("Consigue los objetivos y alcanza nuevos logros");

        pnMetasActivas.setBackground(new java.awt.Color(255, 255, 255));
        pnMetasActivas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Metas activas");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 8, 214));
        jLabel3.setText("03");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/dianaIcon.png"))); // NOI18N

        javax.swing.GroupLayout pnMetasActivasLayout = new javax.swing.GroupLayout(pnMetasActivas);
        pnMetasActivas.setLayout(pnMetasActivasLayout);
        pnMetasActivasLayout.setHorizontalGroup(
            pnMetasActivasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMetasActivasLayout.createSequentialGroup()
                .addGroup(pnMetasActivasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnMetasActivasLayout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jLabel3))
                    .addGroup(pnMetasActivasLayout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(pnMetasActivasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnMetasActivasLayout.setVerticalGroup(
            pnMetasActivasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMetasActivasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(83, 83, 83))
        );

        pnMetasCumplidas.setBackground(new java.awt.Color(255, 255, 255));
        pnMetasCumplidas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/trofIcon.png"))); // NOI18N

        jLabel6.setText("Metas cumplidas");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 8, 214));
        jLabel8.setText("05");

        javax.swing.GroupLayout pnMetasCumplidasLayout = new javax.swing.GroupLayout(pnMetasCumplidas);
        pnMetasCumplidas.setLayout(pnMetasCumplidasLayout);
        pnMetasCumplidasLayout.setHorizontalGroup(
            pnMetasCumplidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMetasCumplidasLayout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addGroup(pnMetasCumplidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMetasCumplidasLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(60, 60, 60))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMetasCumplidasLayout.createSequentialGroup()
                        .addGroup(pnMetasCumplidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnMetasCumplidasLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel8))
                            .addComponent(jLabel1))
                        .addGap(74, 74, 74))))
        );
        pnMetasCumplidasLayout.setVerticalGroup(
            pnMetasCumplidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMetasCumplidasLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addContainerGap())
        );

        pnProgreso.setBackground(new java.awt.Color(255, 255, 255));
        pnProgreso.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/grafica.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 8, 214));
        jLabel5.setText("70%");

        jLabel9.setText("Progreso general");

        javax.swing.GroupLayout pnProgresoLayout = new javax.swing.GroupLayout(pnProgreso);
        pnProgreso.setLayout(pnProgresoLayout);
        pnProgresoLayout.setHorizontalGroup(
            pnProgresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnProgresoLayout.createSequentialGroup()
                .addGroup(pnProgresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnProgresoLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(pnProgresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)))
                    .addGroup(pnProgresoLayout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jLabel9)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        pnProgresoLayout.setVerticalGroup(
            pnProgresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnProgresoLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbObjetivos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbObjetivos.setText("Mis objetivos");

        jPanel2.setBackground(new java.awt.Color(166, 62, 236));
        jPanel2.setForeground(new java.awt.Color(148, 65, 231));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("+ Crear nueva meta");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(340, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(347, 347, 347))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(232, 221, 240)));

        lbCantidadMeta.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbCantidadMeta.setForeground(new java.awt.Color(16, 14, 14));
        lbCantidadMeta.setText("350 / 500 DUNAB");

        lbPorcentaje.setForeground(new java.awt.Color(153, 51, 255));
        lbPorcentaje.setText("70 % completado");

        lbNombreMeta.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbNombreMeta.setText("Acumular 500 DUNAB");

        barraMeta.setBackground(new java.awt.Color(255, 255, 255));
        barraMeta.setForeground(new java.awt.Color(154, 66, 242));
        barraMeta.setValue(70);
        barraMeta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 255)));
        barraMeta.setStringPainted(true);

        lbEstadoMeta.setForeground(new java.awt.Color(0, 204, 0));
        lbEstadoMeta.setText("En progreso");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbPorcentaje)
                    .addComponent(lbCantidadMeta)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addComponent(lbNombreMeta)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbEstadoMeta))
                        .addComponent(barraMeta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 806, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNombreMeta)
                    .addComponent(lbEstadoMeta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbCantidadMeta)
                .addGap(16, 16, 16)
                .addComponent(barraMeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbPorcentaje)
                .addGap(30, 30, 30))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(232, 221, 240)));

        barraMeta1.setBackground(new java.awt.Color(255, 255, 255));
        barraMeta1.setForeground(new java.awt.Color(255, 175, 44));
        barraMeta1.setValue(40);
        barraMeta1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        barraMeta1.setStringPainted(true);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel11.setText("2/5 encuentros");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel10.setText("Participar en 5 encuentros");

        jLabel14.setForeground(new java.awt.Color(239, 143, 51));
        jLabel14.setText("40% completado");

        jLabel12.setForeground(new java.awt.Color(51, 204, 0));
        jLabel12.setText("En progreso");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addContainerGap())
                    .addComponent(jLabel11)
                    .addComponent(barraMeta1, javax.swing.GroupLayout.PREFERRED_SIZE, 804, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(barraMeta1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbObjetivos)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lbDescripcion)
                            .addComponent(pnMetasActivas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(44, 44, 44)
                        .addComponent(pnMetasCumplidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(pnProgreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 1746, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lbDescripcion)
                .addGap(72, 72, 72)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnProgreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnMetasActivas, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnMetasCumplidas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(lbObjetivos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(354, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(lbTitulo)))
                .addContainerGap(144, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barraMeta;
    private javax.swing.JProgressBar barraMeta1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lbCantidadMeta;
    private javax.swing.JLabel lbDescripcion;
    private javax.swing.JLabel lbEstadoMeta;
    private javax.swing.JLabel lbNombreMeta;
    private javax.swing.JLabel lbObjetivos;
    private javax.swing.JLabel lbPorcentaje;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JPanel pnMetasActivas;
    private javax.swing.JPanel pnMetasCumplidas;
    private javax.swing.JPanel pnProgreso;
    // End of variables declaration//GEN-END:variables
}
