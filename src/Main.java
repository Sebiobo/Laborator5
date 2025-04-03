import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        try {
            printSmallTextFile("input.txt");
            System.out.println("\n\n");
            printSplit("input.txt");
            List<String> modifiedLines = getModifiedLines("input.txt");
            writeSmallTextFile(modifiedLines,"out.txt");


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    static void printSmallTextFile(String fileName) throws IOException{
        System.out.println("Using Files.readAllLines:");
        Path path = Paths.get(fileName);
        List<String> allLinesInMemory = Files.readAllLines(path);
        for(String line: allLinesInMemory) {
            System.out.println("\n " + line);
        }

    }
    static void printSplit(String fileName) throws IOException{
        System.out.println("Split:");
        Path path = Paths.get(fileName);
        try (Scanner scanner = new Scanner(path)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String modifiedLine = line.replace(".", ".\n");
                System.out.print(modifiedLine);
            }
        }
    }
    static List<String> getModifiedLines(String fileName) throws IOException {
        System.out.println("Split:");
        List<String> modifiedLines = new ArrayList<>();
        Path path = Paths.get(fileName);

        // Folosește un Scanner pentru a citi fișierul linie cu linie
        try (Scanner scanner = new Scanner(path)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Modifică linia, adăugând un salt de linie după fiecare punct
                String modifiedLine = line.replace(".", ".\n");
                modifiedLines.add(modifiedLine);
            }
        }
        return modifiedLines;
    }
    static void writeSmallTextFile(List<String> lines, String fileName) throws IOException {
        Path path = Paths.get(fileName);
        Files.write(path, lines);
    }
}