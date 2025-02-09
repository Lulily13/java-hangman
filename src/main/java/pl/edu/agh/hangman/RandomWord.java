package pl.edu.agh.hangman;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

//Odpowiada za losowanie słów z pliku „słowa.txt”.
public class RandomWord {

    //lista bedzie przechowywac wszystkie słowa wczytane z pliku
private final List<String> words = new ArrayList<>();


//tworze konstruktor
public RandomWord(String filename) {


    //wczytuje slowa podane od usera plus dodaje wyjatek
    //otwieram plik o nazwie filename (slowa.txt)
    try (Scanner scanner = new Scanner(new File(filename))) {
        while (scanner.hasNextLine()) {
            words.add(scanner.nextLine().toUpperCase());
        }
    } catch (IOException e) {
        System.err.println("Błąd wczytywania słów: " + e.getMessage());
    }

}


    //wybieram jedno losowe slowo z listy
    // Jeśli lista jest pusta (np. z powodu błędu odczytu pliku), zwracam  słowo "DEFAULT"
    public String getRandomWord() {
        return words.isEmpty() ? "DEFAULT" : words.get(new Random().nextInt(words.size()));
    }




}
