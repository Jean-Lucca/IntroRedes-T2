public class Bcc_decoder {

    public static void main(String[] args) {
        decode("E4CAC9CAE7CA");
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
            res += Util.binToASCII(binArray[i].substring(0, 7));
        }

        return res;
    }
}
