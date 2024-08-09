package com.snhu.contact;

public class Contact {
    final private String id; // cannot be null or updatable
    private String firstName; // cannot be null
    private String lastName; // cannot be null
    private String phoneNumber; // cannot be null
    private String address; // cannot be null

    public Contact(String id, String firstName, String lastName, String phoneNumber, String address) {
        checkIfPhraseIsNullOrEmpty(id);
        checkIfPhraseIsNullOrEmpty(firstName);
        checkIfPhraseIsNullOrEmpty(lastName);
        checkIfPhraseIsNullOrEmpty(phoneNumber);
        checkIfPhraseIsNullOrEmpty(address);

        if (phoneNumber.length() != 10) {
            throw new IllegalArgumentException("phoneNumber is too long or too short");
        }
        checkLengthOfPhrase(id, 10);
        checkLengthOfPhrase(firstName, 10);
        checkLengthOfPhrase(lastName, 10);
        checkLengthOfPhrase(address, 30);
        checkIfAllDigits(id);
        checkIfAllDigits(phoneNumber);

        this.id = id;
        this.firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
        this.lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1);
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Contact(Contact contact, String id) {
        checkIfPhraseIsNullOrEmpty(id);
        checkLengthOfPhrase(id, 10);
        checkIfAllDigits(id);
        this.id = id;
        this.firstName = contact.firstName;
        this.lastName = contact.lastName;
        this.phoneNumber = contact.phoneNumber;
        this.address = contact.address;
    }

//    Getters and Setters

    public String getId() {
        return id;
    }
    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setAddress(String address) {
        checkIfPhraseIsNullOrEmpty(address);
        checkLengthOfPhrase(address, 30);
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        checkIfPhraseIsNullOrEmpty(phoneNumber);
        checkLengthOfPhrase(phoneNumber, 30);
        this.phoneNumber = phoneNumber;
    }

    public void setLastName(String lastName) {
        checkIfPhraseIsNullOrEmpty(lastName);
        checkLengthOfPhrase(lastName, 30);
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        checkIfPhraseIsNullOrEmpty(firstName);
        checkLengthOfPhrase(firstName, 30);
        this.firstName = firstName;
    }

    private void checkIfAllDigits(String phrase) {
        if(!phrase.matches("[0-9]+")) {
            throw new IllegalArgumentException(String.format("%s is invalid", phrase));
        }
    }

    private void checkLengthOfPhrase(String phrase, int length) {
        if(phrase.length() > length) {
            throw new IllegalArgumentException(String.format("%s is too long", phrase));
        }
    }

    private void checkIfPhraseIsNullOrEmpty(String phrase) {
        if(phrase == null || phrase.isEmpty()) {
            throw new NullPointerException("phrase is null or empty");
        }
    }
}

// Refactored code

//        if(!id.matches("[0-9]+")) {
//            throw new IllegalArgumentException("id is invalid");
//        }

//        if(!phoneNumber.matches("[0-9]+")) {
//            throw new IllegalArgumentException("phone number is invalid");
//        }

//        if(id.length() > 10) {
//        throw new IllegalArgumentException("id is too long");
//        }
//                if(firstName.length() > 10) {
//        throw new IllegalArgumentException("firstName is too long");
//        }
//                if(lastName.length() > 10) {
//        throw new IllegalArgumentException("lastName is too long");
//        }
