/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

/**
 *
 * @author rinco
 */
public class PanelEstadisticas extends javax.swing.JPanel {

    /**
     * Creates new form PanelEstadisticas
     */
    public PanelEstadisticas() {
        initComponents();
        configurarInterfaz();
        pnActividadMensual.setLayout(new java.awt.BorderLayout());

    GraficoActividad grafico = new GraficoActividad();

    pnActividadMensual.add(
        grafico,
        java.awt.BorderLayout.CENTER
    );

    pnActividadMensual.revalidate();
    pnActividadMensual.repaint();
    organizarDistribucion();
    }
    private void configurarInterfaz() {

    // Colores DUQUI
    java.awt.Color morado = new java.awt.Color(0x6A1B9A);
    java.awt.Color moradoOscuro = new java.awt.Color(0x3F1D63);
    java.awt.Color naranja = new java.awt.Color(0xF7A823);
    java.awt.Color fondo = new java.awt.Color(0xF7F4FB);
    java.awt.Color blanco = java.awt.Color.WHITE;

    // Fondo general
    setBackground(fondo);

    // Tarjetas blancas
    pnAcumulados.setBackground(blanco);
    pnRacha.setBackground(blanco);
    pnEncuentrosRealizados.setBackground(blanco);
    pnMetasCumplidas.setBackground(blanco);
    pnActividadMensual.setBackground(blanco);

    // Títulos principales
    jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 22));
    jLabel1.setForeground(moradoOscuro);

    jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14));
    jLabel2.setForeground(moradoOscuro);

    // Valores de estadísticas
    jLabel7.setForeground(morado);
    jLabel8.setForeground(morado);
    jLabel9.setForeground(morado);
    jLabel10.setForeground(morado);

    // Iconos
    jLabel3.setForeground(naranja);
    jLabel4.setForeground(naranja);

    // Título del gráfico
    jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18));
    jLabel15.setForeground(moradoOscuro);
}
    private void redondearPanel(javax.swing.JPanel panel) {

    panel.setOpaque(false);

    panel.setBorder(new javax.swing.border.AbstractBorder() {

        @Override
        public void paintBorder(
                java.awt.Component c,
                java.awt.Graphics g,
                int x, int y,
                int width, int height) {

            java.awt.Graphics2D g2 =
                    (java.awt.Graphics2D) g.create();

            g2.setRenderingHint(
                    java.awt.RenderingHints.KEY_ANTIALIASING,
                    java.awt.RenderingHints.VALUE_ANTIALIAS_ON
            );

            g2.setColor(java.awt.Color.WHITE);

            g2.fillRoundRect(
                    x, y, width - 1, height - 1,
                    25, 25
            );

            g2.dispose();
        }

        @Override
        public java.awt.Insets getBorderInsets(
                java.awt.Component c) {
            return new java.awt.Insets(0, 0, 0, 0);
        }
    });
}
    private void organizarDistribucion() {

    // Panel que contendrá todo el contenido
    javax.swing.JPanel contenido = new javax.swing.JPanel();
    contenido.setBackground(new java.awt.Color(0xF7F4FB));
    contenido.setLayout(new javax.swing.BoxLayout(
            contenido, javax.swing.BoxLayout.Y_AXIS));

    // Encabezado
    javax.swing.JPanel encabezado = new javax.swing.JPanel();
    encabezado.setBackground(new java.awt.Color(0xF7F4FB));
    encabezado.setLayout(new java.awt.FlowLayout(
            java.awt.FlowLayout.LEFT, 10, 5));

    encabezado.add(jLabel1);
    encabezado.add(jLabel2);

    // Cuatro tarjetas en dos columnas
    javax.swing.JPanel tarjetas = new javax.swing.JPanel(
            new java.awt.GridLayout(2, 2, 20, 20));

    tarjetas.setBackground(new java.awt.Color(0xF7F4FB));
    tarjetas.setBorder(javax.swing.BorderFactory.createEmptyBorder(
            10, 10, 20, 10));
    
    centrarTarjeta(pnAcumulados, jLabel3, jLabel7, jLabel11);

centrarTarjeta(pnRacha, jLabel4, jLabel8, jLabel12);

centrarTarjeta(pnEncuentrosRealizados, jLabel6, jLabel9, jLabel14);

centrarTarjeta(pnMetasCumplidas, jLabel5, jLabel10, jLabel13);
    
    tarjetas.add(pnAcumulados);
    tarjetas.add(pnRacha);
    tarjetas.add(pnEncuentrosRealizados);
    tarjetas.add(pnMetasCumplidas);

    // Agregar contenido
    contenido.add(encabezado);
    contenido.add(tarjetas);
    contenido.add(pnActividadMensual);

    // Desplazamiento vertical
    javax.swing.JScrollPane scroll =
            new javax.swing.JScrollPane(contenido);

    scroll.setBorder(null);
    scroll.getVerticalScrollBar().setUnitIncrement(20);
    scroll.setHorizontalScrollBarPolicy(
            javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    // Mostrar dentro del panel principal
    this.setLayout(new java.awt.BorderLayout());
    this.add(scroll, java.awt.BorderLayout.CENTER);
}
    private void centrarTarjeta(
        javax.swing.JPanel panel,
        javax.swing.JLabel icono,
        javax.swing.JLabel valor,
        javax.swing.JLabel titulo) {

    panel.removeAll();
    panel.setLayout(new java.awt.GridBagLayout());

    java.awt.GridBagConstraints gbc =
            new java.awt.GridBagConstraints();

    gbc.gridx = 0;
    gbc.weightx = 1;
    gbc.anchor = java.awt.GridBagConstraints.CENTER;
    gbc.fill = java.awt.GridBagConstraints.NONE;

    gbc.gridy = 0;
    gbc.insets = new java.awt.Insets(10, 5, 5, 5);
    panel.add(icono, gbc);

    gbc.gridy = 1;
    gbc.insets = new java.awt.Insets(5, 5, 5, 5);
    panel.add(valor, gbc);

    gbc.gridy = 2;
    gbc.insets = new java.awt.Insets(5, 5, 10, 5);
    panel.add(titulo, gbc);

    panel.revalidate();
    panel.repaint();
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pnAcumulados = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        pnRacha = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        pnEncuentrosRealizados = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        pnMetasCumplidas = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        pnActividadMensual = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();

        jLabel1.setText("Mis estadisticas");

        jLabel2.setText("Consulta tu rendimiento en DUQUI");

        pnAcumulados.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/acumuladoIcon.png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 0, 204));
        jLabel7.setText("1.250");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("DUNAB acumulados");

        javax.swing.GroupLayout pnAcumuladosLayout = new javax.swing.GroupLayout(pnAcumulados);
        pnAcumulados.setLayout(pnAcumuladosLayout);
        pnAcumuladosLayout.setHorizontalGroup(
            pnAcumuladosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAcumuladosLayout.createSequentialGroup()
                .addGroup(pnAcumuladosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnAcumuladosLayout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addGroup(pnAcumuladosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(pnAcumuladosLayout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jLabel11)))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        pnAcumuladosLayout.setVerticalGroup(
            pnAcumuladosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAcumuladosLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnRacha.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/rachaIcon.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 0, 204));
        jLabel8.setText("07 dias");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Racha actual");

        javax.swing.GroupLayout pnRachaLayout = new javax.swing.GroupLayout(pnRacha);
        pnRacha.setLayout(pnRachaLayout);
        pnRachaLayout.setHorizontalGroup(
            pnRachaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnRachaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnRachaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel12)
                    .addComponent(jLabel8))
                .addGap(107, 107, 107))
        );
        pnRachaLayout.setVerticalGroup(
            pnRachaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRachaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pnEncuentrosRealizados.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/encuentrosIcon.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 0, 204));
        jLabel9.setText("05");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Encuentros realizados");

        javax.swing.GroupLayout pnEncuentrosRealizadosLayout = new javax.swing.GroupLayout(pnEncuentrosRealizados);
        pnEncuentrosRealizados.setLayout(pnEncuentrosRealizadosLayout);
        pnEncuentrosRealizadosLayout.setHorizontalGroup(
            pnEncuentrosRealizadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnEncuentrosRealizadosLayout.createSequentialGroup()
                .addGroup(pnEncuentrosRealizadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnEncuentrosRealizadosLayout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(jLabel9))
                    .addGroup(pnEncuentrosRealizadosLayout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jLabel14))
                    .addGroup(pnEncuentrosRealizadosLayout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jLabel6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnEncuentrosRealizadosLayout.setVerticalGroup(
            pnEncuentrosRealizadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnEncuentrosRealizadosLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGap(12, 12, 12)
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnMetasCumplidas.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/metasIcon.png"))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 0, 204));
        jLabel10.setText("07");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Metas cumplidas");

        javax.swing.GroupLayout pnMetasCumplidasLayout = new javax.swing.GroupLayout(pnMetasCumplidas);
        pnMetasCumplidas.setLayout(pnMetasCumplidasLayout);
        pnMetasCumplidasLayout.setHorizontalGroup(
            pnMetasCumplidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMetasCumplidasLayout.createSequentialGroup()
                .addContainerGap(111, Short.MAX_VALUE)
                .addGroup(pnMetasCumplidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMetasCumplidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMetasCumplidasLayout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(130, 130, 130))
                        .addGroup(pnMetasCumplidasLayout.createSequentialGroup()
                            .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel13)
                            .addGap(105, 105, 105)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMetasCumplidasLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(148, 148, 148))))
        );
        pnMetasCumplidasLayout.setVerticalGroup(
            pnMetasCumplidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMetasCumplidasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGroup(pnMetasCumplidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnMetasCumplidasLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnMetasCumplidasLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13)))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pnActividadMensual.setBackground(new java.awt.Color(255, 255, 255));

        jLabel15.setText("Actividad mensual");

        javax.swing.GroupLayout pnActividadMensualLayout = new javax.swing.GroupLayout(pnActividadMensual);
        pnActividadMensual.setLayout(pnActividadMensualLayout);
        pnActividadMensualLayout.setHorizontalGroup(
            pnActividadMensualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnActividadMensualLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel15)
                .addContainerGap(730, Short.MAX_VALUE))
        );
        pnActividadMensualLayout.setVerticalGroup(
            pnActividadMensualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnActividadMensualLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel15)
                .addContainerGap(182, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(pnAcumulados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pnEncuentrosRealizados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(pnRacha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pnMetasCumplidas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnActividadMensual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnRacha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnAcumulados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addComponent(pnMetasCumplidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(pnEncuentrosRealizados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(30, 30, 30)
                .addComponent(pnActividadMensual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(195, 195, 195))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel pnActividadMensual;
    private javax.swing.JPanel pnAcumulados;
    private javax.swing.JPanel pnEncuentrosRealizados;
    private javax.swing.JPanel pnMetasCumplidas;
    private javax.swing.JPanel pnRacha;
    // End of variables declaration//GEN-END:variables
}
