package codigoLaboratorio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.math.BigInteger;

public class servidor{
    public static void main(String[] args) throws IOException {
        //Esta será Alice...
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Introduzca el numero primo:");
        BigInteger modulo=new BigInteger(br.readLine());

        System.out.println("Introduzca la raiz primitiva");
        BigInteger coeficiente=new BigInteger(br.readLine());

        System.out.println("Enter value for x less than "+modulo+":");
        BigInteger exponente=new BigInteger(br.readLine());

        generadorClave generador = new generadorClave(coeficiente,exponente,modulo);
        BigInteger R1 = generador.generarClave();

        enviarInfo(R1, 4000);

    }

    public static void enviarInfo(BigInteger datos, int puerto)  throws IOException {
        ServerSocket ss = new ServerSocket(4000);
        Socket socket = ss.accept();
        OutputStream out = socket.getOutputStream();
        ObjectOutputStream oout = new ObjectOutputStream(out);
        oout.writeObject(datos);
        oout.close();
    }
}
