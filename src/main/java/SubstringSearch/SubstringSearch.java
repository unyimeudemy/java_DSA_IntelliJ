package SubstringSearch;

public class SubstringSearch {
}


class stringSearch{

    public static int search(String pat, String txt){
        int P = pat.length();
        int T = txt.length();

        for (int i = 0; i <= T - P; i++){
            int j;
            for(j = 0; j < P; j++){
                if(txt.charAt(i + j) == pat.charAt(j)){
                    break;
                }
            }
            if(j == P){
                return i;
            }
        }
        return T;
    }

    public static int searchWithExplicitBackoff(String pat, String txt){
        int P = pat.length();
        int T = txt.length();
        int i, j;
        for(i = 0, j = 0; i < T && j < P; i++){
            if(pat.charAt(i) == txt.charAt(j)){
               j++;
            }else {
                i = i - j;
                j = 0;
            }
        }
        if(j == P){
            return i - P;
        }
        return T;
    }
}