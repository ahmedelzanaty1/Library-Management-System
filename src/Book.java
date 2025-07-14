public class Book {
    private int id ;
    private String title;
    private String author ;
    private boolean isAvailable;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public String getAuther() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
    @Override
    public String toString(){
        return "[" + id + "] " + title + " by " + author + " (" + (isAvailable ? "Available" : "Borrowed") + ")";

    }
}
