package com.snhu.contact;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class ContactService {
    List<Contact> contacts;
    public ContactService() {
        contacts = new ArrayList<Contact>();
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    void addContact(String id, String firstName, String lastName, String phoneNumber, String address) {
        contacts.forEach((contact) -> {
            if (contact.getId().equals(id)) {
                throw new IllegalArgumentException("ID exists in another contact");
            }
        });
        Contact newContact = new Contact(id, firstName, lastName, phoneNumber, address);
        contacts.add(newContact);
    }

    void addContact(Contact contact) {
        contacts.forEach((c) -> {
            if (c.getId().equals(contact.getId())) {
                throw new IllegalArgumentException("ID exists in another contact");
            }
        });
        contacts.add(contact);
    }

    void addContact(Contact contact, String id) {
        contacts.forEach((c) -> {
            if (c.getId().equals(id)) {
                throw new IllegalArgumentException("Cannot add contact because id exists in another contact");
            }
        });
        Contact newContact = new Contact(id, contact.getFirstName(), contact.getLastName(), contact.getPhoneNumber(), contact.getAddress());
        contacts.add(newContact);
    }

    void deleteContact(Contact contact) {
        if(!contacts.removeIf(c -> c.getId().equals(contact.getId()))) {
            throw new IllegalArgumentException("ID does not exist");
        }
    }

    void deleteContact(String id) {
        if(!contacts.removeIf(c -> c.getId().equals(id))) {
            throw new IllegalArgumentException("ID does not exist");
        }
    }

    void updateContact(String id, String firstName, String lastName, String phoneNumber, String address) {
        if(id == null) {
            throw new NullPointerException("ID is null");
        }
        AtomicBoolean updatedContact = new AtomicBoolean(false);
        contacts.forEach((contact) -> {
            if(contact.getId().equals(id)) {
                contact.setFirstName(firstName);
                contact.setLastName(lastName);
                contact.setPhoneNumber(phoneNumber);
                contact.setAddress(address);
                updatedContact.set(true);
            }
        });
        if(!updatedContact.get()) {
            throw new IllegalArgumentException("ID does not exist");
        }
    }
}
