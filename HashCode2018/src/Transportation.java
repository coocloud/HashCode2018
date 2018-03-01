public class Transportation {

    public Transportation() {
    }

    public Boolean canRideBeAssigned(Vehicle vehicle, Ride ride, int overallAvailableSteps) {
        if (vehicle.getCurrentTimeStep() > ride.getLatestFinish()) {
            return false;
        }
        int vehicleAndStartDistance = distance(vehicle.getCurrentRow(), ride.getRowStart(),
                vehicle.getCurrentColumn(), ride.getColumnStart());
        int rideDistance = distance(ride.getRowStart(), ride.getRowEnd(), ride.getColumnStart(), ride.getColumnEnd());
        int totalRideDistance = vehicleAndStartDistance + rideDistance;
        if (totalRideDistance + vehicle.getCurrentTimeStep() <= ride.getLatestFinish() &&
                totalRideDistance + vehicle.getCurrentTimeStep() < overallAvailableSteps) {
            return true;
        }
        return false;
    }

    public int getTotalRideDistance(Vehicle vehicle, Ride ride) {
        int vehicleAndStartDistance = distance(vehicle.getCurrentRow(), ride.getRowStart(),
                vehicle.getCurrentColumn(), ride.getColumnStart());
        int rideDistance = distance(ride.getRowStart(), ride.getRowEnd(), ride.getColumnStart(), ride.getColumnEnd());
        int totalRideDistance = vehicleAndStartDistance + rideDistance;
        return totalRideDistance;
    }

    public int distance(int startRow, int endRow, int startCol, int endCol) {
        int distance = Math.abs(startRow - endRow) + Math.abs(startCol - endCol);
        return distance;
    }
}
