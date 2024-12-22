package software.ulpgc.kata6.control;

public class CalculateWorkingDaysCommand {
    private final Input input;
    private final Calendar calendar;
    private final Output output;

    public CalculateWorkingDaysCommand(Input input, Calendar calendar, Output output) {
        this.input = input;
        this.calendar = calendar;
        this.output = output;
    }

    private interface Input {

    }
    private interface Output {

    }
}
