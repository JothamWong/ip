package state;

import misc.PepeException;
import tasks.Task;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Storage {
    private final String path;

    public Storage(String path) {
        this.path = path;
    }

    /**
     * Deserialize from file path and return the list of tasks, or an empty list otherwise.
     * @return list of tasks stored at the specified file path
     */
    public List<Task> getTasks() {
        Path path = Paths.get(this.path);
        if (!Files.exists(path)) {
            return new ArrayList<>();
        }
        try {
            List<String> lines = Files.readAllLines(path);
            return Serderializer.deserializeTasks(lines);
        } catch (IOException | PepeException e) {
            System.out.println("Error while reading tasks from " + this.path + " : " + e.getMessage());
            return new ArrayList<>();
        }
    }



}
