
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


class Words {


    public static void main(String[] args) {

        // the input file to read words from
        String fileName = "collection_of_words.txt";
        ArrayList<String> words = new ArrayList<>();
        try {
            Scanner fileReader = new Scanner(new File(fileName));
            String word;
            while (fileReader.hasNext()) {
                word = fileReader.next().toLowerCase();
                if (!words.contains(word))
                    words.add(word);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: could not find file: " + fileName);
            return;
        }
        System.out.println("Words In Ascending Order: ");
        Collections.sort(words);
        for (String word : words) System.out.print(word+" ");
        System.out.println("\nWords In Descending Order: ");
        for (int i = words.size() - 1; i >= 0; i--) System.out.print(words.get(i)+" ");
    }
}
