import java.util.Scanner;

import Passerelle.Passerelle;

public class Administrateur {

    public static void menuAdministrateur() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Vous êtes administrateur");

        System.out.println("Choissisez la demande de location que vous voulez traiter");
        Passerelle.afficherDemandeLocation();

        int choixAdm = sc.nextInt();

        System.out.println("Voulez-vous valider la demande ou non ?");
        System.out.println("1 : Oui");
        System.out.println("2 : Non");
        int choixAdm2 = sc.nextInt();
        if (choixAdm2 == 1) {
            System.out.println("La demande a bien été validé");
            System.out.println("");
        } else if (choixAdm2 == 2) {

        } else {
            System.out.println("Veuillez choisir un réponse définit.");
        }
    }
}