package software.ulpgc.kata6.view;

import io.javalin.Javalin;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import software.ulpgc.kata6.control.WebService;
import software.ulpgc.kata6.control.commands.CalculateWorkingDateCommand;
import software.ulpgc.kata6.control.commands.CalculateWorkingDaysCommand;
import software.ulpgc.kata6.view.adapters.WorkingDateAdapter;
import software.ulpgc.kata6.view.adapters.WorkingDaysAdapter;

import java.io.IOException;

public class WorkingService {
    private final int port;
    private final WebService web;
    private Javalin app;

    public WorkingService(int port, WebService web) {
        this.port = port;
        this.web = web;
        web.register("working-date", workingDateBuilder());
        web.register("working-days", workingDaysBuilder());
    }
    public void start(){
        app = Javalin.create()
                .get("/working-date", ctx -> execute("working-date", ctx.req(), ctx.res()))
                .get("/working-days", ctx -> execute("working-days", ctx.req(), ctx.res()))
                .start(port);
    }
    public void stop(){
        app.stop();
    }

    private void execute(String command, HttpServletRequest req, HttpServletResponse res) throws IOException {
        web.with(req,res).build(command).execute();
    }

    private WebService.Builder workingDaysBuilder() {
        return (req, resp) -> new CalculateWorkingDaysCommand(WorkingDaysAdapter.inputOf(req), WorkingDaysAdapter.outputOf(resp));
    }

    private WebService.Builder workingDateBuilder() {
        return (req, resp) -> new CalculateWorkingDateCommand(WorkingDateAdapter.inputOf(req), WorkingDateAdapter.outputOf(resp));
    }
}
