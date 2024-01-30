package exception_handling;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {

    public static void main(String[] args) {
        System.out.println("I am starting to read the file");
        readFile("scaler.txt");
        System.out.println("I have read the file");
//
//
//        System.out.println(getInt("1"));
//        System.out.println(getInt("ABCD"));
//        System.out.println("I am last line");

        try {
            readFile2("scaler.txt");
        } catch (Exception e){
            e.printStackTrace();
        }
//        readFile2("scaler.txt");
        System.out.println("I am really the last line");

        readFile("dummy.txt");

        Integer.parseInt("1");

        int age = -10;
        try {
            validateAge(age);
        } catch (NegativeException ne){
            System.out.println(ne.getMessage());
            return;
        }
        System.out.println("Age is verified and correct");

    }

    public static void readFile(String filePath) {
        try {
            FileReader fileReader = new FileReader(filePath);
        } catch (FileNotFoundException fnfe){
            System.out.println("Something bas has happened");
            System.out.println("Exception message:" + fnfe.getMessage());
            fnfe.printStackTrace();
        }finally {
            System.out.println("I will be executed all the time");
        }






    }

    public static void validateAge(int age) throws NegativeException{
        if(age < 0){
            throw new NegativeException("Age cannot be negative");
        }
    }

    public static int getInt(String s){
        try {
            int num = Integer.parseInt(s);
            System.out.println("Num:" + num);
            return num;
        }catch (NumberFormatException nfe){
            nfe.printStackTrace();
        }finally {
            System.out.println("I am inevitable");
        }
        return -1;
    }

    public static void readFile2(String filePath) throws FileNotFoundException{
        FileReader fileReader = new FileReader(filePath);
    }
}
