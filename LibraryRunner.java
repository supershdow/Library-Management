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
          System.out.print("Enter the name or ISBN of the book you would like to search for");
          System.out.println(Librarian.findAllBooks(scan.nextLine()));
        }
        else if (choice.charAt(0) == 'b'){
          if (!current.canBorrow())
            System.out.println("You have reached your borrowing limit. Please return a book first");
          else{
            System.out.print("Enter the ISBN of book you would like to borrow");
            choice = scan.nextLine();
            if (Librarian.findAllBooks(choice).get(0).isAvailable()){
              current.borrowBook(Librarian.findAllBooks(choice).get(0));
              System.out.println("Book borrowed");
            }
          }
        }
        else if (choice.charAt(0) == 'r'){
          if (current.hasBorrowedBooks()){
            System.out.print("Enter the ISBN of the book you want to return");
            current.removeBook(Librarian.findAllBooks(scan.nextLine()).get(0));
          }
        }
      }
      else if (choice.charAt(0) == 't'){
        System.out.print("Enter your ID");
        Teacher current = Teacher.findTeacher(scan.nextLine().trim());
        System.out.print("Would you like to search for a book, borrow one or return one?");
        choice = scan.nextLine().toLowerCase();
        if (choice.charAt(0) == 's'){
          System.out.print("Enter the name or ISBN of the book you would like to search for");
          System.out.println(Librarian.findAllBooks(scan.nextLine()));
        }
        else if (choice.charAt(0) == 'b'){
          if (!current.canBorrow())
            System.out.println("You have reached your borrowing limit. Please return a book first");
          else{
            System.out.print("Enter the ISBN of book you would like to borrow");
            choice = scan.nextLine();
            if (Librarian.findAllBooks(choice).get(0).isAvailable())
              current.borrowBook(Librarian.findAllBooks(choice).get(0));
          }
        }
        else if (choice.charAt(0) == 'r'){
          if (current.hasBorrowedBooks()){
            System.out.print("Enter the ISBN of the book you want to return");
            current.removeBook(Librarian.findAllBooks(scan.nextLine()).get(0));
          }
        }
      }
    }
    else if (choice.charAt(0) == 'l'){
      System.out.print("Would you like to enter a new book, remove an old one, update a status or check borrowing history?");
      choice = scan.nextLine().toLowerCase();
      if (choice.charAt(0) == 'e'){
        System.out.print("Enter the ISBN, name, author, genre, and status of the book to be added");
        Librarian.addNewBook(Book.toBook(scan.nextLine()));
      }
      else if (choice.charAt(0) == 'r'){
        System.out.print("Enter the ISBN of the book you want to remove");
        Librarian.removeOldBook(Librarian.findAllBooks(scan.nextLine()).get(0));
      }
      else if (choice.charAt(0) == 'u'){
        System.out.print("Enter the ISBN of the book and the new status");
        Book update = Librarian.findAllBooks(scan.nextLine()).get(0);
        update.updateStatus(scan.nextLine());
      }
      else if (choice.charAt(0) == 'c'){
        System.out.print("Enter the ISBN or name of the book");
        System.out.println(Librarian.findAllBooks(scan.nextLine()).get(0).getBorrowHistory());
      }
    }
    else
      main(args);
    scan.close();
    
  }
}