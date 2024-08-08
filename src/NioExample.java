import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
public class NioExample {
    public static void main(String[] args) throws IOException
    {
        String[] inputFiles = {"C:/Users/marlie.martinez/Downloads/file1.txt", "C:/Users/marlie.martinez/Downloads/file2.txt"};

        String outputFile = "C:/Users/marlie.martinez/Downloads/nioOutput.text";

        // Get Channel for destination or outputFile
        FileOutputStream  fos = new FileOutputStream(outputFile);
        FileChannel targetChannel =  fos.getChannel();

        for(int i =0; i < inputFiles.length; i++)
        {
            // Get channel for inputFiles
            FileInputStream fis = new FileInputStream(inputFiles[i]);
            FileChannel inputchannel =  fis.getChannel();
            long size = inputchannel.size();
            ByteBuffer buf = ByteBuffer.allocate((int)size);
            System.out.print((char) buf.get());
            while (inputchannel.read(buf)> 0) {
                buf.flip();
                while (buf.hasRemaining()) {
                    //  System.out.print((char) buf.get());
                    targetChannel.write(buf);
                }
            }
            //fis.close();
        }
    }}

