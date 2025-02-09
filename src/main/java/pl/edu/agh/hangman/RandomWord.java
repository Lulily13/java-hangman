package pl.edu.agh.hangman;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class RandomWord {
    private final List<String> words = new ArrayList<>();

    public RandomWord(String filename) {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream(filename);
        if (is == null) {
            System.err.println("Błąd: Plik " + filename + " nie został znaleziony.");
            return;
        }
        try (Scanner scanner = new Scanner(is)) {
            while (scanner.hasNextLine()) {
                words.add(scanner.nextLine().toUpperCase());
            }
        } catch (Exception e) {
            System.err.println("Błąd wczytywania słów: " + e.getMessage());
        }
    }

    public String getRandomWord() {
        return words.isEmpty() ? "DEFAULT" : words.get(new Random().nextInt(words.size()));
    }
}
