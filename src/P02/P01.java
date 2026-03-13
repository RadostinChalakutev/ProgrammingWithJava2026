package P02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Author {
    private String name;

    Author(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Document {
    private double size;
    private String format;
    private String title;

    Document(double size, String format, String name) {
        this.size = size;
        this.format = format;
        this.title = name;
    }


    public double getSize() {
        return size;
    }

    public String getFormat() {
        return format;
    }

    public String getTitle() {
        return title;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}

class Book extends Document {
    private Author author;
    private String ISBN;

    public Book(double size, String format, String title, Author author, String ISBN) {
        super(size, format, title);
        this.author = author;
        this.ISBN = ISBN;
    }

    public Author getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public String toString() {
        return super.toString() + " ," + author.toString() + ", ISBN: " + ISBN;
    }
}

class Novel extends Book {
    private String summary;

    Novel(double size, String format, String title, Author author, String ISBN, String summary) {
        super(size, format, title, author, ISBN);
        this.summary = summary;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "Novel->" + super.toString() + ", Summary: " + summary;

    }
}

class PoetryBook extends Book {
    int numbersOfPoetries;

    PoetryBook(double size, String format, String title, Author author, String ISBN, int numbersOfPoetries) {
        super(size, format, title, author, ISBN);
        this.numbersOfPoetries = numbersOfPoetries;
    }

    public int getNumbersOfPoetries() {
        return numbersOfPoetries;
    }

    public void setNumbersOfPoetries(int numbersOfPoetries) {
        this.numbersOfPoetries = numbersOfPoetries;
    }

    @Override
    public String toString() {
        return "Poetry: " + super.toString() + "with numbers of poems " + numbersOfPoetries;
    }

}

class Newspaper extends Document {
    private int periodicity;
    private int articleCount;

    Newspaper(double size, String format, String title, int periodicity, int articleCount) {
        super(size, format, title);
        this.articleCount = articleCount;
        this.periodicity = periodicity;
    }


    public int getArticleCount() {
        return articleCount;
    }

    public int getPeriodicity() {
        return periodicity;
    }

    public void setArticleCount(int articleCount) {
        this.articleCount = articleCount;
    }

    public void setPeriodicity(int periodicity) {
        this.periodicity = periodicity;
    }

    @Override
    public String toString() {
        return "Newsletter: " + toString() + "with number of article " + articleCount;
    }
}

class Storage {
    private double maxCapacity;
    private int documentCount;
    private double currentDataVolume;
    private List<Document> documentList;

    public Storage(double maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.documentCount = 0;
        this.currentDataVolume = 0;
        this.documentList = new ArrayList<>();
    }

    public boolean addDocument(Document document) {
        if (currentDataVolume + document.getSize() <= maxCapacity) {
            documentList.add(document);
            documentCount++;
            currentDataVolume += document.getSize();
            System.out.println(document.getTitle() + " added to storage");
            return true;
        } else {
            System.out.println("No storage space for document: " + document.getTitle());

            return false;
        }

    }

    @Override
    public String toString() {
        return "Storage-> Maximum space: " + maxCapacity + " MB" + ", Documents: " + documentCount + ", Current space: " + currentDataVolume + " MB";

    }

    public void printAllDocuments() {
        System.out.println("Storage contain:");
        for (Document d : documentList) {
            System.out.println(d);
        }
    }
}

public class P01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Въведи максимален обем на хранилището: ");
        double maxCapacity = sc.nextDouble();
        sc.nextLine();

        Storage storage = new Storage(maxCapacity);

        System.out.print("Въведи брой документи: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("\nДокумент " + (i + 1));
            System.out.println("Избери тип: 1-Роман, 2-Стихосбирка, 3-Вестник");
            int type = sc.nextInt();
            sc.nextLine();

            System.out.print("Заглавие: ");
            String title = sc.nextLine();

            System.out.print("Формат: ");
            String format = sc.nextLine();

            System.out.print("Размер на файла: ");
            double fileSize = sc.nextDouble();
            sc.nextLine();

            if (type == 1) {
                System.out.print("Име на автор: ");
                String authorName = sc.nextLine();

                System.out.print("ISBN: ");
                String isbn = sc.nextLine();

                System.out.print("Резюме: ");
                String summary = sc.nextLine();

                Author author = new Author(authorName);
                Novel novel = new Novel(fileSize, format, title, author, isbn, summary);
                storage.addDocument(novel);

            } else if (type == 2) {
                System.out.print("Име на автор: ");
                String authorName = sc.nextLine();

                System.out.print("ISBN: ");
                String isbn = sc.nextLine();

                System.out.print("Брой стихотворения: ");
                int poemCount = sc.nextInt();
                sc.nextLine();

                Author author = new Author(authorName);
                PoetryBook poetryBook = new PoetryBook(fileSize, format, title, author, isbn, poemCount);
                storage.addDocument(poetryBook);

            } else if (type == 3) {
                System.out.print("Периодичност на издаване: ");
                int periodicity = Integer.parseInt(sc.nextLine());

                System.out.print("Брой статии: ");
                int articleCount = sc.nextInt();
                sc.nextLine();

                Newspaper newspaper=new Newspaper(fileSize,format,title,periodicity,articleCount);
                storage.addDocument(newspaper);

            } else {
                System.out.println("Невалиден тип документ!");
            }
        }

        System.out.println();
        System.out.println(storage);
        storage.printAllDocuments();
    }
}

