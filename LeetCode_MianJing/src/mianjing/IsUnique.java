package mianjing;

public class IsUnique {

    public boolean isUnique(String str){
        if(str == null || str.length()<=1){
            return true;
        }
        boolean[] temp = new boolean[26];
        for(char ch : str.toCharArray()){
            if(temp[ch - 'a']){
                return false;
            }
            temp[ch - 'a'] = true;
        }
        return true;
    }
}
