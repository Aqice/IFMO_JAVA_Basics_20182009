package ru.ifmo.cet.javabasics;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static java.nio.file.Files.readAllLines;

public class WarAndPeaceExercise {

    public static String warAndPeace() {
        final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
        final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");

        // TODO map lowercased words to its amount in text and concatenate its entries.
        // TODO If word "котик" occurred in text 23 times then its entry would be "котик - 23\n".
        // TODO Entries in final String should be also sorted by amount and then in alphabetical order if needed.
        // TODO Also omit any word with lengths less than 4 and frequency less than 10
        Map<String, Integer> map = new HashMap<String, Integer>();
        try {
            for (String bookpart : readAllLines(tome12Path, Charset.forName("windows-1251"))){
                bookpart = bookpart.replaceAll("[^a-zA-Zа-яА-Я]", " ");
                for (String word : bookpart.split(" ")){
                    word = word.toLowerCase();
                    if (map.containsKey(word))
                        map.replace(word, map.get(word) + 1);
                    else
                        map.put(word, 1);
                }
            }
            for(String bookpart : readAllLines(tome34Path, Charset.forName("windows-1251"))){
                bookpart = bookpart.replaceAll("[^a-zA-Zа-яА-Я]", " ");
                for (String word : bookpart.split(" ")){
                    word = word.toLowerCase();
                    if (map.containsKey(word))
                        map.replace(word, map.get(word) + 1);
                    else
                        map.put(word, 1);
                }
            }
        }

        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        List<Map.Entry<String,Integer>> sortedMapList = new ArrayList<>(map.entrySet());

        Collections.sort(sortedMapList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue().equals(o2.getValue()))
                    return o1.getKey().compareTo(o2.getKey());
                else
                    return o2.getValue().compareTo(o1.getValue());

            }
        });
        String result = "";
        for (Map.Entry<String, Integer> entry : sortedMapList) {
            if (entry.getKey().length() >= 4 && entry.getValue() >= 10)
                result += entry.getKey() + " - " + entry.getValue() + "\n";
        }

        return result.substring(0, result.length() - 1);
 //       throw new UnsupportedOperationException();
    }
}