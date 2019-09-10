/**
 * 
 */

/**
 * @author Akhilesh
 *
 */
public class PCs extends Item {

	//assuming a minimum stock level of 20 is being maintained for PCs
	private static final int MIN_QUANTITY = 20;
	
	private int RamSize;
	private boolean isMini;
	private String CPUModel;
	
	/**
	 * 
	 */
	public PCs() {
		// TODO Auto-generated constructor stub
		setCategory("Pc");
		this.RamSize = 0;
		this.isMini = false;
		this.CPUModel = nullstr;
	}

	/**
	 * @param itemId
	 * @param name
	 */
	public PCs(String itemId, String name, int RamSize, boolean isMini, String CPUModel) {
		super(itemId, name);
		// TODO Auto-generated constructor stub
		setCategory("Pc");
		setRamSize(RamSize);
		this.isMini = isMini;
		this.CPUModel = CPUModel;
	}

	/**
	 * @param itemId
	 * @param name
	 * @param brand
	 * @param price
	 * @param quantity
	 */
	public PCs(String itemId, String name, String brand, double price, int quantity, int RamSize, boolean isMini, String CPUModel) {
		super(itemId, name, brand, price, quantity);
		// TODO Auto-generated constructor stub
		setCategory("Pc");
		setRamSize(RamSize);
		this.isMini = isMini;
		this.CPUModel = CPUModel;
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
	public PCs(String itemId, String name, String brand, String category, String supplierName, String supplierContacts,
			double price, int quantity, int RamSize, boolean isMini, String CPUModel) {
		super(itemId, name, brand, category, supplierName, supplierContacts, price, quantity);
		// TODO Auto-generated constructor stub
		setCategory("Pc");
		setRamSize(RamSize);
		this.isMini = isMini;
		this.CPUModel = CPUModel;
		
	}
	
	/**
	 * @return the ramSize
	 */
	public int getRamSize() {
		return RamSize;
	}

	/**
	 * @return the isMini
	 */
	public boolean getisMini() {
		return isMini;
	}

	/**
	 * @return the cPUModel
	 */
	public String getCPUModel() {
		return CPUModel;
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
	 * @param isMini the isMini to set
	 */
	public void setMini(boolean isMini) {
		this.isMini = isMini;
	}

	/**
	 * @param cPUModel the cPUModel to set
	 */
	public void setCPUModel(String CPUModel) {
		this.CPUModel = CPUModel;
		
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
		return "PCs [getItemId()=" + getItemId() + ", getName()=" + getName() + ", getBrand()=" + getBrand() + ", getCategory()="
				+ getCategory() + ", getSupplierName()=" + getSupplierName() + ", getSupplierContacts()="
				+ getSupplierContacts() + ", getPrice()=" + getPrice() + ", getQuantity()=" + getQuantity() + 
				"RamSize=" + RamSize + ", isMini=" + isMini + ", CPUModel=" + CPUModel + "]";
	}
	
	

	
	
}
