import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws Exception {
    
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    
    String filePath = "words.txt";
    ArrayList<String> words = new ArrayList<>();
    
    try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
      String line;
      while((line = reader.readLine()) != null){
        words.add(line.trim());
      }
    }
    catch(FileNotFoundException e){
      System.out.println("Could not find the file!");
    }
    catch(IOException e){
      System.out.println("Something went wrong!");
    }
    
    String word = words.get(random.nextInt(words.size()));
    
    
    ArrayList<Character> wordState = new ArrayList<>();
    for(int i=0;i<word.length();i++){
      wordState.add(i,'_');
    }
    
    for(Character c : wordState){
      System.out.print(c + " ");
    }
    
    System.out.println("");
    
    int wrongGusses = 0;
    
    while(wrongGusses < 6){
      
      char guss;
      System.out.print(conditionOfMan(wrongGusses));
      
      System.out.print("Enter your gussed character: ");
      guss = scanner.next().toLowerCase().charAt(0);
      if(word.indexOf(guss) >= 0){
        
        System.out.println("Currect guss!");
        
        for(int i=0;i<word.length();i++){
          if(word.charAt(i)==guss){
            wordState.set(i, guss);
          }
        }
        for(Character c : wordState){
          System.out.print(c + " ");
        }
        System.out.println("");
        if(!wordState.contains('_')){
          System.out.println(conditionOfMan(wrongGusses));
          System.out.println("YOU WIN!");
          System.out.println("The word was: " + word);
          break;
        }
      }
      else{
        System.out.println("Wrong guss!");
        wrongGusses++;
      }
    }
    if(wrongGusses==6){
      System.out.println(conditionOfMan(wrongGusses));
      System.out.println("The word was: " + word);
    }
    System.out.println("");
    System.out.println("GAME OVER!");
    System.out.println("");
    
    
    scanner.close();
  }
  


  static String conditionOfMan(int wrongGusses){
    return switch(wrongGusses){
      case 0 -> "";
      case 1 -> """
           0

          """;
      case 2 -> """
           0
           |
          """;
      case 3 -> """
           0
          /|
          """;
      case 4 -> """
           0
          /|\\
          """;
      case 5 -> """
           0
          /|\\
          /
          """;
      case 6 -> """
           0
          /|\\
          / \\
          """;
      default -> "More than 6 wrong gusses!";
    };
  }
}
