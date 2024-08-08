import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

public class NioExampleTwo {
    public static void main(String[] args) throws IOException{
        String[] inputFiles = {"C:/Users/marlie.martinez/Downloads/file1.txt", "C:/Users/marlie.martinez/Downloads/file2.txt"};

        String outputFile = "C:/Users/marlie.martinez/Downloads/OutputExampleTwo.txt";

        FileOutputStream fos = new FileOutputStream(outputFile);
        WritableByteChannel targetChannel = fos.getChannel();
        for(int i = 0; i < inputFiles.length; i++){
            FileInputStream fis = new FileInputStream(inputFiles[i]);
            FileChannel inputChannel = fis.getChannel();

            inputChannel.transferTo(0, inputChannel.size(), targetChannel);
            inputChannel.close();
            fis.close();
        }

        targetChannel.close();
        fos.close();
    }
}
