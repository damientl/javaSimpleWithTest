package org.example.hackerplat;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExJson {
    public static List<String> compare(String json1, String json2) {
        List<String> result = new ArrayList<>();

        JsonObject jsonObject = JsonParser.parseString(json1).getAsJsonObject();
        JsonObject jsonObject2 = JsonParser.parseString(json2).getAsJsonObject();
        jsonObject.entrySet().forEach(e -> {
            String thisKey = e.getKey();
            JsonElement thisElement = e.getValue();
            var otherElement = jsonObject2.get(thisKey);
            if(otherElement!= null && !areElementsEquals(thisElement, otherElement)){
                result.add(thisKey);
            }

        });
        Collections.sort(result);
        return result;
    }

    private static boolean areElementsEquals(JsonElement thisElement, JsonElement otherElement) {
        return thisElement.getAsString().equals(otherElement.getAsString());
    }
}
