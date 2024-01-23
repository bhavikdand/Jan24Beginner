package generics.intro;

public class ObjectPrinter {

    Object objToPrint;

    public ObjectPrinter(Object objToPrint) {
        this.objToPrint = objToPrint;
    }

    public void print(){
        System.out.println(objToPrint);
    }

    public Object get(){
        return objToPrint;
    }
}
