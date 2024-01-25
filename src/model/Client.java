package model;

import java.util.Date;

public class Client {
    private int id;
    private String nume;
    private String numeFilm;
    private int ora;
    private int rand;
    private int loc;
    private Date dataRezervare;

    public Client(int id, String nume, String numeFilm, int ora, Date dataRezervare, int rand, int loc) {
        this.id = id;
        this.nume = nume;
        this.numeFilm = numeFilm;
        this.ora = ora;
        this.rand = rand;
        this.loc = loc;
        this.dataRezervare = dataRezervare;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getNumeFilm() {
        return numeFilm;
    }

    public void setNumeFilm(String numeFilm) {
        this.numeFilm = numeFilm;
    }

    public int getOra() {
        return ora;
    }

    public void setOra(int ora) {
        this.ora = ora;
    }

    public int getRand() {
        return rand;
    }

    public void setRand(int rand) {
        this.rand = rand;
    }

    public int getLoc() {
        return loc;
    }

    public void setLoc(int loc) {
        this.loc = loc;
    }

    public Date getDataRezervare() {
        return dataRezervare;
    }

    public void setDataRezervare(Date dataRezervare) {
        this.dataRezervare = dataRezervare;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", numeFilm='" + numeFilm + '\'' +
                ", ora=" + ora +
                ", rand=" + rand +
                ", loc=" + loc +
                ", dataRezervare=" + dataRezervare +
                '}';
    }
}
