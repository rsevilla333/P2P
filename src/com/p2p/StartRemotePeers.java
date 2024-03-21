package com.p2p;

import java.io.*;
import java.util.*;

public class StartRemotePeers {

    public Vector<RemotePeerInfo> peerInfoVector;

    public void getConfiguration()
    {
        String st;
        int i1;
        peerInfoVector = new Vector<RemotePeerInfo>();
        try {
            BufferedReader in = new BufferedReader(new FileReader("config/PeerInfo.cfg"));
            while((st = in.readLine()) != null) {

                String[] tokens = st.split("\\s+");
                System.out.println("tokens begin ----");
                for (int x=0; x<tokens.length; x++) {
                    System.out.println(tokens[x]);
                }
                System.out.println("tokens end ----");

                peerInfoVector.addElement(new RemotePeerInfo(tokens[0], tokens[1], tokens[2]));

            }

            in.close();
        }
        catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

}
