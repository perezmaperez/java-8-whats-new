package com.perezma;

import java.io.File;
import java.io.FileFilter;

/**
 * This class will filter file names in a directory for those ending in ".java".
 *
 */
public class FirstLambda {

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

        File dir = new File(
                "d:/tmp");

        // using anonymous class
        File[] filesAnon = dir.listFiles(filterAnon);

        System.out.println("Filter using anonymous class..");
        for (File f : filesAnon) {
            System.out.println(f);
        }
        // output separator
        System.out.println();

        // using lambda expression
        File[] filesLambda = dir.listFiles(filterLambda);

        System.out.println("Filter using lambda expression..");
        for (File f : filesLambda) {
            System.out.println(f);
        }
    }

}
