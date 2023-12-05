package days.d3;

import java.awt.Point;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import util.Input;

public class p2 {

    public static void main(String[] args) throws FileNotFoundException {

        Input input = new Input("src/input/day3.txt");

        ArrayList<String> lines = input.ReadLinesAsList();
        HashMap<Point, Integer> pnbrs = new HashMap<Point, Integer>();
        ArrayList<Point> psmbls = new ArrayList<>();

        psmbls.re

        int rows = lines.size();
        int cols = lines.get(0).length();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (Character.isDigit(lines.get(i).charAt(j))) {
                    int w = j;
                    StringBuilder sb = new StringBuilder();
                    while (w < rows && Character.isDigit(lines.get(i).charAt(w))) {
                        sb.append(lines.get(i).charAt(w));
                        w++;
                    }
                    for (int e = j; e < w; e++) {
                        pnbrs.put(new Point(e, i), Integer.parseInt(sb.toString()));
                    }
                    j = w - 1;
                } else if (lines.get(i).charAt(j) == '*') {
                    psmbls.add(new Point(j, i));
                }
            }
        }

        int sum = 0;

        for (Point p : psmbls) {
            ArrayList<Point> neighb = new ArrayList();
            neighb.add(new Point(p.x - 1, p.y - 1));
            neighb.add(new Point(p.x - 1, p.y));
            neighb.add(new Point(p.x - 1, p.y + 1));
            neighb.add(new Point(p.x, p.y - 1));
            neighb.add(new Point(p.x, p.y + 1));
            neighb.add(new Point(p.x + 1, p.y));
            neighb.add(new Point(p.x + 1, p.y - 1));
            neighb.add(new Point(p.x + 1, p.y + 1));

            Set<Integer> uniq = new HashSet<>();
            Set<Integer> countd = new HashSet<>();

            for (Point neighbor : neighb) {
                if (pnbrs.containsKey(neighbor)) {
                    uniq.add(pnbrs.get(neighbor));
                }
            }

            for (int value : uniq) {
                if (!countd.contains(value)) {
                    countd.add(value);
                }
            }

            if (uniq.size() == 2) {
                Integer[] arr = uniq.toArray(new Integer[0]);
                sum += arr[0] * arr[1];
            }

        }
        System.out.println(sum);
    }

}
