package april_daily_challenge;

public class D23_CountBinarySubstrings {
    public static void main(String[] args) {

    }
}

class CountBinarySubstringsSolution {
    public int countBinarySubstrings(String s) {
        int current = 1, previous = 0, answer = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) current++;
            else {
                answer += Math.min(current, previous);
                previous = current;
                current = 1;
            }
        }
        return answer + Math.min(current, previous);
    }
}

class CountBinarySubstringsSolution1 {
    public int countBinarySubstrings(String s) {
        int res = 0;
        int prev = 0;
        int curr = 0;
        char c = s.charAt(0);

        for(char ch : s.toCharArray()){
            if(ch == c){
                curr++;
            }else{
                res += Math.min(prev, curr);
                prev = curr;
                curr = 1;
                c = ch;
            }
        }
        return res+Math.min(curr, prev);
    }
}