package command;

import java.util.StringJoiner;

import misc.PepeException;
import state.Storage;
import state.TaskList;
import state.Ui;
import tasks.Task;


/**
 * Command to find a task in the list given an exact match on the provided phrase.
 */
public class FindCommand implements Command {
    private final String matchPhrase;

    public FindCommand(String matchPhrase) {
        this.matchPhrase = matchPhrase;
    }

    /**
     * Factory method to construct a FindCommand from the user input.
     * @param args A list of user-input strings which form a spaced phrase
     * @return An instance of the FindCommand
     * @throws PepeException if an exception occurred while parsing user input or constructing FindCommand class
     */
    public static FindCommand fromInput(String[] args) throws PepeException {
        if (args.length == 0) {
            throw new PepeException("Please provide a search term");
        }
        StringJoiner matchPhraseJoiner = new StringJoiner(" ");
        for (String arg : args) {
            matchPhraseJoiner.add(arg);
        }
        return new FindCommand(matchPhraseJoiner.toString());
    }

    @Override
    public boolean execute(Ui ui, Storage storage, TaskList tasks) throws PepeException {
        TaskList matchedTaskList = new TaskList();
        for (Task task : tasks) {
            if (task.matchesPhrase(matchPhrase)) {
                matchedTaskList.add(task);
            }
        }
        if (matchedTaskList.isEmpty()) {
            ui.printMessage("No tasks match the provided search term: " + matchPhrase);
        } else {
            ui.displayTaskList("Here are the matching tasks in your list:", matchedTaskList);
        }
        return true;
    }
}
