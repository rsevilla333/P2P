package com.p2p;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Utility class to load and provide access to common configuration settings.
 */
public class CommonConfig {

    // Map to store configuration key-value pairs
    private Map<String, String> configValues;

    /**
     * Constructs a new CommonConfig object.
     */
    public CommonConfig() {
        this.configValues = new HashMap<>();
    }

    /**
     * Loads common configuration settings from the specified file.
     *
     * @param fileName The name of the file containing configuration settings.
     */
    public void loadCommonFile(String fileName) {
        try (FileReader fileReader = new FileReader(fileName);
             Scanner scanner = new Scanner(fileReader)) {

            // Read each line from the file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Split the line into key-value pairs based on whitespace
                String[] parts = line.split(" ");

                // If there are two parts, add the key-value pair to the map
                if (parts.length == 2) {
                    configValues.put(parts[0], parts[1]);
                }
            }
        } catch (IOException | NumberFormatException e) {
            // Print any exceptions that occur during file reading
            e.printStackTrace();
        }
    }

    /**
     * Gets the number of preferred neighbors from the configuration.
     *
     * @return The number of preferred neighbors.
     */
    public int getNumberOfPreferredNeighbors() {
        return Integer.parseInt(configValues.getOrDefault("NumberOfPreferredNeighbors", "0"));
    }

    /**
     * Gets the unchoking interval from the configuration.
     *
     * @return The unchoking interval.
     */
    public int getUnchokingInterval() {
        return Integer.parseInt(configValues.getOrDefault("UnchokingInterval", "0"));
    }

    /**
     * Gets the optimistic unchoking interval from the configuration.
     *
     * @return The optimistic unchoking interval.
     */
    public int getOptimisticUnchokingInterval() {
        return Integer.parseInt(configValues.getOrDefault("OptimisticUnchokingInterval", "0"));
    }

    /**
     * Gets the file name from the configuration.
     *
     * @return The file name.
     */
    public String getFileName() {
        return configValues.getOrDefault("FileName", "");
    }

    /**
     * Gets the file size from the configuration.
     *
     * @return The file size.
     */
    public int getFileSize() {
        return Integer.parseInt(configValues.getOrDefault("FileSize", "0"));
    }

    /**
     * Gets the piece size from the configuration.
     *
     * @return The piece size.
     */
    public int getPieceSize() {
        return Integer.parseInt(configValues.getOrDefault("PieceSize", "0"));
    }
}
