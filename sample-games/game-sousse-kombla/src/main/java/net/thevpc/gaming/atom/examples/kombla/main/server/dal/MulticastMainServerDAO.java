package net.thevpc.gaming.atom.examples.kombla.main.server.dal;

import net.thevpc.gaming.atom.examples.kombla.main.server.engine.MainServerDAOListener;
import net.thevpc.gaming.atom.examples.kombla.main.shared.engine.AppConfig;
import net.thevpc.gaming.atom.examples.kombla.main.shared.model.DynamicGameModel;
import net.thevpc.gaming.atom.examples.kombla.main.shared.model.StartGameInfo;

import java.io.IOException;
import java.net.*;
import java.util.Random;

public class MulticastMainServerDAO implements MainServerDAO{
    MulticastSocket serverSocket;

    private InetAddress groupAddress;
    private int groupPort = 9999;
    private boolean clientConnected = false;



    @Override
    public void start(net.thevpc.gaming.atom.examples.kombla.main.server.dal.MainServerDAOListener listener, AppConfig properties) {


        try {
            serverSocket = new MulticastSocket();
            groupAddress = InetAddress.getByName("localhost");

        } catch (Exception ex) {
            throw new RuntimeException("Impossible de lancer le serveur", ex);
        }
        new Thread(new Runnable() {

            @Override
            public void run() {
                listen(listener);
            }
        }).start();

    }
    private void listen(net.thevpc.gaming.atom.examples.kombla.main.server.dal.MainServerDAOListener listener) {
        try {
            byte[] buffer = new byte[255]; //burst
            DatagramPacket p = new DatagramPacket(buffer, buffer.length);
            while (true) {
//                System.out.println("WAITING FOR BIRST");
                serverSocket.receive(p);
                switch (p.getData()[0]){
                    case 0:
                       StartGameInfo s = listener.onReceivePlayerJoined("Number One");
                        clientConnected = true;
                        new Thread(new Runnable() {

                            @Override
                            public void run() {
                                broadcast(s);
                            }
                        }).start();
                        serverSocket.close();
                        break;

                }
            }



        } catch (Exception ex) {
            throw new RuntimeException("Impossible de lancer le serveur", ex);
        }
    }

    public void broadcast(StartGameInfo s) {
        byte[] buffer = new byte[255]; //burst
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, groupAddress, groupPort);
        while (!clientConnected) {
            try {
                Thread.sleep(1000);
                // send the StartGameInfo
                serverSocket.send(packet);
            } catch (Exception ex) {
                throw new RuntimeException("Erreur reseau", ex);
            }
        }
//        System.out.println("STOP SENDING BURST : Client Already connected");

    }
    @Override
    public void sendModelChanged(DynamicGameModel dynamicGameModel) {

    }
}
