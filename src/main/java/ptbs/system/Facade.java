package ptbs.system;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Scanner;

public class Facade {

	private int UserType;

	private Product theSelectedProduct;

	private int nProductCategory;

	private ClassProductList theProductList;

	private Person thePerson;

	private String userName;

	public void startFacade(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("---------- PTBS System ----------");
		System.out.println("Please select : 1. Login 2. Create New User");
		int value = scanner.nextInt();
		System.out.println("---------- Implementing Facade Pattern ----------");
//		scanner.close();
		if (value==1){
			doLogin();
		}
		else {
			createNewUser();
		}
	}


	public void doLogin(){
		Scanner scanner = new Scanner(System.in);
		UserType = login(new Login()); // 0 buyer 1 seller
		System.out.println("---------- Bridge Pattern + Factory Pattern ----------");
		System.out.println(UserType>0? "Welcome Seller!":"Welcome Buyer!");
		System.out.println("Select from available Product Menu \n 1. Meat Product Menu \n 2. Produce Product Menu. " +
				"\n Enter 1 or 2 based on above selection");
		int selectProductType = scanner.nextInt();

		callProductMenu(UserType,selectProductType);
	}

	public void callProductMenu(int UserType, int selectProductType){
		Scanner scanner = new Scanner(System.in);
		if (selectProductType == 1) {
			SelectProduct(new MeatProductMenu(), UserType, userName, selectProductType);
		} else if (selectProductType == 2) {
			SelectProduct(new ProduceProductMenu(), UserType, userName, selectProductType);
		} else {
			System.out.println("Please select from above given choices");
			System.exit(-1);
		}

		System.out.println("Wish to see offered products: \n 1. Yes \n 2. No");
		int value1 = scanner.nextInt();
		if(value1==1){
			callOfferedProduct();
		}
		else {
			System.out.println("Closing PTSB");
		}

	}

	public void callOfferedProduct(){
		System.out.println("---------- Iterator Pattern + Visitor Pattern ----------");
		OfferingList offeringList = new OfferingList();
		Iterator itr = offeringList.createIterator();
		OfferingIterator offeringIterator = new OfferingIterator();
		while(offeringIterator.hasNext(itr))
		{
			String k = offeringIterator.Next(itr);
			if(k == null)
				break;
			System.out.println(k);

		}
	}
	public void createNewUser(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the type of User: \n 0. Buyer \n 1. Seller");
		UserType = scanner.nextInt();
		System.out.println("Enter the UserName:");
		String userName = scanner.next();
		System.out.println("Enter Password:");
		String password = scanner.next();
		createUser( new UserInfoItem(UserType, userName, password));
		System.exit(0);
	}

	public int login(Login login) {
		boolean output = login.HasAccess();
		if(output == true) {
			userName = login.username;
			return login.GetUserType();
		}
		else
			System.exit(-1);
		return -1;
	}

	public void addTrading() {

	}

	public void viewTrading() {

	}

	public void decideBidding() {

	}

	public void discussBidding() {

	}

	public void submitBidding() {

	}

	public void remind() {

	}

	public void createUser(UserInfoItem userinfoItem) {
		if(userinfoItem.type==0){
			try(FileWriter fileWriter = new FileWriter("src/main/resources/BuyerInfo.txt",true);
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
				PrintWriter printWriter = new PrintWriter(bufferedWriter);){
				printWriter.println("\n"+userinfoItem.user+":"+userinfoItem.password);
			} catch (IOException ioException){
				ioException.printStackTrace();
			}
		}
		else {
			try(FileWriter fileWriter = new FileWriter("src/main/resources/SellerInfo.txt",true);
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
				PrintWriter printWriter = new PrintWriter(bufferedWriter);){
				printWriter.println("\n"+userinfoItem.user+":"+userinfoItem.password);
			} catch (IOException ioException){
				ioException.printStackTrace();
			}
		}
		System.out.println("New User Added Successfully! Please Re-Run the code to see changes");
		System.exit(0);
	}

	public void createProductList() {

	}

	public void AttachProductToUser() {

	}

	public Product SelectProduct(ProductMenu productMenu, int userType, String userName, int selectProductType) {
		return null;
	}

	public void productOperation() {

	}

}
