package dao;

import model.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDao {

    private Connection connection;

    private PreparedStatement insertRezervare;
    private PreparedStatement getClientiByLoc;
    private PreparedStatement getCLientiByFilmSiora;
    private PreparedStatement stergeRezervareaByNume;
    private PreparedStatement getReservationByName;


    public ClientDao(Connection connection) {
        this.connection = connection;

        try {
            insertRezervare = connection.prepareStatement("INSERT INTO rezervari VALUES(null,?, ?, ?, ?, ?,?)");
            getClientiByLoc = connection.prepareStatement("SELECT * FROM rezervari WHERE rand = ? AND loc = ?");
            getCLientiByFilmSiora = connection.prepareStatement("SELECT * FROM rezervari WHERE film = ? AND ora = ?");
            stergeRezervareaByNume = connection.prepareStatement("DELETE FROM rezervari WHERE nume = ?");
            getReservationByName = connection.prepareStatement("SELECT * FROM rezervari WHERE nume = ?");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertRezervare(String nume, String film, int ora, Date data, int rand, int loc) {
        try {

            insertRezervare.setString(1, nume);
            insertRezervare.setString(2, film);
            insertRezervare.setInt(3, ora);
            insertRezervare.setDate(4, data);
            insertRezervare.setInt(5, rand);
            insertRezervare.setInt(6, loc);
            insertRezervare.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public void stergeRezervareaByNume(String nume) {
        try {
            stergeRezervareaByNume.setString(1,nume);
            stergeRezervareaByNume.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Client> getClientByFilmSiOra(String film, int ora) {
        ArrayList<Client> list = new ArrayList<>();
        try {
            getCLientiByFilmSiora.setString(1, film);
            getCLientiByFilmSiora.setInt(2, ora);
            ResultSet resultSet = getCLientiByFilmSiora.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String nume = resultSet.getString(2);
                String film1 = resultSet.getString(3);
                int ora1 = resultSet.getInt(4);
                Date data = resultSet.getDate(5);
                int rand = resultSet.getInt(6);
                int loc = resultSet.getInt(7);
                Client client = new Client(id, nume, film1, ora1, data, rand, loc);
                list.add(client);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<Client> getReservationByName(String nume) {
        ArrayList<Client> listRezervari = new ArrayList<>();
        try {
            getReservationByName.setString(1, nume);
            ResultSet resultSet = getReservationByName.executeQuery();
            while(resultSet.next()) {
                int id = resultSet.getInt(1);
                String nume1 = resultSet.getNString(2); String film1 = resultSet.getString(3);
                int ora1 = resultSet.getInt(4);
                Date data = resultSet.getDate(5);
                int rand = resultSet.getInt(6);
                int loc = resultSet.getInt(7);
                Client client = new Client(id,nume1, film1,ora1, data,rand,loc);
                listRezervari.add(client);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listRezervari;
    }


}
