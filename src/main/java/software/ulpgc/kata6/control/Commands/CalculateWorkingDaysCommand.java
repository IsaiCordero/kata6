package software.ulpgc.kata6.control.Commands;

import software.ulpgc.kata6.control.Command;

import java.io.IOException;
import java.time.LocalDate;
import java.time.DayOfWeek;

import static java.time.DayOfWeek.*;

public class CalculateWorkingDaysCommand implements Command {
    private final Input input;
    private final Output output;

    public CalculateWorkingDaysCommand(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public void execute() throws IOException {
        LocalDate current = input.start();
        int daysWorking = 0;

        while (!current.isAfter(input.end())) {
            if (current.getDayOfWeek() != SATURDAY && current.getDayOfWeek() != SUNDAY) {
                daysWorking++;
            }
            current = current.plusDays(1);
        }
        output.daysWorking(daysWorking);
    }

    public interface Input {
        LocalDate start();
        LocalDate end();
    }

    public interface Output {
        void daysWorking(int days) throws IOException;
    }
}
