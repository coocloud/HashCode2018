import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = null;
        FileOutputStream out = new FileOutputStream("file/b_should_be_easy_7.out");
        try {
            fis = new FileInputStream("file/b_should_be_easy.in");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fis));
        BufferedWriter writer = null;
        writer = new BufferedWriter(new OutputStreamWriter(out));


        String line = bufferedReader.readLine();
        String firstLine[] = line.split(" ");
//        System.out.println(Arrays.toString(firstLine));

        int rows;
        int columns;
        int fleets;
        int nRides;
        int bonus;
        int timesteps;

        rows = Integer.parseInt(firstLine[0]);
        columns = Integer.parseInt(firstLine[1]);
        fleets = Integer.parseInt(firstLine[2]);
        nRides = Integer.parseInt(firstLine[3]);
        bonus = Integer.parseInt(firstLine[4]);
        timesteps = Integer.parseInt(firstLine[5]);

        System.out.println("Number of rows: " + rows);
        System.out.println("Number of columns: " + columns);
        System.out.println("Number of vehicles: " + fleets);
        System.out.println("Number of rides: " + nRides);
        System.out.println("Bonus: " + bonus);
        System.out.println("Timesteps: " + timesteps);

        List<Ride> rideList = new ArrayList<Ride>();
        List<Vehicle> vehicleList = new ArrayList<Vehicle>();
        Transportation transportation = new Transportation();
        RideComparator comparator = new RideComparator();

        for (int i=0; i<fleets; i++) {
            Vehicle vehicle = new Vehicle(0,0);
            vehicleList.add(vehicle);
        }

        for (int i=0; i<nRides; i++) {
            line = bufferedReader.readLine();
            String rideInfo[] = line.split(" ");
            Ride ride = new Ride(Integer.parseInt(rideInfo[0]), Integer.parseInt(rideInfo[1]), Integer.parseInt(rideInfo[2]), Integer.parseInt(rideInfo[3]), Integer.parseInt(rideInfo[4]), Integer.parseInt(rideInfo[5]), i);
//            System.out.println(ride.toString());
            rideList.add(ride);
        }

        Collections.sort(rideList, comparator);
        System.out.println(rideList.toString());

        //Assigning 1 ride to each vehicle first

        Boolean stopThis = true;

        do {
            stopThis = false;
            for (Vehicle v: vehicleList) {
                for (Ride r: rideList) {
                    if (!r.hasBeenAssigned && transportation.canRideBeAssigned(v, r, timesteps)) {
                        int currentTimeStep = v.getCurrentTimeStep();
                        currentTimeStep += transportation.getTotalRideDistance(v, r);
                        v.getRidesAssigned().add(r);
                        r.setHasBeenAssigned(true);
                        v.setCurrentRow(r.rowEnd);
                        v.setCurrentColumn(r.columnEnd);
                        v.setCurrentTimeStep(currentTimeStep);
                        break;
                    }
                }
            }
            for (Vehicle v: vehicleList) {
                for (Ride r: rideList) {
                    if (!r.hasBeenAssigned && transportation.canRideBeAssigned(v, r, timesteps)) {
                        stopThis = true;
                    }
                }
            }
        } while (stopThis);




//        System.out.println("Vehicles" + vehicleList.size());
//        System.out.println("Solution: ");
//        System.out.println();
//        System.out.println();
        for (Vehicle vehicle: vehicleList){
            writer.write(String.valueOf(vehicle.getRidesAssigned().size()));
//            System.out.print(vehicle.getRidesAssigned().size());
            for (Ride ride: vehicle.getRidesAssigned()){
                writer.write(" "+ride.getRideNumber());
//                System.out.print(" "+ride.getRideNumber());
            }
            writer.write("\n");
//            System.out.println();
        }
        writer.flush();


        for (Ride ride: rideList) {
            if (!ride.hasBeenAssigned) {
               System.out.println(ride.getRideNumber() + ":" + ride.hasBeenAssigned);
            }
        }
    }
}
