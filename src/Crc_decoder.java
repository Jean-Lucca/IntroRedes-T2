public class Crc_decoder {
    public static void main(String[] args) {
        System.out.println(decode("72365964C659736", "10101"));
    }

    public static String decode(String str, String pol) {
        String res = "";
        for( int i = 0; i < str.length()/3; i++ ) {
            String aux = "";
            for( int j=0; j<3; j++ ) {
                aux +=  str.charAt(3*i + j);
            }
            aux = Util.hexToBinary(aux);
            int check = Util.binToDec(Util.divide(aux, pol));
            if( check == 0 ) {
                res += Util.binToASCII(aux.substring(0 , aux.length() - pol.length()+1));
            } else {
                res += "_";
            }
        }
        return res;
    }
}
