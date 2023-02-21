import java.util.HashMap;
import java.util.Map;

public class Main {

    static String TEXT = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

    public static void main(String[] args) {

        char[] letters = TEXT.toLowerCase().toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < letters.length; i++) {      // Цикл для заполнения map

            if (Character.isLetter(letters[i])) {       // Проверка, буква или нет

                if (!map.containsKey(letters[i])) {     // Содержит ли map эту букву. если нет, то добавляет. если да, то увеличивает счет.
                    map.put(letters[i], 1);
                } else {
                    int count = map.get(letters[i]);
                    map.put(letters[i], ++count);
                }
            }
        }

        getMax(map);        // Вывод буквы с максимальным количеством
        getMin(map);        // Вывод буквы с минимальным количеством

    }

    private static void getMax(Map<Character, Integer> map) {
        int maxCount = Integer.MIN_VALUE;
        Character key = null;
        for (Map.Entry<Character, Integer> kv : map.entrySet()) {
            if (kv.getValue() > maxCount) {
                maxCount = kv.getValue();
                key = kv.getKey();
            }
        }
        System.out.println("Максимальное количество у буквы: " + key + " - " + maxCount);
    }

    private static void getMin(Map<Character, Integer> map) {
        int minCount = Integer.MAX_VALUE;
        Character key = null;
        for (Map.Entry<Character, Integer> kv : map.entrySet()) {
            if (kv.getValue() < minCount) {
                minCount = kv.getValue();
                key = kv.getKey();
            }
        }
        System.out.println("Минимальное количество у буквы: " + key + " - " + minCount);
    }
}