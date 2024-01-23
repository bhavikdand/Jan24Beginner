package generics.documents;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        PDFDocument pdf = new PDFDocument("I am a PDF doc's content");
        DocumentPrinter<PDFDocument> pdfPrinter = new DocumentPrinter<>(pdf);
        pdfPrinter.print();

        CSVDocument csv = new CSVDocument("CSV file content");
        DocumentPrinter<CSVDocument> csvPrinter = new DocumentPrinter<>(csv);
        csvPrinter.print();

        Student s = new Student(10, "ABC");
//        DocumentPrinter<Student> documentPrinter = new DocumentPrinter<>(s);
//        documentPrinter.print();

        SpecialPDF specialPDF = new SpecialPDF("I am special pdf");
        DocumentPrinter<SpecialPDF> specialPDFDocumentPrinter = new DocumentPrinter<>(specialPDF);
        specialPDFDocumentPrinter.print();

//        print(s);
        print(pdf);
        PDFDocument pdfDocument = printAndGet(pdf);
        CSVDocument csvDocument = printAndGet(csv);

        List<PDFDocument> pdfs = Arrays.asList(pdf);
        List<CSVDocument> csvs = Arrays.asList(csv);

        printList(pdfs);
        printList(csvs);
    }

    public static <T extends Document> void print(T doc){
        System.out.println(doc);
    }

    public static <T extends Document> T printAndGet(T doc){
        System.out.println(doc);
        return doc;
    }

    // Create a method which will print list of documents (pdfs or csv or docs)
    public static <T extends Document> void printList(List<T> docs){
        System.out.println(docs);
    }


}

