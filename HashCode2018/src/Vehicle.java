
import java.util.ArrayList;
import java.util.List;

public class Vehicle {
    int currentRow;
    int currentColumn;
    List<Ride> ridesAssigned;
    int currentTimeStep;

    public Vehicle(int currentRow, int currentColumn) {
        this.currentRow = currentRow;
        this.currentColumn = currentColumn;
        this.ridesAssigned = new ArrayList<Ride>();
        this.currentTimeStep = 0;
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public void setCurrentRow(int currentRow) {
        this.currentRow = currentRow;
    }

    public int getCurrentColumn() {
        return currentColumn;
    }

    public void setCurrentColumn(int currentColumn) {
        this.currentColumn = currentColumn;
    }

    public List<Ride> getRidesAssigned() {
        return ridesAssigned;
    }

    public void setRidesAssigned(List<Ride> ridesAssigned) {
        this.ridesAssigned = ridesAssigned;
    }

    public int getCurrentTimeStep() {
        return currentTimeStep;
    }

    public void setCurrentTimeStep(int currentTimeStep) {
        this.currentTimeStep = currentTimeStep;
    }
}
