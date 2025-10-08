package org.openxava.xavaprojects.formatters;

import java.time.DayOfWeek;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;

import org.openxava.formatters.LocalDateFormatter;

/**
 * @author Javier Paniza
 */
public class DeadlineDateListFormatter extends LocalDateFormatter {

    @Override
    public String format(HttpServletRequest request, Object object) {
        LocalDate date = (LocalDate) object;
        String formattedDate = super.format(request, date);
        
        LocalDate today = LocalDate.now();
        LocalDate lastWorkingDay = getPreviousWorkingDay(today);
        LocalDate secondLastWorkingDay = getPreviousWorkingDay(lastWorkingDay);
        
        if (date.equals(today)) {
            formattedDate = "<span class='deadline-today'>" + formattedDate + "</span>";
        } else if (date.equals(lastWorkingDay)) {
            formattedDate = "<span class='deadline-yesterday'>" + formattedDate + "</span>";
        } else if (date.equals(secondLastWorkingDay)) {
            formattedDate = "<span class='deadline-day-before-yesterday'>" + formattedDate + "</span>";
        }
        
        return formattedDate;
    }
    
    private LocalDate getPreviousWorkingDay(LocalDate date) {
        LocalDate previousDay = date.minusDays(1);
        while (previousDay.getDayOfWeek() == DayOfWeek.SATURDAY || 
               previousDay.getDayOfWeek() == DayOfWeek.SUNDAY) {
            previousDay = previousDay.minusDays(1);
        }
        return previousDay;
    }

}
