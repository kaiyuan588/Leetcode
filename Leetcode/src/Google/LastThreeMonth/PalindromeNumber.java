package Google.LastThreeMonth;

public class PalindromeNumber {
    public int reverse(int y) {
        int rev = 0;
        while(y != 0){
            rev = rev*10+y%10;;
            y = y/10;
        }
        return rev;
    }
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        int k =  reverse(x);
        if(k == x){
            return true;
        }
        return false;
    }
}
