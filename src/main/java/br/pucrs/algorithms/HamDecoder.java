package br.pucrs.algorithms;

import java.util.ArrayList;

public class HamDecoder {
    public static void main(String[] args) {
        System.out.println(decode(args[0]));
    }

    public static String decode(String hex) {
        StringBuilder res = new StringBuilder();
        for( int i = 0; i < hex.length()/3; i++ ) {
            String aux = "";
            for( int j=0; j<3; j++ ) {
                aux += hex.charAt(3*i + j);
            }
            res.append(Util.binToASCII(run(Util.reverse(Util.hexToBinary(aux)),i)));
        }
        return res.toString();
    }

    public static String run(String str, int charIndex) {
        int count = 1;
        ArrayList<String> binArray = new ArrayList<String>();

        for( int i =0; i < str.length(); i++ ) {
            if( str.charAt(i) == '1' ) {
                binArray.add( String.format("%4s", Integer.toBinaryString(count)).replace(' ', '0') );
            }
            count++;
        }

        binArray.add("");

        for( int i = 0; i < 4; i++ ) {
            String aux = "";
            for( int j = 0; j < binArray.size()-1; j++ ) {
                aux += binArray.get(j).charAt(i);
            }
            binArray.set(binArray.size()-1, binArray.get(binArray.size()-1)+Util.countParity(aux));
        }
        
        int check = Util.binToDec(binArray.get(binArray.size()-1));
        
        if( check == 0 ) {
            return Util.reverse(removeHamming(str));
        } else {
            //inverte bit na posicao check remove os bits re hamming e retorna
            String res = Util.reverse(removeHamming(replaceXor(str, check-1, (char) ((int) str.charAt(check-1) ^ 1))));
            System.out.println( "ERRO no caractere " +(charIndex+1)+" -> Correcao: "+ Util.binToASCII(res));
            return res;
        }
    }

    public static String removeHamming(String str) {
        return str.charAt(2)+str.substring(4,7)+str.substring(8,str.length());
    }

    public static String replaceXor(String str, int index, char replace){     
        if(str==null){
            return str;
        }else if(index<0 || index>=str.length()){
            return str;
        }
        char[] chars = str.toCharArray();
        chars[index] = replace;
        return String.valueOf(chars);       
    }
}
