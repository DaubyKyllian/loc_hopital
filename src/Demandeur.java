import java.sql.*;
import java.util.ArrayList;
import Passerelle.Passerelle;

public class Demandeur {
    private static Connection conn = Passerelle.connexionBDD();

    public static void afficherTypeVehicules(){

        String query = "SELECT libelle FROM type";

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            String type = rs.getString("libelle");

            System.out.println("type de véhicules" + type);

            rs.close();
            stmt.close();

        } catch (SQLException e) {
            System.err.println("Erreur lors de l'affichage des demandes de location: " + e.getMessage());
        }
    }
}
