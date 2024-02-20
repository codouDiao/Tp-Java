package Repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entities.Adresse;

public class AdresseRepository {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/TpJava";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";

    public AdresseRepository() {

        initializeDatabase();
    }

    private void initializeDatabase() {
        try (Connection connection = DriverManager.getConnection(JDBC_URL);
                Statement statement = connection.createStatement()) {

            // Créez la table si elle n'existe pas
            String createTableQuery = "CREATE TABLE IF NOT EXISTS adresse ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "ville TEXT,"
                    + "quartier TEXT,"
                    + "numVilla TEXT,"
                    + "clientId INTEGER)";
            statement.executeUpdate(createTableQuery);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addAdresse(Adresse adresse) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL);
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO adresse (ville, quartier, numVilla,clientId) VALUES (?, ?, ?,?)")) {

            preparedStatement.setString(1, adresse.getVille());
            preparedStatement.setString(2, adresse.getQuartier());
            preparedStatement.setString(3, adresse.getNumVilla());
            preparedStatement.setInt(4, adresse.getClientId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Adresse> getAdressesByClientId(int clientId) {
        List<Adresse> adresses = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(JDBC_URL);
                PreparedStatement preparedStatement = connection
                        .prepareStatement("SELECT * FROM adresse WHERE clientId = ?")) {

            preparedStatement.setInt(1, clientId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Adresse adresse = new Adresse();
                    adresse.setId(resultSet.getInt("id"));
                    adresse.setVille(resultSet.getString("ville"));
                    adresse.setQuartier(resultSet.getString("quartier"));
                    adresse.setNumVilla(resultSet.getString("numVilla"));
                    adresse.setClientId(resultSet.getInt("clientId"));
                    adresses.add(adresse);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return adresses;
    }

}
