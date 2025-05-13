import java.util.*;

class Problem3 {
    public static class Task {
        public final int userId;
        public final int taskId;
        public final int priority;

        public Task(int userId, int taskId, int priority) {
            this.userId = userId;
            this.taskId = taskId;
            this.priority = priority;
        }
    }
    private TreeSet<Task> taskSortedSet = new TreeSet<>(new Comparator<Task>() {
        public int compare(Task o1, Task o2)
        {
            return o1.priority == o2.priority ? o1.taskId - o2.taskId : o1.priority - o2.priority;
        }
    });
    private Map<Integer, Task> taskIdToTask = new HashMap<>();

    public Problem3(List<List<Integer>> tasks) {
        for (List<Integer> task : tasks) {
            Task newTask = new Task(task.get(0), task.get(1), task.get(2));
            taskSortedSet.add(newTask);
            taskIdToTask.put(task.get(1), newTask);
        }
    }

    public void add(int userId, int taskId, int priority) {
        Task task = new Task(userId, taskId, priority);
        taskSortedSet.add(task);
        taskIdToTask.put(taskId, task);
    }

    public void edit(int taskId, int newPriority) {
        Task old = taskIdToTask.remove(taskId);
        taskSortedSet.remove(old);
        Task newTask = new Task(old.userId, old.taskId, newPriority);
        taskSortedSet.add(newTask);
        taskIdToTask.put(taskId, newTask);
    }

    public void rmv(int taskId) {
        Task old = taskIdToTask.remove(taskId);
        taskSortedSet.remove(old);
    }

    public int execTop() {
        if (taskSortedSet.isEmpty()) {
            return -1;
        }
        Task highestPrio = taskSortedSet.last();
        taskSortedSet.remove(highestPrio);
        taskIdToTask.remove(highestPrio.taskId);
        return highestPrio.userId;

    }
}

