package generics.documents;

public class CSVDocument extends Document{
    public CSVDocument(String content) {
        super(content);
    }

    @Override
    public String toString() {
        return "CSVDocument{" +
                "content='" + content + '\'' +
                '}';
    }
}
