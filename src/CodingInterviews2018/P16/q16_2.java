package CodingInterviews2018.P16;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class q16_2 {

    private static Map<String,Integer> occ;

    private static long findOcc(String book, String wordToFind) {
        String[] words = book.split("[ .,]");
        return Arrays.stream(words).filter(t->t.trim().equalsIgnoreCase(wordToFind)).count();
    }

    private static void findOccCache(String book) {
        occ = Arrays.stream(book.split("[ .,]")).map(t->t.trim().toLowerCase()).collect(Collectors.toMap(t->t,t->1,(oldV,newV)->oldV+1));
    }

    private static long findOccCached(String wordToFind) {
        return occ.get(wordToFind.trim().toLowerCase());
    }

    public static void main(String[] args) {
        String book = "As they rounded a bend in the path that ran beside the river, Lara recognized the silhouette of a fig tree atop a nearby hill. The weather was hot and the days were long. The fig tree was in full leaf, but not yet bearing fruit. "
                + "Soon Lara spotted other landmarks�an outcropping of limestone beside the path that had a silhouette like a man�s face, a marshy spot beside the river where the waterfowl were easily startled, a tall tree that looked like a man with his arms upraised. They were drawing near to the place where there was an island in the river. The island was a good spot to make camp. They would sleep on the island tonight."
                + "Lara had been back and forth along the river path many times in her short life. Her people had not created the path�it had always been there, like the river�but their deerskin-shod feet and the wooden wheels of their handcarts kept the path well worn. Lara�s people were salt traders, and their livelihood took them on a continual journey. ";
        long occ = findOcc(book, "river");
        System.out.println(occ);
        findOccCache(book);
        System.out.println(findOccCached("river"));
        System.out.println(findOccCached("LarA"));
    }
}
