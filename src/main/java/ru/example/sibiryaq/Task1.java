package ru.example.sibiryaq;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        String filePath = "resources/input.txt";
        int totalDistance = calculateTotalDistance(filePath);
        System.out.println("Общее расстояние : " + totalDistance);
    }

    public static int calculateTotalDistance(String filePath) {
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

        Collections.sort(leftColumn);
        Collections.sort(rightColumn);

        int totalDistance = 0;
        for (int i = 0; i < leftColumn.size(); i++) {
            totalDistance += Math.abs(leftColumn.get(i) - rightColumn.get(i));
        }

        return totalDistance;
    }
}
