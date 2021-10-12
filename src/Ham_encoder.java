import java.util.ArrayList;

public class Ham_encoder {
    public static void main(String[] args) {
        encode("redes");
    }

    public static String encode(String str) {
        String res = "";
        String[] binArray = new String[str.length()+1];
        binArray[binArray.length-1] = "";

        for( int i = 0; i < str.length(); i++ ) {
            String aux = Integer.toBinaryString(str.charAt(i)-0);
            binArray[i] = "0" + aux;
            res += run(hamming(reverse(binArray[i]))).toUpperCase();
        }
        System.out.println(res);
        return res;
    }

    public static String reverse(String str) {
        String res = "";
        for( int i=str.length()-1; i >= 0; i-- ) {
            res += str.charAt(i);
        }
        return res;
    }

    public static String hamming(String str) {
        return "xx"+str.charAt(0)+"x"+str.substring(1,4)+"x"+str.substring(4,str.length());
    }

    public static String run(String str) {
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

        int aux = 0;
        String reversedParity = reverse(binArray.get(binArray.size()-1));
        for( int i=0; i < str.length(); i++ ) {
            if( str.charAt(i) == 'x' ) {
                str = str.replaceFirst("x", ""+reversedParity.charAt(aux));
                aux++;
            }
        }
        return Util.binaryToHex(reverse(str));
    }
}
