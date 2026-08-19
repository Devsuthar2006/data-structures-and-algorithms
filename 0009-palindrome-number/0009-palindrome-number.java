class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        else{
            String x_string = Integer.toString(x);
            int n = x_string.length();
            int buffer;
            int start = 0;
                buffer = x_string.charAt(start);
                for (int end=n-1; end > start; end--){
                    if(!(buffer == x_string.charAt(end))){
                        return false;
                    }
                    buffer = x_string.charAt(++start);
                }
            return true;

        }
    }
}