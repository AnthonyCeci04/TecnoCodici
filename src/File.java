import java.io.*;
import java.nio.channels.*;
import java.net.URL;

public class File {
    public static void reader(String path, String codeType, int number) {
        String line = "";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            for (int i = 1; i <= number; i++) {
                line = br.readLine();
                if (line == null) {
                    System.out.printf("Questo articolo non esiste, ricorda che il Codice %s possiede da 1 a %d articoli.\n", codeType, (i - 1));
                    return;
                }
            }
            line = line.replaceAll("\"", "");

            String[] parts = line.split(";");

            for (String part : parts) {
                System.out.println(part.trim());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void update() throws IOException {
        String link = "";
        String name = "";

        for (int i = 1 ; i<=3 ; i++) {
            switch (i) {
                case 1 -> {
                    link = "https://docs.google.com/spreadsheets/d/e/2PACX-1vSgMi9XDQIm6BqzA0q3iGhH_MqZRERQaDUo_EEd9PuLo8eQFygdFfiRJwrih1nu1BrqK9-6gecyqsxz/pub?output=csv\n";
                    name = "Civile";
                }
                case 2 -> {
                    link = "https://docs.google.com/spreadsheets/d/e/2PACX-1vSttnCrw2fqhCuh07hAk7Wi54ElvgzhZx9ztq0myxnpaYK5SopDLbxA9NrO6BYrfZbBIDD-q9Ft0QNB/pub?output=csv\n";
                    name = "Penale";
                }
                case 3 -> {
                    link = "https://docs.google.com/spreadsheets/d/e/2PACX-1vSqSJ7hJlXIXbftoqJZhqN8CQn60BuPyS68F_AcRI5SLBfAGBYQrfvZHsjYfev3ylbJARXxCSXI0vM9/pub?output=csv\n";
                    name = "Stradale";
                }
            }
            URL fetchWebsite = new URL(link);
            ReadableByteChannel readableByteChannel = Channels.newChannel(fetchWebsite.openStream());
            try (FileOutputStream fos = new FileOutputStream("Codici/Codice " + name + ".csv")) {
                fos.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
