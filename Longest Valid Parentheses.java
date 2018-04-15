Parentheses is a series questions about Data Structure-stack and Algorithm-DP.
Now, we will learn it step by step. 

/**************************************** Problem 1 -  Valid Parentheses ****************************************/
Firstly, let's look at a easy problem.

/*
Problem 1: Valid Parentheses  
Description:
    Given a string only containing the characters '(' and ')', determine if the input string is valid.
    The brackets must close in the correct order.
*/

/**
 * Approach 1: Traverse the String
 * Algorithm:
 * This question is very easy. We only need to check the number of '(' and ')' whether equals to each other or not.
 * So we use a number: status to represent the difference between '(' and ')'.
 * When it encounters '(' status++, otherwise status--.
 * if the character is ')' and --status- < 0 then return false.
 * At the end, we just need to check status equals to 0 or not.
 * (if a character is illegal, return false directly.)
 * 
 * Complexity Analysis:
 *  Time complexity  : O(n). Single traversal of string.
 *  Space complexity : O(1). Only a variable status is need.
 */
public class Solution {
    /*
     * @param s: A string
     * @return: whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }

        int status = 0;
        for (char c : str.toCharArray()) {
            // character is '(' then status++
            if (c == '(') {
                status++;
            // character is ')' then status--
            // if status < 0 return false
            } else if (c == ')') {
                if (--status < 0) {
                    return false;
                }
            // illegal character
            } else {
                return false;
            }
        }

        return status == 0;
    }
}

/**
 * Approach 2: Using Stack
 * Algorithm:
 * Every time we encounter a ‘(’, we push it onto the stack.
 * For every ‘)’ encountered, we pop a ‘(’ from the stack.
 * If ‘(’ is not available on the stack for popping at anytime or
 * if stack contains some elements after processing complete substring,
 * the substring of parentheses is invalid.
 * Complexity Analysis:
 *  Time complexity  : O(n). Single traversal of string.
 *  Space complexity : O(n). A size of stack is n.
 */
public class Solution {
    /*
     * @param s: A string
     * @return: whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }

        Stack<Character> stack = new Stack<Character>();
        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')' && !stack.empty() && stack.peek() == '(') {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.empty();
    }
}

/**************************************** Problem 2 -  Valid Parentheses ****************************************/
Secondly, we do a little change based on Problem 1.
Look at the question below.

/*
Problem 2: Valid Parentheses
Description:
    Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
    determine if the input string is valid.
    The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

/**
 * Approach : Using Stack
 * Algorithm:
 * In this question, there are three types of parentheses. "()","[]" and "{}".
 * So we need to use a Data Structure - Stack. It can help us to solve this problem easily.
 * This method is the same as Problem 1's Solution 2.
 * Traverse the String, push any open parentheses onto stack.
 * When encounters right parentheses, check the peek of stack.
 * If they could close in the correct order then pop the topmost element,
 * otherwise return false.
 *
 * Complexity Analysis:
 *  Time complexity  : O(n). Single traversal of string.
 *  Space complexity : O(n). A size of stack is n.
 *
 * Note:
 * Stack is also used in Postfix Expression.
 * Actually, this problem is a sub-question of How to calculate the Postfix Expression.
 */
class Solution {
    /*
     * @param s: A string
     * @return: whether the string is a valid parentheses
     */
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        // Iterate through string until empty
        for (char c : s.toCharArray()) {
            // Push any open parentheses onto stack
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            // Check stack for corresponding closing parentheses, false if not valid
            } else if (c == ')' && !stack.empty() && stack.peek() == '(') {
                stack.pop();
            } else if (c == ']' && !stack.empty() && stack.peek() == '[') {
                stack.pop();
            } else if (c == '}' && !stack.empty() && stack.peek() == '{') {
                stack.pop();
            } else {
                return false;
            }
        }

        // return true if no open parentheses left in stack
        return stack.empty();
    }
}

/**************************************** Problem 3 -  Longest Vaild Parentheses ****************************************/
At last, let's see : Longest Vaild Parentheses.
Look at the question below.

/*
Problem 3: Longest Vaild Parentheses
Description:
    Given a string containing just the characters '(' and ')', 
    find the length of the longest valid (well-formed) parentheses substring.
    For "(()", the longest valid parentheses substring is "()", which has length = 2.
    Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.

Hint:
    We can see clearly that the Problem is based on Problem 1.
    We need to determine the length of the largest valid substring of parentheses from a given string.
*/

/**
 * Approach 1: Brute Force (TLE)
 * Algorithm:
 * We need to traverse the string to check every possible non-empty substring whether it's a valid string of parentheses or not.
 * In order to check the validity, we use the Stack's Method. Same as the method in Problem 1's Solution 2.
 * Using this way, we repeat the process for every possible substring
 * and we keep on storing the length of the longest valid string found so far.
 * 
 * Complexity Analysis:
 *  Time complexity : O(n^3). Generating every possible substring from a string of length n requires O(n^2).
 *  Checking validity of a string of length n requires O(n).
 *  Space complexity : O(n).  A stack of depth n will be required for the longest substring.
 */
