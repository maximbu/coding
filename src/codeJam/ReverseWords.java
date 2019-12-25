package codeJam;

/**
 * Created by max on 2/21/2017.
 */
public class ReverseWords implements ISolution {

    public static void main(String[] st) {
        Utils.solve("B-large-practice.in", new ReverseWords());
    }

    @Override
    public String handleTest(String[] params) {
        String[] prices = params[0].split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = prices.length - 1; i >= 0; i--) {
            sb.append(prices[i]);
            if (i != 0) sb.append(" ");
        }
        return sb.toString();
    }
}
