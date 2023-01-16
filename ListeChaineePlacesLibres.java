/**
 * Classe qui modelise une liste chainee sous la forme d'un tableau de maillons
 * - chaque maillon represente un element de la liste
 * - le successeur est stocke explicitement dans chaque maillon
 *
 * L'entier -1 designe la fin de liste, nil
 *
 * Les places libres sont caracterisees par le fait que le successeur vaut -2
 *
 */

public class ListeChaineePlacesLibres implements Liste {


    /**
     * attributs de gestion de la liste
     */
    private int teteLibre;
    private int tete;
    private MaillonChaine[] tab;

    /**
     * constructeur
     * @param taillemax de la liste
     */
    public ListeChaineePlacesLibres(int tMax) {
			// cree les tableaux
			this.tab = new MaillonChaine[tMax];

			// la liste est vide
			this.tete = -1;

			// initialise la teteLibre à 0
			this.teteLibre = 0;

			// initialise les cases en creant les objets
			// On initialise l'espace libre. Chacun case libre a un successeur qui a une place libre
			for (int i = 0; i < tMax-1; i++) {
				this.tab[i]=new MaillonChaine(null, i+1);
			}
			this.tab[tMax-1] = new MaillonChaine(null,0);
    }

    /**
     * acces a la tete
     */
    @Override
    public int tete() {
			return this.tete;
    }


    /**
     * savoir si une place est en fin
     * si la place vaut nil
     */
    @Override
    public boolean finliste(int p) {
			return p == -1;
    }

    /**
     * la successeur de maniere chainee, trouve dans le tableau suivant
     */
    @Override
    public int suc(int p) {
			return this.tab[p].getSuc();
    }

    /**
     * valeur trouvee dans le tableau valeur
     */
    @Override
    public String val(int p) {
			return this.tab[p].getVal();
    }


    /**
     * suppression d'un element de la liste
     * avec gestion de la liste libre
     */
    @Override
    public void suplis(int p) {
	// si la place est la tete
	MaillonChaine courant = this.tab[p];
	if (p == this.tete) {
	    //on decale la tete
	    this.tete = courant.getSuc();
	    //on libere la place
	    this.libererPlace(p);
	}
	else {
	    int place = this.tete;
	    // trouver le precedent
	    while (this.tab[place].getSuc() != p) {
				place = this.tab[place].getSuc();
	    }
	    this.tab[place].setSuc(courant.getSuc());
	    this.libererPlace(p);
	}

    }

    /**
     * permet de liberer une place en l'ajoutant en tete a la liste des places libres
     * @param p place a liberer
     */
    private void libererPlace(int p) {
			this.tab[p].setSuc(-2);

    }

    /**
     * ajout en tete avec gestion place libres
     */
    @Override
    public void adjtlis(String s) {
			int libre = retournerPlaceLibre();

			//on decale la place libre vers l'ancienne tete
			this.tab[libre].setSuc(this.tete);
			//on met a jour la tete
			this.tete = libre;
			//on ajute la valeur dans la nouvelle tete
			this.tab[this.tete].setVal(s);

    }

    /**
     * ajout avec gestion place libres
     */
    @Override
    public void adjlis(int p, String s) {
			int libre=this.retournerPlaceLibre();
			this.tab[libre].setSuc(this.tab[p].getSuc());
			this.tab[libre].setVal(s);
			this.tab[p].setSuc(libre);
    }

    /**
     * permet de recuperer une place libre
     * on suppose qu'il existe une place libre (teteLibre n'est pas -2)
     * @return la tete de la liste libre et met a jour la liste libre
     */
    public int retournerPlaceLibre() {
	//A COMPLETER
			throw (new Error ("A compléter"));
    }


    public String toString()
    {
			String s="*******************\n* contenu liste CHAINEE *\n*******************\n";
			int place=this.tete;
			while(place!=-1){
				s+=this.tab[place].getVal()+"\n";
				place=this.tab[place].getSuc();
			}
			s+="*******************";
			return(s);
    }



}
