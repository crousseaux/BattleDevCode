package JeuGrenier;

import java.util.*;

public class IsoContest {
	 public static void main( String[] argv ) throws Exception {
	        Integer  line;
	        Scanner sc = new Scanner(System.in);
	        int max = 0;
	        int currentMax;
	        int nbJeux = 0;
	        ArrayList<Integer> jeuxList = new ArrayList<Integer>();
	        if (sc.hasNextLine())
	            nbJeux = Integer.parseInt(sc.nextLine());
	        while(sc.hasNextLine() && jeuxList.size() < nbJeux) {
	            line = Integer.parseInt(sc.nextLine());
	            for(Integer annee: jeuxList) {
	                currentMax = Math.abs(line-annee);
	                if(currentMax>max){
	                    max = currentMax;
	                }
	            }
	            jeuxList.add(line);
				/* Lisez les données et effectuez votre traitement */
	        }
	        sc.close();
	        System.out.println(max);
		/* Vous pouvez aussi effectuer votre traitement une fois que vous avez lu toutes les données.*/
	    }
}
