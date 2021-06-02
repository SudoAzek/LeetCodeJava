package may_daily_challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D31_SearchSuggestionsSystem {
    public static void main(String[] args) {

    }
}

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> answer = new ArrayList<>();
        int left = 0, right = products.length - 1;
        for (int i = 0; i < searchWord.length(); i++) {
            List<String> result = new ArrayList<>();
            char ch = searchWord.charAt(i);
            while (left <= right && (products[left].length() == i || products[left].charAt(i) < ch)) left++;
            while (left <= right && (products[right].length() == i || products[right].charAt(i) > ch)) right--;
            for (int j = 0; j < 3 && left + j <= right; j++) {
                result.add(products[left + j]);
            }
            answer.add(result);
        }
        return answer;
    }
}