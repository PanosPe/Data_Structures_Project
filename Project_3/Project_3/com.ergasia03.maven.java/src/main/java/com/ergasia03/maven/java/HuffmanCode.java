import java.io.Serializable;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.io.PrintWriter;


public class HuffmanCode implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        PrintWriter writeFile = new PrintWriter("src/main/java/com/ergasia03/maven/java/codes.dat");
        FileInputStream InputStream = new FileInputStream("src/main/java/com/ergasia03/maven/java/tree.dat");
        ObjectInputStream ObjectInputStream = new ObjectInputStream(InputStream);

        TreeNode root;

        root = (TreeNode) ObjectInputStream.readObject();


        printHuffmanCoding(root, writeFile);

        writeFile.close();
    }

    static ArrayDeque<String>  dq = new ArrayDeque<>();


    public static void printHuffmanCoding(TreeNode root, PrintWriter writeFile) {


        if (
            root.getLeft() == null
            && root.getRight() == null
        ) {

            writeFile.println((char) root.getC() + ":" + dq );
            return;
        }



        if(root.getLeft() != null) {
            dq.add("0");
            printHuffmanCoding(root.getLeft(), writeFile);
            dq.removeLast();
        }

        if(root.getRight() != null) {
            dq.add("1");
            printHuffmanCoding(root.getRight(), writeFile);
            dq.removeLast();
        }

    }
}
