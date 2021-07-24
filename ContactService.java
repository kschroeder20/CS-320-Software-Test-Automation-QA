import java.util.ArrayList;
import java.util.Iterator;


public class ContactService {
	// constant variables
	public static final String ID_ATTRIBUTE = "id";
	public static final String FIRSTNAME_ATTRIBUTE = "firstName";
	public static final String LASTNAME_ATTRIBUTE = "lastName";
	public static final String ADDRESS_ATTRIBUTE = "address";
	public static final String PHONE_ATTRIBUTE = "phone";
	// list of all contacts
	private ArrayList<Contact> contacts = new ArrayList<>();
	
	// creates contact and adds to contacts list
    public Contact createContact(String id, String firstName, String lastName, String phone, String address) { 
    	boolean contactIdTaken = false;
    	// verify that the id is unique
    	for (Contact contactItr : contacts)
    		if (contactItr.getId() == id) {
    			contactIdTaken = true;
    		}    	
    	// create contact or display error message
    	if (contactIdTaken == true) {
    		throw new IllegalArgumentException("The contact ID is already taken: " + id);
    	} else {
        	Contact contact = new Contact(id, firstName, lastName, phone, address);
        	contacts.add(contact);
        	return contact;
    	}
    }
    
    // edits existing contact
    public void editContact(String contactId, String attrName, String attrValue) {
    	// keeps track if a contact is found with the id
    	int counter = 0;
    	// loop through contact list
    	for (Contact contact : contacts)
    		// edit attribute based on user input
    		if (contact.getId() == contactId) {
	    		if(attrName == FIRSTNAME_ATTRIBUTE) {
		    		contact.setFirstName(attrValue);
		    	} else if(attrName == LASTNAME_ATTRIBUTE) {
		    		contact.setLastName(attrValue);
		    	} else if(attrName == ADDRESS_ATTRIBUTE) {
		    		contact.setAddress(attrValue);
		    	} else if(attrName == PHONE_ATTRIBUTE) {
		    		contact.setPhone(attrValue);
		    	} else {
		    		// print error to console if attribute name is invalid
		    		throw new IllegalArgumentException("Invalid attribute of the Contact class: " + attrName);
		    	}
    		} else {
    			counter += 1;
    		}
    	// If no contacts match contactId param
    	// throw exception
    	if (counter == contacts.size()) {
    		throw new IllegalArgumentException("No contact found with id " + contactId);
    	}
    }
    
    // removes contact
    public void removeContact(String contactId) {
    	// keeps track if a contact is found with the id
    	int counter = 0;
    	// remove contact with matching id
        Iterator<Contact> contactItr = contacts.iterator();
        while (contactItr.hasNext()) {
        	counter += 1;
            Contact currentContact = (Contact)contactItr.next();
            if (currentContact.getId() == contactId) {
            	contactItr.remove();
            }
        }
        // If no contacts match contactId param
        // throw execption
        if (counter == contacts.size()) {
        	throw new IllegalArgumentException("No contact found with id " + contactId);
    	}
    }
    
    // returns array list of all contacts
    public ArrayList<Contact> getAllContacts() {
    	return contacts;
    }
    
    // clears array list of all contacts
    public void clearAllContacts() {
    	contacts.clear();
    }
}
