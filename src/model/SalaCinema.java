package model;

import java.util.Arrays;
import java.util.Date;

public class SalaCinema {

    public static   final String[] filme = {"Film 1", "Film 2", "Film 3", "Film 4", "Film 5", "Film 6", "Film 7", "Film 8", "Film 9"};
    private int [][] locuri;
    private boolean [][] locuriOcupate;

    public SalaCinema(int[][] locuri, boolean[][] locuriOcupate) {
        this.locuri = locuri;
        this.locuriOcupate = locuriOcupate;
    }

    public SalaCinema() {}

    public int[][] getLocuri() {
        return locuri;
    }

    public void setLocuri(int[][] locuri) {
        this.locuri = locuri;
    }

    public boolean[][] getLocuriOcupate() {
        return locuriOcupate;
    }

    public void setLocuriOcupate(boolean[][] locuriOcupate) {
        this.locuriOcupate = locuriOcupate;
    }

    public static void afiseazaFilme() {
        for(int i = 0;i < filme.length;i++){
            System.out.println(i + 1 + " - " + filme[i]);
        }

    }

    public static void afiseazaOraFilm() {
        for(int ora = 10; ora <= 22 ; ora = ora +2) {
            System.out.println("Ora " + ora);
        }
    }

    @Override
    public String toString() {
        return "SalaCinema{" +
                "locuri=" + Arrays.toString(locuri) +
                ", locuriOcupate=" + Arrays.toString(locuriOcupate) +
                '}';
    }
}
