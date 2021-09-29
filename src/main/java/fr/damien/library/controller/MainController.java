package fr.damien.library.controller;

import fr.damien.library.entity.Book;
import fr.damien.library.repository.BookRepository;
import fr.damien.library.utils.DataBaseConnection;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private TextField bookId;

    @FXML
    private TextField bookTitle;

    @FXML
    private TextField bookAuthor;

    @FXML
    private TextField bookYears;

    @FXML
    private TextField bookNbPages;

    @FXML
    private TableView tableView;

    @FXML
    private TableColumn<Book, Integer> tableId;

    @FXML
    private TableColumn<Book, String> tableTitle;

    @FXML
    private TableColumn<Book, String> tableAuthor;

    @FXML
    private TableColumn<Book, Integer> tableYears;

    @FXML
    private TableColumn<Book, Integer> tableNbPages;


    private int id;
    private String title = " ";
    private String authors = " ";
    private int years ;
    private int nbPages ;
    private ObservableList<ObservableList> data;

//    private TableView tableview;


    public void getInput() {
        this.id = Integer.parseInt(bookId.getText());
        this.title = bookTitle.getText();
        this.authors = bookAuthor.getText();
        this.years = Integer.parseInt(bookYears.getText());
        this.nbPages = Integer.parseInt(bookNbPages.getText());
    }

    @FXML
    void onDeleteAction(ActionEvent event) {

        Book book = (Book)tableView.getSelectionModel().getSelectedItem();
        BookRepository bookRepository = new BookRepository();
        bookRepository.deleteRecord(book.getId());
//        bookRepository.deleteRecord(Integer.parseInt(bookId.getText()));

        showBooks();
    }

    @FXML
    void onInsertAction(ActionEvent event) {

        getInput();

        Book newBook = new Book(id, title, authors, years,nbPages);

        BookRepository bookRepository = new BookRepository();
        bookRepository.insertRecord(newBook);
        showBooks();

    }

    @FXML
    void onUpdateAction(ActionEvent event) {
        getInput();

        Book newBook = new Book(id, title, authors, years,nbPages);

        BookRepository bookRepository = new BookRepository();
        bookRepository.updateRecord(newBook);
        showBooks();
    }

    @FXML
    private void handleTableView(Event event) {
        Book book = (Book)tableView.getSelectionModel().getSelectedItem();

        bookId.setText(String.valueOf(book.getId()));
        bookTitle.setText(book.getTitle());
        bookAuthor.setText(book.getAuthor());
        bookYears.setText(String.valueOf(book.getYears()));
        bookNbPages.setText(String.valueOf(book.getNbPages()));
    }


    public void showBooks() {

        BookRepository obsBook = new BookRepository();
        ObservableList<Book> list = obsBook.getBooksList();

        tableId.setCellValueFactory(new PropertyValueFactory<Book, Integer>("id"));
        tableTitle.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
        tableAuthor.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
        tableYears.setCellValueFactory(new PropertyValueFactory<Book, Integer>("years"));
        tableNbPages.setCellValueFactory(new PropertyValueFactory<Book, Integer>("nbPages"));

        tableView.setItems(list);
    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showBooks();
        /*
        tableView.setRowFactory( tv -> {
            TableRow<Book> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    Book rowData = row.getItem();
                    System.out.println(rowData);
                    bookId.setText(String.valueOf(row.getItem().getId()));
                    bookTitle.setText(row.getItem().getTitle());
                    bookAuthor.setText(row.getItem().getAuthor());
                    bookYears.setText(String.valueOf(row.getItem().getYears()));
                    bookNbPages.setText(String.valueOf(row.getItem().getNbPages()));
                }
            });
            return row ;
        });

         */
    }

}