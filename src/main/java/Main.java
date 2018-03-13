import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyList<String> myList = null;
        while (myList == null){
            System.out.println("Введите имя файла: ");
            File file = new File();
            myList = file.copyFileToArray(new Scanner(System.in).next());
        }
        File file = new File();
        file.createResult(myList);

    }
}
