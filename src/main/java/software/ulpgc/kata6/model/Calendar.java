package software.ulpgc.kata6.model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.Set;

import static java.time.DayOfWeek.*;

public class Calendar {
    public Iterator<LocalDate> from(LocalDate date){
        return new Iterator<LocalDate>() {
            LocalDate current = date;
            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public LocalDate next() {
                var next = current.plusDays(1);
                while (!WorkingDay(next)){
                    next = next.plusDays(1);
                }
                current = next;
                return next;
            }

            private boolean WorkingDay(LocalDate day) {
                return daysOfWork.contains(day.getDayOfWeek());
            }


        };
    }
    private final Set<DayOfWeek> daysOfWork = Set.of(MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY);

}
