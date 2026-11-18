package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public final class Estilo {

    public static final Color MORADO = new Color(0x6A1B9A);
    public static final Color MORADO_OSCURO = new Color(0x3F1D63);
    public static final Color NARANJA = new Color(0xF7A823);
    public static final Color FONDO = new Color(0xF7F4FB);
    public static final Color BORDE = new Color(0xE4D9F0);
    public static final Color GRIS = new Color(0x777777);

    private Estilo() {
    }

    public static JPanel tarjeta() {
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        p.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BORDE),
                BorderFactory.createEmptyBorder(15, 20, 15, 20)));
        return p;
    }

    public static JLabel encabezado(String texto) {
        JLabel l = new JLabel(texto);
        l.setFont(new Font("Segoe UI", Font.BOLD, 28));
        l.setForeground(MORADO);
        return l;
    }

    public static JLabel titulo(String texto) {
        JLabel l = new JLabel(texto);
        l.setFont(new Font("Segoe UI", Font.BOLD, 16));
        l.setForeground(MORADO_OSCURO);
        return l;
    }

    public static JLabel subtitulo(String texto) {
        JLabel l = new JLabel(texto);
        l.setForeground(GRIS);
        return l;
    }

    public static JButton boton(String texto, boolean principal) {
        JButton b = new JButton(texto);
        b.setFont(new Font("Segoe UI", Font.BOLD, 14));
        b.setFocusPainted(false);
        b.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b.setBackground(principal ? MORADO : NARANJA);
        b.setForeground(principal ? Color.WHITE : MORADO_OSCURO);
        return b;
    }
}
