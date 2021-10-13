public class Crc_encoder {
    public static void main(String[] args) {
        System.out.println(encode("redes","10101"));
    }

    public static String encode(String str, String pol) {
        String res = "";
        for( int i =0; i < str.length(); i++ ) {
            String aux = Integer.toBinaryString(str.charAt(i)-0);
            res += Util.binaryToHex(aux) + 
                   Util.binaryToHex(Util.divide(aux+Util.appendNZeros(pol.length()-1), pol));
        }
        System.out.println(res);
        return res;
    }
}
