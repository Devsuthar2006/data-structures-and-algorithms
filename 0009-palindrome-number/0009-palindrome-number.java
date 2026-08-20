class Solution {
    public boolean isPalindrome(int x) {
        if (x<0) return false;
        int t=x;
        int rev = 0 ;
        while (x != 0){
            int lastd = x%10 ; 
            rev = rev*10+lastd;
            x = x/10;
        }
        if(rev == t){
            return true;
        }else{
            return false;
        }
    }
}
