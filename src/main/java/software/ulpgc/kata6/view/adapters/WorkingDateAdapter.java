package software.ulpgc.kata6.view.adapters;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import software.ulpgc.kata6.control.commands.CalculateWorkingDateCommand;

import java.time.LocalDate;

public class WorkingDateAdapter {
    public static CalculateWorkingDateCommand.Input inputOf(HttpServletRequest req){
        return new CalculateWorkingDateCommand.Input() {
            @Override
            public LocalDate start() {
                String start = req.getParameter("start");
                return LocalDate.parse(start);
            }

            @Override
            public int daysWorking() {
                String days = req.getParameter("days");
                return Integer.parseInt(days);
            }
        };
    }
    public static CalculateWorkingDateCommand.Output outputOf(HttpServletResponse resp){
        return date -> {
            resp.getWriter().write(date.toString());
            resp.setStatus(200);
        };
    }
}
