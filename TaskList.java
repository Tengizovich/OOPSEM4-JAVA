import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private final static List<Task> tasks = new ArrayList<>();

    public static List<Task> getTasks() {
        return tasks;
    }

    public static void add(Task task) {
        tasks.add(task);
    }
    public static void addAll(List<Task> tasks) {
        tasks.addAll(tasks);
    }

    public static int getTaskById(int id) {
        int i = 0;
        boolean notFind = true;
        while (notFind && i < tasks.size()) {
            if (tasks.get(i).getId() == id) {
                notFind = false;
            } else {
                i++;
            }
        }
        if (notFind) {
            i = -1;
        }
        return i;
    }

    public static void removeById(int id) {
        if (getTaskById(id) > -1) {
            int index = getTaskById(id);
            tasks.remove(index);
        }
    }

    public static void updateByDeadline() {
        tasks.sort(new DeadlineComparator());
    }

    public static void updateByPriority() {
        tasks.sort(new PriorityComparator());
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Task element : tasks) {
            str.append(element + "\n");
        }
        return str.toString();

    }
}
