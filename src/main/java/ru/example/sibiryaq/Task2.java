package ru.example.sibiryaq;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task2 {
    public static void main(String[] args) {
        String filePath = "src/main/resources/input.txt"; // Укажите относительный путь к вашему файлу
        int similarityScore = calculateSimilarityScore(filePath);
        System.out.println("Оценка сходства: " + similarityScore);
    }

    public static int calculateSimilarityScore(String filePath) {
        List<Integer> leftColumn = new ArrayList<>();
        List<Integer> rightColumn = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split("\\s+");
                leftColumn.add(Integer.parseInt(values[0]));
                rightColumn.add(Integer.parseInt(values[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Подсчет частоты каждого числа в правом списке
        Map<Integer, Integer> rightColumnFrequency = new HashMap<>();
        for (int number : rightColumn) {
            rightColumnFrequency.put(number, rightColumnFrequency.getOrDefault(number, 0) + 1);
        }

        // Вычисление оценки сходства
        int similarityScore = 0;
        for (int number : leftColumn) {
            int frequency = rightColumnFrequency.getOrDefault(number, 0);
            similarityScore += number * frequency;
        }

        return similarityScore;
    }
}
