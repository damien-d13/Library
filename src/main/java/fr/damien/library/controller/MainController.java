package fr.damien.library.controller;

import fr.damien.library.entity.Book;
import fr.damien.library.repository.BookRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController {
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
    void onDeleteAction(ActionEvent event) {
    }

    @FXML
    void onInsertAction(ActionEvent event) {
        int id = Integer.parseInt(bookId.getText());;
        String title = bookTitle.getText();
        String authors = bookAuthor.getText();
        int years = Integer.parseInt(bookYears.getText());
        int nbPage = Integer.parseInt(bookNbPages.getText());

        Book newBook = new Book(id, title, authors, years,nbPage);

        BookRepository bookRepository = new BookRepository();
        bookRepository.insertRecord(newBook);


    }

    @FXML
    void onUpdateAction(ActionEvent event) {

    }
}