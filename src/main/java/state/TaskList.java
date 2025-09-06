package state;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import tasks.Task;

/**
 * Class that represents the tasks in the Pepe application.
 */
public class TaskList implements Iterable<Task> {
    private final List<Task> tasks;

    /**
     * Constructs an empty TaskList.
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Constructs a TaskList with the provided list of tasks.
     */
    public TaskList(List<Task> tasks) {
        this.tasks = tasks;
    }

    public int size() {
        return tasks.size();
    }

    /**
     * Predicate method to check if TaskList is empty.
     * @return true if TaskList is empty
     */
    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    public void add(Task task) {
        tasks.add(task);
    }

    public Task get(int index) {
        return tasks.get(index);
    }

    public void remove(int index) {
        tasks.remove(index);
    }

    @Override
    public Iterator<Task> iterator() {
        return tasks.iterator();
    }

    /**
     * Filters the TaskList for tasks that match the provided match phrase.
     * @param matchPhrase the phrase that task descriptions should match on
     * @return a TaskList with only tasks that match the match phrase
     */
    public TaskList filter(String matchPhrase) {
        return new TaskList(tasks.stream()
                .filter(task -> task.matchesPhrase(matchPhrase)).toList());
    }
}
