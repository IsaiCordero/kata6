package software.ulpgc.kata6.control;

import java.time.LocalDate;
import java.util.Iterator;

public class CalculateWorkingDateCommand implements Command {
    private final Input input;
    private final Output output;

    public CalculateWorkingDateCommand(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public void execute() {
        Iterator<LocalDate> iterator = new 
    }

    private interface Input {

    }
    private interface Output {

    }
}
