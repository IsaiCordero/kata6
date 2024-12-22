package software.ulpgc.kata6.control;

import java.time.LocalDate;
import java.util.Iterator;

public class Calendar {
    public Iterable<LocalDate> from(LocalDate date){
        return () -> createIteratorFrom(date);
    }

    private Iterator<LocalDate> createIteratorFrom(LocalDate date) {
        private LocalDate currentDay = date;
        
    }
}
