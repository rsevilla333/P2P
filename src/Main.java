

public class Main {
    public static void main(String[] args) {
        // Initialize components and start P2P file sharing system

        CommonConfig commonConfig = new CommonConfig();
        PeerInfoConfig peerInfoConfig = new PeerInfoConfig();
        PeerAdmin peerAdmin = new PeerAdmin(commonConfig, peerInfoConfig);
        RemoteServer remoteServer = new RemoteServer(peerAdmin);

        // Start P2P file sharing system
        remoteServer.start();

    }
}