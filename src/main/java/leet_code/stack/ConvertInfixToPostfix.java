package leet_code.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class ConvertInfixToPostfix {
  static void main() {

    String input = "A*(B+C)/D"; // "A+B*C-D";

    String result = convertToPostfix(input);

    System.out.println("Result: " + result);
  }

  static String convertToPostfix(String input) {
    Deque<Character> stack = new ArrayDeque<>();
    StringBuilder result = new StringBuilder();
    Map<Character, Integer> priorityMap = new HashMap<>();

    priorityMap.put('^', 5);
    priorityMap.put('/', 4);
    priorityMap.put('*', 3);
    priorityMap.put('+', 2);
    priorityMap.put('-', 1);

    int i = 0;

    while (i < input.length()) {
      char ch = input.charAt(i);

      if (Character.isLetterOrDigit(ch)) {
        result.append(ch).append(' ');

      } else if (ch == '(') {
        stack.push(ch);

      } else if (ch == ')') {
        while (!stack.isEmpty() && stack.peek() != '(') {
          result.append(stack.pop()).append(' ');
        }
        if (!stack.isEmpty()) stack.pop();

      } else {
        while (!stack.isEmpty()
            && stack.peek() != '('
            && !(ch == '^' && stack.peek() == '^')
            && priorityMap.get(ch) <= priorityMap.get(stack.peek())) {
          result.append(stack.pop()).append(' ');
        }
        stack.push(ch);
      }

      i++;
    }

    while (!stack.isEmpty()) {
      result.append(stack.pop()).append(' ');
    }

    return result.toString().trim();
  }
}
