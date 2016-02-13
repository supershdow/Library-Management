import java.util.ArrayList;
import java.util.Scanner;

public class LibraryRunner{
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    System.out.print("Borrower or Librarian?");
    String choice = scan.nextLine().toLowerCase();
    if (choice.charAt(0) == 'b'){
      System.out.print("Student or Teacher?");
      choice = scan.nextLine().toLowerCase();
      if (choice.charAt(0) == 's'){
        System.out.print("Enter your name (last, first)");
        System.out.println(Student.findStudent(scan.nextLine().trim()));
      }
      else if (choice.charAt(0) == 't'){
      }
    }
    else if (choice.charAt(0) == 'l'){
      
    }
    else
      main(args);
    scan.close();
    
  }
}