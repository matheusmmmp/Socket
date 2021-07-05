/*
 * Client.java
 *
 * Created on 23 de Maio de 2012, 16:38
 */

package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;


/**
 *
 * @author Alysson e Michelle
 */
public class Client {
    public static void main(String[] args) {
      

        try{
            String addrString = JOptionPane.showInputDialog("Digite o Endereço IP do Servidor: ");
            InetAddress addr = InetAddress.getByName(addrString);
            String portString = JOptionPane.showInputDialog("Digite a Porta do Servidor: ");
            int port = Integer.parseInt(portString);
            String message = JOptionPane.showInputDialog("Digite o nome do Cliente: ");   
            
            for (int i = 0; i < 3; i++) {   
                DatagramSocket socket = new DatagramSocket();           

                DatagramPacket datagram1 = new DatagramPacket(message.getBytes(),0,
                  message.getBytes().length,addr,port);

                socket.send(datagram1);

                socket.close();    
                TimeUnit.SECONDS.sleep(10);
            }
       
        }catch(Exception e){
            System.err.println("An exception ocourred: "+e.getMessage());
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
