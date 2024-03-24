package com.p2p;

// imports
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Represents and stores Peer Instance Info -> client and server too
 */
public class peerProcess {
    private ServerSocket serverSocket;
    private CommonConfig commonConfig;
    public RemotePeerInfo remotePeerInfo;
    public List<RemotePeerInfo> peers;
    private int port;
    private MessageHandler mh;
    private Message message;
    private Data data;


    // Constructor to initialize a peerProcess object with a remote peer and port
    public peerProcess(RemotePeerInfo rm, int p) {
        remotePeerInfo = rm;
        port = p;
    }

    // Method to start the peer process
    public void start() {
        // Load common configuration file
        this.data = new Data("../P2P/data/" + remotePeerInfo.peerId, remotePeerInfo.peerId);
        this.commonConfig = new CommonConfig();
        this.commonConfig.loadCommonFile("../P2P/config/Common.cfg");

        // Print information about starting peer
        System.out.println("Starting peer: " + remotePeerInfo.peerId);

        this.data.listFiles();

        // Retrieve peers information
        getPeersInfo();

        // Uncomment to start server or client
        // startClient();
        // startServer();
    }

    // Method to start the server for peer-to-peer communication
    private void startServer() {
        try {
            // Create server socket
            serverSocket = new ServerSocket(port);
            System.out.println("Peer process started. Listening on port " + port);

            // Accept incoming connection from client
            System.out.println("Waiting for incoming connection from client...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Connection accepted from client.");

            // Close the socket once done with the connection
            clientSocket.close();
        } catch (IOException e) {
            System.err.println("Error starting server: " + e.getMessage());
        }
    }

    // Method to retrieve information about peers
    private void getPeersInfo() {
        StartRemotePeers myStart = new StartRemotePeers();
        myStart.getConfiguration();
        peers = myStart.peerInfoVector;
    }

    // Method to start the client for peer-to-peer communication
    private void startClient() {
        for (RemotePeerInfo peer : peers) {
            // Connect to the server
            if (Integer.parseInt(peer.peerId) < Integer.parseInt(remotePeerInfo.peerId)) {

                try {
                    System.out.println("Connecting to server...");
                    Socket serverSocket = new Socket(peer.peerAddress, Integer.parseInt(peer.listeningPort));
                    System.out.println("Connected to server: " + peer.peerId);

                    // Send handshake message to server
                    System.out.println("Sending handshake message to server...");
                    performHandshake(serverSocket);
                    System.out.println("Handshake with server completed.");

                    // Close the connection
                    serverSocket.close();
                    System.out.println("Connection closed.");
                } catch (IOException e) {
                    System.err.println("Error connecting to server " + peer.peerId + ": " + e.getMessage());
                }
            } else {
                break; // Exit loop if peer ID is greater or equal to remotePeerInfo.peerId
            }
        }
    }

    // Method to perform handshake with a peer
    private void performHandshake(Socket socket) {

        try {
            // Create a handshake message to send to the peer
            HandshakeMessage handshakeMessage = new HandshakeMessage("CUSTOM_HEADER", Integer.parseInt(remotePeerInfo.peerId));

            // Send the handshake message to the peer
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(handshakeMessage);
            outputStream.flush();
            System.out.println("Sent handshake message to peer.");

            // Receive the handshake response from the peer
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            HandshakeMessage response = (HandshakeMessage) inputStream.readObject();
            System.out.println("Received handshake response from peer: " + response.getPeerId());

            // Process the handshake response if needed
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error performing handshake: " + e.getMessage());
        }
    }

    // Method to print common configuration details
    public void printCommonConfig(){

        System.out.println("File Name: " + commonConfig.getFileName());
        System.out.println("File Size: " + commonConfig.getFileSize());
        System.out.println("Piece Size: " + commonConfig.getPieceSize());
        System.out.println("# of nbg: " + commonConfig.getNumberOfPreferredNeighbors());
    }

    // Method to print peer information
    public void printPeerInfo(){

        System.out.println("Peer Id: " + remotePeerInfo.peerId);
        System.out.println("Peer Addy: " + remotePeerInfo.peerAddress);
        System.out.println("Peer Port: " + port);
        System.out.println("Has complete file: " + ((remotePeerInfo.bitField == 0) ? "False": "True"));
    }

    // Method to print peer ID
    public void printId(){

        System.out.println("Peer ID: " + this.remotePeerInfo.peerId);
    }

    // Main method
    public static void main(String[] args) {

        if (args.length != 1) {
            // Check for correct command-line arguments
            System.err.println("Usage: java peerProcess <peerID>");
            System.exit(1);
        }

        // Process command-line arguments
        // Not implemented in provided code snippet
    }
}
