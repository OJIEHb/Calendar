import java.time.*;
import java.time.format.TextStyle;
import java.util.Locale;

public class MonthCalendar {
    private static final String CURRENT_DAY_COl = "\033[36m";
    private static final String DAY_OFF_COl = "\033[31m";
    private static final String COMMON_DAY_COl = "\033[37m";

    private int year = Year.now().getValue();
    private YearMonth month;

    public MonthCalendar(int monthNumber) {
        try {
            this.month = YearMonth.of(year, monthNumber);
        }catch(Exception e){
            System.out.println("ERROR! Invalid month. Set default value.");
            this.month = YearMonth.now();
        }
    }

    public MonthCalendar() {
        this.month = YearMonth.now();
    }

    public void printCalendar(){
        for (DayOfWeek dayName: DayOfWeek.values())
            System.out.print(dayName.getDisplayName(TextStyle.SHORT, Locale.ENGLISH)+" ");
        System.out.println();
        int startPos= LocalDate.of(year,month.getMonthValue(),1).getDayOfWeek().getValue()-1;
        for(int i = 0; i <startPos;i++)
            System.out.print("    ");
        for (int i = 1; i<=month.lengthOfMonth();i++){
            LocalDate monthDay = LocalDate.of(month.getYear(),month.getMonthValue(),i);
            String dayValue = String.format("%2d  ",monthDay.getDayOfMonth());
            if(monthDay.equals(LocalDate.now()))
                System.out.print(CURRENT_DAY_COl+dayValue);
            else if(monthDay.getDayOfWeek().getValue()==6||monthDay.getDayOfWeek().getValue()==7)
                System.out.print(DAY_OFF_COl+dayValue);
            else
                System.out.print(COMMON_DAY_COl+dayValue);
            if(monthDay.getDayOfWeek().getValue()==7)
                System.out.println();
        }
    }
}
