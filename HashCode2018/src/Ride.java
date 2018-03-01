public class Ride {
    int rowStart;
    int columnStart;
    int rowEnd;
    int columnEnd;
    int earliestStart;
    int latestFinish;
    int rideNumber;


    public Ride(int rowStart, int columnStart, int rowEnd, int columnEnd, int earliestStart, int latestFinish, int rideNumber) {
        this.rowStart = rowStart;
        this.columnStart = columnStart;
        this.rowEnd = rowEnd;
        this.columnEnd = columnEnd;
        this.earliestStart = earliestStart;
        this.latestFinish = latestFinish;
        this.rideNumber = rideNumber;
    }

    public int getRowStart() {
        return rowStart;
    }

    public void setRowStart(int rowStart) {
        this.rowStart = rowStart;
    }

    public int getColumnStart() {
        return columnStart;
    }

    public void setColumnStart(int columnStart) {
        this.columnStart = columnStart;
    }

    public int getRowEnd() {
        return rowEnd;
    }

    public void setRowEnd(int rowEnd) {
        this.rowEnd = rowEnd;
    }

    public int getColumnEnd() {
        return columnEnd;
    }

    public void setColumnEnd(int columnEnd) {
        this.columnEnd = columnEnd;
    }

    public int getEarliestStart() {
        return earliestStart;
    }

    public void setEarliestStart(int earliestStart) {
        this.earliestStart = earliestStart;
    }

    public int getLatestFinish() {
        return latestFinish;
    }

    public void setLatestFinish(int latestFinish) {
        this.latestFinish = latestFinish;
    }

    public int getRideNumber() {
        return rideNumber;
    }

    public void setRideNumber(int rideNumber) {
        this.rideNumber = rideNumber;
    }

    @Override
    public String toString() {
        return "Ride{" +
                "rowStart=" + rowStart +
                ", columnStart=" + columnStart +
                ", rowEnd=" + rowEnd +
                ", columnEnd=" + columnEnd +
                ", earliestStart=" + earliestStart +
                ", latestFinish=" + latestFinish +
                ", rideNumber=" + rideNumber +
                '}';
    }
}
