package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Scrollable;
import javax.swing.SwingConstants;

public class PanelSobreNosotros extends JPanel {

    private static final String[] INTEGRANTES = {"Valentin", "Valerie", "Kevin"};

    private static final String PORQUE =
            "Somos tres estudiantes de Sistemas de tercer semestre y DUQUI es nuestro proyecto de la materia "
            + "Estructura de Datos.\n\n"
            + "Lo hicimos para que cada estudiante pueda ver en un solo lugar cuántos DUNAB lleva, cuántos le "
            + "faltan para llegar a los 10.000, a qué encuentros puede inscribirse, cuáles son sus metas y cómo va "
            + "en el ranking, sin tener que llevar la cuenta a mano.";

    private static final String APLICAMOS =
            "En el proyecto aplicamos lo visto en clase: listas (ArrayList) para los encuentros, un mapa hash "
            + "(HashMap) para las inscripciones y una pila (ArrayDeque) para la actividad reciente.\n\n"
            + "También usamos programación orientada a objetos (clases abstractas, herencia, interfaces y "
            + "encapsulamiento) y serialización para que tus datos se guarden en un archivo y sigan ahí la próxima "
            + "vez que abras el programa.";

    public PanelSobreNosotros() {
        setLayout(new BorderLayout(0, 20));
        setBackground(Estilo.FONDO);

        JPanel norte = new JPanel(new BorderLayout(0, 4));
        norte.setOpaque(false);
        norte.add(Estilo.encabezado("Sobre nosotros"), BorderLayout.NORTH);
        norte.add(Estilo.subtitulo("Estudiantes de Sistemas de 3er semestre · Proyecto de Estructura de Datos"), BorderLayout.CENTER);

        JPanel fila = new JPanel(new GridLayout(1, 3, 20, 0));
        fila.setOpaque(false);
        for (String nombre : INTEGRANTES) {
            fila.add(tarjetaIntegrante(nombre));
        }

        JPanel textos = new JPanel(new GridLayout(1, 2, 20, 0));
        textos.setOpaque(false);
        textos.add(tarjetaTexto("¿Por qué hicimos DUQUI?", PORQUE));
        textos.add(tarjetaTexto("Lo que aplicamos", APLICAMOS));
        textos.setPreferredSize(new Dimension(100, 330));

        JPanel centro = new Contenido();
        centro.setOpaque(false);
        centro.add(fila, BorderLayout.NORTH);
        centro.add(textos, BorderLayout.CENTER);

        JScrollPane scroll = new JScrollPane(centro);
        scroll.setBorder(BorderFactory.createEmptyBorder());
        scroll.getViewport().setOpaque(false);
        scroll.setOpaque(false);
        scroll.getVerticalScrollBar().setUnitIncrement(16);

        add(norte, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
    }

    private JPanel tarjetaIntegrante(String nombre) {
        JPanel p = Estilo.tarjeta();
        p.setLayout(new BorderLayout(0, 10));

        JPanel avatar = new Avatar(nombre.substring(0, 1));
        JPanel cont = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        cont.setOpaque(false);
        cont.add(avatar);

        JLabel lblNombre = new JLabel(nombre, SwingConstants.CENTER);
        lblNombre.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblNombre.setForeground(Estilo.MORADO);

        JLabel lblCarrera = new JLabel("Estudiante de Sistemas", SwingConstants.CENTER);
        lblCarrera.setForeground(Estilo.GRIS);
        JLabel lblSemestre = new JLabel("3er semestre", SwingConstants.CENTER);
        lblSemestre.setForeground(Estilo.GRIS);

        JPanel textos = new JPanel(new GridLayout(3, 1, 0, 2));
        textos.setOpaque(false);
        textos.add(lblNombre);
        textos.add(lblCarrera);
        textos.add(lblSemestre);

        p.add(cont, BorderLayout.NORTH);
        p.add(textos, BorderLayout.CENTER);
        return p;
    }

    private JPanel tarjetaTexto(String titulo, String texto) {
        JPanel p = Estilo.tarjeta();
        p.setLayout(new BorderLayout(0, 10));

        JTextArea area = new JTextArea(texto);
        area.setEditable(false);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setOpaque(false);
        area.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        area.setForeground(new Color(0x333333));

        p.add(Estilo.titulo(titulo), BorderLayout.NORTH);
        p.add(area, BorderLayout.CENTER);
        return p;
    }

    private static final class Contenido extends JPanel implements Scrollable {

        Contenido() {
            super(new BorderLayout(0, 20));
            setOpaque(false);
        }

        @Override
        public Dimension getPreferredScrollableViewportSize() {
            return getPreferredSize();
        }

        @Override
        public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
            return 16;
        }

        @Override
        public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
            return visibleRect.height;
        }

        @Override
        public boolean getScrollableTracksViewportWidth() {
            return true;
        }

        @Override
        public boolean getScrollableTracksViewportHeight() {
            return false;
        }
    }

    private static final class Avatar extends JPanel {

        private final String inicial;

        Avatar(String inicial) {
            this.inicial = inicial;
            setOpaque(false);
            setPreferredSize(new Dimension(80, 80));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(Estilo.MORADO);
            g2.fillOval(0, 0, getWidth() - 1, getHeight() - 1);
            g2.setColor(Estilo.NARANJA);
            g2.setFont(new Font("Segoe UI", Font.BOLD, 34));
            int x = (getWidth() - g2.getFontMetrics().stringWidth(inicial)) / 2;
            int y = (getHeight() + g2.getFontMetrics().getAscent() - g2.getFontMetrics().getDescent()) / 2;
            g2.drawString(inicial, x, y);
            g2.dispose();
        }
    }
}
