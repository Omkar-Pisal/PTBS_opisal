package ptbs.system;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class AddNewUser {
    Properties props = new Properties();

    void AddDetailsToConfig(String path, String username, String password)
    {

        props.put(username, password);
        try
        {
            File file = new File(path);
            FileInputStream fileIn = new FileInputStream(file);
            props.load(fileIn);
            fileIn.close();
            FileOutputStream outputStream = new FileOutputStream(path);
            props.store(outputStream, "");
            outputStream.flush();
            outputStream.close();
            System.out.println("Details Added Successfully");

        }
        catch (Exception e)
        {
            System.out.println("File not found");
        }


    }

    void GetDetails()
    {
        System.out.println("");
    }
}
