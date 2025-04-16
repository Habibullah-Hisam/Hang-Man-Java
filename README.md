# Hangman Game in Java

This is a simple command-line Hangman game implemented in Java.

## How to Play

1.  **Clone the repository (if applicable) or save the `Main.java` file.**
2.  **Ensure you have a file named `words.txt` in the same directory as `Main.java`. This file should contain a list of words, with each word on a new line.**
3.  **Compile the Java code:**
    ```bash
    javac Main.java
    ```
4.  **Run the game:**
    ```bash
    java Main
    ```

The game will then start, and you will be prompted to guess letters.

## Game Description

The game randomly selects a word from the `words.txt` file. Your goal is to guess the word by suggesting letters.

* At the beginning, the word is displayed as a series of underscores, representing the unguessed letters.
* You enter one lowercase letter at a time.
* If your guess is correct, all occurrences of that letter in the word are revealed.
* If your guess is incorrect, a part of the "hangman" figure is drawn, and your number of wrong guesses increases.
* You have a maximum of 6 wrong guesses before the game ends.
* You win if you correctly guess all the letters in the word before running out of guesses.
* If you run out of guesses, the game ends, and the correct word is revealed.

## Code Structure

The Java code consists of a single class, `Main`, with the following methods:

* `main(String[] args)`: This is the entry point of the program. It handles:
    * Reading words from the `words.txt` file.
    * Selecting a random word.
    * Initializing the game state (displaying underscores).
    * The main game loop, which takes user input, checks guesses, updates the game state, and determines the winner or loser.
    * Closing the scanner.
* `conditionOfMan(int wrongGusses)`: This static method takes the number of wrong guesses as input and returns a string representation of the current state of the hangman figure.

## Potential Improvements

* **Error Handling:** Improve error handling for invalid user input (e.g., entering more than one character or non-alphabetic characters).
* **Case Insensitivity:** The current implementation converts the user's guess to lowercase. Consider making the word selection case-insensitive as well.
* **Duplicate Guesses:** Keep track of already guessed letters to prevent the user from guessing the same letter multiple times.
* **User Interface:** Enhance the user interface (e.g., display the number of remaining guesses, the letters already guessed).
* **Difficulty Levels:** Implement difficulty levels by selecting words of different lengths.
* **Scoring:** Add a scoring system.

Enjoy playing Hangman!