package br.pucrs.algorithms;

public class Crc_encoder {
    public static void main(String[] args) {
        System.out.println(encode(args[0], args[1]));
    }

    public static String encode(String str, String pol) {
        String res = "";
        for( int i =0; i < str.length(); i++ ) {
            String aux = Integer.toBinaryString(str.charAt(i)-0);
            //divisao binaria modulo 2
            res += Util.binaryToHex(aux) + 
                   Util.binaryToHex(Util.divide(aux+Util.appendNZeros(pol.length()-1), pol));
        }
        return res;
    }
}
