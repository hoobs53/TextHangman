package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Word {
    private String word;
    private final List<String> wordBase;

    Random random = new Random();

    public Word() {
        wordBase = loadWordBase();
        word = generateWord();
    }

    private List<String> loadWordBase() {
        List<String> result = new ArrayList<>();
        try {
            File wordBaseFile = new File("src/resources/word_list.txt");
            Scanner wordReader = new Scanner(wordBaseFile);
            while (wordReader.hasNextLine()) {
                String word = wordReader.nextLine();
                result.add(word);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Couldn't open word base file," +
                    " check if word_list.txt is present in resources directory");
            e.printStackTrace();
            System.exit(-1);
        }
        return result;
    }
    private String generateWord() {
        int max = wordBase.size() - 1;
        int ind = random.nextInt(max);

        return wordBase.get(ind);
    }
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getWordLength() {
        return word.length();
    }
}
