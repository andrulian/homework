package hw12lesson170823;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordsFrequency {
    static Map<String, Integer> wordsFrequency = new HashMap<>();
    static List<String> splitOnWhitespace;
    static String rawString;

    public static void main(String[] args) {
        rawString = "He was an old man who fished alone in a skiff in the Gulf Stream and he had gone eighty-four " +
                    "days now without taking a fish. In the first forty days a boy had been with him. But after " +
                    "forty days without a fish the boy's parents had told him that the old man was now definitely " +
                    "and finally salao, which is the worst form of unlucky, and the boy had gone at their orders in " +
                    "another boat which caught three good fish the first week. It made the boy sad to see the old " +
                    "man come in each day with his skiff empty and he always went down to help him carry either the " +
                    "coiled lines or the gaff and harpoon and the sail that was furled around the mast. The sail was" +
                    " patched with flour sacks and, furled, it looked like the flag of permanent defeat.";

        wordsSplitter(rawString);
        mapFiller();

    }

    private static void mapFiller() {
        System.out.println("FILLER");
//       Stream.of(splitOnWhitespace).map(x -> if (wordsFrequency.containsKey(x)))
        for (String word : splitOnWhitespace) {
            if (!wordsFrequency.containsKey(word)) wordsFrequency.put(word, 1);
            else wordsFrequency.put(word, wordsFrequency.get(word) + 1);
        }
        System.out.println(wordsFrequency);
    }

    private static void wordsSplitter(String rawString) {
//        Stream<String> words = Stream.of(rawString);//.map(x -> x.split("\\s+"));

//        splitOnWhitespace = Stream.of(rawString.split("\\s+")).collect(Collectors.toList());
//        TODO: replace "replace"
        splitOnWhitespace = Stream.of(rawString.replace(",", " " ).replace(".", " " ).
                                      split("\\s+")).collect(Collectors.toList());


//        Stream.of(rawString).map(x -> x.split("\\s+")).collect(Collectors.toList());
//        Stream.of(rawString).map(x -> x.split("\\s+")).map(forEach(x -> splitOnWhitespace.add(Arrays.toString(x))));
//        Stream.of(rawString).map(x -> x.split("\\s+")).forEach(x -> System.out.println(Arrays.toString(x)));
//        System.out.println(Stream.of(rawString).map(x -> x.split("\\s+")));
//        splitOnWhitespace = Stream.of(rawString).map(x -> x.split("\\s+"));//.collect(Collectors.toList());
        System.out.println(splitOnWhitespace.get(0));
    }



}
