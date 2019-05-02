package io.github.wangyuxiang0829.util.myio;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * An object the represent the output
 * @see PrintWriter
 */
public class Out {
    private PrintWriter printWriter;




    /**
     * Constructor
     * Construct the Out object that write to a file
     * @param sourceFileName the name of the file to be written to
     */
    public Out(String sourceFileName) {
        File file = new File(sourceFileName);
        try {
             if (!file.exists()) {
                 boolean b = file.createNewFile();
             }
            printWriter = new PrintWriter(file);
        } catch (IOException e) {
            System.out.println("An I/O error occurred");
            throw new RuntimeException(e);
        }
    }

    /**
     * Constructor
     * Construct the Out object that write to the standard output
     */
    public Out() {
        printWriter = new PrintWriter(System.out);
    }




    /**
     * Terminate the current line in the specified output stream
     */
    public void println() {
        printWriter.println();
    }

    /**
     * Print an int to the specified output stream and then terminate the line
     * @param i the variable to be printed
     */
    public void println(int i) {
        printWriter.println(i);
    }

    /**
     * Print a double to the specified output stream and then terminate the line
     * @param d the variable to be printed
     */
    public void println(double d) {
        printWriter.println(d);
    }

    /**
     * Print a boolean to the specified output stream and then terminate the line
     * @param b the variable to be printed
     */
    public void println(boolean b) {
        printWriter.println(b);
    }

    /**
     * Print a byte to the specified output stream and then terminate the line
     * @param b the variable to be printed
     */
    public void println(byte b) {
        printWriter.println(b);
    }

    /**
     * Print a short to the specified output stream and then terminate the line
     * @param s the variable to be printed
     */
    public void println(short s) {
        printWriter.println(s);
    }

    /**
     * Print a long to the specified output stream and then terminate the line
     * @param l the variable to be printed
     */
    public void println(long l) {
        printWriter.println(l);
    }

    /**
     * Print a float to the specified output stream and then terminate the line
     * @param f the variable to be printed
     */
    public void println(float f) {
        printWriter.println(f);
    }

    /**
     * Print a char to the specified output stream and then terminate the line
     * @param c the variable to be printed
     */
    public void println(char c) {
        printWriter.println(c);
    }

    /**
     * Print an object to the specified output stream and then terminate the line
     * @param o the object to be printed
     */
    public void println(Object o) {
        printWriter.println(o);
    }

    /**
     * Print an int to the specified output stream
     * @param i the variable to be printed
     */
    public void print(int i) {
        printWriter.print(i);
    }

    /**
     * Print a double to the specified output stream
     * @param d the variable to be printed
     */
    public void print(double d) {
        printWriter.print(d);
    }

    /**
     * Print a boolean to the specified output stream
     * @param b the variable to be printed
     */
    public void print(boolean b) {
        printWriter.print(b);
    }

    /**
     * Print a byte to the specified output stream
     * @param b the variable to be printed
     */
    public void print(byte b) {
        printWriter.print(b);
    }

    /**
     * Print a short to the specified output stream
     * @param s the variable to be printed
     */
    public void print(short s) {
        printWriter.print(s);
    }

    /**
     * Print a long to the specified output stream
     * @param l the variable to be printed
     */
    public void print(long l) {
        printWriter.print(l);
    }

    /**
     * Print a float to the specified output stream
     * @param f the variable to be printed
     */
    public void print(float f) {
        printWriter.print(f);
    }

    /**
     * Print a char to the specified output stream
     * @param c the variable to be printed
     */
    public void print(char c) {
        printWriter.print(c);
    }

    /**
     * Print an object to the specified output stream
     * @param o the object to be printed
     */
    public void print(Object o) {
        printWriter.print(o);
    }

    /**
     * Flush this output stream
     */
    public void flush() {
        printWriter.flush();
    }
}
