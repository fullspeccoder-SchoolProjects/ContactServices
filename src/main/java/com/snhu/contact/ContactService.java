package com.snhu.contact;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class ContactService {
    List<Contact> contacts;
    public ContactService() {
        contacts = new ArrayList<>();
    }

    public Contact getContact(String id) {
        if(id == null || id.isEmpty()) {
            throw new NullPointerException("Contact id cannot be null or empty");
        }
        for(Contact c : contacts) {
            if(c.getId().equals(id)) {
                return c;
            }
        }
        throw new IllegalArgumentException("Contact with id " + id + " not found");
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
        Contact newContact = new Contact(contact, id);
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
        AtomicBoolean hasUpdatedContact = new AtomicBoolean(false);
        contacts.forEach((contact) -> {
            if(contact.getId().equals(id)) {
                contact.setFirstName(firstName);
                contact.setLastName(lastName);
                contact.setPhoneNumber(phoneNumber);
                contact.setAddress(address);
                hasUpdatedContact.set(true);
            }
        });
        if(!hasUpdatedContact.get()) {
            throw new IllegalArgumentException("ID does not exist");
        }
    }
}
