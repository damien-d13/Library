package fr.damien.library.entity;

public class Book {

    private int id;
    private String title = "";
    private String author;
    private int years;
    private int nbPages;


    public Book(int id, String title, String author, int years, int nbPages ) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.years = years;
        this.nbPages = nbPages;
    }

//    public Book() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public int getNbPages() {
        return nbPages;
    }

    public void setNbPages(int nbPages) {
        this.nbPages = nbPages;
    }
}
