import java.util.Scanner;

class Book {
    private String name;
    private String author;
    private double price;
    private int numPages;

    // Constructor
    Book(String name, String author, double price, int numPages) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.numPages = numPages;
    }

    // Set methods
    void setName(String name) { this.name = name; }
    void setAuthor(String author) { this.author = author; }
    void setPrice(double price) { this.price = price; }
    void setNumPages(int numPages) { this.numPages = numPages; }

    // Get methods
    String getName() { return name; }
    String getAuthor() { return author; }
    double getPrice() { return price; }
    int getNumPages() { return numPages; }

    // toString method
    public String toString() {
        return "\nBook Name : " + name +
               "\nAuthor    : " + author +
               "\nPrice     : " + price +
               "\nPages     : " + numPages;
    }
}

// Main class
public class BookDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of books: ");
        int n = sc.nextInt();
        sc.nextLine();

        Book[] books = new Book[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details of book " + (i + 1));

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Author: ");
            String author = sc.nextLine();

            System.out.print("Price: ");
            double price = sc.nextDouble();

            System.out.print("Number of pages: ");
            int pages = sc.nextInt();
            sc.nextLine();

            books[i] = new Book(name, author, price, pages);
        }

        System.out.println("\n--- Book Details ---");
        for (Book b : books) {
            System.out.println(b);   // calls toString()
        }
    }
}

