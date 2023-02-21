import java.io.File;
import java.util.Scanner;

public class ReaderService {
    static Scanner sc = new Scanner(System.in);
    public static String path = "C:/Users/Admin/Java_projects/GB_java_seminars/src/seminar4_homework/TaskList";

    public static void getChoice() {
        boolean repeatInput = true;
        while (repeatInput) {
            System.out.println("Read from: 1-XML, 2-CSV, 3-JSON");
            switch (sc.next()) {
                case ("1") -> {
                    ReaderFromXML();
                    repeatInput = false;
                }
                case ("2") -> {
                    ReaderFromCSV();
                    repeatInput = false;
                }
                case ("3") -> {
                    ReaderFromJSON();
                    repeatInput = false;
                }
                default -> System.out.println("read ERROR");
            }
        }
    }

    public static void ReaderFromXML() {
        path += ".xml";
        ReaderFromXML imp = new ReaderFromXML(new File(path));
    }

    public static void ReaderFromCSV() {
        path += ".csv";
        ReaderFromCSV imp = new ReaderFromCSV(new File(path));
    }

    public static void ReaderFromJSON() {
        path += ".json";
        ReaderFromJSON imp = new ReaderFromJSON(new File(path));
    }

}
