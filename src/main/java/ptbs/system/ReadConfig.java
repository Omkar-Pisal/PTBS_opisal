package ptbs.system;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.io.InputStream;

public class ReadConfig {

    String result = "";
    InputStream inputStream;

    String usertype = "";

    public String[] getPropValues(String username) throws IOException {
        String[] details = new String[2];
        try {

            AddNewUser addNewUser = new AddNewUser();
            Properties prop1 = new Properties();
            String loginFileName = "SellerInfo.txt";
            String loginFileName1 = "BuyerInfo.txt";
            String password = "";
            inputStream = getClass().getClassLoader().getResourceAsStream(loginFileName);
            if (inputStream != null) {
                prop1.load(inputStream);
                password = prop1.getProperty(username);
                if(password != null)
                {
                    usertype = "Seller";
                }

            }
            else {
                throw new FileNotFoundException("property file '" + loginFileName + "' not found in the classpath");
            }


            if( password == null)
            {

                inputStream = getClass().getClassLoader().getResourceAsStream(loginFileName1);
                if (inputStream != null) {
                    prop1.load(inputStream);
                    password = prop1.getProperty(username);
                    if(password != null)
                    {
                        usertype = "Buyer";
                    }
                }
                else {
                    throw new FileNotFoundException("property file '" + loginFileName + "' not found in the classpath");
                }
            }

            if(password == null) {
                System.out.println("No user found");
            }
            details[0] = password;
            details[1] = usertype;

        }
        catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        finally {
            inputStream.close();
        }
        return  details;
    }
}
