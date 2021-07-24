import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactServiceTest {
	private static ContactService contactService = new ContactService();
	private Contact contact;
	
    @BeforeEach 
    void init() {
    	contactService.clearAllContacts();
        contact = contactService.createContact("aa", "foo", "bar", "1111111111", "foobar street");
    }

	@Test
	void testCreateContactMethodCreatesContact() {
		assertTrue(contact.getId().equals("aa"));
		assertTrue(contact.getFirstName().equals("foo"));
		assertTrue(contact.getLastName().equals("bar"));
		assertTrue(contact.getPhone().equals("1111111111"));
		assertTrue(contact.getAddress().equals("foobar street"));
	}
	
	@Test
	void testCreateContactMethodIdValidation() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.createContact("aa", "foo", "bar", "1111111111", "foobar street");
		});
	}
	
	@Test
	void testEditContact() {
		contactService.editContact(contact.getId(), "firstName", "fooish");
		contactService.editContact(contact.getId(), "lastName", "barish");
		contactService.editContact(contact.getId(), "phone", "2222222222");
		contactService.editContact(contact.getId(), "address", "foobarish street");
		
		assertTrue(contact.getFirstName().equals("fooish"));
		assertTrue(contact.getLastName().equals("barish"));
		assertTrue(contact.getPhone().equals("2222222222"));
		assertTrue(contact.getAddress().equals("foobarish street"));
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.editContact(contact.getId(), "test", "fooish");
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.editContact("bb",  "firstName", "fooish");
		});
	}
	
	@Test
	void testRemoveContact() {
		assertEquals(1,contactService.getAllContacts().size());
		contactService.removeContact(contact.getId());
		assertEquals(0,contactService.getAllContacts().size());
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.removeContact("bbb");
		});		
	}

}
