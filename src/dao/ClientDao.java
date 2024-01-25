package dao;

import controller.ClientController;
import model.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientDao {

    private Connection connection;

    private PreparedStatement insertRezervare;
    private PreparedStatement getClientiByLoc;


    public ClientDao(Connection connection) {
        this.connection = connection;

        try {
            insertRezervare = connection.prepareStatement("INSERT INTO rezervari VALUES(null, ?, ?, ?, ?, ?,?)");
            getClientiByLoc = connection.prepareStatement("SELECT * FROM rezervari WHERE rand = ? AND loc = ?");
            getClientiByLoc = connection.prepareStatement("SELECT * FROM rezervari WHERE film = ? AND ora = ?");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertRezervare(int id, String nume, String film, int ora, Date data, int rand, int loc) {
        try {
            insertRezervare.setInt(1, id);
            insertRezervare.setString(2, nume);
            insertRezervare.setString(3, film);
            insertRezervare.setInt(4, ora);
            insertRezervare.setDate(5, data);
            insertRezervare.setInt(6, rand);
            insertRezervare.setInt(7, loc);
            insertRezervare.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    public Optional<Client> getClientByLoc(int rand, int loc) {
//        try {
//            getClientiByLoc.setInt(6, rand);
//            getClientiByLoc.setInt(7, loc);
//            ResultSet resultSet = getClientiByLoc.executeQuery();
//            if (resultSet.next()) {
//                Client client = new Client(resultSet.getInt(1),
//                        resultSet.getString(2),
//                        resultSet.getString(3),
//                        resultSet.getInt(4),
//                        resultSet.getDate(5),
//                        resultSet.getInt(6),
//                        resultSet.getInt(7));
//                return Optional.of(client);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return Optional.empty();
//    }

    public List<Client> getClientByFilmSiOra(String film, int ora) {
        ArrayList<Client> list = new ArrayList<>();
        try {
            getClientiByLoc.setString(1, film);
            getClientiByLoc.setInt(2, ora);
            ResultSet resultSet = getClientiByLoc.executeQuery();
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
}
