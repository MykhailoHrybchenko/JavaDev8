package org.example;

import org.example.task1.DatabaseService;
import org.example.task2.Client;
import org.example.task2.ClientService;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        DatabaseService.initAndPopulate();
        ClientService clientService = new ClientService();
//        clientService.createClient("Amogus");
//        clientService.close();
//        System.out.println(clientService.getClientById(2));
//        clientService.close();
//        clientService.setNewName("Amogus", 2);
//        clientService.close();
//        clientService.deleteById(2);
//        clientService.close();
        List<Client> listOfClients = clientService.getClientList();
        System.out.println("Client list: " + listOfClients);
        clientService.close();
    }
}