package comp_decomp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class compressor {

    public static void method(File file) throws IOException {
        
        //to store a output
        String fileDirectory = file.getParent();

        //to take input as a file
        FileInputStream fis = new FileInputStream(file);
        
        //to store a output
        FileOutputStream fos = new FileOutputStream(fileDirectory + "/CompressedFile.gz");

        //to create and store a compressed out in a GZIP form
        GZIPOutputStream gzip = new GZIPOutputStream(fos);

        //to take a input in a byte format
        byte[] buffer = new byte[1024];
        int len;

        //to read a given file till end we use while loop
        while((len = fis.read(buffer)) != -1){
            gzip.write(buffer, 0, len);
        }

        //then close all stream file which is open
        gzip.close();
        fos.close();
        fis.close();

    }

    //to create a main func for above method func

    public static void main(String[] args) throws IOException {
        
        //create a path for a file
        File path = new File("/Users/Prathamesh/downloads/Compressor/compresssordecompressor/Testfile");
        method(path);
    }
    
}

