package software.ulpgc.kata6.view.adapters;

import software.ulpgc.kata6.control.Commands.CalculateWorkingDateCommand;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDate;

public class WorkingDateAdapter {

    public static CalculateWorkingDateCommand.Input inputOf(HttpServletRequest req) {
        return new CalculateWorkingDateCommand.Input() {
            @Override
            public LocalDate start() {
                String startParam = req.getParameter("start");
                try {
                    return LocalDate.parse(startParam);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

            @Override
            public int daysWorking() {
                String daysParam = req.getParameter("days");

                try {
                    return Integer.parseInt(daysParam);
                } catch (NumberFormatException e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }

    public static CalculateWorkingDateCommand.Output outputOf(HttpServletResponse resp) {
        return date -> {
            resp.getWriter().write(date.toString());
            resp.setStatus(200);
        };
    }
}