public class Solution {
    // Stack Method (same as Problem 1's Solution 2)
    public boolean isValid(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }

        Stack<Character> stack = new Stack<Character>();
        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')' && !stack.empty() && stack.peek() == '(') {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.empty();
    }

    public int longestValidParentheses(String str) {
        int maxlen = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 2; j <= str.length(); j += 2) {
                if (isValid(str.substring(i, j))) {
                    maxlen = Math.max(maxlen, j - i);
                }
            }
        }
        return maxlen;
    }
}

/**
 * Approach 2: DP
 * Algorithm:
 * We make use of a dp array where ith element of dp represents the length of the longest valid substring ending at ith index.
 * We initialize the complete dp array with 0's. Now, it's obvious that the valid substrings must end with ')'.
 * This further leads to the conclusion that: the substrings ending with '(' will always contain '0' at their corresponding dp indices.
 * Thus, we update the dp array only when ')' is encountered.
 * Function:
 *  Using pre represent the position of i-dp[i-1]-1.
 *  if s[i]=')' and s[pre]='(', i.e. string looks like "(......)"
 *  =>  dp[i] = dp[i-1] + 2
 *  But it's not enough...(And this is also the key point of this question)
 *  We should also plus the value of dp[pre-1] (if the pre-1 is in range)
 *  Eg. the string is "()()()()", if we don't plus the dp[pre-1]
 *  we will get dp[]={0,2,0,2,0,2,0,2}. 
 *  Apparently, it's wrong...
 *  But if we plus dp[pre-1], we can get dp[]={0,2,0,4,0,6,0,8}, it's the right answer.
 *
 * Complexity Analysis:
 * Time complexity  : O(n). Single traversal of string to fill dp array is done.
 * Space complexity : O(n). dp array of size n is used.
 * if you can't understand this method well. you can click here for help:
 * https://leetcode.com/articles/longest-valid-parentheses/
 */
public class Solution {
    public int longestValidParentheses(String s) {
        int maxlen = 0;
        int dp[] = new int[s.length()];

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                int pre = i - dp[i - 1] - 1;
                // check the pre is in range and s[pre] equals '('
                if (pre >= 0 && s.charAt(pre) == '(') {
                    // remember to plus dp[pre - 1] 
                    dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
                }
                maxlen = Math.max(maxlen, dp[i]);
            }
        }

        return maxlen;
    }
}

/**
 * Approach 3: Using Stack
 * Algorithm:
 * Instead of finding every possible string and checking its validity,
 * we can make use of Stack while scanning the given string to check if the string scanned so far is valid,
 * and also the length of the longest valid string.
 * In order to do so, we start by pushing −1 onto the stack.
 * For every‘(’ encountered, we push its index onto the stack.
 * For every ‘)’ encountered, we pop the topmost element and subtract the current element's index from the top element of the stack,
 * which gives the length of the currently encountered valid string of parentheses.
 * If while popping the element, the stack becomes empty, we push the current element's index onto the stack.
 * In this way, we keep on calculating the lengths of the valid substrings, and return the length of the longest valid string at the end.
 * 
 * Complexity Analysis:
 *  Time  complexity : O(n). n is the length of the given string.
 *  Space complexity : O(n). The size of stack can go up to n.
 */
public class Solution {
    public int longestValidParentheses(String s) {
        int maxlen = 0;
        Stack<Integer> stack = new Stack<>();

        // Initialize stack, push -1 first.
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            // when encounter '(' push the index onto stack
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                // when encounter ')', pop the topmost element first
                // then subtract the index from the peek element (if the stack is not empty)
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    // keep the longest length of the valid substrings
                    maxlen = Math.max(maxlen, i - stack.peek());
                }
            }
        }

        return maxlen;
    }
}

/**
 * Approach 4: Traverse string twice, left->right & right->left (without extra space)
 * Like method is Problem 1's Solution 1.
 * Algorithm:
 * In this approach, we make use of two counters left and right.
 * First, we start traversing the string from the left towards the right and for every ‘(’ encountered,
 * we increment the left counter and for every ‘)’ encountered, we increment the right counter.
 * Whenever left becomes equal to right, we calculate the length of the current valid string
 * and keep track of maximum length substring found so far.
 * If right becomes greater than left we reset left and right to 0.
 * Next, we start traversing the string from right to left and similar procedure is applied.
 * 
 * Complexity Analysis:
 *  Time  complexity : O(n). Two traversals of the string.
 *  Space complexity : O(1). Only two extra variables left and right are needed.
 */
public class Solution {
    public int longestValidParentheses(String s) {
        int left = 0, right = 0, maxlength = 0;

        // Left to Right
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            // left counters equals to right counters, calculate the length.
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
                // not equals, reset both counters to zero.
            } else if (right >= left) {
                left = right = 0;
            }
        }

        // Right to Left, similar procedure
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left >= right) {
                left = right = 0;
            }
        }

        return maxlength;
    }
}
