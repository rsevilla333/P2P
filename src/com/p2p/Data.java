package com.p2p;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Data {

    private List<String> filePaths; // Private field to store file paths
    private String path;

    private String peerId;

    /**
     * Constructor for Data class
     *
     * @param dirPath The path of the directory to search for files.
     */
    public Data(String dirPath, String peeId) {
        path = dirPath;
        peerId = peeId;
        filePaths = new ArrayList<>();
        getAllFiles();
    }

    /**
     * Retrieves a list of file paths within the specified directory.
     *
     */
    private void getAllFiles() {
        File directory = new File(path);

        // Check if the directory exists
        if (directory.exists() && directory.isDirectory()) {
            // Get all files in the directory
            File[] files = directory.listFiles();
            if (files != null) {
                // Add the paths of all files to the list
                for (File file : files) {
                    if (file.isFile()) {
                        filePaths.add(file.getAbsolutePath());
                    }
                }
            }
        } else {
            System.err.println("Directory does not exist or is not a directory: " + path);
        }
    }

    /**
     * Retrieves the list of file paths.
     *
     * @return The list of file paths.
     */
    public List<String> getFilePaths() {
        return filePaths;
    }

    /**
     * Lists the files and prints out their names with extensions.
     */
    public void listFiles() {

        System.out.println("Files in " + peerId + ": ");
        for (String filePath : filePaths) {
            File file = new File(filePath);
            if (file.exists() && file.isFile()) {
                System.out.println(file.getName()); // Print only the file name with extension
            }
        }

    }

    /**
     * Main method to demonstrate usage of the Data class.
     *
     * @param args Command-line arguments (not used in this example).
     */
//    public static void main(String[] args) {
//        // Example usage
//        Data data = new Data();
//
//        // Specify the directory path to search for files
//        String directoryPath = "/path/to/your/directory";
//
//        // Retrieve list of files within the specified directory
//        data.getAllFiles(directoryPath);
//
//        // List and print the files
//        data.listFiles();
//    }
}
