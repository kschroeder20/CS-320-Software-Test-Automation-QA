public class Contact {
    private String id;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
     	
	// constant variables
	public static final String ID_ATTRIBUTE = "id";
	public static final String FIRSTNAME_ATTRIBUTE = "firstName";
	public static final String LASTNAME_ATTRIBUTE = "lastName";
	public static final String ADDRESS_ATTRIBUTE = "address";
	public static final String PHONE_ATTRIBUTE = "phone";
	
    
    public Contact(String id, String firstName, String lastName, String phone, String address) {
    	// validate id
    	if (!this.validateAttribute(id, 10)) {
    		throw new IllegalArgumentException("Invalid ID");
    	}
    	// validate firstName
    	if (!this.validateAttribute(firstName, 10)) {
    		throw new IllegalArgumentException("Invalid First Name");
    	}
    	// validate lastName
    	if (!this.validateAttribute(lastName, 10)) {
    		throw new IllegalArgumentException("Invalid Last Name");
    	}
    	// validate phone
    	if (!validateAttribute(phone, 10, "phone")) {
    		throw new IllegalArgumentException("Invalid Phone Number");
    	}
    	// validate address
    	if (!this.validateAttribute(address, 30)) {
    		throw new IllegalArgumentException("Invalid Address");
    	}
    	// save instance
    	this.id = id;
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.lastName = lastName;
    	this.phone = phone;
    	this.address = address;
    }
    
    // GETTERS //
    public String getId() {
        return id;	
    }
    
    public String getFirstName() {
        return firstName;	
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getPhone() {
        return phone;	
    }
    
    public String getAddress() {
        return address;	
    }
    // SETTERS //
    public void setId(String id) {
    	if (!this.validateAttribute(id, 10)) {
    		throw new IllegalArgumentException("Invalid ID");
    	}
    	this.id = id;
    }
    
    public void setFirstName(String firstName) {
    	if (!this.validateAttribute(firstName, 10)) {
    		throw new IllegalArgumentException("Invalid First Name");
    	}
    	this.firstName = firstName;
    }
    
    public void setLastName(String lastName) {
    	if (!this.validateAttribute(lastName, 10)) {
    		throw new IllegalArgumentException("Invalid Last Name");
    	}
    	this.lastName = lastName;
    }
    
    public void setPhone(String phone) {
    	if (!validateAttribute(phone, 10, "phone")) {
    		throw new IllegalArgumentException("Invalid Phone Number");
    	}
    	this.phone = phone;
    }
    
    public void setAddress(String address) {
    	if (!this.validateAttribute(address, 30)) {
    		throw new IllegalArgumentException("Invalid Address");
    	}
    	this.address = address;
    }
    
    // validation helper methods
    public boolean validateAttribute(String attribute, int characterLength, String specialConsideration) {
    	if (specialConsideration == PHONE_ATTRIBUTE) {
    		if (attribute == null || attribute == "" || attribute.length()!=characterLength ) {
    			return false;
    		} else {
    			return true;
    		}
    	} else {
    		throw new IllegalArgumentException("Invalid special consideration");
    	}
    }
    
    public boolean validateAttribute(String attribute, int characterLength) {
    	if (attribute == null || attribute == "" || attribute.length()>characterLength) {
    		return false;
    	} else {
    		return true;
    	}
    }
      
}
