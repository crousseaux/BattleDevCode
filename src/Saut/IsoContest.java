package Saut;

import java.util.*;

public class IsoContest {
    public static void main( String[] argv ) throws Exception {
        String  line;
        Scanner sc = new Scanner(System.in);
        int lgNiv = 0;
        String[] caract = new String[0];
        if (sc.hasNextLine())
            lgNiv = Integer.parseInt(sc.nextLine());
        if (sc.hasNextLine())
            caract = sc.nextLine().split("-");
        int max =1;
        for (int i=0; i<caract.length; i++){
            max = (max < caract[i].length()) ? caract[i].length() : max;
        }
        System.out.println(max);
    }
}