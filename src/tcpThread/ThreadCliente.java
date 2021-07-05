/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpThread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author Wangham
 */
public class ThreadCliente extends Thread {

    private Socket socket_clie;
    int cont = 0;

    public ThreadCliente(Socket cliente) {
        this.socket_clie = cliente;
    }

    public void run() {
        try {
            String rCerto = "Certa";
            String rErro = "Errada";

            System.out.println("Recebendo mensagem de " + socket_clie.getInetAddress().getHostName() + ":" + socket_clie.getPort());
            DataInputStream dataInput = new DataInputStream(socket_clie.getInputStream());
            String r1 = dataInput.readUTF();
            System.out.println("O cliente " + socket_clie.getInetAddress().getHostName() + ":" + socket_clie.getPort() + " respondeu a pergunta 1 com: " + r1);

            DataOutputStream dataOutput = new DataOutputStream(socket_clie.getOutputStream());
            if (r1.equalsIgnoreCase("4")) {
                System.out.println("A resposta da pergunta 1 está: Certa");
                dataOutput.writeUTF(rCerto);
                cont++;
            } else {
                System.out.println("A resposta da pergunta 1 está: Errada");
                dataOutput.writeUTF(rErro);
            }

            DataInputStream dataInput1 = new DataInputStream(socket_clie.getInputStream());
            String r2 = dataInput1.readUTF();
            System.out.println("O cliente " + socket_clie.getInetAddress().getHostName() + ":" + socket_clie.getPort() + " respondeu a pergunta 2 com: " + r2);
            DataOutputStream dataOutput1 = new DataOutputStream(socket_clie.getOutputStream());

            if (r2.equalsIgnoreCase("roma")) {
                System.out.println("A resposta da pergunta 2 está: Certa");
                dataOutput1.writeUTF(rCerto);
                cont++;
            } else {
                System.out.println("A resposta da pergunta 2 está: Errada");
                dataOutput1.writeUTF(rErro);
            }

            DataInputStream dataInput3 = new DataInputStream(socket_clie.getInputStream());
            String r3 = dataInput3.readUTF();
            System.out.println("O cliente " + socket_clie.getInetAddress().getHostName() + ":" + socket_clie.getPort() + " respondeu a pergunta 3 com: " + r3);
            DataOutputStream dataOutput3 = new DataOutputStream(socket_clie.getOutputStream());
            if (r3.equalsIgnoreCase("discordo") || r3.equalsIgnoreCase("nao")) {
                System.out.println("A resposta da pergunta 3 está: Certa");
                dataOutput3.writeUTF(rCerto);
                cont++;
            } else {
                System.out.println("A resposta da pergunta 3 está: Errada");
                dataOutput3.writeUTF(rErro);
            }
            System.out.println("O cliente " + socket_clie.getInetAddress().getHostName() + ":" + socket_clie.getPort() + " finalizou com " + cont + " pontos!");
            socket_clie.close();
        } catch (Exception e) {
            System.out.println("Excecao ocorrida na thread: " + e.getMessage());
            try {
                socket_clie.close();
            } catch (Exception ec) {
            }

        }
    }

}
