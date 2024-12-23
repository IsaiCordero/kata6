package software.ulpgc.kata6.view.adapters;

import software.ulpgc.kata6.control.Commands.CalculateWorkingDaysCommand;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDate;

public class WorkingDaysAdapter {

    public static CalculateWorkingDaysCommand.Input inputOf(HttpServletRequest req) {
        return new CalculateWorkingDaysCommand.Input() {
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
            public LocalDate end() {
                String endParam = req.getParameter("end");

                try {
                    return LocalDate.parse(endParam);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }

    public static CalculateWorkingDaysCommand.Output outputOf(HttpServletResponse resp) {
        return days -> {
            resp.getWriter().write(String.valueOf(days));
            resp.setStatus(200);
        };
    }
}
