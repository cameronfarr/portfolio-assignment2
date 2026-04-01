import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        English word = new English();

        System.out.println("How many letters are in the word?");
        int wordLength = sc.nextInt();

        System.out.println("Do you want me to look for letters or a pattern?\n1. Letters\n2. Pattern");
        int option = sc.nextInt();
        sc.nextLine();

        if (option == 1) {
            System.out.println("What letters are in the word?");
            String lettersInWord = sc.nextLine();
            guessWordWithLetters(word, wordLength, lettersInWord);
        } else if (option == 2) {
            System.out.println("What pattern is in the word?");
            String patternInWord = sc.nextLine();
            guessWordWithPattern(word, wordLength, patternInWord);
        }

    }
    public static boolean wordContainsLetter(String word, char letter){
        char[] myCharArray = word.toCharArray();

        for(int i = 0; i < word.length(); i++){
            if(myCharArray[i] == letter){
                return true;
            }
        }
        return false;
    }

    public static boolean wordContainsString(String s1, String s2){
        return s1.contains(s2);
    }

    public static void guessWordWithLetters(English object, int length, String letters){
        char[] letterArray = letters.toCharArray();

        for(int i = 0; i < object.words.size(); i++){
            String dictionaryWord = object.words.get(i);
            if(dictionaryWord.length() == length){
                for(int j = 0; j < letterArray.length; j++){
                    if(wordContainsLetter(dictionaryWord, letterArray[j])){
                        System.out.println(dictionaryWord);
                    }
                }
            }
        }
    }

    public static void guessWordWithPattern(English object, int length, String pattern){

        for(int i = 0; i < object.words.size(); i++){
            String dictionaryWord = object.words.get(i);
            if(dictionaryWord.length() == length && wordContainsString(dictionaryWord, pattern)){
                System.out.println(dictionaryWord);
            }
        }
    }

}
