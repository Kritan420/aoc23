package days.d1;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import util.Input;

public class p1 {

    public static void main(String[] args) throws FileNotFoundException {

        Input input = new Input("src/input/day1.txt");

        ArrayList<String> lines = input.ReadLinesAsList();

        int sum = 0;

        String line;

        for (int i = 0; i < lines.size(); i++) {
            line = lines.get(i).replaceAll("[a-zA-Z]", "");
            StringBuilder sb = new StringBuilder();
            sb.append(line.charAt(0));
            sb.append(line.charAt(line.length() - 1));
            lines.set(i, sb.toString());
        }

        for (String s : lines) {
            sum += Integer.parseInt(s);
        }

        System.out.println(sum);
    }

}
