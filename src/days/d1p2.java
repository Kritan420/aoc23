package days;

import util.Input;

import java.io.FileNotFoundException;
import java.util.*;

public class d1p2 {

    public static void main(String[] args) throws FileNotFoundException {

        Input input = new Input("src/input/day1.txt");

        ArrayList<String> lines = input.ReadLinesAsList();

        HashMap<String, String> map = new LinkedHashMap<>();
        map.put("oneight", "oneeight");
        map.put("twone", "twoone");
        map.put("threeight", "threeeight");
        map.put("fiveight", "fiveeight");
        map.put("sevenine", "sevennine");
        map.put("eightwo", "eighttwo");
        map.put("nineight", "nineeight");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");

        int sum = 0;
        String line;

        for (int i = 0; i < lines.size(); i++) {
            line = lines.get(i);

            for (Map.Entry<String, String> entry : map.entrySet()) {
                line = line.replaceAll(entry.getKey(), entry.getValue());
            }

            line = line.replaceAll("[^1-9]", "");

            StringBuilder sb = new StringBuilder();
            sb.append(line.charAt(0));
            sb.append(line.charAt(line.length() - 1));
            sum += Integer.parseInt(sb.toString());
        }

        System.out.println(sum);
    }
}
