import java.util.*;

class TaskManager {
    private class Task {
        int userId;
        int taskId;
        int priority;

        public Task(int userId, int taskId, int priority) {
            this.userId = userId;
            this.taskId = taskId;
            this.priority = priority;
        }
    }

    private PriorityQueue<Task> pq;
    private Map<Integer, Task> taskMap;  // stores latest valid task

    public TaskManager(List<List<Integer>> tasks) {
        pq = new PriorityQueue<>((t1, t2) -> {
            if (t1.priority != t2.priority) return t2.priority - t1.priority;  // higher priority first
            return t2.taskId - t1.taskId;  // larger taskId first
        });
        taskMap = new HashMap<>();

        for (List<Integer> task : tasks) {
            add(task.get(0), task.get(1), task.get(2));
        }
    }

    public void add(int userId, int taskId, int priority) {
        Task newTask = new Task(userId, taskId, priority);
        pq.add(newTask);
        taskMap.put(taskId, newTask);
    }

    public void edit(int taskId, int newPriority) {
        if (!taskMap.containsKey(taskId)) return;
        Task updated = new Task(taskMap.get(taskId).userId, taskId, newPriority);
        pq.add(updated);          // add new version
        taskMap.put(taskId, updated);  // overwrite with new version
    }

    public void rmv(int taskId) {
        taskMap.remove(taskId);   // mark as deleted (lazy)
    }

    public int execTop() {
        while (!pq.isEmpty()) {
            Task top = pq.poll();
            // Check if it's still valid (exists in map & same object reference)
            if (taskMap.containsKey(top.taskId) && taskMap.get(top.taskId) == top) {
                taskMap.remove(top.taskId);
                return top.userId;
            }
        }
        return -1;
    }
}