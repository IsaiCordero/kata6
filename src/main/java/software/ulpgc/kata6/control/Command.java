package software.ulpgc.kata6.control;

import java.io.IOException;

public interface Command {
    void execute() throws IOException;
}
