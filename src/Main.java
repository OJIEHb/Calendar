
public class Main {
    public static void main(String[] args){
        MonthCalendar monthCalendar;
        try{
            monthCalendar = new MonthCalendar(Integer.parseInt(args[0]));
        }catch (Exception e){
            monthCalendar =new MonthCalendar();
        }
        monthCalendar.printCalendar();
    }
}
