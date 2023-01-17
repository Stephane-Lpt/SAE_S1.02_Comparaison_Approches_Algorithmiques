/**
 * Classe principale de la SAÉ
 * @author Étienne André Sergueï Lenglet
 * @since 2021-11-04
 */


public class Principale{
    private static final String[] ELEMENTS_DE_DEBUT
	= {"ABITEBOUL", "ADLEMAN", "AL-KINDI", "ALUR", "BERNERS-LEE",
	"BOOLE", "BUCHI", "BUTLER", "CLARKE", "CURRY"};
    private static final String[] ELEMENTS_DE_FIN
	= {"RABIN", "RIVEST", "SHAMIR", "SIFAKIS", "TORVALDS",
	"TURING", "ULLMAN", "VALIANT", "WIRTH", "YAO"};
    
    // NOTE: pour fichier 10 000
    // 	private static final String[] ELEMENTS_DE_DEBUT_SUPPR
    // = {"ABBADI", "ABERGEL", "ALIAS", "ALIOUI", "AKKUS", "ALAZARD",
    // "ALLA", "AIDARA", "ABRANTES", "AARAB"};
    // NOTE: pour fichier 1 000
    //private static final String[] ELEMENTS_DE_DEBUT_SUPPR
    // = {"ABADIE", "ABDALLAH", "ABRAHAM", "ADAM", "AFONSO",
    // "ALBERT", "ALEXANDRE", "ALI", "ALIX", "ALLAIN"};
    // NOTE: pour fichier 10 000
    //private static final String[] ELEMENTS_DE_FIN_SUPPR
    // = {"WEIS", "ZANIN", "WERQUIN", "YAGOUBI", "WERNERT",
    // "WAWRZYNIAK", "ZULIANI", "ZAIRE", "WAVRANT", "VILLAR"}; //
    // NOTE: pour fichier 1 000
    //private static final String[] ELEMENTS_DE_FIN_SUPPR
    //= {"WEBER", "WEISS", "WINTERSTEIN", "WOLFF", "YANG",
    //"YILDIRIM", "YILDIZ", "YILMAZ", "ZIEGLER", "ZIMMERMANN"}; //
	
    // Type des listes, peut etre utile pour factoriser les tests
    private static final int CONTIGUE	       = 1;
    private static final int CHAINEE	       = 2;
    private static final int CHAINEE_PLIBRES   = 3;
	
    // Exemple d'utilisation de LectureFichier et remplissage d'une liste
    public static void remplir_liste(ListeTriee liste, String nom_fichier){
	    LectureFichier lf = new LectureFichier(nom_fichier);	
        String[] liste_noms = lf.lireFichier();
        for (int i = 0; i < liste_noms.length; i++){
            liste.adjlisT(liste_noms[i]);
        }
    }
		
    public static void main(String [] args){
        System.out.println("Bienvenue !\n");

        //Exemple d'utilisation de la classe EcritureFichier
        EcritureFichier fichier = new EcritureFichier("resultats.csv");
        fichier.ouvrirFichier();
        fichier.ecrireLigne("liste;operation;emplacement;duree");
        fichier.fermerFichier();

        ListeTriee lT = new ListeTriee(new ListeChaineePlacesLibres(10010));
        remplir_liste(lT, "noms10000.txt");

        long temps;


        // Question 7
        System.out.println("Question 7\nadjlisT avec element debut alphabet\n");
        String[] donneeD={"ABBADI", "ABERGEL", "ALIAS", "ALIOUI", "AKKUS", "ALAZARD","ALLA", "AIDARA", "ABRANTES", "AARAB"};
        
        lT = new ListeTriee(new ListeContigue(100000));
        System.out.println("contigue :"+chronoAdjlis(lT, donneeD));
        lT = new ListeTriee(new ListeChainee(100000));
        System.out.println("chaine :"+chronoAdjlis(lT, donneeD));
        lT = new ListeTriee(new ListeChaineePlacesLibres(100000));
        System.out.println("chainePlaceLibre :"+chronoAdjlis(lT, donneeD));

        // Question 8
        System.out.println("\n\nQuestion 8\nadjlisT avec element fin alphabet\n");
        String[] donneeF={"WEIS", "ZANIN", "WERQUIN", "YAGOUBI", "WERNERT","WAWRZYNIAK", "ZULIANI", "ZAIRE", "WAVRANT", "VILLAR"};
        
        lT = new ListeTriee(new ListeContigue(100000));
        System.out.println("contigue :"+chronoAdjlis(lT, donneeF));
        lT = new ListeTriee(new ListeChainee(100000));
        System.out.println("chaine :"+chronoAdjlis(lT, donneeF));
        lT = new ListeTriee(new ListeChaineePlacesLibres(100000));
        System.out.println("chainePlaceLibre :"+chronoAdjlis(lT, donneeF))

        // Question 9
        /**
         * contigue :
         * 
         * chainee : 
         * 
         * chainePlaceLibre : parcours toute la liste
         */
    }

    public static long chronoAdjlis(ListeTriee lT, String[] donnee){
        remplir_liste(lT, "noms10000.txt");
        long date_debut = System.nanoTime();
        for(int i=0; i<donnee.length;i++){
            lT.adjlisT(donnee[i]);
        }
        long date_fin = System.nanoTime();
        return date_fin - date_debut;

    }


}
