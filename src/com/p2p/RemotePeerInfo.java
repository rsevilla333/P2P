package com.p2p;



/**
 * Represents information about a remote peer in the peer-to-peer network.
 */
public class RemotePeerInfo {

    // Attributes of the remote peer
    public String peerId; // Peer ID
    public String peerAddress; // Peer address
    public String listeningPort; // Peer port
    public int bitField; // Bit field representing file status

    /**
     * Constructs a new RemotePeerInfo object with the specified parameters.
     *
     * @param pId       The peer ID.
     * @param pAddress  The peer address.
     * @param pPort     The peer port.
     * @param hf        The bit field representing file status.
     */
    public RemotePeerInfo(String pId, String pAddress, String pPort, String hf) {
        peerId = pId;
        peerAddress = pAddress;
        listeningPort = pPort;
        bitField = Integer.parseInt(hf);
    }

    /**
     * Gets the peer ID.
     *
     * @return The peer ID.
     */
    public String getPeerId() {
        return peerId;
    }

    /**
     * Sets the peer ID.
     *
     * @param peerId The peer ID to set.
     */
    public void setPeerId(String peerId) {
        this.peerId = peerId;
    }

    /**
     * Gets the hostname of the peer.
     *
     * @return The hostname of the peer.
     */
    public String getHostName() {
        return peerAddress;
    }

    /**
     * Gets the listening port of the peer.
     *
     * @return The listening port of the peer.
     */
    public String getListeningPort() {
        return listeningPort;
    }

    /**
     * Checks if the peer has the file.
     *
     * @return True if the peer has the file, false otherwise.
     */
    public boolean hasFile() {
        return bitField == 1;
    }

    @Override
    public String toString() {
        return "PeerInfo{" +
                "peerId=" + peerId +
                ", hostName='" + peerAddress + '\'' +
                ", listeningPort=" + listeningPort +
                ", hasFile=" + hasFile() +
                '}';
    }
}
