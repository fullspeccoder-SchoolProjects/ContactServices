package com.snhu.contact;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {
    @Test
    public void addContact() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact("2186", "Jacob", "Wilson", "5555555555", "100 Slew Crew Ct, St. Louis");
        service.addContact(contact1);
        assertEquals(contact1, service.getContacts().getFirst());
    }

    @Test
    public void addContactWithParams() {
        ContactService service = new ContactService();
        service.addContact("2186", "Jacob", "Wilson", "5555555555", "100 Slew Crew Ct, St. Louis");
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
        Contact contact2 = new Contact("5186", "Jacob", "Wilson", "5555555555", "100 Slew Crew Ct, St. Louis");
        service.addContact(contact1);
        service.addContact(contact2);
        assertEquals(contact2, service.getContacts().get(1));
    }

    @Test
    public void addContactWithContactAndUniqueId() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact("2186", "Jacob", "Wilson", "5555555555", "100 Slew Crew Ct, St. Louis");
        Contact contact2 = new Contact("2186", "Jacob", "Wilson", "5555555555", "100 Slew Crew Ct, St. Louis");
        String id = "5186";
        service.addContact(contact1);
        service.addContact(contact2, id);
        assertNotEquals(contact2.getId(), service.getContacts().get(1).getId());
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
    public void deleteContact() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact("2186", "Jacob", "Wilson", "5555555555", "100 Slew Crew Ct, St. Louis");
        service.addContact(contact1);
        service.deleteContact(contact1);
        assertEquals(0, service.getContacts().size());
    }

    @Test
    public void deleteContactWithUniqueId() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact("2186", "Jacob", "Wilson", "5555555555", "100 Slew Crew Ct, St. Louis");
        service.addContact(contact1);
        service.deleteContact("2186");
        assertEquals(0, service.getContacts().size());
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
        assertEquals("Charles", service.getContacts().getFirst().getFirstName());

    }

    @Test
    public void updateContactWithNullId() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact("2186", "Jacob", "Wilson", "5555555555", "100 Slew Crew Ct, St. Louis");
        service.addContact(contact1);
        assertThrows(NullPointerException.class, () -> service.updateContact(null, "Charles", "Finnegan", "1234567890", "135 Duffy Street"));

    }

    @Test
    public void updateContactWithNonExistentId() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact("2186", "Jacob", "Wilson", "5555555555", "100 Slew Crew Ct, St. Louis");
        service.addContact(contact1);
        assertThrows(IllegalArgumentException.class, () -> service.updateContact("5186", "Charles", "Finnegan", "1234567890", "135 Duffy Street"));

    }
}