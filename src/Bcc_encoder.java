public class Bcc_encoder {

    public static void main(String[] args) {
        encode("redes");
    }

    public static String encode( String str ) {
        String res = "";
        String[] binArray = new String[str.length()+1];
        binArray[binArray.length-1] = "";

        for( int i = 0; i < str.length(); i++ ) {
            String aux = Integer.toBinaryString(str.charAt(i)-0);
            binArray[i] = aux += countParity(aux);
        }

        for( int i = 0; i < 8; i++ ) {
            String aux = "";
            for( int j = 0; j < binArray.length-1; j++ ) {
                aux += binArray[j].charAt(i);
            }
            binArray[binArray.length-1] += countParity(aux);
        }

        for( int j = 0; j < binArray.length; j++ ) {
            res += Util.binaryToHex(binArray[j]);
        }

        return res;
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

}
