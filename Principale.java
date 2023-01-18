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

        String[] actionListe={"ajout","suppression"};
        String[] typeListe={"contigue","chainee","chaineePlaceLibre"};
        String[] donneeD={"ABBADI", "ABERGEL", "ALIAS", "ALIOUI", "AKKUS", "ALAZARD","ALLA", "AIDARA", "ABRANTES", "AARAB"};
        String[] donneeF={"WEIS", "ZANIN", "WERQUIN", "YAGOUBI", "WERNERT","WAWRZYNIAK", "ZULIANI", "ZAIRE", "WAVRANT", "VILLAR"};
        
        /**
         * le code suivant chronomètre la moyenne de tempsd'execution de chaque type de liste donner dans typeListe pour chaque action définit dans actionListe 
         * et pour les 2 jeux de données donnéeD et donnéeF soit noms en debut et noms en fin d'alphabet
         */
        EcritureFichier fichier = new EcritureFichier("resultats.csv");
        fichier.ouvrirFichier();
        fichier.ecrireLigne("liste;operation;emplacement;duree");
        for(int i=0; i<actionListe.length;i++){
            for(int j=0; j<2; j++){
                String[] donnee = donneeD;
                String typeDonnee = "debut";
                if(j == 1){
                    donnee = donneeF;
                    typeDonnee = "fin";
                }
                for(int k=0; k<typeListe.length; k++){
                    long temps = moyChronoListeTriee(typeListe[k], actionListe[i], donnee, "noms10000.txt", 100);
                    fichier.ecrireLigne(typeListe[k]+";"+actionListe[i]+";"+typeDonnee+";"+temps);
                }
            }
        }
        fichier.fermerFichier();
    }
    /**
     * 
     * @param typeListe int : contigue=ListeContigue---chainee=ListeChaine---chaineePlaceLibre=ListeChainePlaceLibre
     * @param typeAction int : ajout=adjlisT---suppression=suplisT
     * @param donnee String[] : liste des chaines a ajouter ou supprimer de la ListeTriée
     * @param nomFichier String : nom du fichier de remplissage de la ListeTriée
     * @return long : duree de l'ajout ou la suppression des données fournie en nanoSeconde
     */
    public static long moyChronoListeTriee(String typeListe, String typeAction, String[] donnee, String nomFichier, int nbFois){
        long moyenne =0;
        for(int i=0; i<nbFois; i++){
            ListeTriee lT = null;
            switch(typeListe){
                case "contigue":
                    lT = new ListeTriee(new ListeContigue(100000));
                    break;

                case "chainee":
                    lT = new ListeTriee(new ListeChainee(100000));
                    break;
                
                case "chaineePlaceLibre":
                    lT = new ListeTriee(new ListeChaineePlacesLibres(100000));
                    break;
            }
            remplir_liste(lT, nomFichier);

            long date_debut = System . nanoTime () ;
            //debut chrono
            for (int j=0; j<donnee.length; j++){
                switch (typeAction){
                    case "ajout":
                        lT.adjlisT(donnee[j]);
                        break;
                    case "suppression":
                        lT.suplisT(donnee[j]);
                        break;
                }
            }
            //fin chrono
            long date_fin = System.nanoTime();
            moyenne+= date_fin - date_debut;
        }
        return moyenne/nbFois;
    }
}
