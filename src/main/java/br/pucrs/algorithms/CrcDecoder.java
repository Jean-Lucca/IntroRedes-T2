package br.pucrs.algorithms;

import java.util.LinkedList;

public class CrcDecoder {
    public static void main(String[] args) {
        decode(args[0], args[1]);
    }

    public static void decode(String str, String pol) {
        StringBuilder res = new StringBuilder();
        LinkedList<Integer> err = new LinkedList<>();
        int count = 1;
        for( int i = 0; i < str.length()/3; i++ ) {
            StringBuilder aux = new StringBuilder();
            for( int j=0; j<3; j++ ) {
                aux.append(str.charAt(3*i + j));
            }
            String tmp = Util.hexToBinary(aux.toString());
            aux = new StringBuilder();
            aux.append(tmp);
            int check = Util.binToDec(Util.divide(aux.toString(), pol));
            if( check == 0 ) {
                res.append(Util.binToASCII(aux.substring(0 , aux.length() - pol.length()+1)));
            } else {
                err.add(count);
                res.append("_");
            }
            count++;
        }
        System.out.println(res);
        System.out.print("ERRO nos caracteres: ");
        System.out.print(err);
    }
}
