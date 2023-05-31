package com.wjd.pattern.behavioral.iterator;

/**
 * @since 2022/1/21
 */
public class MainTest {

    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(4);
        bookShelf.appendBook(new Book("2设计模式"));
        bookShelf.appendBook(new Book("3代码整洁之道"));
        bookShelf.appendBook(new Book("4重构"));
        bookShelf.appendBook(new Book("1编程思想"));

        Iterator<Book> iterator = bookShelf.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            System.out.println(book.getName());
        }
    }

}
