package SalesforceBuilding;

import java.util.*;

public class IsoContest {
	public static void main(String[] args) throws Exception {
        HashMap<Integer, Integer> hashTable = new HashMap<Integer, Integer>();
        int maxRoom = 0;
        int teamNumber = 0;
        int count = 0;
        int L = 0;
        String line;
        int sumMinus;
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLine())
            maxRoom = Integer.parseInt(sc.nextLine());
        if (sc.hasNextLine())
            teamNumber = Integer.parseInt(sc.nextLine());
        while (sc.hasNextLine() && count < teamNumber) {
            line = sc.nextLine();
            if (Integer.parseInt(line) == maxRoom) {
                L++;
            } else {
                sumMinus = maxRoom - Integer.parseInt(line);
                if (!hashTable.isEmpty() && hashTable.containsKey(sumMinus)) {
                    int numberOfOccurence = hashTable.get(sumMinus) -1;
                    if(numberOfOccurence == 0)
                        hashTable.remove(sumMinus);
                    else{
                        hashTable.put(sumMinus, numberOfOccurence);
                    }
                    L++;
                } else {
                    if (!hashTable.containsKey(Integer.parseInt(line)))
                        hashTable.put(Integer.parseInt(line), 1);
                    else {
                        int newValue = hashTable.get(Integer.parseInt(line));
                        hashTable.put(Integer.parseInt(line), newValue+1);
                    }
                }
            }
            count++;
            /* Lisez les données et effectuez votre traitement */
        }
        System.out.println(L);
    /* Vous pouvez aussi effectuer votre traitement une fois que vous avez lu toutes les données.*/
    }
}
