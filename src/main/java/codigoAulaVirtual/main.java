package codigoAulaVirtual;

import java.io.*;
import java.math.BigInteger;

public class main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        //PEDIMOS NUMERO PRIMO...
        System.out.println("Enter prime number:");
        BigInteger p=new BigInteger(br.readLine());

        //PEDIMOS PRIMITIVO DE NUMERO PRIMO...
        System.out.print("Enter primitive root of "+p+":");
        BigInteger g=new BigInteger(br.readLine());

        //PEDIMOS VALOR MENOR A NUMERO PRIMO...
        System.out.println("Enter value for x less than "+p+":");
        BigInteger x=new BigInteger(br.readLine());

        //CALCULAMOS R1...    modPow(BigInteger exponent, BigInteger m)
        BigInteger R1=g.modPow(x,p);
        //R1 = coeficiente.modpow(exponente, modulo) => g^x mod(p)
        System.out.println("R1="+R1);

        //PEDIMOS OTRO VALOR QUE SEA MENOR AL NUMERO PRIMO...
        System.out.print("Enter value for y less than "+p+":");
        BigInteger y=new BigInteger(br.readLine());

        //CALCULAMOS R2...
        BigInteger R2=g.modPow(y,p);
        //R2 = coeficiente.modpow(exponente, modulo) => g^y mod(p)
        System.out.println("R2="+R2);

        //CALCULAMOS K1...key esta es ALICE
        BigInteger k1=R2.modPow(x,p);
        //K1 = coeficiente.modpow(exponente, modulo) => R2^x mod(p)
        System.out.println("Key calculated at Alice's side:"+k1);

        //CALCULAMOS K2...key este es BOB
        BigInteger k2=R1.modPow(y,p);
        //K2 = coeficiente.modpow(exponente, modulo) => R1^y mod(p)
        System.out.println("Key calculated at Bob's side:"+k2);

        System.out.println("deffie hellman secret key Encryption has Taken");
    }
}
/* OUTPUT

Enter prime number:
11
Enter primitive root of 11:7
Enter value for x less than 11:
3
R1=2
Enter value for y less than 11:6
R2=4
Key calculated at Alice's side:9
Key calculated at Bob's side:9
deffie hellman secret key Encryption has Taken

*/