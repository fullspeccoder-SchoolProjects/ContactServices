package com.snhu.contact;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    @Test
    public void canGetContactWithId() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact("2186", "Jacob", "Wilson", "5555555555", "100 Slew Crew Ct, St. Louis");
        service.addContact(contact1);
        assertEquals("Jacob", service.getContact("2186").getFirstName());
    }

    @Test
    public void canGetAddressWithUniqueId() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact("2186", "Jacob", "Wilson", "5555555555", "100 Slew Crew Ct, St. Louis");
        service.addContact(contact1);
        assertEquals("100 Slew Crew Ct, St. Louis", service.getContact("2186").getAddress());
    }

    @Test
    public void canGetPhoneNumberWithUniqueId() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact("2186", "Jacob", "Wilson", "5555555555", "100 Slew Crew Ct, St. Louis");
        service.addContact(contact1);
        assertEquals("5555555555", service.getContact("2186").getPhoneNumber());
    }

    @Test
    public void cannotGetContactWithNullId() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact("2186", "Jacob", "Wilson", "5555555555", "100 Slew Crew Ct, St. Louis");
        service.addContact(contact1);
        assertThrows(NullPointerException.class, () -> service.getContact(null));
    }

    @Test
    public void cannotGetContactWithEmptyId() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact("2186", "Jacob", "Wilson", "5555555555", "100 Slew Crew Ct, St. Louis");
        service.addContact(contact1);
        assertThrows(NullPointerException.class, () -> service.getContact(""));
    }

    @Test
    public void cannotGetContactWithNonexistentId() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact("2186", "Jacob", "Wilson", "5555555555", "100 Slew Crew Ct, St. Louis");
        service.addContact(contact1);
        assertThrows(IllegalArgumentException.class, () -> service.getContact("5186"));
    }

    @Test
    public void addContact() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact("2186", "Jacob", "Wilson", "5555555555", "100 Slew Crew Ct, St. Louis");
        service.addContact(contact1);
        assertEquals("Jacob", service.getContact("2186").getFirstName());
    }

    @Test
    public void addContactWithParams() {
        ContactService service = new ContactService();
        service.addContact("2186", "Jacob", "Wilson", "5555555555", "100 Slew Crew Ct, St. Louis");
        assertEquals("Wilson", service.getContact("2186").getLastName());
    }

    @Test
    public void addContactWithContactId() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact("2186", "Jacob", "Wilson", "5555555555", "100 Slew Crew Ct, St. Louis");
        Contact contact2 = new Contact("2186", "Jacob", "Wilson", "5555555555", "100 Slew Crew Ct, St. Louis");
        service.addContact(contact1);
        assertThrows(IllegalArgumentException.class, () -> service.addContact(contact2));
    }

    @Test
    public void addContactWithUniqueId() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact("2186", "Jacob", "Wilson", "5555555555", "100 Slew Crew Ct, St. Louis");
        Contact contact2 = new Contact("5186", "Charles", "Xavier", "5555555555", "100 Slew Crew Ct, St. Louis");
        service.addContact(contact1);
        service.addContact(contact2);
        assertEquals("Charles", service.getContact("5186").getFirstName());
    }

    @Test
    public void addContactWithContactAndUniqueId() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact("2186", "Jacob", "Wilson", "5555555555", "100 Slew Crew Ct, St. Louis");
        Contact contact2 = new Contact("2186", "Charles", "Xavier", "5555555555", "100 Slew Crew Ct, St. Louis");
        String id = "5186";
        service.addContact(contact1);
        service.addContact(contact2, id);
        assertEquals("Charles", service.getContact("5186").getFirstName());
    }

    @Test
    public void doesntAddContactWithUniqueId() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact("2186", "Jacob", "Wilson", "5555555555", "100 Slew Crew Ct, St. Louis");
        service.addContact(contact1);
        assertThrows(IllegalArgumentException.class, () -> service.addContact("2186", "Jacob", "Wilson", "5555555555", "100 Slew Crew Ct, St. Louis"));
    }

    @Test
    public void doesntAddContactWithContactAndUniqueId() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact("2186", "Jacob", "Wilson", "5555555555", "100 Slew Crew Ct, St. Louis");
        Contact contact2 = new Contact("2186", "Jacob", "Wilson", "5555555555", "100 Slew Crew Ct, St. Louis");
        String id = "2186";
        service.addContact(contact1);
        assertThrows(IllegalArgumentException.class, () -> service.addContact(contact2, id));
    }

    @Test
    public void cannotAddContactWithLongId() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, () -> service.addContact("5646545645648941", "Jacob", "Wilson", "5555555555", "100 Slew Crew Ct, St. Louis"));
    }

    @Test
    public void cannotAddContactWithFirstName() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, () -> service.addContact("5646", "Jacobl;kjhasddghbasdhfashdlkjhjkasdf", "Wilson", "5555555555", "100 Slew Crew Ct, St. Louis"));
    }

    @Test
    public void cannotAddContactWithLastName() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, () -> service.addContact("5646", "Jacob", "asdfasgasdfgasdfasdfasdfasdfasdfsadfasdfsadf", "5555555555", "100 Slew Crew Ct, St. Louis"));
    }

    @Test
    public void cannotAddContactWithLongPhoneNumber() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, () -> service.addContact("5646", "Jacob", "Wilson", "454645498444897445487944644", "100 Slew Crew Ct, St. Louis"));
    }

    @Test
    public void cannotAddContactWithLongAddress() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, () -> service.addContact("5646", "Jacob", "Wilson", "5555555555", "100 Slew Cr;lkjhasdgjh;asdjflkasdjflk;masmd;lkfjmasd;lkfj;lkasdfj;klasdjflk/asjd;lkfjasdlkfgjkl/asdfgjkl;asdjfg;lkasdj;klfjnasdkl.jads;lfgjn;jlkasgfhnj;asdnfgew Ct, St. Louis"));
    }

    @Test
    public void cannotAddContactWithNullId() {
        ContactService service = new ContactService();
        assertThrows(NullPointerException.class, () -> service.addContact(null, "Jacob", "Wilson", "5555555555", "100 Slew Crew Ct, St. Louis"));
    }

    @Test
    public void cannotAddContactWithEmptyId() {
        ContactService service = new ContactService();
        assertThrows(NullPointerException.class, () -> service.addContact(null, "Jacob", "Wilson", "5555555555", "100 Slew Crew Ct, St. Louis"));
    }

    @Test
    public void doesntAddContactWithAlphabeticPhoneNumber() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, () -> service.addContact("2186", "Jacob", "Wilson", "55a5555555", "100 Slew Crew Ct, St. Louis"));
    }

    @Test
    public void deleteContact() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact("2186", "Jacob", "Wilson", "5555555555", "100 Slew Crew Ct, St. Louis");
        service.addContact(contact1);
        service.deleteContact(contact1);
        assertThrows(IllegalArgumentException.class, () -> service.getContact("2186"));
    }

    @Test
    public void deleteContactWithUniqueId() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact("2186", "Jacob", "Wilson", "5555555555", "100 Slew Crew Ct, St. Louis");
        service.addContact(contact1);
        service.deleteContact("2186");
        assertThrows(IllegalArgumentException.class, () -> service.getContact("2186"));
    }

    @Test
    public void doesntDeleteContactWithUniqueId() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact("2186", "Jacob", "Wilson", "5555555555", "100 Slew Crew Ct, St. Louis");
        service.addContact(contact1);

        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("5186"));
    }

    @Test
    public void doesntDeleteContactWithNonExistentContact() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact("2186", "Jacob", "Wilson", "5555555555", "100 Slew Crew Ct, St. Louis");

        assertThrows(IllegalArgumentException.class, () -> service.deleteContact(contact1));
    }

    @Test
    public void updateContactWithUniqueId() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact("2186", "Jacob", "Wilson", "5555555555", "100 Slew Crew Ct, St. Louis");
        service.addContact(contact1);
        service.updateContact("2186", "Charles", "Finnegan", "1234567890", "135 Duffy Street");
        assertEquals("Charles", service.getContact("2186").getFirstName());

    }

    @Test
    public void doesntUpdateContactWithNullId() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact("2186", "Jacob", "Wilson", "5555555555", "100 Slew Crew Ct, St. Louis");
        service.addContact(contact1);
        assertThrows(NullPointerException.class, () -> service.updateContact(null, "Charles", "Finnegan", "1234567890", "135 Duffy Street"));

    }

    @Test
    public void doesntUpdateContactWithNonExistentId() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact("2186", "Jacob", "Wilson", "5555555555", "100 Slew Crew Ct, St. Louis");
        service.addContact(contact1);
        assertThrows(IllegalArgumentException.class, () -> service.updateContact("5186", "Charles", "Finnegan", "1234567890", "135 Duffy Street"));

    }
}