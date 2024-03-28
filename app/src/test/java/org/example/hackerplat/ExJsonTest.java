package org.example.hackerplat;

import org.example.FileReader;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExJsonTest {

    @Test
    void compare() {

        var json1 = FileReader.readFileWithBuffer("a.json");
        var json2 = FileReader.readFile("b.json");
        List<String> result = ExJson.compare(json1, json2);
        List<String> expected = List.of("GlossSee", "ID");
        assertIterableEquals(expected, result);

    }


}