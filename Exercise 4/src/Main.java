public class Main {
    public static void main(String[] args) {
        Book[] books = initBook();
        countBooks(books);
        countJavaBooks(books);
        System.out.println("Show book list");
        showBooks(books);
        sortBooks(books);
        System.out.println("After sort books");
        showBooks(books);
    }

    private static void sortBooks(Book[] books) {
        for (int i = 0; i < books.length-1; i++) {
            for (int j = i+1; j < books.length; j++){
                Book book1 = books[i];
                Book book2 = books[j];
                Book temp = new Book();
                if (book1.getPrice() < book2.getPrice()){
                    temp = books[i];
                    books[i] = books[j];
                    books[j] = temp;
                }
            }
        }
    }

    private static void showBooks(Book[] books) {
        for (Book book:
                books) {
            System.out.println(book);
            System.out.println();
        }
    }

    private static void countJavaBooks(Book[] books) {
        int countJavaBook = 0;
        for (Book book :
                books) {
            if (book instanceof ProgrammingBook) {
                if (((ProgrammingBook) book).getLanguage().equals("Java")) {
                    countJavaBook++;
                }
            }
        }
        System.out.println("Total numbers of Java books: " + countJavaBook);
    }

    private static void countBooks(Book[] books) {
        double totalPrice = 0;
        for (Book book :
                books) {
            totalPrice += book.getPrice();
        }
        System.out.println("Total price of books: " + totalPrice);
    }

    private static Book[] initBook() {
        Book[] books = new Book[10];
        Book fb1 = new FrictionBook(1, "book1", 5.0, "Chuoi", "love");
        Book fb2 = new FrictionBook(2, "book2", 5.5, "Thanh", "friend");
        Book fb3 = new FrictionBook(3, "book3", 2.0, "Duyet", "love");
        Book fb4 = new FrictionBook(4, "book4", 3.0, "Tri", "friend");
        Book fb5 = new FrictionBook(5, "book5", 4.5, "Ngoc Anh", "love");
        Book pb1 = new ProgrammingBook(6, "java", 3.5, "Quan", "Java", "Spring");
        Book pb2 = new ProgrammingBook(7, "C++", 3.5, "Son", "Java", "Bootstrap");
        Book pb3 = new ProgrammingBook(8, "HTML", 2.5, "Tu", "Java", "Spring");
        Book pb4 = new ProgrammingBook(9, "Pascal", 1.5, "Minh", "PHP", "Bootstrap");
        Book pb5 = new ProgrammingBook(10, "JS", 6.5, "Tuan", "PHP", "Spring");
        books[0] = fb1;
        books[1] = fb2;
        books[2] = fb3;
        books[3] = fb4;
        books[4] = fb5;
        books[5] = pb1;
        books[6] = pb2;
        books[7] = pb3;
        books[8] = pb4;
        books[9] = pb5;
        return books;
    }
}
