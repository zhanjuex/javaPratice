import java.io.*;

public class CopyTest {
    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        BookShop bookShop1 = new BookShop("清华书店");
        Bookshelf bookshelf1 = new Bookshelf("文化");
        Book book = new Book("中国文化");

        bookshelf1.setBook(book);
        bookShop1.setBookshelf(bookshelf1);

        // System.out.println(bookShop1.getBookshelf().getBookShelfName());

        BookShop bookShop2 = (BookShop) bookShop1.clone();
        System.out.println("bookShop1:" + bookShop1);
        System.out.println("bookShop2:" + bookShop2);
        // 引用是一样的
        System.out.println("bookShop1 bookshelf:" + bookShop1.getBookshelf() + " " + bookShop1.getBookshelf().getBookShelfName());
        System.out.println("bookShop2 bookshelf:" + bookShop2.getBookshelf() + " " + bookShop2.getBookshelf().getBookShelfName());
        bookShop2.getBookshelf().setBookShelfName("科技");
        System.out.println("bookShop1 bookshelf:" + bookShop1.getBookshelf() + " " + bookShop1.getBookshelf().getBookShelfName());
        System.out.println("bookShop2 bookshelf:" + bookShop2.getBookshelf() + " " + bookShop2.getBookshelf().getBookShelfName());

        BookShop bookShop3 = (BookShop) bookShop1.deepClone();
        System.out.println("bookShop1:" + bookShop1);
        System.out.println("bookShop3:" + bookShop3);
        // 引用不一样了
        System.out.println("bookShop1 bookshelf:" + bookShop1.getBookshelf() + " " + bookShop1.getBookshelf().getBookShelfName());
        System.out.println("bookShop3 bookshelf:" + bookShop3.getBookshelf() + " " + bookShop3.getBookshelf().getBookShelfName());
        bookShop3.getBookshelf().setBookShelfName("音乐");
        System.out.println("bookShop1 bookshelf:" + bookShop1.getBookshelf() + " " + bookShop1.getBookshelf().getBookShelfName());
        System.out.println("bookShop3 bookshelf:" + bookShop3.getBookshelf() + " " + bookShop3.getBookshelf().getBookShelfName());

    }
}


class BookShop implements Serializable, Cloneable {
    String bookShopName;
    Bookshelf bookshelf;

    public BookShop(String bookShopName) {
        this.bookShopName = bookShopName;
    }

    public String getBookShopName() {
        return bookShopName;
    }

    public void setBookShopName(String bookShopName) {
        this.bookShopName = bookShopName;
    }

    public Bookshelf getBookshelf() {
        return bookshelf;
    }

    public void setBookshelf(Bookshelf bookshelf) {
        this.bookshelf = bookshelf;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * 深拷贝
     * @return 对象
     */
    public Object deepClone() throws IOException, ClassNotFoundException{
        // 序列化
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(this);

        // 反序列化
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        return objectInputStream.readObject();
    }
}

class Bookshelf implements Serializable, Cloneable {
    String bookShelfName;
    Book book;

    public Bookshelf(String bookShelfName) {
        this.bookShelfName = bookShelfName;
    }

    public String getBookShelfName() {
        return bookShelfName;
    }

    public void setBookShelfName(String bookShelfName) {
        this.bookShelfName = bookShelfName;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Book implements Serializable, Cloneable {
    String bookName;

    public Book (String bookName) {
        this.bookName = bookName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
