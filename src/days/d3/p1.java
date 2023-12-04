package days.d3;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import util.Input;

public class p1 {
    public static void main(String[] args) throws FileNotFoundException {

        Input input = new Input("src/input/day3.txt");
        ArrayList<String> lines = input.ReadLinesAsList();

        int rows = lines.size() + 2;
        int cols = lines.get(0).length() + 2;

        Character[][] numbers = new Character[rows][cols];
        Character[][] symbols = new Character[rows][cols];

        for (int i = 0; i < 140; i++) {
            for (int j = 0; j < 140; j++) {
                if (Character.isDigit(lines.get(i).charAt(j))) {
                    numbers[i + 1][j + 1] = lines.get(i).charAt(j);
                } else if (lines.get(i).charAt(j) != '.') {
                    symbols[i + 1][j + 1] = lines.get(i).charAt(j);
                }
            }
        }

        int sum = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (numbers[i][j] != null) {
                    int w = 0;
                    while (numbers[i][j + w] != null) {
                        w++;
                    }
                    for (int k = i - 1; k <= i + 1; k++) {
                        for (int l = j - 1; l <= j + w; l++) {
                            if (symbols[k][l] != null) {
                                StringBuilder sb = new StringBuilder();
                                for (int o = j; o < j + w; o++) {
                                    sb.append(numbers[i][o]);
                                }

                                sum += Integer.parseInt(sb.toString());

                            }
                        }
                    }
                    j = j + w;
                }

            }
        }

        System.out.println(sum);

    }
}
