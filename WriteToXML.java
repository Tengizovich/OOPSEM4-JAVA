import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToXML {
    public WriteToXML(File file) {

        try (FileWriter fr = new FileWriter(file, false);) {
            StringBuilder strBuilder = new StringBuilder();
            strBuilder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<TaskList>\n");
            for (Task task : TaskList.getTasks()) {
                strBuilder.append("<task>\n<createDate>");
                strBuilder.append(task.getCreateDate());
                strBuilder.append("</createDate>\n");
                strBuilder.append("<createTime>");
                strBuilder.append(task.getCreateTime());
                strBuilder.append("</createTime>\n");
                strBuilder.append("<deadline>");
                strBuilder.append(task.getDeadline());
                strBuilder.append("</deadline>\n");
                strBuilder.append("<author>");
                strBuilder.append(task.getAuthor());
                strBuilder.append("</author>\n");
                strBuilder.append("<taskDescription>");
                strBuilder.append(task.getDescription());
                strBuilder.append("</taskDescription>\n");
                strBuilder.append("<priority>");
                strBuilder.append(task.getTaskPriority());
                strBuilder.append("</priority>\n</task>\n");
            }
            strBuilder.append("</TaskList>");
            fr.append(strBuilder.toString());
        } catch (IOException e) {
            System.out.printf("Write ERROR! %s", e);
        }
    }

}
