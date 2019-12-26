package interviewbit.arrays;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by max on 7/1/
 * A hotel manager has to process N advance bookings of rooms for the next season. His hotel has K rooms. Bookings contain an arrival date and a departure date. He wants to find out whether there are enough rooms in the hotel to satisfy the demand. Write a program that solves this problem in time O(N log N) .

 Input:


 First list for arrival time of booking.
 Second list for departure time of booking.
 Third is K which denotes count of rooms.

 Output:

 A boolean which tells whether its possible to make a booking.
 Return 0/1 for C programs.
 O -> No there are not enough rooms for N booking.
 1 -> Yes there are enough rooms for N booking.
 */
public class HotelBookingsPossible {
  public static void main(String[] st) {
    HotelBookingsPossible q = new HotelBookingsPossible();

    ArrayList<Integer> arrive = new ArrayList<>();
    arrive.add(1);
    arrive.add(3);
    arrive.add(5);

    ArrayList<Integer> depart = new ArrayList<>();
    depart.add(2);
    depart.add(6);
    depart.add(8);

    int K = 1;

    System.out.println(q.hotel(arrive, depart, K));
  }

  public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
    Collections.sort(arrive);
    Collections.sort(depart);
    int nextArr = 0;
    int nextDep = 0;
    int guests = 0;
    while (nextDep < depart.size() && nextArr < arrive.size()) {
      if (arrive.get(nextArr) < depart.get(nextDep)) {
        nextArr++;
        guests++;
      } else if (arrive.get(nextArr) > depart.get(nextDep)) {
        nextDep++;
        guests--;
      } else {
        nextArr++;
        nextDep++;
      }
      if (guests < 0 || guests > K) return false;
    }
    return true;
  }
}
