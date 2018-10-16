package pruebas;

import java.math.BigInteger;

public class biginteger {
    public static void main(String[] args) {
        // create 3 BigInteger objects
        BigInteger bi1, bi2, bi3;

        // create a BigInteger exponent
        BigInteger exponent = new BigInteger("2"); //EXPONENTE

        bi1 = new BigInteger("7"); //COEFICIENTE
        bi2 = new BigInteger("20"); //MODULO

        // perform modPow operation on bi1 using bi2 and exp
        bi3 = bi1.modPow(exponent, bi2);
        //bi3 = coeficiente.modpow(exponente, modulo)

        String str = bi1 + "^" +exponent+ " mod " + bi2 + " is " +bi3;

        // print bi3 value
        System.out.println( str );
    }
}
