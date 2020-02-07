package CodingInterviews2018.P16;

import java.util.Arrays;
import java.util.HashMap;

public class q16_15 {

    enum Balls {
        G,
        B,
        R,
        Y
    }

    private static MasterMindResult guessResult(Balls[] guess, Balls[] real) {
        int hits = 0;
        int pseudo;
        HashMap<Balls, Integer> realOcc = new HashMap<>();
        HashMap<Balls, Integer> guessOcc = new HashMap<>();
        for (int i = 0; i < guess.length; i++) {
            if (guess[i].equals(real[i])) {
                hits++;
            } else {
                updateOcc(real[i], realOcc);
                updateOcc(guess[i], guessOcc);
            }
        }
        pseudo = realOcc.entrySet().stream().mapToInt(o -> Math.min(guessOcc.getOrDefault(o.getKey(), 0), o.getValue())).sum();
        return new MasterMindResult(hits, pseudo);
    }

    private static void updateOcc(Balls key, HashMap<Balls, Integer> occMap) {
        int ballOcc = occMap.getOrDefault(key, 0);
        occMap.put(key, ballOcc + 1);
    }


    public static void main(String[] args) {
        Balls[] guess = {Balls.B, Balls.G, Balls.G, Balls.R};
        Balls[] real = {Balls.R, Balls.B, Balls.G, Balls.Y};
        System.out.println("Real:" + Arrays.toString(real) + " Guess:" + Arrays.toString(guess) + " result:" + guessResult(guess, real));

        guess = new Balls[]{Balls.G, Balls.G, Balls.G, Balls.G};
        real = new Balls[]{Balls.G, Balls.B, Balls.G, Balls.Y};
        System.out.println("Real:" + Arrays.toString(real) + " Guess:" + Arrays.toString(guess) + " result:" + guessResult(guess, real));

        guess = new Balls[]{Balls.G, Balls.G, Balls.G, Balls.G, Balls.B, Balls.G, Balls.G, Balls.R, Balls.R, Balls.B, Balls.G, Balls.Y, Balls.G, Balls.B, Balls.G, Balls.Y};
        real = new Balls[]{Balls.G, Balls.B, Balls.G, Balls.Y, Balls.G, Balls.B, Balls.G, Balls.G, Balls.R, Balls.R, Balls.B, Balls.G, Balls.Y, Balls.R, Balls.B, Balls.G};
        System.out.println("Real:" + Arrays.toString(real) + " Guess:" + Arrays.toString(guess) + " result:" + guessResult(guess, real));
    }
}
