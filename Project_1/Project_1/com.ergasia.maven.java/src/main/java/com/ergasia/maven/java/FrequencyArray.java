import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;


public class FrequencyArray {

    public static void main(String[] args) throws IOException {

        FileInputStream in = null;

        int[] array = new int[128];

        int i;
        for (i = 0; i < 128; i++) {
            array[i] = 0;
        }


        PrintWriter writeFile = new PrintWriter("src/main/java/com/ergasia/maven/java/frequency.dat");

        in = new FileInputStream("src/main/java/com/ergasia/maven/java/Biblio1.txt");

        int c;
        while ((c = in.read()) != -1) {

            if (c < 128) {
                array[c]++;
            }
        }


        in = new FileInputStream("src/main/java/com/ergasia/maven/java/Biblio2.txt");

        int y;
        while ((y = in.read()) != -1) {

            if (y < 128) {
                array[y]++;
            }
        }


        in = new FileInputStream("src/main/java/com/ergasia/maven/java/Biblio3.txt");

        int x;
        while ((x = in.read()) != -1) {

            if (x < 128) {
                array[x]++;
            }
        }

        for (i = 0; i < 128; i++) {
            writeFile.println(array[i]);
        }
        writeFile.close();
    }
}
