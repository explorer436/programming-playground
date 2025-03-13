package com.my.company.strings;

import com.my.company.abstractdatatypes.stack.StackImplementationUsingDoubleLinkedList;
import com.my.company.abstractdatatypes.stack.StackImplementationUsingLinkedList;

public class BalancedParanthesis {

    /**
     * This works for expressions in general. That included adjacently balanced brackets.
     *
     * <p>Complexity is O (n)
     */
    public boolean checkIfBracketsIsAnExpression(String str) {
        boolean result = false;

        if (null != str && !str.isEmpty() && (str.length() % 2 == 0)) {
            StackImplementationUsingLinkedList<Character> stack = new StackImplementationUsingLinkedList<>();

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[') {
                    stack.push((char) str.charAt(i));
                } else if (str.charAt(i) == ')') {
                    char correspondingBracketAtTheBeginning = (char) stack.pop();
                    if (correspondingBracketAtTheBeginning != '(') {
                        return false;
                    }
                } else if (str.charAt(i) == '}') {
                    char correspondingBracketAtTheBeginning = (char) stack.pop();
                    if (correspondingBracketAtTheBeginning != '{') {
                        return false;
                    }
                } else if (str.charAt(i) == ']') {
                    char correspondingBracketAtTheBeginning = (char) stack.pop();
                    if (correspondingBracketAtTheBeginning != '[') {
                        return false;
                    }
                } else {
                    return false;
                }
            }

            if (stack.isEmpty()) {
                result = true;
            }
        }

        return result;
    }

    /**
     * This is a brute force method that will work for both adjacently balanced and balanced
     * expressions.
     * This works for expressions in general.
     * That included adjacently balanced brackets.
     *
     * <p>Complexity is O (n^2)
     */
    public boolean isBalanced(String str) {
        boolean result = false;

        if (null != str && !str.isEmpty() && (str.length() % 2 == 0)) {
            // without using linked lists.

            // REMEMBER do not use while (str.length() > 0).. it will lead to infinite loop when the input
            // is not balanced.
            while (str.contains("()") || str.contains("[]") || str.contains("{}")) {
                str = str.replaceAll("\\(\\)", "").replaceAll("\\[\\]", "").replaceAll("\\{\\}", "");
            }
        } else {
            return false;
        }

        if (str.isEmpty()) {
            result = true;
        }

        return result;
    }

    /**
     * This is not a valid solution.
     * This will work only if the brackets at the beginning and at the end match.
     * e.g. This works for {[()]} But it does not work for {}[()]
     */
    public boolean checkIfBracketsAreBalancedFromBeginningAndEnding(String str) {
        boolean result = false;

        if (null != str && !str.isEmpty() && (str.length() % 2 == 0)) {
            // using double linked list for this.
            StackImplementationUsingDoubleLinkedList<Character> stack =
                    new StackImplementationUsingDoubleLinkedList<>();

            for (int i = 0; i < str.length(); i++) {
                stack.pushToTheTop((char) str.charAt(i));
            }

            while (!stack.isEmpty()) {
                char lastChar = (char) stack.popFromTheTop();

                // { {, }, (, ), [, ] }
                if (lastChar == '}') {
                    char correspondingBracketAtTheBeginning = (char) stack.popFromTheBottom();
                    if ('{' == correspondingBracketAtTheBeginning) {
                        continue;
                    } else {
                        return false;
                    }
                } else if (lastChar == ')') {
                    char correspondingBracketAtTheBeginning = (char) stack.popFromTheBottom();
                    if ('(' == correspondingBracketAtTheBeginning) {
                        continue;
                    } else {
                        return false;
                    }
                } else if (lastChar == ']') {
                    char correspondingBracketAtTheBeginning = (char) stack.popFromTheBottom();
                    if ('[' == correspondingBracketAtTheBeginning) {
                        continue;
                    } else {
                        return false;
                    }
                }
            }

            if (stack.isEmpty()) {
                result = true;
            }
        }

        return result;
    }

    /**
     * This is not an accurate solution.
     * This works only if the brackets are adjacently balanced.
     * It works for {}[]() It does not work for []{()}
     */
    public boolean checkIfBracketsAreAdjacentBalanced(String str) {
        boolean result = false;

        if (null != str && !str.isEmpty() && (str.length() % 2 == 0)) {
            // using single linked list for this.
            StackImplementationUsingLinkedList<Character> stack = new StackImplementationUsingLinkedList<>();

            for (int i = 0; i < str.length(); i++) {
                stack.push((char) str.charAt(i));
            }

            while (!stack.isEmpty()) {
                char lastChar = (char) stack.pop();

                // { {, }, (, ), [, ] }
                if (lastChar == '}') {
                    if ('{' == (char) stack.pop()) {
                        continue;
                    } else {
                        return false;
                    }
                } else if (lastChar == ')') {
                    if ('(' == (char) stack.pop()) {
                        continue;
                    } else {
                        return false;
                    }
                } else if (lastChar == ']') {
                    if ('[' == (char) stack.pop()) {
                        continue;
                    } else {
                        return false;
                    }
                }
            }

            if (stack.isEmpty()) {
                result = true;
            }
        }

        return result;
    }
}
