package com.perezma.practice;

import java.io.File;
import java.io.FileFilter;

/**
 * This class will filter file names in a directory for those ending in ".java".
 *
 */
public class FirstLambda20220604 {

    public static void main(String[] args) {

        // Step 1: create an anonymous class using FileFilter interface
        //         the accept method returns true if the pathname ends in ".java"

        FileFilter filterAnon = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".java");
            }
        };

        // Step 2: convert the anonymous class to a Lambda expression
        //      i: copy the input argument block, include parens, from the accept method.
        //     ii: add the "->" operator.
        //    iii: copy the accept method return block.

        FileFilter filterLambda = (File pathname) -> pathname.getName().endsWith(".java");

        // Step 3: use File to get directory "d:/temp" which contains several files in it.

        File dir = new File("d:/tmp");

        // Step 4: use anonymous class to read and filter results into a File array.
        // Print results to verify it's working.

        File[] filesAnon = dir.listFiles(filterAnon);
        System.out.println("Filter using anonymous class..");
        for(File f: filesAnon) {
            System.out.println(f);
        }

        // Step 5: use lambda expression to read and filter results into a File array.
        // Print results to verify it's working.

        File[] filesLambda = dir.listFiles(filterLambda);
        System.out.println("Filter using lambda expression..");
        for(File f : filesLambda) {
            System.out.println(f);
        }

    }
}
