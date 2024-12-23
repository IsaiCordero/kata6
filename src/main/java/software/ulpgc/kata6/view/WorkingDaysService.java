package software.ulpgc.kata6.view;

import io.javalin.Javalin;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import software.ulpgc.kata6.control.Commands.CalculateWorkingDateCommand;
import software.ulpgc.kata6.control.Commands.CalculateWorkingDaysCommand;
import software.ulpgc.kata6.control.webBuilder;
import software.ulpgc.kata6.view.adapters.WorkingDateAdapter;
import software.ulpgc.kata6.view.adapters.WorkingDaysAdapter;

import java.io.IOException;

public class WorkingDaysService {
    private final int port;
    private final webBuilder web;
    private Javalin app;

    public WorkingDaysService(int port, webBuilder web) {
        this.port = port;
        this.web = web;
        web.register("working-days", workingDaysBuilder());
        web.register("working-date", workingDateBuilder());
    }
    public void start() {
        app = Javalin.create()
                .get("/working-date", ctx -> execute("working-date", ctx.req(), ctx.res()))
                .get("/working-days", ctx -> execute("working-days", ctx.req(), ctx.res()))
                .start(port);
    }

    private webBuilder.Builder workingDateBuilder() {
        return (req, resp) -> new CalculateWorkingDateCommand(WorkingDateAdapter.inputOf(req), WorkingDateAdapter.outputOf(resp));
    }

    private webBuilder.Builder workingDaysBuilder() {
        return (req, resp) -> new CalculateWorkingDaysCommand(WorkingDaysAdapter.inputOf(req), WorkingDaysAdapter.outputOf(resp));
    }
    public void stop(){
        app.stop();
    }

    private void execute(String command, HttpServletRequest req, HttpServletResponse res) throws IOException {
        web.with(req,res).build(command).execute();
    }
}
