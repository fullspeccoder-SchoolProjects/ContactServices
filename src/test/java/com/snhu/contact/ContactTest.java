package com.snhu.contact;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    @Test
    public void shouldCreateContactObject() {
        Contact contact1 = new Contact("5186", "Jacob", "Wilson", "5555555555", "Some address here");
        assertEquals(Contact.class, contact1.getClass());
    }

    @Test
    public void shouldNotCreateContactObjectWithNullId() {
        assertThrows(NullPointerException.class, () -> new Contact(null, "Jacob", "Wilson", "5555555555", "Some address here"));
    }

    @Test
    public void shouldNotCreateContactWithNullFirstName() {
        assertThrows(NullPointerException.class, () -> new Contact("5186", null, "Wilson", "5555555555", "Some address here"));
    }

    @Test
    public void shouldNotCreateContactWithNullLastName() {
        assertThrows(NullPointerException.class, () -> new Contact("5186", "Jacob", null, "5555555555", "Some address here"));
    }

    @Test
    public void shouldNotCreateContactWithNullPhoneNumber() {
        assertThrows(NullPointerException.class, () -> new Contact("5186", "Jacob", "Wilson", null, "Some address here"));
    }

    @Test
    public void shouldNotCreateContactWithNullAddress() {
        assertThrows(NullPointerException.class, () -> new Contact("5186", "Jacob", "Wilson", "5555555555", null));
    }

    @Test
    public void shouldNotCreateContactObjectFromContactObjectWithNullId() {
        assertThrows(NullPointerException.class, () -> new Contact(null, "Jacob", "Wilson", "5555555555", "Some address here"));
    }

    @Test
    public void shouldNotCreateContactObjectWithLongId() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("12235487841654874314857894", "Jacob", "Wilson", "5555555555", "Some address here"));
    }

    @Test
    public void shouldNotCreateContactWithLongFirstName() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("5186", "ughthesenamesaresosuperlongiwishthiswouldntactuallyexist", "Wilson", "5555555555", "Some address here"));
    }

    @Test
    public void shouldNotCreateContactWithLongLastName() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("5186", "Jacob", "flabergastingfabbernacketes", "5555555555", "Some address here"));
    }

    @Test
    public void shouldNotCreateContactWithTooShortPhoneNumber() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("5186", "Jacob", "Wilson", "555", "Some address here"));
    }

    @Test
    public void shouldNotCreateContactWithTooLongPhoneNumber() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("5186", "Jacob", "Wilson", "5555555555555555555555555", "Some address here"));
    }

    @Test
    public void shouldNotCreateContactWithLongAddress() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("5186", "Jacob", "Wilson", "5555555555", ";lknasdglkjbaesrlkgfj askljvh;ljkasdnjgfkjasdjvlkasdhdgkjaswhnflkjasdfnkjgasdoj;gn;ojasdhbkjaswejflkaswh;KFJ;NAWSELKJGJ"));
    }

    @Test
    public void shouldNotCreateContactObjectFromContactObjectWithLongId() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("1234561465687984645", "Jacob", "Wilson", "5555555555", "Some address here"));
    }

    @Test
    public void shouldNotCreateContactObjectWithLetteredId() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("1245a", "Jacob", "Wilson", "5555555555", "Some address here"));
    }

    @Test
    public void shouldNotCreateContactObjectWithLetteredPhoneNumber() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("245734", "Jacob", "Wilson", "654564asd", "Some address here"));
    }

    @Test
    public void createdContactObjectBeginsWithCapitalLetterFirstName() {
        Contact contact1 = new Contact("5186", "jacob", "Wilson", "5555555555", "Some address here");
        assertEquals("Jacob", contact1.getFirstName());
    }

    @Test
    public void createdContactObjectBeginsWithCapitalLetterLastName() {
        Contact contact1 = new Contact("5186", "Jacob", "wilson", "5555555555", "Some address here");
        assertEquals("Wilson", contact1.getLastName());
    }

    @Test
    public void createContactWithContactAndUniqueId() {
        Contact contact = new Contact("2186", "Jacob", "Wilson", "5555555555", "Some address here");
        Contact newContact = new Contact(contact, "5186");
        assertEquals("5186", newContact.getId());
    }

    @Test
    public void cannotCreateContactWithNullId() {
        Contact contact = new Contact("2186", "Jacob", "Wilson", "5555555555", "Some address here");
        assertThrows(NullPointerException.class, () -> new Contact(contact, null));
    }

    @Test
    public void cannotCreateContactWithLongId() {
        Contact contact = new Contact("2186", "Jacob", "Wilson", "5555555555", "Some address here");
        assertThrows(IllegalArgumentException.class, () -> new Contact(contact, "5165486484465489748"));
    }

    @Test
    public void canGetId() {
        Contact contact = new Contact("2186", "Jacob", "Wilson", "5555555555", "Some address here");
        assertEquals("2186", contact.getId());
    }

    @Test
    public void canGetFirstName() {
        Contact contact = new Contact("2186", "Jacob", "Wilson", "5555555555", "Some address here");
        assertEquals("Jacob", contact.getFirstName());
    }

    @Test
    public void canGetLastName() {
        Contact contact = new Contact("2186", "Jacob", "Wilson", "5555555555", "Some address here");
        assertEquals("Wilson", contact.getLastName());
    }

    @Test
    public void canGetPhoneNumber() {
        Contact contact = new Contact("2186", "Jacob", "Wilson", "5555555555", "Some address here");
        assertEquals("5555555555", contact.getPhoneNumber());
    }

    @Test
    public void canGetAddressName() {
        Contact contact = new Contact("2186", "Jacob", "Wilson", "5555555555", "Some address here");
        assertEquals("Some address here", contact.getAddress());
    }

    @Test
    public void canSetFirstName() {
        Contact contact = new Contact("2186", "Jacob", "Wilson", "5555555555", "Some address here");
        contact.setFirstName("Charles");
        assertEquals("Charles", contact.getFirstName());
    }

    @Test
    public void canSetLastName() {
        Contact contact = new Contact("2186", "Jacob", "Wilson", "5555555555", "Some address here");
        contact.setLastName("Finnegan");
        assertEquals("Finnegan", contact.getLastName());
    }

    @Test
    public void canSetPhoneNumber() {
        Contact contact = new Contact("2186", "Jacob", "Wilson", "5555555555", "Some address here");
        contact.setPhoneNumber("1234567890");
        assertEquals("1234567890", contact.getPhoneNumber());
    }

    @Test
    public void canSetAddress() {
        Contact contact = new Contact("2186", "Jacob", "Wilson", "5555555555", "Some address here");
        contact.setAddress("135 Duffy Street");
        assertEquals("135 Duffy Street", contact.getAddress());
    }
}