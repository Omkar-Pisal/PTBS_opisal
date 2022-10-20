package ptbs.system;

import java.util.Scanner;

public class Facade {

	private int UserType;

	private Product theSelectedProduct;

	private int nProductCategory;

	private ClassProductList theProductList;

	private Person thePerson;

	private String userName;

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
	public void startFacade(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("---------- PTBS System ----------");
		System.out.println("Please select : \n 1. Login \n 2. Create New User");
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
		System.out.println("HERE");
		UserType = login(new Login()); // 0 buyer 1 seller
		System.out.println("Welcome "UserType>0? "Buyer!":"Seller!");
		System.out.println("Select from available Product Menu \n 1. Meat Product Menu \n 2. Produce Product Menu. " +
				"\n Enter 1 or 2 based on above selection");
		int selectProductType = scanner.nextInt();

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
		System.out.println("Called createUser function, exiting!");
		System.exit(0);
	}

	public void createProductList() {

	}

	public void AttachProductToUser() {

	}

	public Product SelectProduct() {
		return null;
	}

	public void productOperation() {

	}

}
