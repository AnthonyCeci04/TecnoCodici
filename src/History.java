import java.util.ArrayList;
import java.util.Scanner;

public class History {
    public static void load (ArrayList hist) {
        Scanner scanner = new Scanner(System.in);

        String stop;

        Console.clear();

        StringBuilder strHistBuild = new StringBuilder();
        for (Object scroll : hist) {
            strHistBuild.append(scroll).append(" ");
        }
        String strHist = strHistBuild.toString();
        strHist = strHist.replaceAll("[\\[\\],]", "");

        System.out.println("TecnoCodici - by ToxicAnthony @NonSonoAntho\n\n");
        System.out.println("Cronologia Articoli cercati:");

        System.out.print(strHist);

        System.out.print("\n\nCercare un altro articolo? (n per uscire) -> ");
        stop = scanner.nextLine().strip();
        if (stop.equals("n")) System.exit(0);
    }
}