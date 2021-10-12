public class Bcc_decoder {

    public static void main(String[] args) {
        System.out.println(decode("E4CAC9CAE7CB"));
    }
    public static String decode(String hex) {
        String res = "";
        String bin = Util.hexToBinary(hex);
        String[] binArray = new String[bin.length()/8];
        for( int i = 0; i < binArray.length; i++ ) {
            binArray[i] = "";
            for( int j=0; j<8; j++ ) {
                binArray[i] += bin.charAt(8*i + j);
            }
        }

        for( int i = 0; i < binArray.length-1; i++ ) {
            if ( Util.countParity( binArray[i].substring(0,7) ) == '0' && binArray[i].charAt(7) != '0' ) {
                return "ERRO";
            }
        }

        String bcc = binArray[binArray.length-1];

        for( int i = 0; i < 7; i++) {
            String aux = "";
            for( int j = 0; j < binArray.length-1; j++ ) {
                aux += binArray[j].charAt(i);
            }
            if ( Util.countParity( aux ) == '0' && bcc.charAt(i) != '0' ) {
                return "ERRO";
            }
        }

        for( int i = 0; i < binArray.length-1; i++ ) {
            res += Util.binToASCII(binArray[i].substring(0, 7));
        }

        return res;
    }
}
