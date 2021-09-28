package fr.damien.library.repository;

import fr.damien.library.entity.Book;
import fr.damien.library.utils.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class BookRepository {


    private static final String GET_QUERY = "SELECT book_title, book_author, book_years, book_nbpage FROM t_book";


    DataBaseConnection dataBaseConnection = new DataBaseConnection();
    Connection connectDB = dataBaseConnection.getConnection();

    public void insertRecord(Book newBook) {
        String bookTitle = newBook.getTitle();
        String bookAuthor = newBook.getAuthor();
        int bookYears = newBook.getYears();
        int bookPage = newBook.getNbPages();

        try {
            String INSERT_QUERY = "INSERT INTO t_book (book_title, book_author, book_years, book_nbpage) VALUES ('" + bookTitle + "','" + bookAuthor + "','" + bookYears + "','" + bookPage + "')";
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(INSERT_QUERY);


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur dans le Main");
        }
    }
}
