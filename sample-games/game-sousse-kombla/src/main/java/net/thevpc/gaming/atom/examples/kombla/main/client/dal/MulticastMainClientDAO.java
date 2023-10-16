package net.thevpc.gaming.atom.examples.kombla.main.client.dal;

import net.thevpc.gaming.atom.examples.kombla.main.shared.engine.AppConfig;
import net.thevpc.gaming.atom.examples.kombla.main.shared.model.StartGameInfo;

import java.io.IOException;
import java.net.*;

public class MulticastMainClientDAO implements MainClientDAO{
    private DatagramSocket socket;
    @Override
    public void start(MainClientDAOListener listener, AppConfig properties) {

    }

    @Override
    public StartGameInfo connect() {
        try {
            socket = new DatagramSocket();

            byte connect =0;
            byte[] buffer = new byte[255];
            byte[] sendData = {connect};
            DatagramPacket p =new DatagramPacket(buffer, buffer.length, InetAddress.getByName("localhost"),9999);
            p.setData(sendData);
            socket.send(p);
            //boolean connected = false;
                byte[] buffer2 = new byte[255];
                socket.receive(new DatagramPacket(buffer2, buffer2.length));
               } catch (Exception ex) {
                ex.printStackTrace();
                    }
        return null;
    }

    @Override
    public void sendMoveLeft() {

    }

    @Override
    public void sendMoveRight() {

    }

    @Override
    public void sendMoveUp() {

    }

    @Override
    public void sendMoveDown() {

    }

    @Override
    public void sendFire() {

    }
}
