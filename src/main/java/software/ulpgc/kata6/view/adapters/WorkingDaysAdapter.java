package software.ulpgc.kata6.view.adapters;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import software.ulpgc.kata6.control.commands.CalculateWorkingDaysCommand;

import java.time.LocalDate;

public class WorkingDaysAdapter {
    public static CalculateWorkingDaysCommand.Input inputOf(HttpServletRequest req){
        return new CalculateWorkingDaysCommand.Input() {
            @Override
            public LocalDate start() {
                String start = req.getParameter("start");
                return LocalDate.parse(start);
            }

            @Override
            public LocalDate end() {
                String end = req.getParameter("end");
                return LocalDate.parse(end);
            }
        };
    }
    public static CalculateWorkingDaysCommand.Output outputOf(HttpServletResponse resp){
        return days -> {
            resp.getWriter().write(String.valueOf(days));
            resp.setStatus(200);
        };
    }
}
