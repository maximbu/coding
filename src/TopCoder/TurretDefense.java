package TopCoder;

/**
 * Created by max on 2/9/2017.
 */
public class TurretDefense {
    public int firstMiss(int[] xs, int[] ys, int[] times) {
        int timePassed = 0;
        int prevX = 0;
        int prevY = 0;
        for (int i = 0; i < times.length; i++) {
            int minTime = timePassed + Math.abs(xs[i] - prevX) + Math.abs(ys[i] - prevY);
            if (minTime > times[i]) return i;
            timePassed = times[i];
            prevX = xs[i];
            prevY = ys[i];
        }
        return -1;
    }
}
