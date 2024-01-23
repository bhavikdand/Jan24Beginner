package generics.documents;

public class PDFDocument extends Document{

    public PDFDocument(String content) {
        super(content);
    }

    @Override
    public String toString() {
        return "PDFDocument{" +
                "content='" + content + '\'' +
                '}';
    }
}
