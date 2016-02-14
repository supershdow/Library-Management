import java.io.*;
import java.util.ArrayList;

public class Librarian 
{
  
 public void addNewBook(Book book) throws IOException{
   PrintWriter outputFile =
                 new PrintWriter(new FileWriter("Book.txt"));
   outputFile.println(book);
   outputFile.close();
   System.out.println("Book added");
 }
 
   public static Book findBook(String info) throws IOException{
    BufferedReader inputFile =
                 new BufferedReader(new FileReader("Books.txt"), 1024);
   String line;
    while ((line = inputFile.readLine()) != null)
    {
      if (line.contains(info)){
        return Book.toBook(line);
      }
    }
    return null;
  }
  
  public static ArrayList<Book> findAllBooks(String info) throws IOException{
    BufferedReader inputFile =
                 new BufferedReader(new FileReader("Books.txt"), 1024);
    ArrayList<Book> bookList = new ArrayList<Book>();
   String line;
    while ((line = inputFile.readLine()) != null)
    {
      if (line.contains(info)){
        bookList.add(Book.toBook(line));
      }
    }
    return bookList;
  }
 
 public void removeOldBook(Book book) throws IOException{
   BufferedReader inputFile =
                 new BufferedReader(new FileReader("Book.txt"), 1024);
   PrintWriter outputFile =
                 new PrintWriter(new FileWriter("Book.txt"));
   ArrayList<Book> readBooks = new ArrayList<Book>();
   String line;
    while ((line = inputFile.readLine()) != null)
    {
      if (line.equals(book.toString()))
        continue;
      else
        readBooks.add(Book.toBook(line));
    }
   for (Book toAdd: readBooks)
     outputFile.println(toAdd.toString());
   System.out.println("Book removed");
 }
  
}