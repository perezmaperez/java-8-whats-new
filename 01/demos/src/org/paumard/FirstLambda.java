package org.paumard;

import java.io.File;
import java.io.FileFilter;

/**
 *
 * @author José
 */
public class FirstLambda {

    public static void main(String[] args) {

        // anonymous class
        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".java");
            }
        };

        // convert anonymous class to lambda expression
        FileFilter filterLambda = (File pathname) -> pathname.getName().endsWith(".java");

        // test: get files ending in ".java" from directory "d:/tmp".
        File dir = new File("d:/tmp");

        File[] files = dir.listFiles(filter);

        for (File f : files) {
            System.out.println(f);
        }
    }
}
