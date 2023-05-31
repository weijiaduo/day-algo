package com.wjd.pattern.behavioral.iterator;

/**
 * @since 2022/1/21
 */
public class BookShelf implements Aggregate<Book> {

    private Book[] books;
    private int last = 0;

    public BookShelf(int maxSize) {
        this.books = new Book[maxSize];
    }

    public Book getBookAt(int index) {
        return books[index];
    }

    public void appendBook(Book book) {
        sortInsert(book);
    }

    public int getLength() {
        return last;
    }

    private void sortInsert(Book book) {
        int index = last;
        for (; index > 0; index--) {
            Book b = books[index - 1];
            if (book.getName().compareTo(b.getName()) <= 0) {
                break;
            }
            books[index] = b;
        }
        books[index] = book;
        last++;
    }

    @Override
    public Iterator<Book> iterator() {
        return new BookShelfIterator(this);
    }

}
