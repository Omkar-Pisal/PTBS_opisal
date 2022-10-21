package ptbs.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		/*This is beging of program and facade pattern
		* We are asking user to either login or Register*/
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
		/*This function logs-in user (buyer or seller) Also start of Bridge and Factory Pattern*/
		Scanner scanner = new Scanner(System.in);
		UserType = login(new Login()); // 0 buyer 1 seller
		System.out.println("---------- Bridge Pattern + Factory Pattern ----------");
		System.out.println(UserType>0? "Welcome Seller!":"Welcome Buyer!");
		System.out.println("Select from available Product Menu 1. Meat Product Menu 2. Produce Product Menu.");
		int selectProductType = scanner.nextInt();

		callProductMenu(UserType,selectProductType);
	}

	public void callProductMenu(int UserType, int selectProductType){
		/*This function shows user available products*/
		Scanner scanner = new Scanner(System.in);
		if (selectProductType == 1) {
			SelectProduct(new MeatProductMenu(), UserType, userName, selectProductType);
		} else if (selectProductType == 2) {
			SelectProduct(new ProduceProductMenu(), UserType, userName, selectProductType);
		} else {
			System.out.println("Invalid Choice!");
			System.exit(-1);
		}

		System.out.println("Wish to see offered products: 1. Yes  2. No");
		int value1 = scanner.nextInt();
		if(value1==1){
			callOfferedProduct();
		}
		else {
			System.out.println("Closing PTSB");
		}

	}

	public void callOfferedProduct(){
		/*THis fucnction lists all the offered prodcuts also begining of iterator and visitor pattern*/
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
		/*This function will create new user as Buyer or Seller and upadte txt files accordingly*/
		Scanner scanner = new Scanner(System.in);
		System.out.println("Who Are You? :  0. Buyer 1. Seller");
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
		/*Creating user as buyer or seller and updatinf txt files*/
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
