package interviewbit.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *  N number of books are given.
 The ith book has Pi number of pages.
 You have to allocate books to M number of students so that maximum number of pages alloted to a student is minimum. A book will be allocated to exactly one student. Each student has to be allocated at least one book. Allotment should be in contiguous order, for example: A student cannot be allocated book 1 and book 3, skipping book 2.

 NOTE: Return -1 if a valid assignment is not possible
 *
 */
public class AllocateBooks {
  public static void main(String[] st){
    AllocateBooks q = new AllocateBooks();

    ArrayList<Integer> X = new ArrayList<>();
    X.add(12);
    X.add(34);
    X.add(67);
    X.add(90);

    int numOfStudents = 2;
    System.out.println(q.books(X,numOfStudents));

    X = new ArrayList<>();
    X.add(31);
    X.add(14);
    X.add(19);
    X.add(75);

    numOfStudents = 12;
    System.out.println(q.books(X,numOfStudents));

    X = new ArrayList<>();
    X.add(73);
    X.add(58);
    X.add(30);
    X.add(72);
    X.add(44);
    X.add(78);
    X.add(23);
    X.add(9);

    numOfStudents = 5;
    System.out.println(q.books(X,numOfStudents));

    X = new ArrayList<>(Arrays.asList(97, 26, 12, 67, 10, 33, 79, 49, 79, 21, 67, 72, 93, 36, 85, 45, 28, 91, 94, 57, 1, 53, 8, 44, 68, 90, 24));
    numOfStudents = 26;
    System.out.println(q.books(X,numOfStudents));
  }

  public int books(ArrayList<Integer> a, int b) {
    int min = Integer.MAX_VALUE;
    int bookMax = Integer.MIN_VALUE;
    int max = 0;
    for (Integer m : a) {
      max += m;
      bookMax = Math.max(bookMax, m);
      min = Math.min(min, m);
    }
    int res = Integer.MAX_VALUE;
    int mid;
    if (a.size() < b)
      return -1;
    while (max >= min) {
      mid = min + (max - min) / 2;
      if (canAllocate(mid, a, b,bookMax)) {
        max = mid - 1;
        res = Math.min(res, mid);
      } else {
        min = mid + 1;
      }
    }
    return res;
  }


  private boolean canAllocate(int pages, ArrayList<Integer> a, int b, int bookMax) {
    if (pages < bookMax) {
      return false;
    }
    int studentsNeeded = 1;
    int currTotal = 0;
    int i=0;
    while (i < a.size()) {
      if (currTotal + a.get(i) > pages) {
        currTotal = 0;
        studentsNeeded++;
      } else {
        currTotal += a.get(i);
        i++;
      }
    }
    return studentsNeeded <= b;
  }
}
