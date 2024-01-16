import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reservation {
    private String name;
    private int nPeople;
    private long timeMade;
    public String timeMadeString;

    private long timeFor;
    private boolean waitlisted;
    private String printInfo;

    public Reservation() {
        nPeople = (int) (Math.random() * 10 + 1);
        timeMade = new Date().getTime() - (int) (Math.random() * 1000000000);
        timeFor = new Date().getTime() + (int) (Math.random() * 1000000000);
        timeStuff();
    }

    public void timeStuff() {
        long now = new Date().getTime();
        System.out.println(now);
        DateFormat dateFormat = new SimpleDateFormat("E,M-dd-yyyy k:mm");
        String timeString = dateFormat.format(now);
        System.out.println(timeString);

        long future = new Date().getTime() + 100000000;
        String futureString = dateFormat.format(future);
        System.out.println(futureString);
        System.out.println(future > now);


        System.out.println("\n\n");
    }


    public int getNPeople() {
        return nPeople;
    }

    public double getTimeMade() {
        return timeMade;
    }

    public String getTimeMadeString(){
        DateFormat dateFormat = new SimpleDateFormat("E,M-dd-yyyy k:mm");
        String timeString = dateFormat.format(timeMade);
        return timeString;
    }

    public String getTimeForString(){
        DateFormat dateFormat = new SimpleDateFormat("E,M-dd-yyyy k:mm");
        String timeForString = dateFormat.format(timeFor);
        return timeForString;
    }


    public double getTimeFor() {
        return timeFor;
    }


    public void printInfo() {
        System.out.println("Reservation for " + nPeople + ", made at " + timeMade + ", for " + timeFor);
    }
///return print info instead

}
