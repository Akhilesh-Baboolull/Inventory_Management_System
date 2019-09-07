/**
 * 
 */

/**
 * @author Akhilesh
 *
 */
public abstract class Item {
	
	//Static Attributes
	private static int totalItems = 0;

	// object attributes
	private String itemId;
	private String name;
	private String brand;
	private String category;
	private String supplierName;
	private String supplierContacts;
	private double price;
	private int quantity;
	
	//Variable declared for null reference:
	protected final String nullstr = "No_Info";
	
	/**
	 * Default constructor
	 */
	public Item() {
		
		this.itemId = "xxxxx";
		this.name = nullstr;
		this.brand = nullstr;
		this.category = nullstr;
		this.supplierName = nullstr;
		this.supplierContacts = nullstr;
		this.price = 0.0;
		this.quantity = 0;
		setTotalItems(getTotalItems()+1);
		
	}
	
	//Overloaded Constructors
	
	/**
	 * Basic Constructor with minimum info required to create the object
	 * @param itemId
	 * @param name
	 */
	
	public Item(String itemId, String name) {
		
		this.itemId = itemId;
		this.name = name;
		this.brand = nullstr;
		this.category = nullstr;
		this.supplierName = nullstr;
		this.supplierContacts = nullstr;
		this.price = 0.0;
		this.quantity = 0;
		
		setTotalItems(getTotalItems()+1);
		
	}

	/**
	 * constructor specifying the brand, price and quantity
	 * @param itemId
	 * @param name
	 * @param category
	 */
	
	public Item(String itemId, String name, String brand, double price, int quantity) {
	
		this.itemId = itemId;
		this.name = name;
		this.brand = brand;
		this.category = nullstr;
		this.supplierName = nullstr;
		this.supplierContacts = nullstr;
		setPrice(price);
		setQuantity(quantity);
		setTotalItems(getTotalItems()+1);
		
	}
	
	/**
	 * Constructor with full details
	 * @param prodCode
	 * @param prodName
	 * @param brand
	 * @param componentType
	 * @param buyingPrice
	 */
	
	public Item(String itemId, String name, String brand, String category, String supplierName, String supplierContacts, double price, int quantity) {
		this.itemId = itemId;
		this.name = name;
		this.brand = brand;
		this.category = category;
		this.supplierName = supplierName;
		this.supplierContacts = supplierContacts;
		setPrice(price);
		setQuantity(quantity);
		setTotalItems(getTotalItems()+1);
	}
	

	//Getters
	/**
	 * @return the itemId
	 */
	public String getItemId() {
		return itemId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @return the supplierName
	 */
	public String getSupplierName() {
		return supplierName;
	}

	/**
	 * @return the supplierContacts
	 */
	public String getSupplierContacts() {
		return supplierContacts;
	}
	
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}


	//Setters
	
	/**
	 * @param itemId the itemId to set
	 */
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @param supplierName the supplierName to set
	 */
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	/**
	 * @param supplierContacts the supplierContacts to set
	 */
	public void setSupplierContacts(String supplierContacts) {
		this.supplierContacts = supplierContacts;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		if (price > 0){
			 this.price = price;
		}
		else {
			System.out.println("*Invalid Price! Default Price has been used. Please Set the correct Price to avoid errors!");
			this.price = 0.0;
		}
	}
	
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		if (quantity > 0){
			this.quantity = quantity;
		}
		else {
			System.out.println("*Invalid Quantity! Default Quantity has been used. Please Set the correct quantity to avoid errors!");
			this.quantity = 0;
		}
	}
	
		
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", name=" + name + ", brand=" + brand + ", category=" + category
				+ ", supplierName=" + supplierName + ", supplierContacts=" + supplierContacts + ", price=" + price
				+ ", quantity=" + quantity + "]";
	}

	/**
	 * @return the totalItems
	 */
	public static int getTotalItems() {
		return totalItems;
	}
	
	/**
	 * @param totalItems the totalItems to set
	 */
	public static void setTotalItems(int totalItems) {
		Item.totalItems = totalItems;
	
	}
	
	/**
	 * To Check if two items are the same based on Item ID
	 * @param item1
	 * @return
	 */
	
	public boolean equals(Item item1) {
		
		if(this.itemId.equalsIgnoreCase(item1.itemId)) {
			return true;
			
		}
		else {
			return false;
		}
	}
	
	/**
	 * 
	 * @param item1 Item Id of item to be compared
	 * @return
	 */
	
	public boolean equals(String item1) {
			
			if(getItemId().equalsIgnoreCase(item1)) {
				return true;
			}
			else {
				return false;
			}
		}
	
	/**
	 * find items with specific categories
	 * @param cat
	 * @return
	 */
	
	public boolean findByCat(String cat) {
		
		if(this.category.equalsIgnoreCase(cat)){
			return true;
		}
		else {
			return false;
		}
		
	}
	
	
	
}
