/**
 * 
 */

/**
 * @author Akhilesh
 *
 */
public class OtherCategory extends Item {

	// THIS CLASS WILL ONLY BE USED IF CATEGORY OF ITEM IS CONFUSING! EXCEPTION CASE...
	
	//assuming a minimum stock level of 20 is being maintained for Other Categories
	private static final int MIN_QUANTITY = 20;
	
	/**
	 * 
	 */
	public OtherCategory() {
		// TODO Auto-generated constructor stub
		setCategory("Other_Category");
	}

	/**
	 * @param itemId
	 * @param name
	 */
	public OtherCategory(String itemId, String name) {
		super(itemId, name);
		// TODO Auto-generated constructor stub
		setCategory("Other_Category");
	}

	/**
	 * @param itemId
	 * @param name
	 * @param brand
	 * @param price
	 * @param quantity
	 */
	public OtherCategory(String itemId, String name, String brand, double price, int quantity) {
		super(itemId, name, brand, price, quantity);
		// TODO Auto-generated constructor stub
		setCategory("Other_Category");
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
	public OtherCategory(String itemId, String name, String brand, String category, String supplierName,
			String supplierContacts, double price, int quantity) {
		super(itemId, name, brand, category, supplierName, supplierContacts, price, quantity);
		// TODO Auto-generated constructor stub
		setCategory("Other_Category");
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
