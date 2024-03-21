//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class PeerInfoConfig {
//    private String peerInfoFilePath;
//    private List<PeerInfo> peerInfoList;
//
//    public PeerInfoConfig(String peerInfoFilePath) {
//        this.peerInfoFilePath = peerInfoFilePath;
//        this.peerInfoList = new ArrayList<>();
//    }
//
//    // Method to parse the PeerInfo.cfg file and populate peerInfoList
//    public void parsePeerInfoFile() throws IOException {
//        try (BufferedReader br = new BufferedReader(new FileReader(peerInfoFilePath))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                String[] parts = line.split(" ");
//                if (parts.length == 4) {
//                    int peerId = Integer.parseInt(parts[0]);
//                    String hostName = parts[1];
//                    int listeningPort = Integer.parseInt(parts[2]);
//                    boolean hasFile = Integer.parseInt(parts[3]) == 1;
//                    peerInfoList.add(new PeerInfo(peerId, hostName, listeningPort, hasFile));
//                }
//            }
//        }
//    }
//
//    // Method to get the list of peer information
//    public List<PeerInfo> getPeerInfoList() {
//        return peerInfoList;
//    }
//}