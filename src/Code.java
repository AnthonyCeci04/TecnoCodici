import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Code {
    public static void open() throws IOException {

        Scanner scanner = new Scanner(System.in);

        Console.clear();

        System.out.println("TecnoCodici - by ToxicAnthony @NonSonoAntho\n\n");

        System.out.print("""
                ┌────────────────────────────────────┐
                             MENU SCELTA\s

                  1) Codice Civile
                  2) Codice Penale
                  3) Codice Stradale
                └────────────────────────────────────┘

                """);

        System.out.print("Effettua la tua scelta: ");
        String strCode = scanner.nextLine().strip();

        int chooseCode = Checks.parseInt(strCode);

        while (chooseCode < 1 || chooseCode > 3) {
            System.out.print("\tErrore durante la scelta, il numero inserito non è valido.\n\tReinserisci il numero: ");
            strCode = scanner.nextLine().strip();
            chooseCode = Checks.parseInt(strCode);
        }

        String file_path = " ";
        String code = " ";
        switch (chooseCode) {
            case 1 -> {
                file_path = "Codici/Codice Civile.cc";
                code = "Civile";
            }
            case 2 -> {
                file_path = "Codici/Codice Penale.cp";
                code = "Penale";
            }
            case 3 -> {
                file_path = "Codici/Codice Stradale.cs";
                code = "Stradale";
            }
        }

        System.out.print("\nQuale articolo vuoi cercare? -> ");
        String strArt = scanner.nextLine().strip();
        System.out.println();
        int art = Checks.parseInt(strArt);
        boolean find = false;

        long numberOfLines = Files.lines(Paths.get(file_path)).count();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file_path));
            String line;
            int current_line = 1;

            while ((line = reader.readLine()) != null) {
                if (current_line == art) {
                    String[] parts = line.split(";");
                    for (String part : parts) {
                        System.out.println(part.trim());
                    }
                    find = true;
                    break;
                }

                current_line++;
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!find)
            System.out.printf("Questo articolo non esiste, ricorda che il Codice %s possiede da 1 a %d articoli.\n", code, numberOfLines);
    }
}


