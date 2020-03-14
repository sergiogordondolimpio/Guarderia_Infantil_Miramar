package main;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Year;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public interface Utilities {

    public static String getAges(String date) throws ParseException {
        String ages = "";

        if (date == null || date.isEmpty()) {
            ages = "No se ingreso la fecha de nacimiento";
        }else{
            String dateArray[] = new String[3];
            dateArray = date.split("-");
            System.out.println(Integer.parseInt(dateArray[0]) +
                    Integer.parseInt(dateArray[1]) +
                    Integer.parseInt(dateArray[2]));
            LocalDate today  = LocalDate.now();
            LocalDate birthday  = LocalDate.of(
                    Integer.parseInt(dateArray[0]),
                    Integer.parseInt(dateArray[1]),
                    Integer.parseInt(dateArray[2]));
            if (ChronoUnit.YEARS.between(birthday, today) == 0){
                ages = Long.toString(ChronoUnit.MONTHS.between(birthday, today)) + " meses";
            }else {
                ages = Long.toString(ChronoUnit.YEARS.between(birthday, today)) + " años";
            }
        }

        return ages;
    }
}
