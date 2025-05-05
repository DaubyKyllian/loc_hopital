
package Passerelle;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Base64;

public class Passerelle {
    private static Connection conn = connexionBDD();

    public static Connection connexionBDD() {
        Connection conn = null;
        String urlBDD = "jdbc:postgresql://192.168.1.245:5432/slam2025location_windal";
        String userBDD = "windal";
        String passwdBDD = "windal";
        try {
            conn = DriverManager.getConnection(urlBDD, userBDD, passwdBDD);
            // System.out.println("-------------------------------\nConnexion à la base de
            // donnée réussi !\n-------------------------------");
            return conn;
        }

        catch (SQLException e) {
            System.out.println(
                    "-------------------------------\nConnexion à la base de donnée refusée !\n-------------------------------");
            System.out.println("Erreur : " + e);
        }
        return conn;
    }

    public static void deconnexionBDD(Connection conn) {
        if (conn == null) {
            return;
        }
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("Erreur: " + e);
        }
    }

    public static void afficherDemandeLocation() {

        String query = "SELECT * FROM location where valide = false";

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("idloc");
                int idUtilisateur = rs.getInt("idperso");
                Date dateDebut = rs.getDate("datedebut");
                Boolean statut = rs.getBoolean("valide");

                System.out.println("ID: " + id +
                        ", Utilisateur: " + idUtilisateur +
                        ", Du: " + dateDebut +
                        ", validé ? : " + statut);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'affichage des demandes de location: " + e.getMessage());
        }
    }

}