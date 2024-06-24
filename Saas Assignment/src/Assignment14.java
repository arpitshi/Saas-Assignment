import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Assignment14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int w = Integer.parseInt(scanner.nextLine());

        String[] words = new String[w];
        for (int i = 0; i < w; i++) {
            words[i] = scanner.next();
        }
        scanner.nextLine();

        int s = Integer.parseInt(scanner.nextLine());

        String charString = scanner.nextLine();

        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : charString.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        int maxWords = findMaxWords(words, charCount, 0);

        System.out.println(maxWords);

        scanner.close();
    }

    public static int findMaxWords(String[] words, Map<Character, Integer> charCount, int index) {
        if (index >= words.length) {
            return 0;
        }

        int maxWords = 0;
        if (canFormWord(words[index], charCount)) {
            Map<Character, Integer> usedChars = useWordChars(words[index], charCount);
            maxWords = 1 + findMaxWords(words, charCount, index + 1);
            restoreWordChars(charCount, usedChars);
        }

        maxWords = Math.max(maxWords, findMaxWords(words, charCount, index + 1));

        return maxWords;
    }

    public static boolean canFormWord(String word, Map<Character, Integer> charCount) {
        Map<Character, Integer> tempCount = new HashMap<>(charCount);
        for (char c : word.toCharArray()) {
            if (tempCount.getOrDefault(c, 0) <= 0) {
                return false;
            }
            tempCount.put(c, tempCount.get(c) - 1);
        }
        return true;
    }

    public static Map<Character, Integer> useWordChars(String word, Map<Character, Integer> charCount) {
        Map<Character, Integer> usedChars = new HashMap<>();
        for (char c : word.toCharArray()) {
            charCount.put(c, charCount.get(c) - 1);
            usedChars.put(c, usedChars.getOrDefault(c, 0) + 1);
        }
        return usedChars;
    }

    public static void restoreWordChars(Map<Character, Integer> charCount, Map<Character, Integer> usedChars) {
        for (Map.Entry<Character, Integer> entry : usedChars.entrySet()) {
            charCount.put(entry.getKey(), charCount.getOrDefault(entry.getKey(), 0) + entry.getValue());
        }
    }
}
