import java.util.Comparator;

public class RideComparator implements Comparator<Ride> {

    @Override
    public int compare(Ride ride1, Ride ride2) {
        return  ride1.earliestStart - ride2.earliestStart;
    }
}
