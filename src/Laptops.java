/**
 * 
 */

/**
 * @author Akhilesh
 *
 */
public class Laptops extends Item {

	//assuming a minimum stock level of 20 is being maintained for Laptops
	private static final int MIN_QUANTITY = 20;
	
	private int RamSize;
	private boolean hasSSD;
	private int StorageSize;
	
	/**
	 * 
	 */
	public Laptops() {
		// TODO Auto-generated constructor stub
		setCategory("Laptop");
		this.RamSize = 0;
		this.hasSSD = false;
		this.StorageSize = 0;
	}

	/**
	 * 
	 * @param itemId
	 * @param name
	 * @param RamSize
	 * @param hasSSD
	 * @param StorageSize
	 */
	public Laptops(String itemId, String name, int RamSize, boolean hasSSD, int StorageSize) {
		super(itemId, name);
		// TODO Auto-generated constructor stub
		setCategory("Laptop");
		setRamSize(RamSize);
		this.hasSSD = hasSSD;
		setStorageSize(StorageSize);
		
	}

	/**
	 * 
	 * @param itemId
	 * @param name
	 * @param brand
	 * @param price
	 * @param quantity
	 * @param RamSize
	 * @param hasSSD
	 * @param StorageSize
	 */
	public Laptops(String itemId, String name, String brand, double price, int quantity, int RamSize, boolean hasSSD, int StorageSize) {
		super(itemId, name, brand, price, quantity);
		// TODO Auto-generated constructor stub
		setCategory("Laptop");
		setRamSize(RamSize);
		this.hasSSD = hasSSD;
		setStorageSize(StorageSize);
	}

	/**
	 * 
	 * @param itemId
	 * @param name
	 * @param brand
	 * @param category
	 * @param supplierName
	 * @param supplierContacts
	 * @param price
	 * @param quantity
	 * @param RamSize
	 * @param hasSSD
	 * @param StorageSize
	 */
	public Laptops(String itemId, String name, String brand, String category, String supplierName,
			String supplierContacts, double price, int quantity, int RamSize, boolean hasSSD, int StorageSize) {
		super(itemId, name, brand, category, supplierName, supplierContacts, price, quantity);
		// TODO Auto-generated constructor stub
		setCategory("Laptop");
		setRamSize(RamSize);
		this.hasSSD = hasSSD;
		setStorageSize(StorageSize);
	}

	/**
	 * @return the ramSize
	 */
	public int getRamSize() {
		return RamSize;
	}

	/**
	 * @return the isSSD
	 */
	public boolean getHasSSD() {
		return hasSSD;
	}

	/**
	 * @return the storageSize
	 */
	public int getStorageSize() {
		return StorageSize;
	}

	/**
	 * @param ramSize the ramSize to set
	 */
	public void setRamSize(int ramSize) {
		if(ramSize > 0) {
			this.RamSize = ramSize;
		}
		else {
			System.out.println("Default Size for Ram has been used. Please Set the correct number to avoid errors!");
			this.RamSize = 0;
		}
	}

	/**
	 * @param isSSD the isSSD to set
	 */
	public void setHasSSD(boolean isSSD) {
		this.hasSSD = isSSD;
	}

	/**
	 * @param storageSize the storageSize to set
	 */
	public void setStorageSize(int storageSize) {
		if(storageSize > 0) {
			this.StorageSize = storageSize;
		}
		else {
			System.out.println("Default Size for Storage has been used. Please Set the correct number to avoid errors!");
			this.StorageSize = 0;
		}
	}

	/**
	 * @return the minQuantity
	 */
	public static int getMinQuantity() {
		return MIN_QUANTITY;
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
		return "Laptops [itemId=" + getItemId() + ", name=" + getName() + ", brand=" + getBrand() + ", category=" + getCategory()
				+ ", supplierName=" + getSupplierName() + ", supplierContacts=" + getSupplierContacts() + ", price=" + getPrice()
				+ ", quantity=" + getQuantity() + ",RamSize=" + RamSize + ", hasSSD=" + hasSSD + ", StorageSize=" + StorageSize + "]";
	}
	
	
	
}
