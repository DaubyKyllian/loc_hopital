
package Passerelle;


import java.sql.*;

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

    public static void valider(int nb) {
        String query = "update location set valide = true where idloc=" + nb;

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.err.println("Erreur lors de la : " + e.getMessage());
        }
    }

    public static void refuser(int nb) {
        String query = "update location set valide = false where idloc=" + nb;

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'affichage des demandes de location: " + e.getMessage());
        }
    }

    public static void afficherVehiculeDispo(int idloc) {

        String query = "SELECT * FROM vehicule where type = (select type from vehicule v join location l on l.idvehicule=v.Immatriculation where l.idloc ="+idloc+" and l.idvehicule=v.Immatriculation)";

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

    public static void refuser2(int nb) {
        String query = "update location set valide = false where idloc=" + nb;

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'affichage des demandes de location: " + e.getMessage());
        }
    }
}