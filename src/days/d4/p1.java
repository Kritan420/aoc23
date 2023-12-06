package days.d4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class p1 {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scan = new Scanner(new File("src/input/day4.txt"));
        ArrayList<String> lines = new ArrayList<String>();

        int sum = 0;

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            line = line.substring(8);
            String[] card = line.split("[|]");
            ArrayList<String> wins = new ArrayList<>();
            ArrayList<String> haves = new ArrayList<>();
            ArrayList<String> winshaves = new ArrayList<>();
            for (String win : card[0].split(" ")) {
                if (win.length() > 0) {
                    wins.add(win);
                }
            }
            for (String have : card[1].split(" ")) {
                if (have.length() > 0) {
                    haves.add(have);
                }

            }
            winshaves.addAll(wins);
            winshaves.retainAll(haves);
            int result = 0;
            for (int i = 0; i < winshaves.size(); i++) {
                if (result == 0) {
                    result = 1;
                } else {
                    result = result * 2;
                }

            }

            sum += result;

        }
        System.out.println(sum);

    }
}
