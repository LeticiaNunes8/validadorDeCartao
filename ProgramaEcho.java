package control;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ProgramaEcho {

    public static void main(String[] args) {

        Socket socket;
        InputStream canalEntrada;
        OutputStream canalSaida;
        BufferedReader entrada;
        PrintWriter saida;

        try {
            socket = new Socket("127.0.0.1", 4000);

            canalEntrada = socket.getInputStream();
            canalSaida = socket.getOutputStream();

            entrada = new BufferedReader(new InputStreamReader(canalEntrada));
            //saida = new PrintWriter(canalSaida, true);

//            Scanner leitor = new Scanner(System.in);
//            System.out.println("Envie uma mensagem:");
//            String leitura = leitor.nextLine();
//            saida.println(leitura);

            CartaoService chamadaUsuario = new CartaoService();

            chamadaUsuario.obterNumeroDoCartao();
            chamadaUsuario.obterNomeDoCartao();
            chamadaUsuario.obterDataDoCartao();
            chamadaUsuario.obterCVVDoCartao();

            System.out.println(chamadaUsuario.cartao);

            String resultado = entrada.readLine(); //recupera msg do topo do buffered
            System.out.println(resultado);

            socket.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
