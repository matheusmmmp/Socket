/*
 * Server.java
 *
 * Created on 23 de Maio de 2012
 */

package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 *
 * @author Alysson e Michelle
 */
public class Server {
    public static void main(String[] args) {
        
        try{
            String portString = JOptionPane.showInputDialog("Digite a Porta do Servidor: ");
            int port = Integer.parseInt(portString);

            DatagramSocket socket = new DatagramSocket(port);

            System.out.println("Servidor UDP escutando na porta  "+port);
            
            boolean exit = false;
            do{
                DatagramPacket datagram = new DatagramPacket(new byte[1024],1024);
                socket.receive(datagram);
                
                String message = new String(datagram.getData()).trim();
                
                if(message.equalsIgnoreCase("exit")) {
                    exit = true;
                }
                   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
                   LocalDateTime now = LocalDateTime.now();  
                   System.out.println("Cliente: "+message+" Hora:"+ dtf.format(now) +" Endere?o:"+
                   datagram.getAddress()+":"+datagram.getPort());
            }while(!exit);
            
            socket.close();
        }catch(Exception e){
            System.err.println("An exception ocourred: "+e.getMessage());
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
