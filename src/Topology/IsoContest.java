package Topology;

import java.util.*;

public class IsoContest {
    public static void main( String[] argv ) throws Exception {
        String  line;
        Scanner sc = new Scanner(System.in);
        int nbCercle = 0;
        ArrayList<String> array = new ArrayList<String>();
        boolean isAnomalie = false;
        if (sc.hasNextLine()) {
            nbCercle = Integer.parseInt(sc.nextLine());
        }
        while(sc.hasNextLine()) {
            line = sc.nextLine();
            array.add(line);
			/* Lisez les données et effectuez votre traitement */
        }
        sc.close();
        for(int i=0; i<array.size(); i++){
            for(int j=i+1; j<array.size(); j++){
                String[] splitedI = array.get(i).split("\\s+");
                String[] splitedJ = array.get(j).split("\\s+");
                double distance = calculateDist(Integer.parseInt(splitedI[0]), Integer.parseInt(splitedJ[0]), Integer.parseInt(splitedI[1]), Integer.parseInt(splitedJ[1]));
                isAnomalie = isAnomalie(distance, Integer.parseInt(splitedI[2]), Integer.parseInt(splitedJ[2]));
                if(isAnomalie){
                    System.out.println("KO");
                    return;
                }
            }
        }
        System.out.println("OK");
	/* Vous pouvez aussi effectuer votre traitement une fois que vous avez lu toutes les données.*/
    }
    public static double calculateDist(int x1, int x2, int y1, int y2){
        return (Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1)));
    }

    public static boolean isAnomalie(double distance, int rayon1, int rayon2){
        int max =0;
        int min =0;
        if(rayon1>rayon2){
            max = rayon1;
            min = rayon2;
        } else {
            max = rayon2;
            min = rayon1;
        }
        return (distance<=(rayon1+rayon2) && distance>=(max-min));
    }
}