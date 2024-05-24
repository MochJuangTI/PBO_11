package PBO;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        // add default list book
        library.addBook(new Book("1", "Harry Potter", "J.K. Rowling"));
        library.addBook(new Book("2", "The Hobbit", "J.R.R. Tolkien"));


        while (!exit) {
            System.out.println("=== Aplikasi Peminjaman Buku Perpustakaan ===");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Pinjam Buku");
            System.out.println("3. Kembalikan Buku");
            System.out.println("4. Lihat Daftar Buku");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over

            switch (choice) {
                case 1:
                    System.out.print("Masukkan ID Buku: ");
                    String id = scanner.nextLine();
                    System.out.print("Masukkan Judul Buku: ");
                    String title = scanner.nextLine();
                    System.out.print("Masukkan Penulis Buku: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(id, title, author));
                    System.out.println("Buku berhasil ditambahkan!");
                    break;
                case 2:
                    System.out.print("Masukkan ID Buku yang akan dipinjam: ");
                    String borrowId = scanner.nextLine();
                    library.borrowBook(borrowId);
                    break;
                case 3:
                    System.out.print("Masukkan ID Buku yang akan dikembalikan: ");
                    String returnId = scanner.nextLine();
                    library.returnBook(returnId);
                    break;
                case 4:
                    library.displayBooks();
                    break;
                case 5:
                    exit = true;
                    System.out.println("Terima kasih telah menggunakan aplikasi ini!");
                    break;
                default:
                    System.out.println("Opsi tidak valid. Silakan coba lagi.");
            }
            System.out.println();
        }
        scanner.close();
    }
}
