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
        return new ArrayList<>();
    }



}
