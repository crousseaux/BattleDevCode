package Snowflake;

import java.util.*;

public class IsoGrad {
    public static void main( String[] argv ) throws Exception {
        String  line;
        Scanner sc = new Scanner(System.in);
        int tailleLosange = 0;
        while(sc.hasNextLine()) {
            line = sc.nextLine();
            tailleLosange = Integer.parseInt(line);
			/* Lisez les données et effectuez votre traitement */
        }
        sc.close();
        int etoile = 1;

        while(etoile<=tailleLosange) {
            System.out.println( createLine(etoile, tailleLosange));
            etoile +=2;
        }
        etoile = etoile-2;
        while(etoile>=3) {
            etoile = etoile-2;
            System.out.println( createLine(etoile, tailleLosange));

        }

	/* Vous pouvez aussi effectuer votre traitement une fois que vous avez lu toutes les données.*/
    }

    public static String createLine(int etoile, int taille){
        String line ="";
        for(int i=0; i < (taille - etoile)/2 ; i++){
            line += ".";
        }
        for(int i=1; i <= etoile ; i++){
            line += "*";
        }
        for(int i=(taille - etoile)/2; i >0 ; i--){
            line += ".";
        }
        return line;
    }

}
