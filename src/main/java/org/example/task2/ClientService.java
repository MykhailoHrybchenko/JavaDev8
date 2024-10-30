package org.example.task2;

import org.example.task1.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientService {
    private final PreparedStatement createClientSt;
    private final PreparedStatement getClientByIdSt;
    private final PreparedStatement setNewNameSt;
    private final PreparedStatement deleteByIdSt;
    private final Connection connection;

    public ClientService() throws SQLException {
        connection = Database.getInstance().getConnection();
        createClientSt =  connection.prepareStatement("INSERT INTO client (name) VALUES ?");
        getClientByIdSt = connection.prepareStatement("SELECT name FROM client WHERE id = ?");
        setNewNameSt = connection.prepareStatement("UPDATE client SET name = ? WHERE id = ?");
        deleteByIdSt = connection.prepareStatement("DELETE FROM client WHERE id = ?");
    }

    public long createClient(String name) throws SQLException {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        createClientSt.setString(1, name);
        createClientSt.executeUpdate();

        ResultSet keySet = createClientSt.getGeneratedKeys();
        if (keySet.next()) {
            System.out.println("Client" + " " + name + " created successfully");
            return keySet.getLong("id");
        } else {
            throw new SQLException("Client could not be created");
        }
    }

    public String getClientById(long id) throws SQLException {
        getClientByIdSt.setLong(1, id);
        ResultSet resultSet = getClientByIdSt.executeQuery();
        if (resultSet.next()) {
            return resultSet.getString("name");
        } else {
            throw new SQLException("Client with id " + id + " not found");
        }
        }

    public void setNewName(String name, long id) throws SQLException {
        setNewNameSt.setString(1, name);
        setNewNameSt.setLong(2, id);
        int updatedRows = setNewNameSt.executeUpdate();
        if (updatedRows == 0) {
            throw new SQLException("Client with id " + id + " not found");
        }
    }

    public void deleteById(long id) throws SQLException {
        deleteByIdSt.setLong(1, id);
        int rowsDeleted = deleteByIdSt.executeUpdate();
        if (rowsDeleted == 0) {
            throw new SQLException("Client with id " + id + " not found.");
        }
    }

    public List<Client> getClientList() throws SQLException {
        List<Client> clients = new ArrayList<>();
        String sqlQuery = "SELECT id, name FROM client";
        try(Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                clients.add(new Client(name, id));
            }
        }
        return clients;
    }

    public void close() throws SQLException {
        createClientSt.close();
        getClientByIdSt.close();
        setNewNameSt.close();
        deleteByIdSt.close();
    }
}

