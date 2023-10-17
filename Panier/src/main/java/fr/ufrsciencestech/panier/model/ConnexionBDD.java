/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class ConnexionBDD {
    private static final String URL = "jdbc:sqlite:bddprojetgl.db";
    private Connection connection;
    
    //Connexion à la base de donnée
    public ConnexionBDD() {
        try{
            connection = DriverManager.getConnection(URL);
            System.out.println("Connexion à la BDD établie ");
        } catch(SQLException e) {
            System.err.println("Erreur de connexion à la BDD");
        }
    }
    
    //Fermeture de la connexion à la base de donnée
    public void closeConnection() {
        try {
            if(connection != null){
                connection.close();
                System.out.println("Connexion à la BDD fermée");
            }
        } catch(SQLException e){
            System.out.println("Erreur lors de la fermeture de la connexion à la BDD");
        }
    }
    
    //insertion d'un nouveau fruit dans la table fruit du BDD (Création d'un fruit)
    public void insertFruit(String nom, double prix, String origine, String type){
       String requete = "INSERT INTO fruit (name, price, origin, type) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(requete)) {
            preparedStatement.setString(1, nom);
            preparedStatement.setDouble(2, prix);
            preparedStatement.setString(3, origine);
            preparedStatement.setString(4, type);
            
            int rows = preparedStatement.executeUpdate();
            if(rows > 0){
                System.out.println("Données insérées avec succés.");
            } else {
                System.out.println("Aucune donnée insérée");
            }
            
        } catch (SQLException e){
            System.err.println("Erreur lors de l'insertion de données à la BDD: " + e.getMessage());
        }
    }
    
    
    //récuperer les fruits depuis la table Fruit de BDD (proposer liste de fruit)
    public List<Fruit> listeFruit() {
        List<Fruit> fruits = new ArrayList<>();
        
        String requete = "SELECT * FROM fruit";
        try(PreparedStatement preparedStatement = connection.prepareStatement(requete);
                ResultSet resultSet = preparedStatement.executeQuery()){
            while (resultSet.next()) {
                String nom = resultSet.getString("name");
                double prix = resultSet.getDouble("price");
                String origine = resultSet.getString("origin");
                String type = resultSet.getString("type");
                
                
                Fruit fruit = new Fruit(nom, prix, origine, type);
                
                fruits.add(fruit);
            }
        } catch (SQLException e){
            System.err.println("Erreur lors de la recuperation des données");
        }
        
        return fruits;
    }
    
    
    
    //creation d'un nouveau panier
    public void insertPanier(String nom, String type, int capacité, double value){
       String requete = "INSERT INTO panier (name, type, maxcapacity, value) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(requete)) {
            preparedStatement.setString(1, nom);
            preparedStatement.setString(4, type);
            preparedStatement.setInt(2, capacité);
            preparedStatement.setDouble(3, value);
            
            
            int rows = preparedStatement.executeUpdate();
            if(rows > 0){
                System.out.println("Données insérées avec succés.");
            } else {
                System.out.println("Aucune donnée insérée");
            }
            
        } catch (SQLException e){
            System.err.println("Erreur lors de l'insertion de données à la BDD: " + e.getMessage());
        }
    }
    
    //pour recuperer la liste des paniers depuis la bdd du panier (liste des paniers disponibles)
    public List<String> listePanier() {
        List<String> panier = new ArrayList<>();
        
        String requete = "SELECT * FROM panier";
        try(PreparedStatement preparedStatement = connection.prepareStatement(requete);
                ResultSet resultSet = preparedStatement.executeQuery()){
            while (resultSet.next()) {
                String nom = resultSet.getString("name");
                
                panier.add(nom);
            }
        } catch (SQLException e){
            System.err.println("Erreur lors de la recuperation des données");
        }
        
        return panier;
    }
    
    //pour trier les fruits en utilisant le filtre fruit
    public List<Fruit> getFruitByName(String text, String filter) {
        List<Fruit> fruits = new ArrayList<>();
        String requete = "";
        switch (filter){
            case "Fruit":{
                requete = "SELECT * FROM fruit WHERE name='" + text +"'";
            } break;
            case "Origine":{
                requete = "SELECT * FROM fruit WHERE origin='" + text +"'";
            } break;
            case "Type":{
                requete = "SELECT * FROM fruit WHERE type='" + text +"'";
            } break;
                
        }
        
        try(PreparedStatement preparedStatement = connection.prepareStatement(requete);
            ResultSet resultSet = preparedStatement.executeQuery()){
            while (resultSet.next()) {
                String nom = resultSet.getString("name");
                double prix = resultSet.getDouble("price");
                String origine = resultSet.getString("origin");
                String type = resultSet.getString("type");
                
                
                Fruit fruit = new Fruit(nom, prix, origine, type);
                
                fruits.add(fruit);
            }
        } catch (SQLException e){
            System.err.println("Erreur lors de la recuperation des données");
        }
        
        return fruits;
    }
    
    
}