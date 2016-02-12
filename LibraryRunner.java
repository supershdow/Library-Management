import java.util.ArrayList;
import java.util.Scanner;

public class LibraryRunner{
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    System.out.print("Borrower or Librarian?");
    String choice = scan.nextLine().toLowerCase();
    if (choice.charAt(0) == 'b'){
      System.out.print("Student or Teacher?");
      String choice2 = scan.nextLine().toLowerCase();
      if (choice2.charAt(0) == 's'){
      }
      else if (choice2.charAt(0) == 't'){
      }
    }
    else if (choice.charAt(0) == 'l'){
      
    }
    else
      main(args);
    
  }
}