package view;

import controller.ClientController;
import dao.ClientDao;
import model.Client;
import model.SalaCinema;
import view.GUI;

import java.util.List;
import java.util.Scanner;

public class ClientOperations {
    private static SalaCinema salaCinema = new SalaCinema();
    private static ClientController clientController = new ClientController();
    private static Scanner scanner = new Scanner(System.in);

    private ClientOperations() {
    }

    public static void clientOperations() {

        GUI gui = new GUI();
//        System.out.println("Ce doriti sa faceti");
//        String cmd = scanner.nextLine();

//        switch (cmd) {
//            case "r":
//                System.out.println("Alege Filmul");
//                SalaCinema.afiseazaFilme();
//                int filmAles = scanner.nextInt();
//                scanner.nextLine();
//                String filmString = SalaCinema.filme[filmAles - 1];
//                if (filmAles < 1 || filmAles > SalaCinema.filme.length) {
//                    System.out.println("Numarul filmului este invalid!");
//                    return;
//                }
//                System.out.println("Alege ora filmului");
//                SalaCinema.afiseazaOraFilm();
//                int oraFilm = scanner.nextInt();
//                scanner.nextLine();
//                if (oraFilm < 10 || oraFilm > 22 || (oraFilm % 2 != 0)) {
//                    System.out.println("Ora film invalida");
//                    return;
//                }
//                GUI gui = new GUI();
//
//                List<Client> client1 = clientController.getClientByFilmSiOra(filmString, oraFilm);
//                for (Client c : client1) {
//                    System.out.println(c);
//                }
//
//
//                int[][] locuri = new int[4][5];
//
//                for (Client client : client1) {
//                    int loc = client.getLoc();
//                    int rand = client.getRand();
//                    locuri[loc - 1][rand - 1] = 1;
//                }
//
//                for (int j = 0; j < 5; j++) {
//                    for (int i = 0; i < 4; i++) {
//                        System.out.print(locuri[i][j] + " ");
//                    }
//                    System.out.println();
//                }
        }
    }

