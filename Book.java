import java.io.*;

public class Book {
  private String ISBN, bookName, author, category, status;
  
  public Book(String ID, String bname, String auth, String cat, String stat){
    ISBN = ID;
    bookName = bname;
    author = auth;
    category = cat;
    status = stat;
  }
  
  public String toString(){
    String[] fields = {ISBN, bookName, author, category};
    String write = "";
    for (String add: fields)
      write += add + ",";
    write += status;
    return write;
  }
  
  public static Book toBook(String info){
   String[] fields = new String[5];
   for (int i = 0; i < 5; i++){
     if (info.indexOf(",") == -1){
       fields[i] = info;
       break;
     }
     fields[i] = info.substring(0,info.indexOf(","));
     info = info.substring(info.indexOf(",") + 1);
   }
   return new Book(fields[0],fields[1],fields[2],fields[3],fields[4]);
 }
  
  public static Book findBook(String title) throws IOException{
    BufferedReader inputFile =
                 new BufferedReader(new FileReader("Books.txt"), 1024);
   String line;
    while ((line = inputFile.readLine()) != null)
    {
      if (line.contains(title)){
        return toBook(line);
      }
    }
    return null;
  }
    
}