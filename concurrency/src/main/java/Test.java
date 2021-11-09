import java.io.*;

public class Test {
    public static void main(String[] args) {
        File file = new File("./1.txt");
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,true)));
            for (int i = 0; i < 10; i++) {
                bufferedWriter.write("ftb"+"\n");
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
