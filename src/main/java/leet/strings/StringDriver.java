package leet.strings;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringDriver {

  // Q1 -> For a given input get all digits
  static void main() {
    // String userInput = getUserInput();
    // measureTimeMillis(() -> checkForDigits(userInput));

    checkForWordsInMessage("The Leetcode Coders Test", "Leetcode tests the codes of coder");
  }

  // functional approach to check for digits in given string
  public static void checkForDigits(String userInput) {
    if (userInput != null) {
      userInput
          .chars()
          .mapToObj(c -> (char) c)
          .filter(Character::isDigit)
          .forEach(d -> log.info("Digit -> {}", d));
    }
  }

  // functional approach to check for letters in given string
  public static void checkForLetters(String userInput) {
    if (userInput != null) {
      userInput
          .chars()
          .mapToObj(c -> (char) c)
          .filter(Character::isLetter)
          .forEach(l -> log.info("Letter -> {}", l));
    }
  }

  // functional approach to return updated string with ### if word in given message is not present
  // in given  dictionary
  public static void checkForWordsInMessage(String dictionary, String message) {

    if (message != null && dictionary != null) {
      Set<String> dictionarySet =
          Arrays.stream(dictionary.split(" ")).map(String::toLowerCase).collect(Collectors.toSet());

      message =
          Arrays.stream(message.split(" "))
              .map(word -> dictionarySet.contains(word.toLowerCase()) ? word : "###")
              .collect(Collectors.joining(" "));
    }
    log.info("Updated message: {}", message);
  }

  public static String getUserInput() {
    log.info("Enter input:");
    Scanner scanner = new Scanner(System.in);
    return scanner.nextLine();
  }
}
