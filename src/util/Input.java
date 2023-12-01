package util;

import java.io.*;
import java.util.*;

public class Input {

    private String fileName;

    public Input(String fileName) {
        this.fileName = fileName;

        // Example content of input file is:
        // A B
        // C D
    }

    /*
     * This method reads the whole file as one string.
     * You can use this method to get the file content as a string, and process it
     * as you need.
     * For example, you can use this method to read a binary file and count the
     * number of 1s in it.
     * 
     * String fileContent = ReadFileAsString();
     * System.out.println(fileContent); // prints "A BC D"
     */
    public String ReadFileAsString() throws FileNotFoundException {
        Scanner scan = new Scanner(new File(fileName));
        StringBuilder sb = new StringBuilder();
        while (scan.hasNextLine()) {
            sb.append(scan.nextLine());
        }
        return sb.toString();
    }

    /*
     * This method reads the lines of the file as a list of any type.
     * You can use this method to get the file content as a list, and process it as
     * you need.
     * For example, you can use this method to read a file of numbers and find their
     * sum.
     * 
     * ArrayList<String> list = ReadLinesAsList();
     * System.out.println(list); // prints "[A B, C D]"
     */
    public <T> ArrayList<T> ReadLinesAsList() throws FileNotFoundException {
        Scanner scan = new Scanner(new File(fileName));
        ArrayList<T> list = new ArrayList<>();
        while (scan.hasNextLine()) {
            T element = (T) scan.nextLine();
            list.add(element);
        }
        return list;
    }

    /*
     * This method reads the lines of the file as a list of lists of any type.
     * You can use this method to get the file content as a table, and process it as
     * you need.
     * The delimiter is a string that separates the values in each line.
     * For example, you can use this method to read a file of names and ages, and
     * sort them by age.
     * 
     * ArrayList<ArrayList<String>> table = ReadFileAsTable(" ");
     * System.out.println(table); // prints "[[A, B], [C, D]]
     */
    public <T> ArrayList<ArrayList<T>> ReadFileAsTable(String delimiter) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(fileName));
        ArrayList<ArrayList<T>> table = new ArrayList<>();
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] values = line.split(delimiter);
            ArrayList<T> row = new ArrayList<>();
            for (String value : values) {
                T element = (T) value;
                row.add(element);
            }
            table.add(row);
        }
        return table;
    }

    /*
     * This method reads the lines of the file as a two-dimensional array of any
     * type.
     * You can use this method to get the file content as a grid, and process it as
     * you need.
     * For example, you can use this method to read a file of letters and find the
     * longest word in it.
     * 
     * String[][] grid = ReadFileAsGrid(" ");
     * System.out.println(Arrays.deepToString(grid)); // prints "[[A, B], [C, D]]"
     */
    public <T> T[][] ReadFileAsGrid(String delimiter) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(fileName));
        ArrayList<String[]> lines = new ArrayList<>();
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] values = line.split(delimiter);
            lines.add(values);
        }
        int rows = lines.size();
        int cols = lines.get(0).length;
        T[][] grid = (T[][]) new Object[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                T element = (T) lines.get(i)[j];
                grid[i][j] = element;
            }
        }
        return grid;
    }

    /*
     * This method reads the lines of the file as a one-dimensional array of any
     * type.
     * You can use this method to get the file content as an array, and process it
     * as you need.
     * For example, you can use this method to read a file of numbers and find the
     * sum of them.
     * 
     * Integer[] array = ReadFileAsArray(" ");
     * System.out.println(Arrays.toString(array)); // prints "[1, 2, 3, 4]"
     */
    public <T> T[] ReadFileAsArray(String delimiter) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(fileName));
        ArrayList<String> lines = new ArrayList<>();
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] values = line.split(delimiter);
            for (String value : values) {
                lines.add(value);
            }
        }
        int size = lines.size();
        T[] array = (T[]) new Object[size];
        for (int i = 0; i < size; i++) {
            T element = (T) lines.get(i);
            array[i] = element;
        }
        return array;
    }

    /*
     * This method reads the lines of the file as a set of any type.
     * You can use this method to get the file content as a set, and process it as
     * you need.
     * A set is a collection that does not allow duplicate elements. You can use a
     * set to store unique values, such as names or IDs.
     * For example, you can use this method to read a file of names and find out how
     * many different names there are.
     * 
     * HashSet<String> set = ReadLinesAsSet();
     * System.out.println(set); // prints "[A B, C D]"
     */
    public <T> HashSet<T> ReadLinesAsSet() throws FileNotFoundException {
        Scanner scan = new Scanner(new File(fileName));
        HashSet<T> set = new HashSet<>();
        while (scan.hasNextLine()) {
            T element = (T) scan.nextLine();
            set.add(element);
        }
        return set;
    }

    /*
     * This method reads the lines of the file as a map of any type.
     * You can use this method to get the file content as a map, and process it as
     * you need.
     * A map is a collection that stores key-value pairs. You can use a map to store
     * associations between two values, such as names and phone numbers.
     * The delimiter is a string that separates the key and the value in each line.
     * For example, you can use this method to read a file of names and phone
     * numbers, and find the phone number of a given name.
     * 
     * HashMap<String, String> map = ReadLinesAsMap(" ");
     * System.out.println(map); // prints "{A=B, C=D}"
     */
    public <K, V> HashMap<K, V> ReadLinesAsMap(String delimiter) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(fileName));
        HashMap<K, V> map = new HashMap<>();
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] pair = line.split(delimiter);
            K key = (K) pair[0].trim();
            V value = (V) pair[1].trim();
            map.put(key, value);
        }
        return map;
    }

    /*
     * This method reads the lines of the file as a list of pairs of any type.
     * You can use this method to get the file content as a list, and process it as
     * you need.
     * A pair is a data structure that stores two values, such as coordinates or
     * ranges. You can use a pair to store related values, such as start and end
     * times or lower and upper bounds.
     * The delimiter is a string that separates the first and the second value in
     * each line. You can choose the delimiter according to the format of the file.
     * For example, you can use this method to read a file of coordinates and find
     * the distance between them.
     * 
     * ArrayList<Pair<String, String>> pairs = ReadLinesAsPairList(" ");
     * System.out.println(pairs); // prints "[(A, B), (C, D)]"
     */
    public <A, B> ArrayList<Pair<A, B>> ReadLinesAsPairList(String delimiter) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(fileName));
        ArrayList<Pair<A, B>> pairs = new ArrayList<>();
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] values = line.split(delimiter);
            A first = (A) values[0].trim();
            B second = (B) values[1].trim();
            pairs.add(new Pair<>(first, second));
        }
        return pairs;
    }

}
