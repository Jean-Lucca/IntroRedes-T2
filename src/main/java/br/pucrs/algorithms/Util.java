package br.pucrs.algorithms;

import java.math.BigInteger;

public class Util {

    //Fonte: https://stackoverflow.com/questions/8640803/convert-hex-string-to-binary-string
    public static String hexToBinary(String hex) {
        int len = hex.length() * 4;
        String bin = new BigInteger(hex, 16).toString(2);
        if(bin.length() < len){
            int diff = len - bin.length();
            String pad = "";
            for(int i = 0; i < diff; ++i){
                pad = pad.concat("0");
            }
            bin = pad.concat(bin);
        }
        return bin;
    }

    public static String binaryToHex(String bin) {
        Integer decimal = Integer.parseInt(bin, 2);
        return Integer.toString(decimal, 16);
    }

    public static String intToHex(Integer val) {
        String hex = Integer.toHexString(val);
        return hex;
    }

    public static Integer binToDec(String bin) {
        return Integer.parseInt(bin, 2);
    }

    public static char binToASCII(String bin) {
        return (char) Integer.parseInt(bin, 2);
    }

    public static char countParity( String bin ) {
        int count = 0;
        for( int i = 0; i < bin.length(); i++ ) {
            if( bin.charAt(i) == '1' ) {
                count++;
            }
        }
        if( count % 2 == 0 ) {
            return '0';
        } else {
            return '1';
        }
    }

    public static String reverse(String str) {
        String res = "";
        for( int i=str.length()-1; i >= 0; i-- ) {
            res += str.charAt(i);
        }
        return res;
    }
    //divisao binaria modulo 2
    public static String divide(String a, String b) {
        int aux = b.length();
        String res = a.substring(0, aux);
        int n = a.length();
        while (aux < n) {
            if (res.charAt(0) == '1') {
                res = xor(b, res) + a.charAt(aux);
            } else {
                res = xor(appendNZeros(aux), res) + a.charAt(aux);
            }                  
            aux += 1;
        }
        if (res.charAt(0) == '1') {
            res = xor(b, res);
        } else {
            res = xor(appendNZeros(aux), res);
        }
        return res;
    }

    public static String appendNZeros(int n) {
        String res = "";
        for( int i=0; i < n; i++ ) {
            res += '0';
        }
        return res;
    }

    public static String xor(String a, String b) {
        String res = "";
        for(int i = 1; i < b.length(); i++) {
            if( a.charAt(i) == b.charAt(i) ) {
                res += "0";
            } else {
                res += "1";
            }
        }
        return res;
    }
}