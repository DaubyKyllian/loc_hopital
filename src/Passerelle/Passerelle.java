
package Passerelle;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Base64;

public class Passerelle {

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
}