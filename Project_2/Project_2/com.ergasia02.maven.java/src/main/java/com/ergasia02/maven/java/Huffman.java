import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.Serializable;

public class Huffman implements Serializable {
    public static void main(String[] args) throws IOException {

        FileOutputStream outputStream = new FileOutputStream("tree.dat");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        Scanner scanner = new Scanner(new File("src/main/java/com/ergasia02/maven/java/frequency.dat"));

        final int arrayLength = 128;
        int[] frequencyArray = new int[128];

        int i = 0;
        while (scanner.hasNextInt()) {
            frequencyArray[i++] = scanner.nextInt();
        }

        MinHeap<TreeNode> heap = new ArrayMinHeap<TreeNode>();

        TreeNode root = null;

        for (i = 0; i < arrayLength; i++) {
            TreeNode k = new TreeNode(frequencyArray[i], (char) i, null, null);
            heap.insert(k);
        }


        while (heap.size() > 1) {
            TreeNode x = heap.findMin();
            heap.deleteMin();

            TreeNode y = heap.findMin();
            heap.deleteMin();

            TreeNode node = new TreeNode(x.getFrequency() + y.getFrequency(), '-', x, y);
            root = node;

            heap.insert(node);
        }

        objectOutputStream.writeObject(root);
        objectOutputStream.close();
    }
}
