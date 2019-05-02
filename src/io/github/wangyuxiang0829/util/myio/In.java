package io.github.wangyuxiang0829.util.myio;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * An Object that represent the input
 * @see Scanner
 * @see Pattern
 */
public class In {
    /**
     * The beginning of a line
     */
    private static final Pattern BEGINNING_OF_LINE = Pattern.compile("^");

    /**
     * The beginning of the input
     */
    private static final Pattern BEGINNING_OF_INPUT = Pattern.compile("\\A");

    /**
     * One or more whitespace characters
     */
    private static final Pattern WHITESPACE = Pattern.compile("\\s+");

    /**
     * A scanner used to parse primitive types and strings in a given input stream
     */
    private Scanner scanner;



    /**
     * Constructor:
     * Scanned from the standard input stream
     */
    public In() {
        scanner = new Scanner(System.in);
    }

    /**
     * Constructor:
     * Scanned from the specified file
     */
    public In(String sourceFileName) {
        try {
            File file = new File(sourceFileName);
            FileInputStream fileInputStream = new FileInputStream(file);
            scanner = new Scanner(new BufferedInputStream(fileInputStream));
        } catch (FileNotFoundException e) {
            System.out.println("The specified file doesn't exist.");
            throw new RuntimeException(e);
        }
    }



    /**
     * Read all from the specified input stream as a string
     * @return a string that represent the input stream
     */
    public String readAll() {
        return scanner.useDelimiter(BEGINNING_OF_INPUT).next();
    }

    /**
     * Read the next line from the specified input stream as a string
     * @return a string that represent the next line
     */
    public String readNextLine() {
        return scanner.useDelimiter(BEGINNING_OF_LINE).next();
    }

    /**
     * Whether there is also another line in the input stream
     * @return true if have the next line
     */
    public boolean hasNextLine() {
        return scanner.useDelimiter(BEGINNING_OF_LINE).hasNext();
    }

    /**
     * Reads all remaining tokens from this input stream and returns them as an array of strings
     * @see System to see the use of static method System.arraycopy
     * @return an array of strings remaining in the input stream
     */
    public String[] readAllStrings() {
        String[] strings = WHITESPACE.split(readAll());
        if (strings.length == 0 || strings[0].length() > 0)
            return strings;
        String[] anotherStrings = new String[strings.length - 1];
        System.arraycopy(strings, 1, anotherStrings, 0, anotherStrings.length);
        return anotherStrings;
    }

    /**
     * Read all from the specified input stream as an array of Integer
     * @return an array of Integer that read from the input stream
     */
    public Integer[] readAllIntegers() {
        String[] strings = readAllStrings();
        Integer[] integers = new Integer[strings.length];
        for (int i = 0; i < integers.length; i++)
            integers[i] = Integer.parseInt(strings[i]);
        return integers;
    }

    /**
     * Read all from the specified input stream as an array of Double
     * @return an array of Double the read from the input stream
     */
    public Double[] readAllDoubles() {
        String[] strings = readAllStrings();
        Double[] doubles = new Double[strings.length];
        for (int i = 0; i < doubles.length; i++)
            doubles[i] = Double.parseDouble(strings[i]);
        return doubles;
    }

}
