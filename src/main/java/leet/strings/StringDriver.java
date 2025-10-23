package leet.strings;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class StringDriver {

  public static void main(String... args) {
    log.info("Enter input:");
    Scanner scanner = new Scanner(System.in);
    String userInput = scanner.nextLine();
    checkForDigits(userInput);
    checkForLetters(userInput);
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
}