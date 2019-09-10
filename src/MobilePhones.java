/**
 * 
 */

/**
 * @author Akhilesh
 *
 */
public class MobilePhones extends Item {

	//assuming a minimum stock level of 50 is being maintained for Mobile Phones
	private static final int MIN_QUANTITY = 50;
	
	private int ram;
	private int storage;
	private String processor;
	private String os;
	
	/**
	 * 
	 */
	public MobilePhones() {
		// TODO Auto-generated constructor stub
		setCategory("Mobile_Phones");
	}

	/**
	 * 
	 * @param itemId
	 * @param name
	 * @param ram
	 * @param storage
	 * @param processor
	 * @param os
	 */
	public MobilePhones(String itemId, String name, int ram, int storage, String processor, String os) {
		super(itemId, name);
		// TODO Auto-generated constructor stub
		setCategory("Mobile_Phones");
		setRam(ram);
		setStorage(storage);
		this.processor = processor;
		this.os = os;
	}

	/**
	 * 
	 * @param itemId
	 * @param name
	 * @param brand
	 * @param price
	 * @param quantity
	 * @param ram
	 * @param storage
	 * @param processor
	 * @param os
	 */
	public MobilePhones(String itemId, String name, String brand, double price, int quantity, int ram, int storage, String processor, String os) {
		super(itemId, name, brand, price, quantity);
		// TODO Auto-generated constructor stub
		setCategory("Mobile_Phones");
		setRam(ram);
		setStorage(storage);
		this.processor = processor;
		this.os = os;
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
	 * @param ram
	 * @param storage
	 * @param processor
	 * @param os
	 */
	public MobilePhones(String itemId, String name, String brand, String category, String supplierName,
			String supplierContacts, double price, int quantity, int ram, int storage, String processor, String os) {
		super(itemId, name, brand, category, supplierName, supplierContacts, price, quantity);
		// TODO Auto-generated constructor stub
		setCategory("Mobile_Phones");
		setRam(ram);
		setStorage(storage);
		this.processor = processor;
		this.os = os;
	}

	/**
	 * @return the ram
	 */
	public int getRam() {
		return ram;
	}

	/**
	 * @return the storage
	 */
	public int getStorage() {
		return storage;
	}

	/**
	 * @return the processor
	 */
	public String getProcessor() {
		return processor;
	}

	/**
	 * @return the os
	 */
	public String getOs() {
		return os;
	}

	/**
	 * @param ram the ram to set
	 */
	public void setRam(int ram) {
		if(ram > 0) {
			this.ram = ram;
		}
		else {
			System.out.println("Default Size for Ram has been used. Please Set the correct number to avoid errors!");
			this.ram = 0;
		}
	}

	/**
	 * @param storage the storage to set
	 */
	public void setStorage(int storage) {
		if(storage > 0) {
			this.storage = storage;
		}
		else {
			System.out.println("Default Size for Storage has been used. Please Set the correct number to avoid errors!");
			this.storage = 0;
		}
	}

	/**
	 * @param processor the processor to set
	 */
	public void setProcessor(String processor) {
		this.processor = processor;
	}

	/**
	 * @param os the os to set
	 */
	public void setOs(String os) {
		this.os = os;
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
	
}
