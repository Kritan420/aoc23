package days.d2;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

import util.Input;

public class p1 {

    public static void main(String[] args) throws FileNotFoundException {

        Input input = new Input("src/input/day2.txt");
        ArrayList<String> lines = input.ReadLinesAsList();
        HashMap<Integer, HashMap<String, Integer>> games = new HashMap<>();

        Integer id = 0;

        for (String line : lines) {
            HashMap<String, Integer> colorsPerGame = new HashMap<>();
            int maxblue = 0;
            int maxgreen = 0;
            int maxred = 0;

            id++;
            line = line.substring(8).trim();
            String[] set = line.split("; ");
            for (String s : set) {
                String[] colorPerSet = s.split(", ");
                for (String cs : colorPerSet) {
                    if (cs.contains("blue")) {
                        int bb = Integer.parseInt(cs.replaceAll("[^0-9]", "").trim());
                        if (bb > maxblue) {
                            maxblue = bb;
                        }
                    }
                    if (cs.contains("green")) {
                        int gg = Integer.parseInt(cs.replaceAll("[^0-9]", "").trim());
                        if (gg > maxgreen) {
                            maxgreen = gg;
                        }
                    }
                    if (cs.contains("red")) {
                        int rr = Integer.parseInt(cs.replaceAll("[^0-9]", "").trim());
                        if (rr > maxred) {
                            maxred = rr;
                        }
                    }
                }
            }
            colorsPerGame.put("blue", maxblue);
            colorsPerGame.put("green", maxgreen);
            colorsPerGame.put("red", maxred);

            games.put(id, colorsPerGame);
        }

        int bagred = 12;
        int baggreen = 13;
        int bagblue = 14;

        int sumId = 0;

        for (int i = 1; i < games.size() + 1; i++) {
            if (games.get(i).get("blue") <= bagblue && games.get(i).get("green") <= baggreen
                    && games.get(i).get("red") <= bagred) {
                sumId += i;
            }
        }

        System.out.println(sumId);
    }
}