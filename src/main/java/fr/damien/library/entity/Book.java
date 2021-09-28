package fr.damien.library.entity;

public class Book {

    private int _id;
    private String _title = "";
    private String _author;
    private int _years;
    private int _nbPages;


    public Book(int id, String title, String author, int years, int nbPages ) {
        this._id = id;
        this._title = title;
        this._author = author;
        this._years = years;
        this._nbPages = nbPages;

    }

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        this._id = id;
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        this._title = title;
    }

    public String getAuthor() {
        return _author;
    }

    public void setAuthor(String author) {
        this._author = author;
    }

    public int getYears() {
        return _years;
    }

    public void setYears(int years) {
        this._years = years;
    }

    public int getNbPages() {
        return _nbPages;
    }

    public void setNbPages(int nbPages) {
        this._nbPages = nbPages;
    }
}
