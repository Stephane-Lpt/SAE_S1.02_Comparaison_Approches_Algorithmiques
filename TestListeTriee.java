import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;
import libtest.*;


/**
 * classe de test qui permet de verifier que la classe ListeTriee
 * fonctionne correctement
 */
public class TestListeTriee {

	/**
	 * methode de lancement des tests
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		lancer(new TestListeTriee(), args);
	}

	/**
	 * methode verifiant si une liste contient les memes elements qu'un tableau de chaines
         *
         * @param lT liste triee a tester
         * @param reponse contenu attendu de la liste
         */
	public static void verifie(ListeTriee lT, String[] reponse){
		// verification
		int p = lT.tete();
		for (int i=0;i<reponse.length;i++){

			// verifie la valeur
			assertEquals("liste trop courte taille="+i,false,lT.finliste(p));


			// verifie la valeur
			assertEquals("mauvaise valeur",reponse[i],lT.val(p));
			
			// decale place
			p = lT.suc(p);
		} 
		// verification liste finie
		assertEquals("liste plus grnde que prevue",true,lT.finliste(p));
	}

	// #####################################
	// Ajouts dans liste Triee (debute par 0)
	// #####################################

	
	/**
	 * test d'ajouts 
	 */
	public void test_01_ajoutTrie() {
	    ListeTriee lT = new ListeTriee(new ListeProf());

	    String[] mots= {"a","b","c"};
	    String[] reponse= {"a","b","c"};
	    for (int i = 0; i < mots.length; i++){
		lT.adjlisT(mots[i]);
	    }    	
	    
	    // verification
	    verifie(lT, reponse);
	}


	/**
	 * test d'ajouts 
	 */
	public void test_02_ajoutInverse() {
	    ListeTriee lT = new ListeTriee(new ListeProf());
	    
	    String[] mots= {"c","b","a"};
	    String[] reponse= {"a","b","c"};
	    for (int i = 0; i < mots.length; i++){
		lT.adjlisT(mots[i]);
	    }    	
	    
	    // verification
	    verifie(lT, reponse);
	}

	/**
	 * test d'ajouts quelconque
	 */
	public void test_03_ajoutQuelconque() {
	    ListeTriee lT = new ListeTriee(new ListeProf());
	    
	    String[] mots= {"c","d","b","e","a","f"};
	    String[] reponse= {"a","b","c","d","e","f"};
	    for (int i = 0; i < mots.length; i++){
		lT.adjlisT(mots[i]);
	    }    	
	    
	    // verification
	    verifie(lT, reponse);
	}

	/**
	 * test d'ajouts en tete
	 */
	public void test_04_ajoutTestTete() {
	    ListeTriee lT = new ListeTriee(new ListeProf());

	    // ajoute a en dernier
	    String[] mots= {"b","c","d","a"};
	    String[] reponse= {"a","b","c","d"};
	    for (int i = 0; i < mots.length; i++){
		lT.adjlisT(mots[i]);
	    }    	
	    
	    // verification
	    verifie(lT, reponse);
	}

        /**
	 * test d'ajouts en queue
	 */
	public void test_05_ajoutTestQueue() {
	    ListeTriee lT = new ListeTriee(new ListeProf());

	    // ajoute e en dernier
	    String[] mots= {"b","c","d","a","e"};
	    String[] reponse= {"a","b","c","d","e"};
	    for (int i = 0; i < mots.length; i++){
		lT.adjlisT(mots[i]);
	    }
	    
	    // verification
	    verifie(lT, reponse);
	}

   /**
	 * test d'ajouts 
	 */
	public void test_06_ajoutEgal() {
	    ListeTriee lT = new ListeTriee(new ListeProf());

	    String[] mots= {"a","a"};
	    String[] reponse= {"a","a"};
	    for (int i = 0; i < mots.length; i++){
		lT.adjlisT(mots[i]);
	    }    	
	    
	    // verification
	    verifie(lT, reponse);
	}




}
