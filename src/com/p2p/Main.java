package com.p2p;

public class Main {
//    public static void main(String[] args) {
//        // Initialize components and start P2P file sharing system
//
//        com.p2p.CommonConfig commonConfig = new com.p2p.CommonConfig();
//        PeerInfoConfig peerInfoConfig = new PeerInfoConfig();
//        PeerAdmin peerAdmin = new PeerAdmin(commonConfig, peerInfoConfig);
//        RemoteServer remoteServer = new RemoteServer(peerAdmin);
//
//        // Start P2P file sharing system
//        remoteServer.start();
//
//    }

    /// Remote
//    public static void main(String[] args) {
//        try {
//            StartRemotePeers myStart = new StartRemotePeers();
//            myStart.getConfiguration();
//
//            // get current path
//            String path = System.getProperty("user.dir");
//
//            // start clients at remote hosts
//            for (int i = 0; i < myStart.peerInfoVector.size(); i++) {
//                RemotePeerInfo pInfo = (RemotePeerInfo) myStart.peerInfoVector.elementAt(i);
//
//                System.out.println("Start remote peer " + pInfo.peerId + " at " + pInfo.peerAddress);
//
//                // Construct SSH command
//                String sshCommand = "ssh " + pInfo.peerAddress + " \"cd " + path + " && java com.p2p.peerProcess " + pInfo.peerId + "\"";
//                System.out.println(sshCommand);
//
//                // Execute SSH command
//                Process process = Runtime.getRuntime().exec(sshCommand);
//
//                // Handle errors
//                int exitCode = process.waitFor();
//
//                if (exitCode == 0) {
//                    System.out.println("Remote peer " + pInfo.peerId + " started successfully.");
//                } else {
//                    System.err.println("Failed to start remote peer " + pInfo.peerId);
//                    System.err.println(exitCode);
//                    // Handle the failure accordingly
//                }
//
//            }
//            System.out.println("Starting all remote peers has done.");
//
//        } catch (Exception ex) {
//            System.out.println(ex);
//        }
//    }
//}

/// Local
    public static void main(String[] args) {
        // Start multiple instances of the peer-to-peer program on different ports
        int[] peerPorts = {6000, 6001, 6002}; // Example port numbers for each instance

        for (int port : peerPorts) {
            startPeerInstance(port);
        }
    }

    public static void startPeerInstance(int port) {
        try {
            StartRemotePeers myStart = new StartRemotePeers();
            myStart.getConfiguration();

            // Construct SSH command
            String sshCommand = "ssh localhost \"cd " +
                    "~/Desktop/P2P/src && java -cp . com.p2p.peerProcess " + port + "\"";


            // Execute SSH command
            Process process = Runtime.getRuntime().exec("ssh localhost \"cd ~/Desktop/P2P/src && java -cp . com.p2p.peerProcess 6000\"");

            // Wait for the process to finish
            int exitCode = process.waitFor();

            if (exitCode == 0) {
                System.out.println("Peer instance started successfully on port " + port);
            } else {
                System.err.println("Failed to start peer instance on port " + port);
                // Handle the failure accordingly
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}


