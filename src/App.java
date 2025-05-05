import java.util.Scanner;

import Passerelle.Passerelle;
public class App {
    public static void afficherMenu(){
        System.out.println("Saisissez votre rôle :"); 
        System.out.println("1 : Demandeur");
        System.out.println("2 : Administration");
        System.out.println("Choisissez 1 ou 2");
    }

    

/*-------------------------------------------------------------------------------------------------------------------------------------------
*/
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        
        afficherMenu();
        int choix = sc.nextInt();
        
        if(choix == 1){
            System.out.println("Vous êtes demandeur");
            

        }else if(choix == 2){

            Administrateur.menuAdministrateur();

        }else{
            System.out.println("Veuillez choisir un réponse définit.");
            afficherMenu();
        }
    
    }
}
