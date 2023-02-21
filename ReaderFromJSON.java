import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReaderFromJSON {
    public ReaderFromJSON(File file) {
        try (Scanner reader = new Scanner(new BufferedReader(new FileReader(file)))) {
            StringBuilder stringBuilder = new StringBuilder();
            while (reader.hasNext()) {
                stringBuilder.append(reader.nextLine());
            }
            String temp = stringBuilder.toString();
            temp = temp.replace("\n", "");
            int startIndex = temp.indexOf("{");
            int stopIndex = temp.lastIndexOf("}");
            temp = temp.substring(startIndex + 1, stopIndex);
            temp = temp.trim();
            startIndex = temp.indexOf("{");
            List<String> strings = new ArrayList<>();
            while (startIndex < temp.length()) {
                stopIndex = temp.indexOf("}", startIndex);
                strings.add(temp.substring(startIndex + 1, stopIndex).trim());
                startIndex = temp.indexOf("{", stopIndex + 1);
                if (startIndex < 0) {
                    startIndex = temp.length();
                }
            }
            for (String task : strings) {
                boolean repeat = true;
                startIndex = 0;
                LocalDate createDate = LocalDate.now();
                LocalDate deadline = LocalDate.now();
                LocalTime createTime = LocalTime.now();
                String author = new String();
                String description = new String();
                String priority = new String();
                while (repeat) {
                    startIndex = task.indexOf("\"", startIndex);
                    stopIndex = task.indexOf("\"", startIndex + 1);
                    String tag = task.substring(startIndex + 1, stopIndex);
                    startIndex = task.indexOf("\"", stopIndex + 1);
                    stopIndex = task.indexOf("\"", startIndex + 1);
                    String value = task.substring(startIndex + 1, stopIndex);
                    startIndex = stopIndex + 1;
                    switch (tag) {
                        case ("createDate") -> createDate = LocalDate.parse(value);
                        case ("createTime") -> createTime = LocalTime.parse(value);
                        case ("deadline") -> deadline = LocalDate.parse(value);
                        case ("author") -> author = value;
                        case ("description") -> description = value;
                        case ("priority") -> priority = value;
                        default -> repeat = false;

                    }
                    if (stopIndex == task.length() - 1) {
                        repeat = false;
                    }
                }
                TaskPriority taskPriority = TaskPriority.valueOf(priority);
                TaskList.add(new Task(createDate, createTime, deadline, author, description, taskPriority));
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
