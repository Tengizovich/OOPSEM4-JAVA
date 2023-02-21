import java.util.Comparator;

public class DeadlineComparator implements Comparator<Task> {


    @Override
    public int compare(Task o1, Task o2) {
        return o1.getDeadline().compareTo(o2.getDeadline());
    }
}
