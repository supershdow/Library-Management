public class Book {
  private String ISBN, bookName, author, category, status;
  
  public Book(String ID, String bname, String auth, String cat, String stat){
    ISBN = ID;
    bookName = bname;
    author = auth;
    category = cat;
    status = stat;
  }
  
  public void writeBook(){
    String[] fields = {ISBN, bookName, author, category};
    String write = "";
    for (String add: fields)
      write += add + ",";
    write += status;
  }
    
}