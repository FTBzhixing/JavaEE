package ChapterTwo.Three;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LambdaProcess {

    public static String processFile(BufferReaderProcess p){
        try(BufferedReader br = new BufferedReader(new FileReader("data.txt"))){
            return p.process(br);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        processFile(br->br.readLine());
        processFile(BufferedReader::readLine);
    }

}
