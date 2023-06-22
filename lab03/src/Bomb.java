import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Bomb {

    public String shufflePassword(String s) {
        String code = "" + s.hashCode();
        StdRandom.setSeed(1337);
        char[] chars = code.toCharArray();
        StdRandom.shuffle(chars);

        return String.valueOf(chars);
    }

    public int[] shufflePasswordArr(String s) {
        String code = "" + s.hashCode();
        StdRandom.setSeed(61833);
        char[] chars = code.toCharArray();
        StdRandom.shuffle(chars);

        int[] arr = new int[chars.length];
        for (int i = chars.length - 1; i >= 0; i--) {
            arr[i] = Integer.parseInt(String.valueOf(chars[i]));
        }

        return arr;
    }

    public void phase0(String password) {
        String correctPassword = shufflePassword("hello");
        if (!password.equals(correctPassword)) {
            System.out.println("Phase 0 went BOOM!");
             System.exit(1);
        } else {
            System.err.println("You passed phase 0 with the password \"" + password + "\"");
        }
    }

    public void phase1(int[] password) {
        int[] correctArrPassword = shufflePasswordArr("bye");
        if (!Arrays.equals(correctArrPassword, password)) {
            System.out.println("Phase 1 went BOOM!");
             System.exit(2);
        } else {
            System.err.print("You passed phase 1 with the password \"");
            System.err.print(Arrays.toString(password));
            System.err.println("\"");
        }
    }

    public void phase2(String password) {
        String[] passwordPieces = password.split(" ");

        // Can't use StdRandom because I really do want a random int
        Random r = new Random(1337);
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < 100000) {
            numbers.add(r.nextInt());
        }

        boolean correct = false;
        int i = 0;
        for (int number : numbers) {
            if (i == 1337 && Integer.parseInt(passwordPieces[i]) == number) {
                correct = true;
            }
            i++;
        }
        if (!correct) {
            System.out.println("Phase 2 went BOOM!");
             System.exit(3);
        } else {
            System.err.println("You passed phase 2 with the password \"" + password + "\"");
        }
    }
}
