import java.util.Scanner;
public class App {
    public static void afficherMenu(){
        System.out.println("Saisissez votre rôle :"); 
        System.out.println("1 : Demandeur");
        System.out.println("2 : Administration");
        System.out.println("Choisissez 1 ou 2");
    }

    public static void afficherMenuDemandeur(){
        System.out.println("Quel type de véhicule que vous souhaitez :");
        System.out.println("1 : Longue distance");
        System.out.println("2 : Courte distance");
        System.out.println("3 : Electrique");
        System.out.println("4 : Thermique");
        System.out.println("5 : Hybrid");

    }
    public static void choixDemand(int choixDemandeur){
        System.out.println("");
    }

/*-------------------------------------------------------------------------------------------------------------------------------------------
*/
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        
        afficherMenu();
        int choix = sc.nextInt();
        
        if(choix == 1){
            System.out.println("Vous êtes demandeur");
            afficherMenuDemandeur();
            int choixDemandeur = sc.nextInt();
            
        }else if(choix == 2){
            System.out.println("Vous êtes administrateur");
            Administrateur.afficherDemandeLocation();
        }else{
            System.out.println("Veuillez choisir un réponse définit.");
            afficherMenu();
        }
    
    }
}
