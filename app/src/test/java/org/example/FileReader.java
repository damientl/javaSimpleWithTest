package org.example;

import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class FileReader {
    public static String readFile(String fileName) {
        try {
            return IOUtils.toString(
                    FileReader.class.getClassLoader().getResourceAsStream(fileName),
                    "UTF-8"
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String readFileWithBuffer(String fileName) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                    FileReader.class.getClassLoader().getResourceAsStream(fileName)));
            return bufferedReader.lines()
                    .collect(Collectors.joining(System.lineSeparator()));

    }

}
