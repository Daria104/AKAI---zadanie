import java.util.Collections;

public class AKAI {
	

	    private static String[] sentences = {
	            "Taki mamy klimat",
	            "Wsz�dzie dobrze ale w domu najlepiej",
	            "Wyskoczy� jak Filip z konopii",
	            "Gdzie kucharek sze�� tam nie ma co je��",
	            "Nie ma to jak w domu",
	            "Konduktorze �askawy zabierz nas do Warszawy",
	            "Je�eli nie zjesz obiadu to nie dostaniesz deseru",
	            "Bez pracy nie ma ko�aczy",
	            "Kto sieje wiatr ten zbiera burz�",
	            "By� szybkim jak wiatr",
	            "Kopa� pod kim� do�ki",
	            "Gdzie raki zimuj�",
	            "Gdzie pieprz ro�nie",
	            "Swoj� drog� to gdzie ro�nie pieprz?",
	            "Mam nadziej�, �e poradzisz sobie z tym zadaniem bez problemu",
	            "Nie powinno sprawi� �adnego problemu, bo Google jest dozwolony" 
	            };
	    
	 
	    private static String napis = "";	
	    		
	    		
	    public static void main(String[] args) {
	        /* TODO Twoim zadaniem jest wypisanie na konsoli trzech najcz�ciej wyst�puj�cych s��w
	                w tablicy 'sentences' wraz z ilo�ci� ich wyst�pie�..
	                Przyk�adowy wynik:
	                1. "mam" - 12
	                2. "tak" - 5
	                3. "z" - 2
	        */
	    	
	    	
	    	// wstawianie jednego ca�ego napisu
	    	for (int i=0; i<sentences.length;i++) {
	    		napis = napis + " " + sentences[i] ;
	    	}
	    	
	    	napis = napis.toLowerCase();
	    	
	    	//usuwanie interpunkcji
	    	int a = 0;
	    	while (a<napis.length()){
	    		char ch = napis.charAt(a);
	    		 if(ch == ',' || ch == '?'){
	    			 String before = napis.substring(0, a);
	    			 String after = napis.substring(a + 1);
	    			 napis = before + after;
	    		 }
	    		 else{
	    			 a++;
	    		 }
	    	}

	    	String[] tab = napis.split(" ");
	    	
	    	int[] pozycje = {0,0,0,0,0,0};
	    	int powtarzalnosc = 1;
	    	
	    	for(int i = 0; i<tab.length; i++) {
	    		if(tab[i].equals(tab[pozycje[3]])==false && tab[i].equals(tab[pozycje[4]])==false){
		    		for(int j=tab.length-1;j>i;j--) {
		    			if(tab[i].equals(tab[j])) {
		    				powtarzalnosc+=1;
		    			}
		    		}
	    		}
	    		    		
	    		if(powtarzalnosc > pozycje[0]) {
	    			pozycje[2]=pozycje[1];
	    			pozycje[1]=pozycje[0];
	    			pozycje[5]=pozycje[4];
	    			pozycje[4]=pozycje[3];
	    			
	    			pozycje[0]=powtarzalnosc;
	    			pozycje[3]=i;
	    		}
	    		else if(powtarzalnosc > pozycje[1]) {
	    			pozycje[2]=pozycje[1];
	    			pozycje[5]=pozycje[4];
	    			pozycje[1]=powtarzalnosc;
	    			pozycje[4]=i;
	    		}
	    		else if(powtarzalnosc > pozycje[2]) {
	    			pozycje[2]=powtarzalnosc;
	    			pozycje[5]=i;
	    		}

	    		powtarzalnosc = 1;
	    	}
	    	
	    	System.out.println("1. \"" +tab[pozycje[3]] + "\" - " + pozycje[0] );
	    	System.out.println("2. \"" +tab[pozycje[4]] + "\" - " + pozycje[1] );
	    	System.out.println("3. \"" +tab[pozycje[5]] + "\" - " + pozycje[2] );
	    }

	
}
