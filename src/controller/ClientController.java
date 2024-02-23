package controller;

import dao.ClientDao;
import model.Client;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientController {

    private ClientDao clientDao;

    public ClientController(){
        clientDao = new ClientDao(ConnectionController.getInstance().getConnection());

    }

    public void insertrezervare( String nume, String film, int ora, Date data, int rand, int loc){
        clientDao.insertRezervare(nume,film,ora,data,rand,loc);
    }

    public List<Client> getClientByFilmSiOra(String film , int ora) {
       return clientDao.getClientByFilmSiOra(film, ora);
    }

    public void stergeRezervareaByNume(String nume) {
        clientDao.stergeRezervareaByNume(nume);
    }

    public List<Client> getReservationByName(String nume) {
        return clientDao.getReservationByName(nume);
    }


}
