/**
 * 
 */

/**
 * @author Akhilesh
 *
 */
public class MainBoard extends Item {

	//assuming a minimum stock level of 20 is being maintained for Main Boards
	private static final int MIN_QUANTITY = 25;
	
	String powerConnectorType;
	int numOfUsbPorts;
	int numberOfRamSlots;
	
	/**
	 * 
	 */
	public MainBoard() {
		// TODO Auto-generated constructor stub
		setCategory("MainBoard");
		this.powerConnectorType = nullstr;
		this.numOfUsbPorts = 0;
		this.numberOfRamSlots = 0;
	}

	/**
	 * @param itemId
	 * @param name
	 */
	public MainBoard(String itemId, String name, String powerConnectorType, int numOfUsbPorts, int numberOfRamSlots) {
		super(itemId, name);
		// TODO Auto-generated constructor stub
		setCategory("MainBoard");
		this.powerConnectorType = powerConnectorType;
		setNumOfUsbPorts(numOfUsbPorts);
		setNumberOfRamSlots(numberOfRamSlots);
		
	}

	/**
	 * @param itemId
	 * @param name
	 * @param brand
	 * @param price
	 * @param quantity
	 */
	public MainBoard(String itemId, String name, String brand, double price, int quantity, String powerConnectorType, int numOfUsbPorts, int numberOfRamSlots) {
		super(itemId, name, brand, price, quantity);
		// TODO Auto-generated constructor stub
		setCategory("MainBoard");
		this.powerConnectorType = powerConnectorType;
		setNumOfUsbPorts(numOfUsbPorts);
		setNumberOfRamSlots(numberOfRamSlots);
	}

	/**
	 * @param itemId
	 * @param name
	 * @param brand
	 * @param category
	 * @param supplierName
	 * @param supplierContacts
	 * @param price
	 * @param quantity
	 */
	public MainBoard(String itemId, String name, String brand, String category, String supplierName,
			String supplierContacts, double price, int quantity, String powerConnectorType, int numOfUsbPorts, int numberOfRamSlots) {
		super(itemId, name, brand, category, supplierName, supplierContacts, price, quantity);
		// TODO Auto-generated constructor stub
		setCategory("MainBoard");
		this.powerConnectorType = powerConnectorType;
		setNumOfUsbPorts(numOfUsbPorts);
		setNumberOfRamSlots(numberOfRamSlots);
	}

	
	/**
	 * @return the powerConnectorType
	 */
	public String getPowerConnectorType() {
		return powerConnectorType;
	}

	/**
	 * @return the numOfUsbPorts
	 */
	public int getNumOfUsbPorts() {
		return numOfUsbPorts;
	}

	/**
	 * @return the numberOfRamSlots
	 */
	public int getNumberOfRamSlots() {
		return numberOfRamSlots;
	}

	/**
	 * @param powerConnectorType the powerConnectorType to set
	 */
	public void setPowerConnectorType(String powerConnectorType) {
		this.powerConnectorType = powerConnectorType;
	}

	/**
	 * @param numOfUsbPorts the numOfUsbPorts to set
	 */
	public void setNumOfUsbPorts(int numOfUsbPorts) {
		if (numOfUsbPorts > 0){
			this.numOfUsbPorts = numOfUsbPorts;
		}
		else {
			System.out.println("*Invalid Quantity! Default Number of USB Ports has been used. Please Set the correct number to avoid errors!");
			this.numOfUsbPorts = 0;
		}
		
	}

	/**
	 * @param numberOfRamSlots the numberOfRamSlots to set
	 */
	public void setNumberOfRamSlots(int numberOfRamSlots) {
		if (numberOfRamSlots > 0){
			this.numberOfRamSlots = numberOfRamSlots;
		}
		else {
			System.out.println("*Invalid Quantity! Default Number of RAM Slots has been used. Please Set the correct number to avoid errors!");
			this.numberOfRamSlots = 0;
		}
	}

	/**
	 * Method to Check if item needs to be re-ordered
	 * @param quantity quantity of item
	 * @return true if item needs to be re-ordered
	 */
	
	public static boolean checkReOrder(int quantity) {
		
		if(quantity <= MIN_QUANTITY) {
			return true;
		}
		else {
			return false;
		}
		
	}

	@Override
	public String toString() {
		return "MainBoard [getItemId()=" + getItemId() + ", getName()=" + getName()
				+ ", getBrand()=" + getBrand() + ", getCategory()=" + getCategory() + ", getSupplierName()="
				+ getSupplierName() + ", getSupplierContacts()=" + getSupplierContacts() + ", getPrice()=" + getPrice()
				+ ", getQuantity()=" + getQuantity() + ", powerConnectorType=" + powerConnectorType + ", numOfUsbPorts=" + numOfUsbPorts
						+ ", numberOfRamSlots=" + numberOfRamSlots + "]";
	}


	
	
	
	

	
}
