import java.sql.*;
import java.util.ArrayList;
import Passerelle.Passerelle;

public class Administrateur {
    private static Connection conn=Passerelle.connexionBDD();

    public static void afficherDemandeLocation() {

    String query = "SELECT * FROM location where valide = false";
    
    try {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            int id = rs.getInt("idloc");
            int idUtilisateur = rs.getInt("idperso");
            int idVehicule = rs.getInt("idvehicule");
            Date dateDebut = rs.getDate("datedebut");
            Boolean statut = rs.getBoolean("valide");

            System.out.println("ID: " + id +
                               ", Utilisateur: " + idUtilisateur +
                               ", Véhicule: " + idVehicule +
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
