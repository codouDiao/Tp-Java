package Repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entities.Client;

public class ClientRepository {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/TpJava";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";

    public ClientRepository() {
        initializeDatabase();
    }

    private void initializeDatabase() {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
                Statement statement = connection.createStatement()) {

            String createTableQuery = "CREATE TABLE IF NOT EXISTS client ("
                    + "id INTEGER PRIMARY KEY AUTO_INCREMENT,"
                    + "nomComplet VARCHAR(255),"
                    + "telephone VARCHAR(20),"
                    + "email VARCHAR(255))";
            statement.executeUpdate(createTableQuery);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addClient(Client client) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO client (nomComplet, telephone, email) VALUES (?, ?, ?)",
                        Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, client.getNomComplet());
            preparedStatement.setString(2, client.getTelephone());
            preparedStatement.setString(3, client.getEmail());

            preparedStatement.executeUpdate();

            // Récupérez l'ID généré pour le client
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                client.setId(generatedKeys.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Client> listClients() {
        List<Client> clients = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM client")) {

            while (resultSet.next()) {
                Client client = new Client();
                client.setId(resultSet.getInt("id"));
                client.setNomComplet(resultSet.getString("nomComplet"));
                client.setTelephone(resultSet.getString("telephone"));
                client.setEmail(resultSet.getString("email"));
                clients.add(client);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clients;
    }

}
