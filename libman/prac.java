public class prac {
    public static void main(String[] args) {
      Book b = new Book("Let us C", 101, false);
      Book b1 = new Book("Java for beginners", 123, false);
      Book b2 = new Book("Why Bharat Matters", 121,false);
      Book b3 = new Book("India : 2040", 222,false);
      Book [] bb = new Book[4];
      bb[0]=b;
      bb[1]=b1;
      bb[2]=b2;
      bb[3]=b3;
      library l = new library("India", 2000, bb);
      Customerr c = new Customerr("Raj", new Book[2]);
      l.issueBook(b, c);
    l.issueBook(b, c);
    l.returnBook(b);
    l.issueBook(b1,c);
  
    }
  }