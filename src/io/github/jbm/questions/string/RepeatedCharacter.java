package io.github.jbm.questions.string;

import java.util.LinkedList;
import java.util.Stack;

public class RepeatedCharacter {

    public static String removeAdjacentSB(String str) {
        // We use String Builder like stack
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (!sb.isEmpty() && sb.charAt(sb.length() - 1) == c) {
                while (!sb.isEmpty() && sb.charAt(sb.length() - 1) == c) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static String removeAdjacentLL(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peekLast() == c) {
                // Pop all matching characters from the end
                while (!stack.isEmpty() && stack.peekLast() == c) {
                    stack.removeLast();
                }
            } else {
                stack.addLast(c);
            }
        }

        // Build the result from the stack
        StringBuilder result = new StringBuilder();
        for (char ch : stack) {
            result.append(ch);
        }
        return result.toString();
    }

    public static String removeAdjacentStack(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                // Remove all matching top characters (chain reaction)
                while (!stack.isEmpty() && stack.peek() == c) {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }

        // Build the final string
        StringBuilder result = new StringBuilder();
        for (char ch : stack) {
            result.append(ch);
        }
        return result.toString();
    }

    // O(1) space complexity
    public static String removeAdjacent(String s) {
        char[] chars = s.toCharArray();
        int write = 0;  // "stack pointer"
        for (int read = 0; read < chars.length; read++) {
            char c = chars[read];

            if (write > 0 && chars[write - 1] == c) {
                // Pop (remove adjacent duplicates)
                while (write > 0 && chars[write - 1] == c) {
                    write--;  // pop
                }
            } else {
                // Push current character
                chars[write] = c;
                write++;
            }
        }

        return new String(chars, 0, write);
    }

    public static void main(String[] args) {
        System.out.println(removeAdjacentSB("AABBCC").isEmpty());
        System.out.println(removeAdjacentSB("ABBCD").equals("ACD"));
        System.out.println(removeAdjacentSB("BAABC").equals("C"));
        System.out.println(removeAdjacentSB("XABBAY").equals("XY"));
        System.out.println(removeAdjacentSB("ABBAC").equals("C"));


        System.out.println(removeAdjacentStack("AABBCC").isEmpty());
        System.out.println(removeAdjacentStack("ABBCD").equals("ACD"));
        System.out.println(removeAdjacentStack("BAABC").equals("C"));
        System.out.println(removeAdjacentStack("XABBAY").equals("XY"));
        System.out.println(removeAdjacentStack("ABBAC").equals("C"));

        System.out.println(removeAdjacentLL("AABBCC").isEmpty());
        System.out.println(removeAdjacentLL("ABBCD").equals("ACD"));
        System.out.println(removeAdjacentLL("BAABC").equals("C"));
        System.out.println(removeAdjacentLL("XABBAY").equals("XY"));
        System.out.println(removeAdjacentLL("ABBAC").equals("C"));

        System.out.println(removeAdjacent("AABBCC").isEmpty());
        System.out.println(removeAdjacent("ABBCD").equals("ACD"));
        System.out.println(removeAdjacent("BAABC").equals("C"));
        System.out.println(removeAdjacent("XABBAY").equals("XY"));
        System.out.println(removeAdjacent("ABBAC").equals("C"));

    }
}
