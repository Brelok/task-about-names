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

        Map<Integer, String> mapOfLetters = getMapWithValuesOfLetters();

        List<Integer> valuesOfKeysMapOfLetters = new ArrayList<>(mapOfLetters.keySet());

        List<Integer> valuesOfKeysSortedNames = new ArrayList<>(sortedNames.keySet());


        List<Integer> valuesOfEachName = getValuesOfEachName(sortedNames, mapOfLetters, valuesOfKeysMapOfLetters);



        System.out.println(valuesOfEachName);


    }

    private static List<Integer> getValuesOfEachName(Map<Integer, String> sortedNames, Map<Integer, String> mapOfLetters, List<Integer> valuesOfKeysMapOfLetters) {

        List<Integer> valuesOfEachName = new ArrayList<>();
        int valueOfName = 0;
        for (int i = 1; i < sortedNames.size() + 1; i++) {

            String s = sortedNames.get(i);
            String[] arraysStrings = s.split("");

            for (int j = 0; j < s.length(); j++) {

                for (int k = 0; k < mapOfLetters.size() + 1; k++) {

                    if (arraysStrings[j].equals(mapOfLetters.get(k))) {
                        valueOfName += valuesOfKeysMapOfLetters.get(k - 1);
                    }
                }
            }
            valuesOfEachName.add(valueOfName);
            valueOfName = 0;
        }
        return valuesOfEachName;
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
