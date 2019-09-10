import java.util.Scanner;
import java.io.*;
import java.util.Date;
/**
 * @author Akhilesh
 * 
 * Version 1.0
 */
public class LabInventory {
	
	//Scanner for User Input
	static Scanner key = new Scanner(System.in);

	/**
	 * Checks if inventory is Full
	 * @param pointer
	 * @param size
	 * @return true if inventory is Full
	 */
	
	static boolean isFull(int pointer, int size) {
		
		if(pointer > (size-1)) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	/**
	 * Checks if inventory is Empty
	 * @param pointer
	 * @return true if inventory is Empty
	 */
	
	static boolean isEmpty(int pointer) {
			
		if(pointer == 0) {
			return true;
		}
		else {
			return false;
		}
			
	}
	
	//=================================================================================================================
	//Password Section
	
	/**
	 * Main Method for Pass
	 * Password Section plus date and time for unsuccessful attempts are stored in a text file
	 * @param totalFails
	 * @return
	 * @throws IOException
	 */
	
	static int pass_Checker(int totalFails) throws IOException {
		
		String pass;
		int passFails;
		boolean valid;
		

			BufferedWriter txtwriter = new BufferedWriter(new FileWriter("FailsLog.txt", true));
			
		
		passFails = 0;
		do {
			System.out.println("Password Protected!");
			
			System.out.print("Enter Password to Continue: ");
			pass = key.next();
			
			valid = password_validator(pass);

			if(valid == true) {
				txtwriter.close();
				return -1;
			
			}
			else {
				Date date = new Date();
				txtwriter.write("[" + pass + "] on " + date.toString() + "\n"); //Records date and time in a text file when unsuccessful attempts were made!
				passFails++;
				totalFails++;
				chk_susp_act(totalFails);
				
				if (passFails < 3) {
					System.out.println("Incorrect Password! Please Re-enter." + (3 - passFails) + " attempts remaining." );
				}
			}	
			System.out.println();
		}while(passFails < 3);
		
		txtwriter.close();
		return totalFails;
	}
	
	/**
	 * Password Validator
	 * @param currentPass
	 * @param preSetPass
	 * @return true if password is correct
	 */
	
	static boolean password_validator(String currentPass) {
		
		final String PRESETPASS = "DitProg123";
		
		if(currentPass.equals(PRESETPASS)){
			return true;
		}
		else {
			return false;	
		}
	}
	
	/**
	 * Checks for suspicious activity
	 * @param totalatempts
	 * @return true if suspecious activity detected
	 */
	
	static boolean chk_susp_act(int totalatempts) {
		if(totalatempts < 12) {
			return true;
		}
		else {
			System.out.println("Program detected suspicious activity and is terminating!");
			System.exit(0);
			return false;
		}
	}
	
	
	//=================================================================================================================
	
	/**
	 * Main Menu
	 * @return Choice entered by user
	 */
	
	static int main_Menu() {
		int choice;
		do {
			System.out.println("Main Menu");
			System.out.println("1. Enter a new Item to the inventory (password required)");
			System.out.println("2. Change information of an existing Item (password required)");
			System.out.println("3. Display all the Items with the specified category");
			System.out.println("4. Display all Items to be re-ordered");
			System.out.println("5. Number of Items currently in store");
			System.out.println("6. Quit");
			
			System.out.print("Please enter your choice >");
			choice = key.nextInt();
			if(choice < 1 || choice > 6) {
				System.out.println("Invalid Choice! Please choose from above menu.");
			}
			
		}while(choice < 1 || choice > 6);
		return choice;
		
	}
	
	//================================================================================================================================
	
	/**
	 * Main method for option 1
	 * @param pointer
	 * @param itemDatabase
	 */
	
	static void Option1(int pointer, Item[] itemDatabase) {
		int choice;
		String itemId = null;
		String name = null;
		String brand = "";
		int category;
		String supplierName = null;
		String supplierContacts = null;
		double price = 0;
		int quantity = 0;
		int ram;
		int intchoice;
		boolean tempBooleanChoice = false;
		int storage;
		String processor = null;
		String os = null;
		String model = null;
		int ramSlots;
		int numusb;
		String pcType = null;
		
		
		
		System.out.println("Add a New Item To Inventory:");
		
		do {
			System.out.println("Choose the data to be stored for the items");
			System.out.println("1. Basic Info Input *(Item Id and Name Required)");
			System.out.println("2. Sales Info Input *(Item Id, Name, Brand, Price, Quantity Required)");
			System.out.println("3. Full Details Input *(Item Id, Name, Brand, SupplierName, Supplier Contacts, Price, Quantity Required)");
			
			System.out.print("Please Enter Your Choice > ");
			
			choice = key.nextInt();
			
			if(choice < 1 || choice > 3) {
				System.out.println("Invalid Choice Entered! Please Choose from above.");
			}
			
		}while(choice < 1 || choice > 3);
		
		do{
			do {
				System.out.print("Enter Item ID: ");
				itemId = key.next();
				
				if (itemId.isBlank()){
					System.out.println("This field cannot be blank! ItemID is Required.Please Re-Enter");
				}	
			
			}while(itemId.isBlank());
			
			do {
				System.out.print("Enter Item Name: ");
				name = key.next();
				
				if (name.isBlank()){
					System.out.println("This field cannot be blank! Item Name is Required.Please Re-Enter");
				}
				
			}while(name.isBlank());
			
			if(choice == 1) {
				break;
			}
			
			System.out.print("Enter Brand of Item: ");
			brand = key.next();
	
			
			do {
				System.out.print("Enter item Price: ");
				price = key.nextDouble();
				
				if (price <= 0){
	
					System.out.println("Price cannot be less than or equal to 0! Please Re-Enter");
				}
			}while(price <= 0);
			
			
			do {
				System.out.print("Enter Quantity of Item: ");
				quantity = key.nextInt();
				
				if (quantity <= 0){
					System.out.println("Quantity cannot be less than or equal to 0! Please Re-Enter");
				}
			}while(quantity <= 0);
			
			if(choice == 2) {
				break;
			}
			
			do {
				System.out.print("Enter Supplier Name: ");
				supplierName = key.next();
				if (supplierName.isBlank()){
					System.out.println("This field cannot be blank!");
				}
			}while(supplierName.isBlank());
			
			do {
				System.out.print("Enter Supplier Contacts: ");
				supplierContacts = key.next();
				if (supplierContacts.isBlank()){
					System.out.println("This field cannot be blank!");
				}
			}while(supplierContacts.isBlank());
			break;
		}while(true); 
		System.out.println();
		
		do {
			System.out.println("Choose Category for Item: ");
			System.out.println("1. MainBoard");
			System.out.println("2. Pc");
			System.out.println("3. Laptop");
			System.out.println("4. Mobile Phone");
			System.out.println("5. Other Category");
			System.out.print("Please Enter Choice > ");
			category = key.nextInt();
			
			if (category < 1 || category > 5){
				System.out.println("Invalid Choice! Please Re-enter");
			}
		
		}while(category < 1 || category > 5);
		
		System.out.println("Please Provide more details for the item depending on the catgory");
		
		switch(category) {
		
		case 1:
			//object for main board
			System.out.println("Enter Power Connector Type: ");
			pcType = key.next();
			
			System.out.println("Enter Number of USB Ports: ");
			numusb = key.nextInt();
			
			System.out.println("Enter Number of RAM Slots: ");
			ramSlots = key.nextInt();
			
			if(choice == 1) {
				itemDatabase[pointer] = new MainBoard(itemId, name, pcType, numusb, ramSlots);
			}
			else if(choice == 2) {
				itemDatabase[pointer] = new MainBoard(itemId, name, brand, price, quantity, pcType, numusb, ramSlots);
			}
			else {
				itemDatabase[pointer] = new MainBoard(itemId, name, brand, "MainBoard", supplierName, supplierContacts , price, quantity, pcType, numusb, ramSlots);
			}
			
			break;
		case 2:
			//object for PC
			System.out.println("Enter Ram Size(in GB): ");
			ram = key.nextInt();
			
			do {
				System.out.println("If This is a Mini PC, Enter 1 else Enter 2:");
				intchoice = key.nextInt();
				if(intchoice == 1) {
					tempBooleanChoice = true;
				}
				else if(choice == 2){
					tempBooleanChoice = false;
				}
				else {
					System.out.println("Invalid Choice! Please Choose from the above list.");
				}
			}while(intchoice < 1 || intchoice > 2);
			
			System.out.println("Enter CPU Model: ");
			model = key.next();
			
			if(choice == 1) {
				itemDatabase[pointer] = new PCs(itemId, name, ram, tempBooleanChoice, model);
			}
			else if(choice == 2) {
				itemDatabase[pointer] = new PCs(itemId, name, brand, price, quantity, ram, tempBooleanChoice, model);
			}
			else {
				itemDatabase[pointer] = new PCs(itemId, name, brand, "PC", supplierName, supplierContacts , price, quantity, ram, tempBooleanChoice, model);
			}
			
			break;
		case 3:
			//object for Laptops
			System.out.println("Enter RAM Size(in GB): ");
			ram = key.nextInt();
			
			do {
				System.out.println("Enter 1 if Laptop has SSD Harddisk or 2 for HDD: "); 
				intchoice = key.nextInt();
				
				if(intchoice == 1) {
					tempBooleanChoice = true;
				}
				else if(choice == 2){
					tempBooleanChoice = false;
				}
				else {
					System.out.println("Invalid Choice! Please Choose from the above list.");
				}
				
			}while(intchoice < 1 || intchoice > 2);
			
			System.out.println("Enter Storage Size(in GB): ");
			storage = key.nextInt();
			
			if(choice == 1) {
				itemDatabase[pointer] = new Laptops(itemId, name, ram, tempBooleanChoice, storage);
			}
			else if(choice == 2) {
				itemDatabase[pointer] = new Laptops(itemId, name, brand, price, quantity, ram, tempBooleanChoice, storage);
			}
			else {
				itemDatabase[pointer] = new Laptops(itemId, name, brand, "PC", supplierName, supplierContacts , price, quantity, ram, tempBooleanChoice, storage);
			}
			
			break;
		case 4:
			//Object for mobile phones
			System.out.println("Enter RAM size(in GB): ");
			ram = key.nextInt();
			
			System.out.println("Enter Storage Size(in GB): ");
			storage = key.nextInt();
			
			System.out.println("Enter processor Model: ");
			processor = key.next(); 
			
			System.out.println("Enter Operating System(Android Or IOS Or Windows): ");
			os = key.next();
			
			if(choice == 1) {
				itemDatabase[pointer] = new MobilePhones(itemId, name, ram, storage, processor, model);
			}
			else if(choice == 2) {
				itemDatabase[pointer] = new MobilePhones(itemId, name, brand, price, quantity, ram, storage, processor, os);
			}
			else {
				itemDatabase[pointer] = new MobilePhones(itemId, name, brand, "Mobile_Phones", supplierName, supplierContacts, price, quantity, ram, storage, processor, os);
			}
			
			break;
		default:
			// this object will only be used in case of exceptions
			if(choice == 1) {
				itemDatabase[pointer] = new OtherCategory(itemId, name);
			}
			else if(choice == 2) {
				itemDatabase[pointer] = new OtherCategory (itemId, name, brand, price, quantity);
			}
			else {
				itemDatabase[pointer] = new OtherCategory(itemId, name, brand, "PC", supplierName, supplierContacts , price, quantity);
			
			
			
			break;
		}
	}
					
	}
	
	
	//=================================================================================================================
	
	/**
	 * Main Method for option 2
	 * @param pointer
	 * @param itemData
	 */
	
	static void Option2(int pointer, Item[] itemData) {
		
		int choice = 0;
		String itemId;
		boolean found;
		int idx = 0; // position of itemId when found
		int reTry = 1;
		
		do {
			System.out.print("Enter Item ID to be searched: ");
			itemId = key.next();
			
			if(isEmpty(pointer)) {
				System.out.println("Inventory is Empty! No items to modify.");
				return;
			}
			else {
				found = false;
				for(int i = 0; i < (pointer); i++) {
					
					if(itemData[i].equals(itemId)){

						idx = i;
						found = true;
						break;
					}
					
				}
			}
			
			if (found == false){
				do {
					System.out.println("Item Not Found! Do You want to Search with another ID or return to Main Menu?");
					System.out.println("1. Search with another Item ID");
					System.out.println("2. Return to main menu");
					System.out.print("Enter choice > ");
					choice = key.nextInt();
					if(choice != 1 && choice != 2) {
						System.out.println("Invalid Choice! Choose from above menu.");
					}
				}while(choice != 1 && choice != 2);
				
				if(choice == 1) {
					continue;
				}
				else {
					return;
				}
				
			}
			else {
				do {
					System.out.println();
					dispItem(itemData[idx],idx);
					System.out.println();
					
					choice = modifyItemDetails(itemData[idx]);
					
					if(choice == 0) {
						return;
					}
					else {
						
					
					do {
						System.out.println();
						System.out.println("Do You Want to change more information of the same Item?");
						System.out.println("1. Change more information about the same Item.");
						System.out.println("2. Quit to Main Menu.");
						System.out.println("Please Enter Your Choice > ");
						reTry = key.nextInt();
					
						if(reTry < 1 || reTry > 2) {
							System.out.println("Invalid Choice Entered!Please Re-Enter.");
						}
					}while(reTry < 1 || reTry > 2);
					
					}
					
				}while(reTry == 1 && choice == 1);
				return;
			}
			
		}while(choice == 1);
		
	}
	
	/**
	 * Display Details of item searched
	 * @param searchItem
	 * @param idx index of item in array
	 */
	
	static void dispItem(Item searchItem, int idx) {
		
		System.out.println("Item ID: " + searchItem.getItemId() + " (Stored at index " + idx + " in itemDatabase array)");
		System.out.println("Name: " + searchItem.getName());
		System.out.println("Brand: " + searchItem.getBrand());
		System.out.println("Category: " + searchItem.getCategory());
		System.out.println("Supplier Name: " + searchItem.getSupplierName());
		System.out.println("Supplier Contacts: " + searchItem.getSupplierContacts());
		System.out.println("Price: " + searchItem.getPrice());
		System.out.println("Quantity: " + searchItem.getQuantity());
		
	}
	
	/**
	 * Method to modify the details of item being searched
	 * @param itemData
	 * @return Rrturns 0 if user wants to quit to main menu
	 */
	
	static int modifyItemDetails(Item itemData) {
		
		int choice;
		String tempstr;
		int tempInt;
		double tempDouble;
		
		do {
			System.out.println("What information of this item would you like to change?");
			System.out.println();
			System.out.println("1. Name");
			System.out.println("2. Brand"); //brand cannot be changed But modification is being allowed to correct mistakes
			System.out.println("3. Category");
			System.out.println("4. Supplier Name");
			System.out.println("5. Supplier Contacts");
			System.out.println("6. Price");
			System.out.println("7. Quantity");
			System.out.println("8. Quit");
			System.out.print("Please Enter your choice > ");
			choice = key.nextInt();
			
			if(choice < 1 || choice > 8) {
				System.out.println("Invalid Choice! Please Re-Enter.");
			}				
		}while(choice < 1 || choice > 8);
			
	switch(choice) {
			
		case 1:
			System.out.println("Enter new Name: ");
			tempstr = key.next();
			itemData.setName(tempstr);
			break;
		case 2:
			System.out.println("Enter new Brand: ");
			tempstr = key.next();
			itemData.setBrand(tempstr);
			break;
		case 3:
			do {
				System.out.println("Choose New Category: ");
				System.out.println("1. Internal Parts");
				System.out.println("2. Accessories");
				System.out.println("3. PC");
				System.out.println("4. Laptops");
				System.out.println("5. Mobile Phones");
				System.out.println("6. Other Category");
				System.out.print("Please Enter Choice > ");
				tempInt = key.nextInt();
				
				if (tempInt < 1 || tempInt > 6){
					System.out.println("Invalid Choice! Please Re-enter");
				}
			
			}while(tempInt < 1 || tempInt > 6);
			
			
			switch(tempInt){
				
				case 1:
					itemData.setCategory("Internal Parts");
					break;
				case 2:
					itemData.setCategory("Accessories");
					break;
				case 3:
					itemData.setCategory("PC");
					break;
				case 4:
					itemData.setCategory("Laptop");
					break;
				case 5:
					itemData.setCategory("Mobile Phones");
					break;
				default:
					itemData.setCategory("Other Category");
			}
			
			break;
		case 4:
			System.out.println("Enter new Supplier Name: ");
			tempstr = key.next();
			itemData.setSupplierName(tempstr);
			break;
		case 5:
			System.out.println("Enter new Supplier Contacts: ");
			tempstr = key.next();
			itemData.setSupplierContacts(tempstr);
			break;
		case 6:
			System.out.println("Enter new Price: ");
			tempDouble = key.nextDouble();
			itemData.setPrice(tempDouble);
			break;
		case 7:
			System.out.println("Enter new Quantity: ");
			tempInt = key.nextInt();
			itemData.setQuantity(tempInt);
			break;
		case 8:
			return 0;
		}
		System.out.println();
		System.out.println("Item Information Modified!");
		System.out.println();
		return 1;
	}
	
	//======================================================================================================================

	/**
	 * Method for Option 3
	 * @param pointer pointer which points to the next freecell in array
	 * @param itemData array which contains details of inventory
	 */
	
	static void Option3(int pointer, Item[] itemData) {
		
		int choice;
		int i;
		String category = "";
		
		do {
			System.out.println("Display Item By Category:");
			System.out.println("Choose Category:");
			System.out.println("1. Internal Parts");
			System.out.println("2. Accessories");
			System.out.println("3. PCs");
			System.out.println("4. Laptops");
			System.out.println("5. Mobile Phones");
			System.out.println("6. Other Categories");
			System.out.println("7. Quit to Main Menu");
			System.out.print("Please Enter Choice > ");
			choice = key.nextInt();
			
			if(choice < 1 || choice > 7) {
				System.out.println("Invalid Choice Entered! Please choose from above menu!");
			}
			
		}while(choice < 1 || choice > 7);
			
		switch(choice) {
			
		case 1:
			category = "Internal_Parts";
			break;
		case 2:
			category = "Accessories";
			break;
		case 3:
			category = "Pc";
			break;
		case 4:
			category = "Laptop";
			break;
		case 5:
			category = "Mobile_Phones";
			break;
		case 6:
			category = "Other_Category";
			break;
		case 7:
			return;
		}
		
		System.out.println();
		System.out.println("Here are the items in the Category " + category + ":");
		
		for(i = 0; i < pointer; i++) {
			
			if(itemData[i].findByCat(category)) {
				System.out.println(itemData[i].toString());
			}
		}
		
	}
	//======================================================================================================================
	
	/**
	 * Method for Option 4
	 * @param pointer points to the next free cell in array
	 * @param itemData arry of items
	 */
	
	static void Option4(int pointer, Item[] itemData) {
		
		String category;
		int quantity;
		boolean toReOrder = false;
		
		for(int i=0; i <pointer; i++) {
			
			category = itemData[i].getCategory();
			quantity = itemData[i].getQuantity();
			
			if (category.equalsIgnoreCase("Internal_Parts")){
				toReOrder = MainBoard.checkReOrder(quantity);
			}
			/*
			else if(category.equalsIgnoreCase("Accessories")) {
				toReOrder = Accessories.checkReOrder(quantity);
			}
			*/
			else if(category.equalsIgnoreCase("Pc")) {
				toReOrder = PCs.checkReOrder(quantity);
			}
			else if(category.equalsIgnoreCase("Laptop")) {
				toReOrder = Laptops.checkReOrder(quantity);
			}
			else if(category.equalsIgnoreCase("Mobile_Phones")) {
				toReOrder = MobilePhones.checkReOrder(quantity);
			}
			else {
				toReOrder = OtherCategory.checkReOrder(quantity);
			}
			
			if (toReOrder) {
				System.out.println(itemData[i].toString());
			}	
		}
	}
	
	//======================================================================================================================
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		int choice;
		boolean complete;
		int max_size;
		int totalFails;
		int temp;
		int pointer = 0;
		Item[] itemDatabase;
		
		
		System.out.println("Electronics Lab Store");
		System.out.println("Welcome To Electronics Lab Inventory Management System");
		
		System.out.print("What is the maximum number of Items that can be stored?");
		max_size = key.nextInt();
		System.out.println();
		itemDatabase = new Item[max_size];
		totalFails = 0;
		
		do {
			choice = main_Menu();	
			System.out.println();
			do {
				complete = false;
				switch(choice) {
				
					case 1:
						//==============================================================================================================
						if(isFull(pointer, max_size)) {
							System.out.println("Inventory is FULL! You cannot add any new item!");
							complete = true;
						}
						else {
							
							do {
								do {
									temp = pass_Checker(totalFails);
									System.out.println();
									
									if(temp == -1) {
										break;
									}
									else {
										totalFails = temp;
									}
									
								}while(totalFails < 3 && temp != -1);
								
								if (temp >= 3) {
									choice = main_Menu();
									System.out.println();
									if(choice != 1) {
										break;
									}
								}

							}while(totalFails < 12 && temp != -1);
							
							
							if(choice != 1) {
								break;
							}
							else {
								//after validation of password and choice is still one then execute option 1
								Option1(pointer, itemDatabase);
								pointer++;
							}
							System.out.println();
							System.out.println("Item Successfully recorded!");
							complete = true; /* a flag to determine if task has been successfully completed (also part of password process
											 to check the choice again)*/
						}
						break;
						//=======================================================================================================
					case 2:
						//=======================================================================================================
						if(isEmpty(pointer)) {
							System.out.println("Inventory is Empty! You cannot modify any item!");
							complete = true;
						}
						else {
							
							do {
								do {
									temp = pass_Checker(totalFails);
									System.out.println();
									if(temp == -1) {
										break;
									}
									else {
										totalFails = temp;
									}
									
								}while(totalFails < 3 && temp != -1);
								
								if (temp >= 3) {
									choice = main_Menu();
									System.out.println();
								}

								break;
							}while(totalFails < 12 && temp != -1);
														
							if(choice != 2) {
								break;
							}
							else {
								Option2(pointer, itemDatabase);
								
							}
						
						complete = true;
						}
						break;
						//===========================================================================================================
					case 3:
						
						Option3(pointer, itemDatabase);
						complete = true;
						break;
					case 4:
						
						Option4(pointer, itemDatabase);
						
						
						complete = true;
						break;
						
					case 5:
						System.out.println(Item.getTotalItems() + " items have been created so far.");
						
						complete = true;
						break;
						
					default:
						System.out.println("You have Exited the LabInventory Program...");
						complete = true;
						break;	
				}
				System.out.println();
			}while(complete == false); /*Part of Password Process to check choice again if choice changes when displaying menu in between
										password validation process*/
			System.out.println();
		}while(choice != 6);	
					
				

			
			
			
		}	
	
	}

