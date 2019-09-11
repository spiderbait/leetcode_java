package S374_Guess_Number_Higher_or_Lower;

public class Solution {
    public static int guess(int n){
        int mynum = 10;
        if(n < mynum){
            return 1;
        }else if(n > mynum){
            return -1;
        }else{
            return 0;
        }
    }
//	public static int guessNumber(int n) {
//        if(guess(n) == 0){
//        	return n;
//        }else if(guess(n) == 1){
//        	return guessNumber(n+1);
//        }else if(guess(n) == -1){
//        	return guessNumber(n-1);
//        }
//	       return -1;
//	}

    public static int guessNumber(int n) {
        while(guess(n) != 0){
            if(guess(n) == 1){
                n ++;
            }else if(guess(n) == -1){
                n --;
            }
        }
        return n;
    }
    public static int sum(int n){
        if(n == 1){
            return 1;
        }
        return (n + sum(n - 1));
    }
    public static int Fibonacci(int n){
        if(n == 1){
            return 1;
        }else if(n == 0){
            return 0;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }
    public static void main(String args[]){
        System.out.println(guessNumber(14));
    }
}
