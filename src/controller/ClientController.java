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

//    public void insertrezervare(int id, String nume, String film, int sala, Date data, int rand, int loc){
//        Optional<Client> optional = clientDao.getClientByLoc(rand, loc);
//        if(optional.isEmpty()) {
//            clientDao.insertRezervare(id, nume, film, sala, data, rand, loc);
//            System.out.println("S a adaugat o rezervare");
//        } else {
//            System.out.println("Locurile sunt ocupate");
//        }
//    }

    public List<Client> getClientByFilmSiOra(String film , int ora) {
       return clientDao.getClientByFilmSiOra(film, ora);
    }

}
