import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class LibraryRunner{
  public static void main(String[] args) throws IOException{
    Scanner scan = new Scanner(System.in);
    System.out.print("Borrower or Librarian?");
    String choice = scan.nextLine().toLowerCase();
    if (choice.charAt(0) == 'b'){
      System.out.print("Student or Teacher?");
      choice = scan.nextLine().toLowerCase();
      if (choice.charAt(0) == 's'){
        System.out.print("Enter your OSIS");
        Student current = Student.findStudent(scan.nextLine().trim());
        System.out.print("Would you like to search for a book, borrow one or return one?");
        choice = scan.nextLine().toLowerCase();
        if (choice.charAt(0) == 's'){
          System.out.print("Enter the name of the book you would like to search for");
          System.out.println(Book.findBook(scan.nextLine()));
        }
        else if (choice.charAt(0) == 'b'){
          if (!current.canBorrow())
            System.out.println("You have reached your borrowing limits. Please return a book first");
        }
        else if (choice.charAt(0) == 'r'){
         
        }
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