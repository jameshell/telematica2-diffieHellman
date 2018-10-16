package codigoLaboratorio;

import java.io.*;
import java.net.Socket;
import java.math.BigInteger;

public class cliente {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //Este será Bob...
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Introduzca el numero primo:");
        BigInteger modulo=new BigInteger(br.readLine());

//        System.out.println("Introduzca la raiz primitiva");
//        BigInteger coeficiente=new BigInteger(br.readLine());

        System.out.println("Enter value for x less than "+modulo+":");
        BigInteger exponente=new BigInteger(br.readLine());

        BigInteger R1 = recibirInfo("localhost",4000, "recibido.txt");

        generadorClave generador = new generadorClave(R1,exponente,modulo);
        BigInteger k2 = generador.generarClave();

        System.out.println("Llave calculada desde el lado de Bob: "+k2);
    }

    public static BigInteger recibirInfo(String direccion, int puerto, String nombre) throws IOException, ClassNotFoundException {
        Socket socket =new Socket(direccion, puerto);
        InputStream input = socket.getInputStream();
        ObjectInputStream oin = new ObjectInputStream(input);
        BigInteger R1 = (BigInteger) oin.readObject();
        String str = R1.toString();
//        FileWriter writer = new FileWriter(nombre);
//        writer.write(str);
//        System.out.println("|Archivo Creado Exitosamente!");
//        System.out.println("|Nombre: "+nombre);
//        System.out.println("|Ubicacion: "+System.getProperty("user.dir"));
        input.close();
//        writer.close();
        System.out.println("Datos recibidos del servidor: "+R1);
        return R1;
    }
}
