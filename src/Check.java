import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class Check {
    public static int parseInt(String b) throws IOException{

        Scanner scanner = new Scanner(System.in);

        int a = 0;
        try {
            a = Integer.parseInt(b);
        } catch (NumberFormatException ex) {
            System.out.println("""
                    \tErrore durante la scelta, il numero inserito contiene una o più lettere.
                    \tRiavvio il programma.


                    Premere un tasto per continuare...""");
            scanner.nextLine();
            File file = new File("start.bat");
            Desktop desktop = Desktop.getDesktop();
            desktop.open(file);
            System.exit(0);
        }
        return a;
    }

    public static void internetConnection () {
        Scanner scanner = new Scanner(System.in);

        String site = "www.google.it";

        try (Socket socket = new Socket()) {
            InetSocketAddress address = new InetSocketAddress(site, 80);
            socket.connect(address,3000);
        } catch (IOException e) {
            System.out.print("TecnoCodici - by ToxicAnthony @NonSonoAntho\n\n\nNon sei connesso ad internet!\n");
            System.out.print("Per poter utilizzare il software e aggiornare i codici, connettiti ad internet.\n\nPremere un tasto per chiudere il programma...");
            scanner.nextLine();
            System.exit(0);
        }
    }
}