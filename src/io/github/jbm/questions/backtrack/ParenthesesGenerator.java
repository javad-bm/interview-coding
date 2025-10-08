package io.github.jbm.questions.backtrack;

import java.util.*;

public class ParenthesesGenerator {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, String current,
                           int open, int close, int n) {

        if (current.length() == n * 2) {
            result.add(current);
            return;
        }

        if (open < n)
            backtrack(result, current + "(", open + 1, close, n);

        if (close < open)
            backtrack(result, current + ")", open, close + 1, n);
    }

    public static void main(String[] args) {
        /*

        Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

        Example 1:
        Input: n = 3
        Output: ["((()))","(()())","(())()","()(())","()()()"]

        Example 2:
        Input: n = 1
        Output: ["()"]

        */

        ParenthesesGenerator pg = new ParenthesesGenerator();
        System.out.println(pg.generateParenthesis(3));  // Output: ["((()))","(()())","(())()","()(())","()()()"]
        System.out.println(pg.generateParenthesis(1));  // Output: ["()"]
        System.out.println(pg.generateParenthesis(5));
    }
}
