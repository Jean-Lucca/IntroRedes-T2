package br.pucrs.algorithms;

public class BccEncoder {

    public static void main(String[] args) {
        System.out.println(encode(args[0]));
    }

    public static String encode( String str ) {
        StringBuilder res = new StringBuilder();
        String[] binArray = new String[str.length()+1];
        binArray[binArray.length-1] = "";
        //bit de paridade
        for( int i = 0; i < str.length(); i++ ) {
            String aux = Integer.toBinaryString(str.charAt(i)-0);
            binArray[i] = aux += Util.countParity(aux);
        }
        //bcc
        for( int i = 0; i < 8; i++ ) {
            StringBuilder aux = new StringBuilder();
            for( int j = 0; j < binArray.length-1; j++ ) {
                aux.append(binArray[j].charAt(i));
            }
            binArray[binArray.length-1] += Util.countParity(aux.toString());
        }
        //monta o resultado
        for( int j = 0; j < binArray.length; j++ ) {
            res.append(Util.binaryToHex(binArray[j]));
        }

        return res.toString();
    }
}
