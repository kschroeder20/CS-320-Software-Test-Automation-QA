import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactTest {
	private Contact contact;
	
	@BeforeEach
	public void init(){
		contact = new Contact("aa", "foo", "bar", "1111111111", "foobar street");
	}

	@Test
	void testContactConstructor() {
		assertTrue(contact.getId().equals("aa"));
		assertTrue(contact.getFirstName().equals("foo"));
		assertTrue(contact.getLastName().equals("bar"));
		assertTrue(contact.getPhone().equals("1111111111"));
		assertTrue(contact.getAddress().equals("foobar street"));
	}
	
	@Test
	void testIdValidation() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("aaaaaaaaaaaaaaaaaaa", "foo", "bar", "1111111111", "foobar street");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setId("aaaaaaaaaaaaaaaaaaa");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "foo", "bar", "1111111111", "foobar street");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setId(null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("", "foo", "bar", "1111111111", "foobar street");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setId("");
		});
	}
	
	@Test
	void testFirstNameValidation() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("aaa", "fooooooooooooo", "bar", "1111111111", "foobar street");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setFirstName("fooooooooooooo");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("aaa", null, "bar", "1111111111", "foobar street");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setFirstName(null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("aaa", "", "bar", "1111111111", "foobar street");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setFirstName("");
		});
	}
	
	@Test
	void testLastNameValidation() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("aaa", "foo", "barrrrrrrrrrrrrrrrrrrrrrr", "1111111111", "foobar street");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setLastName("barrrrrrrrrrrrrrrrrrrrrrr");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("aaa", "foo", null, "1111111111", "foobar street");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setLastName(null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("aaa", "foo", "", "1111111111", "foobar street");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setLastName("");
		});
	}
	
	@Test
	void testPhoneValidation() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("aaa", "foo", "bar", "111111111111", "foobar street");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhone("111111111111");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("aaa", "foo", "bar", "1111111", "foobar street");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhone("1111111");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("aaa", "foo", "bar", "", "foobar street");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhone("");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("aaa", "foo", "bar", null, "foobar street");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhone(null);
		});
	}
	
	@Test
	void testAddressValidation() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("aaa", "foo", "bar", "1111111111", "foobar streettttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setAddress("foobar streettttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("aaa", "foo", "bar", "1111111111", "");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setAddress("");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("aaa", "foo", "bar", "1111111111", null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setAddress(null);
		});
	}
	
	@Test
	void testSetters() {
		contact.setId("bbb");
		assertTrue(contact.getId().equals("bbb"));
		
		contact.setFirstName("fooish");
		assertTrue(contact.getFirstName().equals("fooish"));
		
		contact.setLastName("barish");
		assertTrue(contact.getLastName().equals("barish"));
		
		contact.setPhone("2222222222");
		assertTrue(contact.getPhone().equals("2222222222"));
		
		contact.setAddress("fooish barish street");
		assertTrue(contact.getAddress().equals("fooish barish street"));
	}
}
