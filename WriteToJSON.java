import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToJSON {
    public WriteToJSON(File file) {
        try (FileWriter fr = new FileWriter(file, false);) {
            StringBuilder strBuilder = new StringBuilder();
            strBuilder.append("{");
            int iterator = 1;
            for (Task task : TaskList.getTasks()) {
                strBuilder.append("\"task");
                strBuilder.append(iterator);
                strBuilder.append("\":{\"createDate\":\"");
                strBuilder.append(task.getCreateDate());
                strBuilder.append("\",\"createTime\":\"");
                strBuilder.append(task.getCreateTime());
                strBuilder.append("\",\"deadline\":\"");
                strBuilder.append(task.getDeadline());
                strBuilder.append("\",\"author\":\"");
                strBuilder.append(task.getAuthor());
                strBuilder.append("\",\"description\":\"");
                strBuilder.append(task.getDescription());
                strBuilder.append("\",\"priority\":\"");
                strBuilder.append(task.getTaskPriority());
                strBuilder.append("\"},");
                iterator++;
            }
            strBuilder.setLength(strBuilder.length() - 1);
            strBuilder.append("}");
            fr.append(strBuilder.toString());
        } catch (IOException e) {
            System.out.printf("Write ERROR! %s", e);
        }

    }

}
