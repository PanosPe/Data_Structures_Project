import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Scanner;

public class Encoder {
    public static void main(String[] args) throws IOException {

        FileInputStream inputFile = new FileInputStream(args[0]);
        PrintWriter outputFile = new PrintWriter(args[1]);

        File codesDatFile = new File("src/main/java/com/ergasia04/maven/java/codes.dat");
        Scanner scanner = new Scanner(codesDatFile);

        HashMap<String, BitSet> encodedDataMap = new HashMap<>();
        HashMap<String, Integer> encodedValueSizeMap = new HashMap<>();
        while (scanner.hasNextLine()) {
            String fileLine = scanner.nextLine();

            String encodedData[];
            if (fileLine.contains("::")) {
                encodedData = fileLine.split("::");
                encodedData[0] = ":";
            } else {
                encodedData = fileLine.split(":");
            }

            if (encodedData.length != 2) {
                continue;
            }

            if (encodedData[0].length() <= 0) {
                continue;
            }

            if (encodedData[1].length() <= 0) {
                continue;
            }

            encodedData[1] = encodedData[1].replaceAll("[\\[,\\], ]", "");

            BitSet bitset = new BitSet(encodedData[1].length());
            for (int i = 0; i < encodedData[1].length(); i++) {
                if (encodedData[1].charAt(i) == '1') {
                    bitset.set(i, true);
                } else {
                    bitset.set(i, true);
                    bitset.set(i, false);
                }
            }

            encodedDataMap.put(encodedData[0], bitset);
            encodedValueSizeMap.put(encodedData[0], encodedData[1].length());
        }

        String outputResult = "";
        int bitsLength = 0;

        int c;
        while ((c = inputFile.read()) != -1) {

            String key = Character.toString((char) c);

            if (!encodedDataMap.containsKey(key)) {
                System.out.println("No bit size for that key:" + key);
                continue;
            }

            if (!encodedValueSizeMap.containsKey(key)) {
                System.out.println("No bit size for that key:" + key);
                continue;
            }

            bitsLength += encodedValueSizeMap.get(key);
            for (int i = 0; i < encodedValueSizeMap.get(key); i++) {

                String bit = encodedDataMap.get(key).get(i) ? "1" : "0";

                outputResult += bit;
            }
        }

        String finalResult = bitsLength + "\n" + outputResult;
        outputFile.write(finalResult);

        outputFile.close();
        inputFile.close();
    }
}
