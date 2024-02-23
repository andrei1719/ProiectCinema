package view;

import controller.ClientController;
import model.Client;
import model.SalaCinema;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class GUI {
    private static SalaCinema salaCinema = new SalaCinema();
    private static ClientController clientController = new ClientController();
    private static JLabel userlabel;
    private static JLabel passwordLabel;
    private static JPasswordField passwordText;
    private static JButton butonLOgIn;
    private static JTextField userText;
    private static JLabel mesaj;
    private static JButton butoanComenzi;
    private static final int linie = 5;
    private static final int coloana = 4;
    int locRezervat;
    int randRezervat;
    int count = 0;
    List<Integer> locuriRezervate = new ArrayList<>();
    List<Integer> randuriRezervate = new ArrayList<>();

    public GUI() {

        JFrame frameLogIn = new JFrame("LogIn");
        JPanel panouLogIn = new JPanel();
        frameLogIn.setSize(400, 300);
        frameLogIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameLogIn.setResizable(false);
        frameLogIn.add(panouLogIn);
        frameLogIn.setLocationRelativeTo(null);
        panouLogIn.setLayout(null);

        userlabel = new JLabel("User: ");
        userlabel.setBounds(125, 40, 80, 25);
        panouLogIn.add(userlabel);

        userText = new JTextField(20);
        userText.setBounds(125, 60, 150, 25);
        panouLogIn.add(userText);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(125, 90, 80, 25);
        panouLogIn.add(passwordLabel);

        passwordText = new JPasswordField();
        passwordText.setBounds(125, 110, 150, 25);
        panouLogIn.add(passwordText);

        mesaj = new JLabel();
        mesaj.setBounds(130, 200, 300, 25);
        panouLogIn.add(mesaj);

        butonLOgIn = new JButton("LogIn");
        butonLOgIn.setBounds(150, 150, 80, 25);
        butonLOgIn.setSize(100, 30);
        panouLogIn.add(butonLOgIn);

        butonLOgIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = userText.getText();
                String password = passwordText.getText();


                if (user.equals("a") && password.equals("1")) {

                    frameLogIn.dispose();
                    JFrame frameButoane = new JFrame();
                    JPanel panouButoane = new JPanel();

                    frameButoane.setSize(400, 260);
                    frameButoane.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frameButoane.setResizable(false);
                    frameButoane.setLocationRelativeTo(null);


                    panouButoane.setLayout(null);
                    frameButoane.add(panouButoane);

                    ////////ADAUGARE BUTOANE///////////

                    JButton butonRezervare = new JButton("Rezervare loc");
                    butonRezervare.setBounds(40, 40, 80, 25);
                    butonRezervare.setSize(300, 40);
                    panouButoane.add(butonRezervare);

                    JButton butonStergereRezervare = new JButton("Sterge rezervarea");
                    butonStergereRezervare.setBounds(40, 100, 80, 25);
                    butonStergereRezervare.setSize(300, 40);
                    panouButoane.add(butonStergereRezervare);

                    JButton butonAfisareRezervariPersoana = new JButton("Afisare rezervare pentru:");
                    butonAfisareRezervariPersoana.setBounds(40, 160, 80, 25);
                    butonAfisareRezervariPersoana.setSize(300, 40);
                    panouButoane.add(butonAfisareRezervariPersoana);
                    frameButoane.setVisible(true);

                    butonAfisareRezervariPersoana.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JFrame frameafisareRezervare = new JFrame();
                            frameafisareRezervare.setSize(300,200);
                            frameafisareRezervare.setVisible(true);
                            frameafisareRezervare.setResizable(false);
                            frameafisareRezervare.setLocationRelativeTo(null);

                            JPanel panouAfisareRezervare = new JPanel();
                            frameafisareRezervare.add(panouAfisareRezervare);
                            panouAfisareRezervare.setLayout(null);


                            JTextField textNume = new JTextField("Introduceti numele");
                            textNume.setBounds(50, 40, 200, 25);
                            panouAfisareRezervare.add(textNume);

                            JButton afiseazaRezervari = new JButton("Afiseaza rezultate");
                            afiseazaRezervari.setEnabled(true);
                            afiseazaRezervari.setBounds(50, 80, 200,25);
                            panouAfisareRezervare.add(afiseazaRezervari);

                            afiseazaRezervari.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {

                                    frameafisareRezervare.dispose();

                                    JFrame frameRezervari = new JFrame();
                                    frameRezervari.setSize(600,500);
                                    frameRezervari.setResizable(false);
                                    frameRezervari.setLocationRelativeTo(null);
                                    frameRezervari.setVisible(true);

                                    JPanel panouRezervari = new JPanel();
                                    frameRezervari.add(panouRezervari);
                                    panouRezervari.setLayout(null);



                                    JTextArea textRezervare = new JTextArea();
                                    textRezervare.setBounds(20, 0, 600, 500);

                                    List<Client> listaRezervari = clientController.getReservationByName(textNume.getText());
                                    StringBuilder rezervariText = new StringBuilder();

                                    for (Client rezervare : listaRezervari) {
                                        rezervariText.append("Nume: ").append(rezervare.getNume()).append("\n")
                                                .append("Film: ").append(rezervare.getNumeFilm()).append("\n")
                                                .append("Ora: ").append(rezervare.getOra()).append("\n")
                                                .append("Data: ").append(rezervare.getDataRezervare()).append("\n")
                                                .append("Rand: ").append(rezervare.getRand()).append("\n")
                                                .append("Loc: ").append(rezervare.getLoc()).append("\n\n");
                                    }

                                    textRezervare.setText(rezervariText.toString());
                                    JScrollPane scrollPane = new JScrollPane(textRezervare);
                                    scrollPane.setBounds(0, 0, 600, 500);
                                    panouRezervari.add(scrollPane);
                                }
                            });

                        }
                    });

                    butonStergereRezervare.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JFrame frameStergereNume = new JFrame();
                            frameStergereNume.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            frameStergereNume.setSize(300, 200);
                            frameStergereNume.setVisible(true);
                            frameStergereNume.setResizable(false);
                            frameStergereNume.setLocationRelativeTo(null);

                            JPanel panouStergereNume = new JPanel();
                            frameStergereNume.add(panouStergereNume);
                            panouStergereNume.setLayout(null);

                            JLabel labelStergereNume = new JLabel("Nume");
                            labelStergereNume.setBounds(50, 40, 200, 25);
                            panouStergereNume.add(labelStergereNume);

                            JTextField textStergereNume = new JTextField();
                            textStergereNume.setBounds(50, 60, 200, 25);
                            panouStergereNume.add(textStergereNume);

                            JButton butonStergere = new JButton("Sterge Rezervarea");
                            butonStergere.setBounds(50, 100, 200, 30);
                            panouStergereNume.add(butonStergere);

                            butonStergere.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    clientController.stergeRezervareaByNume(textStergereNume.getText());
                                    frameStergereNume.dispose();
                                }
                            });
                        }
                    });

                    butonRezervare.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            JFrame frameSelectareFilm = new JFrame();
                            frameSelectareFilm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            frameSelectareFilm.setResizable(false);
                            frameSelectareFilm.setSize(400, 700);
                            frameSelectareFilm.setVisible(true);
                            frameSelectareFilm.setLocationRelativeTo(null);

                            JPanel panouSelectareFilm = new JPanel();
                            frameSelectareFilm.add(panouSelectareFilm);
                            panouSelectareFilm.setLayout(null);

                            for (int i = 0; i < SalaCinema.filme.length; i++) {
                                JButton butonFilm = new JButton(SalaCinema.filme[i]);
                                butonFilm.setBounds(40, 40 + (i * (50 + 15)), 300, 50);
                                panouSelectareFilm.add(butonFilm);

                                int finalI = i;
                                int finalI1 = i;
                                butonFilm.addActionListener(new ActionListener() {
                                    String filmSalvat;

                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        filmSalvat = SalaCinema.filme[finalI];

                                        JFrame frameSelectareOra = new JFrame();
                                        frameSelectareOra.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                        frameSelectareOra.setResizable(true);
                                        frameSelectareOra.setSize(400, 605);
                                        frameSelectareOra.setResizable(false);
                                        frameSelectareOra.setVisible(true);
                                        frameSelectareOra.setLocationRelativeTo(null);

                                        JPanel panouSelectareOra = new JPanel();
                                        frameSelectareOra.add(panouSelectareOra);
                                        panouSelectareOra.setLayout(null);
                                        frameSelectareFilm.dispose();


                                        for (int j = 0; j < 7; j++) {
                                            JButton butonSelectareOra = new JButton("Ora " + (10 + j * 2) + ":00");
                                            butonSelectareOra.setBounds(40, 70 + (j * (50 + 15)), 300, 50);
                                            panouSelectareOra.add(butonSelectareOra);
                                            int finalJ = j;
                                            butonSelectareOra.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {

                                                    int oraSalvata = 10 + finalJ * 2;


                                                    JFrame frameSalaCinema = new JFrame("Sala Cinema");
                                                    frameSalaCinema.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                                    frameSalaCinema.setResizable(false);
                                                    frameSalaCinema.setSize(620, 600);
                                                    frameSalaCinema.setVisible(true);
                                                    frameSalaCinema.setLocationRelativeTo(null);

                                                    JPanel panouSalaCinema = new JPanel() {
                                                        @Override
                                                        public void paintComponent(Graphics g) {
                                                            super.paintComponent(g);

                                                            int inaltimeDreptunghi = 60;
                                                            int latimeDreptunghi = 300;
                                                            int y = 0;
                                                            int x = 150;

                                                            g.setColor(Color.gray);
                                                            g.fillRect(x, y, latimeDreptunghi, inaltimeDreptunghi);
                                                            g.setColor(Color.black);
                                                            g.setFont(new Font("Montserrat", Font.PLAIN, 20));
                                                            String mesaj = "ECRAN";
                                                            FontMetrics fontMetrics = g.getFontMetrics();
                                                            int textWidth = fontMetrics.stringWidth(mesaj);
                                                            int textHeight = fontMetrics.getHeight();
                                                            int textX = x + (latimeDreptunghi - textWidth) / 2;
                                                            int textY = y + (inaltimeDreptunghi - textHeight) / 2 + fontMetrics.getAscent();
                                                            g.drawString(mesaj, textX, textY);
                                                            frameSelectareOra.dispose();

                                                        }
                                                    };

                                                    frameSalaCinema.add(panouSalaCinema);
                                                    panouSalaCinema.setLayout(null);


                                                    for (int k = 0; k < linie; k++) {
                                                        for (int l = 0; l < coloana; l++) {
                                                            JButton butonRezervare = new JButton();
                                                            butonRezervare.setBounds((85 + (k * (70 + 20))), (100 + (l * (70 + 20))), 70, 70);
                                                            int finalK = k + 1;
                                                            int finalL = l + 1;

                                                            List<Client> client1 = clientController.getClientByFilmSiOra(filmSalvat, oraSalvata);
                                                            for (Client c : client1) {
                                                                if (c.getRand() == finalL && c.getLoc() == finalK) {
                                                                    butonRezervare.setBackground(Color.red);
                                                                    butonRezervare.setEnabled(false);
                                                                }
                                                            }

                                                            panouSalaCinema.add(butonRezervare);
                                                            int finalK1 = k;
                                                            int finalL1 = l;

                                                            butonRezervare.addActionListener(new ActionListener() {


                                                                @Override
                                                                public void actionPerformed(ActionEvent e) {
                                                                    count++;

                                                                    butonRezervare.setBackground(Color.green);
                                                                    locRezervat = finalK1 + 1;
                                                                    randRezervat = finalL1 + 1;
                                                                    locuriRezervate.add(locRezervat);
                                                                    randuriRezervate.add(randRezervat);
                                                                    if (butonRezervare.getBackground().equals(Color.green))
                                                                        ;
                                                                    {
                                                                        butonRezervare.setEnabled(false);
                                                                    }
                                                                }
                                                            });

                                                            JButton butonPasulUrmator = new JButton("Pasul urmator");
                                                            butonPasulUrmator.setBounds(350, 470, 200, 50);
                                                            panouSalaCinema.add(butonPasulUrmator);

                                                            butonPasulUrmator.addActionListener(new ActionListener() {
                                                                @Override
                                                                public void actionPerformed(ActionEvent e) {
                                                                    JFrame frameNume = new JFrame();
                                                                    frameNume.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                                                    frameNume.setResizable(false);
                                                                    frameNume.setSize(400, 300);
                                                                    frameNume.setVisible(true);
                                                                    frameNume.setLocationRelativeTo(null);

                                                                    JPanel panouNume = new JPanel();
                                                                    frameNume.add(panouNume);
                                                                    panouNume.setLayout(null);

                                                                    JLabel numeLabel = new JLabel("Nume:");
                                                                    numeLabel.setBounds(50, 55, 200, 25);
                                                                    panouNume.add(numeLabel);

                                                                    JTextField numeText = new JTextField();
                                                                    numeText.setBounds(100, 55, 200, 25);
                                                                    panouNume.add(numeText);

                                                                    JLabel emailLabel = new JLabel("Email");
                                                                    emailLabel.setBounds(50, 95, 200, 25);
                                                                    panouNume.add(emailLabel);

                                                                    JTextField emailText = new JTextField();
                                                                    emailText.setBounds(100, 95, 200, 25);
                                                                    panouNume.add(emailText);

                                                                    JButton butonDone = new JButton("Finalizare Rezervare");
                                                                    butonDone.setBounds(40, 150, 300, 50);
                                                                    butonDone.setBackground(Color.green);
                                                                    panouNume.add(butonDone);

                                                                    butonDone.addActionListener(new ActionListener() {

                                                                        @Override
                                                                        public void actionPerformed(ActionEvent e) {
                                                                            if(numeText.getText().isEmpty()) {
                                                                                butonDone.setEnabled(false);
                                                                            }
                                                                            for (int i = 0; i < count; i++) {
                                                                                clientController.insertrezervare(numeText.getText(), filmSalvat, oraSalvata, Date.valueOf("2024-01-22"), randuriRezervate.get(i), locuriRezervate.get(i));
                                                                            }

                                                                            butonDone.setEnabled(false);
                                                                            frameNume.dispose();
                                                                            frameSalaCinema.dispose();

                                                                        File rezervare = new File("C:\\Users\\coman\\Desktop\\Rezervari\\Rezervare "  + numeText.getText() + ".txt");
                                                                            try {
                                                                                FileWriter fw = new FileWriter(rezervare, true);
                                                                                BufferedWriter bw = new BufferedWriter(fw);

                                                                                List<Client> listaRezervari = clientController.getReservationByName(numeText.getText());
                                                                                StringBuilder rezervariText = new StringBuilder();

                                                                                for (Client r : listaRezervari) {
                                                                                    rezervariText.append("Nume: ").append(r.getNume()).append("\n")
                                                                                            .append("Film: ").append(r.getNumeFilm()).append("\n")
                                                                                            .append("Ora: ").append(r.getOra()).append("\n")
                                                                                            .append("Data: ").append(r.getDataRezervare()).append("\n")
                                                                                            .append("Rand: ").append(r.getRand()).append("\n")
                                                                                            .append("Loc: ").append(r.getLoc()).append("\n\n");
                                                                                }
                                                                                bw.write(String.valueOf(rezervariText));
                                                                                bw.newLine();
                                                                                bw.flush();
                                                                            } catch (IOException ex) {
                                                                                throw new RuntimeException(ex);
                                                                            }
                                                                        }
                                                                    });
                                                                }
                                                            });
                                                            JButton butonBack = new JButton("Back");
                                                            butonBack.setBounds(50, 470, 200, 50);
                                                            panouSalaCinema.add(butonBack);
                                                            butonBack.addActionListener(new ActionListener() {
                                                                @Override
                                                                public void actionPerformed(ActionEvent e) {
                                                                    frameSalaCinema.dispose();
                                                                    frameSelectareOra.setVisible(true);
                                                                }
                                                            });
                                                        }
                                                    }
                                                }
                                            });
                                        }
                                    }
                                });
                            }
                        }
                    });
                } else {
                    mesaj.setText("User sau parola gresite");
                }
            }
        });
        frameLogIn.setVisible(true);
    }
}
