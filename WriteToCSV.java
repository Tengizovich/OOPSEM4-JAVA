import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToCSV {
    public WriteToCSV(File file) {

        try (FileWriter fr = new FileWriter(file, false);) {
            StringBuilder strBuilder = new StringBuilder();
            for (Task task : TaskList.getTasks()) {
                strBuilder.append(task.getCreateDate());
                strBuilder.append(";");
                strBuilder.append(task.getCreateTime());
                strBuilder.append(";");
                strBuilder.append(task.getDeadline());
                strBuilder.append(";");
                strBuilder.append(task.getAuthor());
                strBuilder.append(";");
                strBuilder.append(task.getDescription());
                strBuilder.append(";");
                strBuilder.append(task.getTaskPriority());
                strBuilder.append("\n");
            }
            fr.append(strBuilder.toString());
        } catch (IOException e) {
            System.out.printf("Write ERROR! %s", e);
        }
    }

}
