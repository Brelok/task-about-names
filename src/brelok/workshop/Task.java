package brelok.workshop;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Task {
    public static void main(String[] args) {

        Path path = Paths.get("/Users/brelok/workspace/task_about_names/names.txt");

        List<String> names = getNamesFromFile(path);

        Map<Integer, String> sortedNames = sortNamesAndPutIntoMap(names);

        Map<Integer, String> valuesOfLetters = getMapWithValuesOfLetters();


        System.out.println();


    }

    private static Map<Integer, String> getMapWithValuesOfLetters() {

        String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        Map<Integer, String> map = new HashMap<>();
        for (int i = 1; i < alphabet.length + 1; i++) {
            map.put(i, alphabet[i - 1]);
        }
        return map;
    }

    private static Map<Integer, String> sortNamesAndPutIntoMap(List<String> list) {
        List<String> sortedName = list.stream()
                .sorted()
                .collect(Collectors.toList());

        Map<Integer, String> map = new HashMap<>();

        for (int i = 1; i < sortedName.size() + 1; i++) {
            map.put(i, sortedName.get(i - 1));
        }

        return map;
    }

    private static List<String> getNamesFromFile(Path path) {

        StringBuilder stringBuilder = new StringBuilder();
        List<String> list = new ArrayList<>();
        try {
            for (String line :
                    Files.readAllLines(path)) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] namesArray = stringBuilder.toString().split(",");

        return Arrays.asList(namesArray);


    }
}
