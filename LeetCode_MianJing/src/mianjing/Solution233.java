package mianjing;

public class Solution233 {
    public int countDigitOne(int n) {
        if(n==0){
            return 0;
        }
        int ans = 0;
        String str = String.valueOf(n);
        int len = str.length();
        int mod = 1;
        for(int i=0; i<len; i++){
            mod *= 10;
        }
        for(int i=0; i<len; i++){
            char ch = str.charAt(i);
            if(ch=='1'){
                ans += n -mod +1;
            }else{
                ans += mod;
            }
            mod = mod * (ch-'0');
            n -= mod;
            mod /= 10;
        }
        return ans;
    }
}
