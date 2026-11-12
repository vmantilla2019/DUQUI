
package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class GraficoActividad extends JPanel {

    private final String[] meses = {
        "Jun", "Jul", "Ago", "Sep", "Oct", "Nov"
    };

    private final int[] valores = {
        120, 180, 150, 250, 210, 340
    };

    private final Color MORADO = new Color(0x6A1B9A);
    private final Color NARANJA = new Color(0xF7A823);
    private final Color TEXTO = new Color(0x3F1D63);
    private final Color GRILLA = new Color(0xE8DDF0);

    public GraficoActividad() {
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(700, 350));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON
        );

        int ancho = getWidth();
        int alto = getHeight();

        // Título
        g2.setColor(TEXTO);
        g2.setFont(new Font("Segoe UI", Font.BOLD, 18));
        g2.drawString("DUNAB obtenidos por mes", 25, 30);

        // Área del gráfico
        int izquierda = 65;
        int derecha = ancho - 30;
        int arriba = 65;
        int abajo = alto - 55;

        int alturaGrafico = abajo - arriba;

        // Líneas horizontales
        g2.setFont(new Font("Segoe UI", Font.PLAIN, 11));

        for (int i = 0; i <= 4; i++) {
            int y = abajo - (alturaGrafico * i / 4);

            g2.setColor(GRILLA);
            g2.drawLine(izquierda, y, derecha, y);

            g2.setColor(TEXTO);
            g2.drawString(
                String.valueOf(i * 100),
                25,
                y + 4
            );
        }

        // Barras
        int espacio = (derecha - izquierda) / valores.length;
        int anchoBarra = Math.min(45, espacio / 2);

        for (int i = 0; i < valores.length; i++) {

            int alturaBarra =
                (valores[i] * alturaGrafico) / 400;

            int x = izquierda + espacio * i
                    + (espacio - anchoBarra) / 2;

            int y = abajo - alturaBarra;

            g2.setColor(i == valores.length - 1
                    ? NARANJA : MORADO);

            g2.fillRoundRect(
                x, y, anchoBarra, alturaBarra,
                12, 12
            );

            // Valor
            g2.setColor(TEXTO);
            g2.setFont(new Font("Segoe UI", Font.BOLD, 11));

            String valor = String.valueOf(valores[i]);

            g2.drawString(
                valor,
                x + (anchoBarra - g2.getFontMetrics()
                    .stringWidth(valor)) / 2,
                y - 8
            );

            // Mes
            g2.setFont(new Font("Segoe UI", Font.PLAIN, 12));

            g2.drawString(
                meses[i],
                x + (anchoBarra - g2.getFontMetrics()
                    .stringWidth(meses[i])) / 2,
                abajo + 22
            );
        }

        g2.dispose();
    }
}
