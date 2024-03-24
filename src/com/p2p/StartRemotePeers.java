package com.p2p;

// imports
import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Utility class to read configuration information about remote peers from a file.
 */
public class StartRemotePeers {

    // Vector to store information about remote peers
    public Vector<RemotePeerInfo> peerInfoVector;

    /**
     * Reads configuration information about remote peers from the PeerInfo.cfg file.
     */
    public void getConfiguration() {
        String st;
        peerInfoVector = new Vector<RemotePeerInfo>(); // Initialize the vector to store peer information
        try {
            // Open the configuration file for reading
            BufferedReader in = new BufferedReader(new FileReader("config/PeerInfo.cfg"));
            // Read each line from the file
            while ((st = in.readLine()) != null) {
                // Split the line into tokens based on whitespace
                String[] tokens = st.split("\\s+");
                // Create a new RemotePeerInfo object using the tokens and add it to the vector
                peerInfoVector.addElement(new RemotePeerInfo(tokens[0], tokens[1], tokens[2], tokens[3]));
            }
            // Close the input stream
            in.close();
        } catch (Exception ex) {
            // Print any exceptions that occur during file reading
            System.out.println(ex.toString());
        }
    }
}

