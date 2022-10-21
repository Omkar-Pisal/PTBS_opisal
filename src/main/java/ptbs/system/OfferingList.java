package ptbs.system;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

public class OfferingList {

	private Trading trading;

	private OfferingIterator offeringIterator;

	private Offering[] offering;

	ArrayList<String> offeringList1 = new ArrayList<String>();
	OfferingList(){

		try {
			System.out.println("Showing Offering List:");
			File file = new File("src/main/resources/Offerings.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			br.readLine(); // this will read the first line
			String st = null;
			while ((st = br.readLine()) != null) {
				String[] values = st.split("=");
				String[] offerings_list = values[1].split(",");
				for( int i = 0;i < offerings_list.length; i++)
				{
					offeringList1.add(offerings_list[i]);
				}

			}
			for (int i = 0; i< offeringList1.size(); i++)
			{
				System.out.println(offeringList1.get(i));
			}

		}
		catch ( Exception e)
		{
			System.out.println("File Not Found"+ e);
		}

	}

	public Iterator createIterator() {
		return this.offeringList1.iterator();
	}

}
