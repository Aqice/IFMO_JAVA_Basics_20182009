package ru.ifmo.cet.javabasics;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.nio.file.Files.readAllLines;


public class WarAndPeaceExercise {

    public static String warAndPeace() {
        final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
        final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");

        // TODO map lowercased words to its amount in text and concatenate its entries.
        // TODO Iff word "котик" occurred in text 23 times then its entry would be "котик - 23\n".
        // TODO Entries in final String should be also sorted by amount and then in alphabetical order iff needed.
        // TODO Also omit any word with lengths less than 4 and frequency less than 10

        String data = "";
        try {
            data += readAllLines(tome12Path, Charset.forName("windows-1251")).stream().collect(Collectors.joining(" "));
            data += readAllLines(tome34Path, Charset.forName("windows-1251")).stream().collect(Collectors.joining(" "));
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

        data = data.replaceAll("[^a-zA-Zа-яА-Я]", " ").toLowerCase();
        String[] words = data.split(" ");
        Stream <String> wordStream = Stream.of(words);

        Map<String, Integer> map = new HashMap<String, Integer>();

        wordStream.forEach(
                (String word) -> map.put(word, map.getOrDefault(word,0) + 1)
        );

        List<Map.Entry<String,Integer>> sortedMapList = new ArrayList<>(map.entrySet());

        Collections.sort(sortedMapList, (o1, o2) ->
                (o1.getValue().equals(o2.getValue())) ? o1.getKey().compareTo(o2.getKey())
                        : o2.getValue().compareTo(o1.getValue()));

        return sortedMapList.stream()
                .filter(item -> item.getValue() >= 10 && item.getKey().length() >= 4)
                .map(item -> item.getKey() + " - " + item.getValue())
                .collect(Collectors.joining("\n"));
    }

}