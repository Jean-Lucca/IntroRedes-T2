public class Crc_encoder {
    public static void main(String[] args) {
        System.out.println(encode("redes","10101"));
    }

    public static String encode(String str, String pol) {
        String res = "";
        for( int i =0; i < str.length(); i++ ) {
            String aux = Integer.toBinaryString(str.charAt(i)-0);
            res += Util.binaryToHex(aux) + Util.binaryToHex(divide(aux+appendNZeros(pol.length()-1), pol));
        }
        System.out.println(res);
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

    public static String divide(String a, String b) {
        int aux = b.length();
        String res = a.substring(0, aux);
        int n = a.length();
        while (aux < n) {
            if (res.charAt(0) == '1'){
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
}
