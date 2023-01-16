public class Test {
    public static void main(String[] args){
        Liste lc = new ListeChaineePlacesLibres(10);
		lc.adjtlis("a");
        lc.adjtlis("b");
        
        System.out.println(lc);
    }
}
