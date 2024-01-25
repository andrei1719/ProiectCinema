package view;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class GUI {

    private static final int linie = 5;
    private static final int coloana = 4;

    public GUI() {
        JFrame frameButoane = new JFrame("Fereastra principala");
        frameButoane.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameButoane.setResizable(false);
        frameButoane.setVisible(true);
        frameButoane.setSize(600, 500);

        JPanel panouButoane = new JPanel(new GridLayout(4,0));

        JButton butonStergereRezervare = new JButton("Stergere Rezervare");
        JButton butonVerificareCapacitate = new JButton("Verifica capacitate");
        JButton butonRezervare = new JButton("Rezervare");
        JButton butonAfisareRezervariPersoana = new JButton("Afisare rezervari persoana");
        frameButoane.add(panouButoane);


        panouButoane.add(butonRezervare);
        panouButoane.add(butonVerificareCapacitate);
        panouButoane.add(butonStergereRezervare);
        panouButoane.add(butonAfisareRezervariPersoana);

        butonRezervare.addActionListener(e -> {

            JFrame frame = new JFrame("Sala Cinema");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);

            JPanel panouEcran = new JPanel() {
                @Override
                public void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    int inaltimeFereastra = getHeight();
                    int latimeFereastra = getWidth();
                    int inaltimeDreptunghi = inaltimeFereastra / 2;
                    int latimeDreptunghi = latimeFereastra/2;
                    int y = 0;
                    int x = (latimeFereastra - latimeDreptunghi) / 2;
                    g.setColor(Color.gray);
                    g.fillRect(x, y, latimeDreptunghi, inaltimeDreptunghi);
                    g.setColor(Color.black);
                    g.setFont(new Font("Arial", Font.PLAIN, 20));
                    String mesaj = "ECRAN";
                    FontMetrics fontMetrics = g.getFontMetrics();
                    int textWidth = fontMetrics.stringWidth(mesaj);
                    int textHeight = fontMetrics.getHeight();
                    int textX = x + (latimeDreptunghi - textWidth) / 2;
                    int textY = y + (inaltimeDreptunghi - textHeight) / 2 + fontMetrics.getAscent();
                    g.drawString(mesaj, textX, textY);
                }
            };
            frame.add(panouEcran, BorderLayout.CENTER);
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
            frame.setSize(600, 500);

            JPanel buttonPanel = new JPanel(new GridLayout(linie, coloana,10,10));
            buttonPanel.setBorder(new EmptyBorder(10, 20, 200, 20));

            for (int i = 0; i < linie; i++) {
                for (int j = 0; j < coloana; j++) {
                    JButton button = new JButton("Rezerva " + (i * coloana + j + 1));
                    buttonPanel.add(button);
                }
            }
            frame.add(buttonPanel, BorderLayout.SOUTH);
        });



    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GUI());
    }
}
