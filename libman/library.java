
public class library {
    String name;
    int capacity;
    Book[] books;

    public library(String name, int capacity, Book[] books) {
        super();
        this.name = name;
        this.capacity = capacity;
        this.books = books;
    }

    public void issueBook(Book b, Customerr c) {

        Book[] books = c.b;
        for (int i = 0; i < books.length;) {
            if (books[i] == null) {
                if (!b.isIssued) {
                    b.isIssued = true;
                    System.out.println("Issued" + b.name);
                } else
                    System.out.println(b.name + " is already issued");
            }
            return;
        }
        System.out.println(c.name + "Cant issue a book");
    }

    public void returnBook(Book b) {
        b.isIssued = false;
        System.out.println(b.name + " returned successfully");
    }

}
