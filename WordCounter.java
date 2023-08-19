
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter 'T' to input text or 'F' to provide a file: ");
        String choice = scanner.nextLine().toUpperCase();
        
        if (choice.equals("T")) {
            System.out.print("Enter the text: ");
            String text = scanner.nextLine();
            processText(text);
        } else if (choice.equals("F")) {
            System.out.print("Enter the file name: ");
            String fileName = scanner.nextLine();
            processFile(fileName);
        } else {
            System.out.println("Invalid choice.");
        }
        
        scanner.close();
    }
    
    private static void processText(String text) {
        text = preprocessText(text);
        String[] words = text.split("\\s+");
        
        Map<String, Integer> wordCounter = new HashMap<>();
        for (String word : words) {
            wordCounter.put(word, wordCounter.getOrDefault(word, 0) + 1);
        }
        
        int totalWords = words.length;
        int uniqueWords = wordCounter.size();
        
        System.out.println("Total words: " + totalWords);
        System.out.println("Unique words: " + uniqueWords);
        
        // Most common words
        System.out.println("\nMost common words:");
        wordCounter.entrySet().stream()
            .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
            .limit(10)
            .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
    
    private static void processFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder textBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                textBuilder.append(line).append("\n");
            }
            String text = textBuilder.toString();
            processText(text);
        } catch (IOException e) {
            System.out.println("Error reading the file.");
        }
    }
    
    private static String preprocessText(String text) {
        text = text.replaceAll("[^\\w\\s]", "");
        text = text.toLowerCase();
        return text;
    }
}
int uniqueWords = wordCounter.size();
        
        System.out.println("Total words: " + totalWords);
        System.out.println("Unique words: " + uniqueWords);
        
        // Most common words
        System.out.println("\nMost common words:");
        wordCounter.entrySet().stream()
            .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
            .limit(10)
            .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
    
    private static void processFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder textBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                textBuilder.append(line).append("\n");
            }
            String text = textBuilder.toString();
            processText(text);
        } catch (IOException e) {
            System.out.println("Error reading the file.");
        }
    }
    
    private static String preprocessText(String text) {
        text = text.replaceAll("[^\\w\\s]", "");
        text = text.toLowerCase();
        return text;
    }
}
