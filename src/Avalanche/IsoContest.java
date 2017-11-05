package Avalanche;

import java.util.*;

public class IsoContest {
	 public static void main( String[] argv ) throws Exception {
	        String  line;
	        Scanner sc = new Scanner(System.in);
	        int nbSommet = 0;
	        String[] departArrivee = new String[0];
	        int count =0;
	        HashMap<Integer, String[]> hashMapProba = new HashMap<Integer, String[]>();
	        HashMap<Integer, ArrayList<Integer>> noeudVisite = new HashMap<Integer, ArrayList<Integer>>();
	        if (sc.hasNextLine())
	            nbSommet = Integer.parseInt(sc.nextLine());
	        if (sc.hasNextLine())
	            departArrivee = sc.nextLine().split("\\s+");
	        while(sc.hasNextLine() && count < nbSommet) {
	            line = sc.nextLine();
	            hashMapProba.put(count, line.split("\\s+"));
	            count++;
	        }
	        sc.close();
	        int depart = Integer.parseInt(departArrivee[0]);
	        int arrivee = Integer.parseInt(departArrivee[1]);
	        int currentNode = depart;
	        HashMap<Integer, Double> minProba = new HashMap<Integer, Double>();
	        for (int key =0; key<nbSommet; key++) {
	            minProba.put(key, 0.0);
	        }
	        boolean fistLoop =true;
	        while(currentNode<arrivee) {
	            for (int sommet = 0; sommet < nbSommet; sommet++) {
	                if (currentNode!=sommet) {
	                    ArrayList<Integer> nodeVisiteList = new ArrayList<Integer>();
	                    if (noeudVisite.containsKey(currentNode)) {
	                        nodeVisiteList = noeudVisite.get(currentNode);
	                    }
	                    if (nodeVisiteList.isEmpty() || !nodeVisiteList.contains(sommet)) {
	                        double proba = calculateProba(minProba.get(currentNode), Double.parseDouble(hashMapProba.get(currentNode)[sommet]));
	                        addMin(minProba, proba, sommet);
	                        if (noeudVisite.containsKey(sommet)) {
	                            noeudVisite.get(sommet).add(currentNode);
	                        } else {
	                            ArrayList<Integer> list = new ArrayList<Integer>();
	                            list.add(currentNode);
	                            noeudVisite.put(sommet, list);
	                        }
	                    }
	                }
	            }
	            if(fistLoop){
	                currentNode=0;
	                fistLoop=false;
	            } else {
	                currentNode++;
	            }
	            if (currentNode==depart){
	                currentNode ++;
	            }
	        }
	        System.out.println(((double)Math.round((1-minProba.get(arrivee))*1000))/1000);

	    }

	    public static double calculateProba(double currentProba, double probaToNextNode){
	        if(currentProba==0){
	            return (1-probaToNextNode);
	        }
	        return (currentProba)*(1-probaToNextNode);
	    }

	    public static void addMin(HashMap<Integer, Double> minProba, double proba, int node){
	        Double currentProba = minProba.get(node);
	        if(currentProba < proba) {
	            minProba.put(node, proba);
	        }
	    }
}
