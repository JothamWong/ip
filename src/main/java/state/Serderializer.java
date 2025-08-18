package state;

import misc.PepeException;
import tasks.Deadline;
import tasks.Event;
import tasks.Task;
import tasks.Todo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Serderializer {
    public static List<Task> deserializeTasks(List<String> lines) throws PepeException {
        List<Task> tasks = new ArrayList<>();
        for (String line : lines) {
            String[] parts = line.split("\\|");
            parts = Arrays.stream(line.split("\\|"))
                        .map(String::strip)
                        .toArray(String[]::new);
            if (parts.length < 3) {
                throw new PepeException("Invalid task format. Expected at least 3 parts but got " + parts.length);
            }
            Task task;
            // Exceptions thrown here will bounce up
            task = switch (parts[0].strip()) {
                case "T" -> Todo.fromFileInput(parts);
                case "D" -> Deadline.fromFileInput(parts);
                case "E" -> Event.fromFileInput(parts);
                default -> throw new PepeException("Invalid task format. Expected one of 'T', 'D' or 'E' but got " + parts[0]);
            };
            tasks.add(task);
        }
        return tasks;
    }
}
