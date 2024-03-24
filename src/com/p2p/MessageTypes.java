package com.p2p;

/**
 * An enum representing different types of messages exchanged between peers in the P2P file sharing software.
 */
public enum MessageTypes {
    CHOKE((byte) 0),
    UNCHOKE((byte) 1),
    INTERESTED((byte) 2),
    NOT_INTERESTED((byte) 3),
    HAVE((byte) 4),
    BITFIELD((byte) 5),
    REQUEST((byte) 6),
    PIECE((byte) 7);


    // The byte value representing the message type
    private final byte value;

    /**
     * Constructs a MessageTypes enum with the specified byte value.
     *
     * @param value The byte value representing the message type.
     */
    MessageTypes(byte value) {
        this.value = value;
    }

    /**
     * Gets the byte value representing the message type.
     *
     * @return The byte value of the message type.
     */
    public byte getValue() {
        return value;
    }

    /**
     * Returns the MessageTypes enum value corresponding to the given byte value.
     *
     * @param b The byte value to convert to a MessageTypes enum.
     * @return The MessageTypes enum corresponding to the byte value.
     * @throws IllegalArgumentException If the byte value does not correspond to any MessageTypes enum.
     */
    public static MessageTypes fromByte(byte b) {
        for (MessageTypes messageType : MessageTypes.values()) {
            if (messageType.getValue() == b) {
                return messageType;
            }
        }
        throw new IllegalArgumentException("Unknown message type: " + b);
    }
}
