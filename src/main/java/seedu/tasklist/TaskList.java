package seedu.tasklist;

import seedu.tasks.Task;
import java.util.ArrayList;


public class TaskList {

    private ArrayList<Task> taskList;

    public TaskList () {
        taskList = new ArrayList<>();
    }

    public int getListSize () {
        return taskList.size();
    }

    public void addTask (Task task) {
        taskList.add(task);
    }

    public void deleteTask (int index) {
        taskList.remove(index);
    }

    public ArrayList<Task> findTasks (String pattern) {

        ArrayList<Task> foundTasks = new ArrayList<>();

        for (Task task : taskList ) {
            if (hasPattern(task, pattern)) {
                foundTasks.add(task);
            }
        }

        return foundTasks;
    }

    private boolean hasPattern (Task task, String pattern) {
        return task.getTitle().contains(pattern) || task.getDescription().contains(pattern);
    }

    public void changeTitle (int taskIndex, String newTitle) {
        taskList.get(taskIndex).setTitle(newTitle);
    }

    public void changeDescription (int taskIndex, String newDescription) {
        taskList.get(taskIndex).setDescription(newDescription);
    }

}