import java.time.*;

public class MonthCalendar {
    private static final int MIN_MONTH_NUM = 1;
    private static final int MAX_MONTH_NUM = 12;
    private static final String CURRENT_DAY_COl = "\033[36m";
    private static final String DAY_OFF_COl = "\033[31m";
    private static final String COMMON_DAY_COl = "\033[37m";

    private int year = Year.now().getValue();
    private YearMonth month;

    public MonthCalendar(int monthNumber) {
        if(monthNumber>=MIN_MONTH_NUM&&monthNumber<=MAX_MONTH_NUM)
            this.month = YearMonth.of(year,monthNumber);
        else{
            System.out.println("ERROR! Invalid month. Set default value.");
            this.month = YearMonth.now();
        }
    }

    public MonthCalendar() {
        this.month = YearMonth.now();
    }

    public void printCalendar(){
        System.out.println("MO TU WE TH FR SA SU");
        int startRowPosition= LocalDate.of(year,month.getMonthValue(),1).getDayOfWeek().getValue()-1;
        for(int i = 0; i <startRowPosition;i++)
            System.out.print("   ");
        int j =0;
        for (int i = 1; i<=month.lengthOfMonth();i++){
            String day = String.format("%2d ",i);
            if(i == LocalDate.now().getDayOfMonth() && month.equals(YearMonth.now()))
                System.out.print(CURRENT_DAY_COl+day);
            else if(j+startRowPosition>=5)
                System.out.print(DAY_OFF_COl+day);
            else
                System.out.print(COMMON_DAY_COl+day);
            j++;
            if(j+startRowPosition>=7) {
                System.out.println();
                startRowPosition=0;
                j=0;
            }
        }
    }
}
