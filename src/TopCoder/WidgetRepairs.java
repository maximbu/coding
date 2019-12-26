package TopCoder;

/**
 * Created by max on 2/10/2017.
 */
public class WidgetRepairs {
    public int days(int[] arrivals, int numPerDay) {
        int workDays = 0;
        int leftOver = 0;
        for (int arrival : arrivals) {
            leftOver += arrival;
            if (leftOver > 0) {
                workDays++;
                leftOver = Math.max(0, leftOver - numPerDay);
            }
        }
        workDays += leftOver / numPerDay;
        if (leftOver % numPerDay != 0) {
            workDays++;
        }
        return workDays;
    }

}
