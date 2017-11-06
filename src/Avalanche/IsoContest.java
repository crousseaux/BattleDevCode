package Avalanche;

import java.util.*;

public class IsoContest {
	public static void main(String[] argv) throws Exception {
		String line;
		Scanner sc = new Scanner(System.in);
		int nbSommet = 0;
		String[] departArrivee = new String[0];
		int count = 0;
		HashMap<Integer, String[]> hashMapProba = new HashMap<Integer, String[]>();

		if (sc.hasNextLine())
			nbSommet = Integer.parseInt(sc.nextLine());
		if (sc.hasNextLine())
			departArrivee = sc.nextLine().split("\\s+");
		while (sc.hasNextLine() && count < nbSommet) {
			line = sc.nextLine();
			hashMapProba.put(count, line.split("\\s+"));
			count++;
		}
		sc.close();
		int depart = Integer.parseInt(departArrivee[0]);
		int arrivee = Integer.parseInt(departArrivee[1]);
		HashMap<Integer, Double> minProba = new HashMap<Integer, Double>();

		ArrayList<Integer> noeudVisite = new ArrayList<Integer>();
		minProba.put(depart, 1.0);
		while (noeudVisite.size() < nbSommet - 1) {
			for (Integer key : minProba.keySet()) {
				if (key != arrivee && !noeudVisite.contains(key)) {
					noeudVisite.add(key);
					for (int sommet = 0; sommet < nbSommet; sommet++) {
						if (noeudVisite.contains(sommet)) {
							continue;
						}
						double proba = calculateProba(minProba.get(key),
								Double.parseDouble(hashMapProba.get(key)[sommet]));
						addMin(minProba, proba, sommet);
					}
				}
			}
		}
		System.out.println(((double) Math.round((1 - minProba.get(arrivee)) * 1000)) / 1000);
	}

	public static double calculateProba(double currentProba, double probaToNextNode) {
		return (currentProba) * (1 - probaToNextNode);
	}

	public static void addMin(HashMap<Integer, Double> minProba, double proba, int node) {
		if (minProba.containsKey(node)) {
			if (minProba.get(node) < proba)
				minProba.put(node, proba);
		} else {
			minProba.put(node, proba);
		}
	}
}
