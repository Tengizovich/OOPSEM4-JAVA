import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

public class Task {
    private static int idCount = 0;
    private LocalDate createDate;
    private LocalTime createTime;
    private LocalDate deadline;
    private String author;
    private String description;
    private TaskPriority taskPriority;
    private int id;

    public Task(LocalDate createDate, LocalTime createTime, LocalDate deadline, String author, String description, TaskPriority taskPriority) {
        this.createDate = createDate;
        this.createTime = createTime;
        this.deadline = deadline;
        this.author = author;
        this.description = description;
        this.taskPriority = taskPriority;
        this.id = ++idCount;
    }


    public LocalDate getCreateDate() {
        return createDate;
    }

    public LocalTime getCreateTime() {
        return createTime;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }
    public TaskPriority getTaskPriority() {
        return taskPriority;
    }

    @Override
    public String toString() {
        Period p = Period.between(LocalDate.now(), deadline);
        return "Task{" +
                "id=" + id +
                ", days to deadline=" + p.getYears() + "y:" + p.getMonths() + "m:" + p.getDays() +
                "d, createDate=" + createDate +
                ", createTime=" + createTime +
                ", deadline=" + deadline +
                ", Author='" + author + '\'' +
                ", Description='" + description + '\'' +
                ", taskPriority='" + taskPriority + '\'' +
                '}';
    }

    public static void print(Task task) {

        System.out.println("------------------------------------------------------");
        System.out.printf("Task ID: \t\t\t\t\t%d\n", task.getId());
        System.out.printf("Days to Deadline: \t\t\t%s\n",
                task.getDeadline().toEpochDay() - LocalDate.now().toEpochDay());
        System.out.printf("Deadline: \t\t\t\t\t%s\n", task.getDeadline());
        System.out.printf("Date of creations: \t\t\t%s\n", task.getCreateDate());
        System.out.printf("Time of creations: \t\t\t%s\n", task.getCreateTime());
        System.out.printf("Author of task: \t\t\t%s\n", task.getAuthor());
        System.out.printf("Description: \t\t\t\t%s\n", task.getDescription());
        System.out.printf("taskPriority: \t\t\t\t%s\n", task.getTaskPriority());
        System.out.println("-------------------------------------------------------");
    }
}
