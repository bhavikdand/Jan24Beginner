package generics.documents;

public class DocumentPrinter<D extends Document> {

    D doc;

    public DocumentPrinter(D doc) {
        this.doc = doc;
    }

    public void print(){
        doc.getContent();
        System.out.println(doc.content);
        System.out.println(doc);
    }
}
