import java.util.Comparator;

public class PriorityComparator implements Comparator<Task> {

    @Override
    public int compare(Task o1, Task o2) {
        return o1.getTaskPriority().compareTo(o2.getTaskPriority());
    }
}
