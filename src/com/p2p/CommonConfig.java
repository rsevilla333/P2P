package com.p2p;


import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommonConfig {
    private Map<String, String> configValues;

    public CommonConfig() {
        this.configValues = new HashMap<>();
    }

    public void loadCommonFile(String fileName) {
        try (FileReader fileReader = new FileReader(fileName);
             Scanner scanner = new Scanner(fileReader)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");

                if (parts.length == 2) {
                    configValues.put(parts[0], parts[1]);
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public int getNumberOfPreferredNeighbors() {
        return Integer.parseInt(configValues.getOrDefault("NumberOfPreferredNeighbors", "0"));
    }

    public int getUnchokingInterval() {
        return Integer.parseInt(configValues.getOrDefault("UnchokingInterval", "0"));
    }

    public int getOptimisticUnchokingInterval() {
        return Integer.parseInt(configValues.getOrDefault("OptimisticUnchokingInterval", "0"));
    }

    public String getFileName() {
        return configValues.getOrDefault("OptimisticUnchokingInterval", "0");
    }

    public int getFileSize() {
        return Integer.parseInt(configValues.getOrDefault("FileSize", "0"));
    }

    public int getPieceSize() {
        return Integer.parseInt(configValues.getOrDefault("PieceSize", "0"));
    }
}