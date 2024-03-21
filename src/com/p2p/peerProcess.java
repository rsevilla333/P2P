package com.p2p;

import com.p2p.CommonConfig;

import java.io.IOException;
import java.net.ServerSocket;


public class peerProcess {
    private int peerId;
    private int port;
    private ServerSocket serverSocket;
    private CommonConfig commonConfig;

    public peerProcess(int peerId, int port) {
        this.peerId = peerId;
        this.port = port;
    }

    public void start() {
        this.commonConfig = new CommonConfig();
        startServer();
        startClient();
    }

    private void startServer() {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Peer process started. Listening on port " + port);
        } catch (IOException e) {
            System.err.println("Error starting server: " + e.getMessage());
        }

        // wait for handshake
    }

    private void startClient() {
        // Implement client initialization here

        // send it
    }

    public void printCommonConfig(){
        System.out.println("File Name: " + commonConfig.getFileName());
        System.out.println("File Size: " + commonConfig.getFileSize());
        System.out.println("Piece Size: " + commonConfig.getPieceSize());
        System.out.println("# of nbg: " + commonConfig.getNumberOfPreferredNeighbors());
    }

    public void printId(){
        System.out.println("Peer ID: " + this.peerId);
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: java com.p2p.peerProcess <peer_id> <port>");
            System.exit(1);
        }

        int peerId = Integer.parseInt(args[0]);
        int port = Integer.parseInt(args[1]);

        peerProcess peer = new peerProcess(peerId, port);
        peer.start();

        peer.printCommonConfig();
    }
}
