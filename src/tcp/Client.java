/*
 * Client.java
 *
 * Created on 10 de Abril de 2005, 16:38
 */

package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author Alysson
 */
public class Client {
    public static void main(String[] args) {
     

        try{
            String addrString = JOptionPane.showInputDialog("Digite o Endere�o IP do Servidor: ");
            InetAddress addr = InetAddress.getByName(addrString);
            String portString = JOptionPane.showInputDialog("Digite a Porta do Servidor: ");
            int port = Integer.parseInt(portString);
            String message = JOptionPane.showInputDialog("Digite uma mensagem para o Servidor: ");
            
            Socket socket = new Socket(addr,port);

            DataOutputStream dataOutput = new DataOutputStream(socket.getOutputStream());
            dataOutput.writeUTF(message);
            
            DataInputStream dataInput = new DataInputStream(socket.getInputStream());
            String data = dataInput.readUTF();
            socket.close();

            if(data.equals(message)){
                System.out.println("Echo: "+data+" - bem sucedido.");
            }else{
                System.out.println("Enviado: "+message);
                System.out.println("Recebido: "+data);
            }
        }catch(Exception e){
            System.err.println("An exception ocourred: "+e.getMessage());
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
