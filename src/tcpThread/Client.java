/*
 * Client.java
 *
 * Created on 11 de Junho de 2013, 16:38
 */

package tcpThread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author Michelle Wanghan
 */
public class Client {
    public static void main(String[] args) {    

        try{            
            String addrString = JOptionPane.showInputDialog("Digite o Endereço IP do Servidor: ");
            InetAddress addr = InetAddress.getByName(addrString);
            String portString = JOptionPane.showInputDialog("Digite a Porta do Servidor: ");
            int port = Integer.parseInt(portString);
            int cont = 0;            
            Socket socket = new Socket(addr,port);
            String q1 = JOptionPane.showInputDialog("Calcule: 2+2 = ? ");
            DataOutputStream dataOutput = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInput = new DataInputStream(socket.getInputStream());
            dataOutput.writeUTF(q1);
            String r1 = dataInput.readUTF();                      
            System.out.println("Sua Resposta foi: "+r1);
            if(r1.equals("Certa")){
                cont++;
            }
            
            String message2 = JOptionPane.showInputDialog("Complete: o rato roeu a roupa do rei de ... ");
            dataOutput.writeUTF(message2);           
            String r2 = dataInput.readUTF();                      
            System.out.println("Sua Resposta foi: "+r2);
              if(r2.equals("Certa")){
                cont++;
            }
            
            
            String message3 = JOptionPane.showInputDialog("Segundo a teoria de Lavoisier, onde explica a lei de conservação das massas, o mesmo cita que 'Na natureza nada se cria, nada se perde, tudo se transforma'. Dito isto, você concodar que essa afirmação pode ser exemplificada com a seguinte frase: 'Substancias quimicas não podem reagir' ");
            dataOutput.writeUTF(message3);           
            String r3 = dataInput.readUTF();          
            if(r3.equals("Certa")){
                cont++;
            }                        
            System.out.println("Sua Resposta foi: "+r3);
            System.out.println("Você conseguiu "+cont+" pontos!");
            socket.close();
        }catch(Exception e){
            System.err.println("An exception ocourred: "+e.getMessage());
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
