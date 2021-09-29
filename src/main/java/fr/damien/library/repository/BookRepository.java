package fr.damien.library.repository;

import fr.damien.library.entity.Book;
import fr.damien.library.utils.DataBaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.sql.ResultSet;
import java.sql.Statement;

public class BookRepository {

    private static ObservableList<ObservableList> data;
    private TableView tableview;


    public void insertRecord(Book newBook) {
        String bookTitle = newBook.getTitle();
        String bookAuthor = newBook.getAuthor();
        int bookYears = newBook.getYears();
        int bookPage = newBook.getNbPages();

        try {
            String INSERT_QUERY = "INSERT INTO t_book (book_title, book_author, book_years, book_nbpages) VALUES ('" + bookTitle + "','" + bookAuthor + "','" + bookYears + "','" + bookPage + "')";
            Statement statement = DataBaseConnection.getConnection().createStatement();
            statement.executeUpdate(INSERT_QUERY);


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in Repository");
        }
    }

    public void updateRecord(Book newBook) {
        int bookId = newBook.getId();
        String bookTitle = newBook.getTitle();
        String bookAuthor = newBook.getAuthor();
        int bookYears = newBook.getYears();
        int bookPage = newBook.getNbPages();

        try {
            String UPDATE_QUERY = "UPDATE t_book SET book_title = '" + bookTitle + "' , book_author = '" + bookAuthor + "', book_years = '" + bookYears + "', book_nbpages = '" + bookPage + "' WHERE book_id = " + bookId;
            Statement statement = DataBaseConnection.getConnection().createStatement();
            statement.executeUpdate(UPDATE_QUERY);


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in Repository");
        }
    }

    public  void deleteRecord(int id) {

        try {
            String DELETE_QUERY = "DELETE FROM t_book WHERE book_id = " + id;
            Statement statement = DataBaseConnection.getConnection().createStatement();
            statement.executeUpdate(DELETE_QUERY);


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in Repository");
        }
    }


    public ObservableList<Book> getBooksList() {
        ObservableList<Book> bookList = FXCollections.observableArrayList();
        //SQL FOR SELECTING ALL OF BOOK
        String SQL = "SELECT * from t_book";
        try {

            //ResultSet
            ResultSet rs = DataBaseConnection.getConnection().createStatement().executeQuery(SQL);
            while (rs.next()) {
                Book book = new Book(rs.getInt("book_id"), rs.getString("book_title"), rs.getString("book_author"), rs.getInt("book_years"), rs.getInt("book_nbpages"));
                bookList.add(book);
            }


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in Repository");
        }
        return bookList;
    }
}
