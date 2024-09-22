import java.util.ArrayList;
import java.util.Scanner;

class Address {
    private String Name;
    private String phoneNumber;
    private String Email;

    public Address(String Name, String phoneNumber, String Email) {
        this.Name = Name;
        this.phoneNumber = phoneNumber;
        this.Email = Email;
    }

    public String getName() {
        return Name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    @Override
    public String toString() {
        return "Name: " + Name + ", Phone: " + phoneNumber + ", Email: " + Email;
    }
}

class AddressBook {
    private ArrayList<Address> Address;

    public AddressBook() {
        Address = new ArrayList<>();
    }

    public void addContact(Address address) {
        Address.add(address);
    }

    public void updateContact(String name, String newPhoneNumber, String newEmail) {
        for (Address contact : Address) {
            if (contact.getName().equals(name)) {
                contact.setPhoneNumber(newPhoneNumber);
                contact.setEmail(newEmail);
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    public void deleteContact(String name) {
        Address.removeIf(contact -> contact.getName().equals(name));
    }

    public void displayContacts() {
        for (Address contact : Address) {
            System.out.println(contact);
        }
    }
}

public class AddressBookApp {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Contact\n2. Update Contact\n3. Delete Contact\n4. Display Contacts\n5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Phone Number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    addressBook.addContact(new Address(name, phoneNumber, email));
                    break;
                case 2:
                    System.out.print("Name of the contact to update: ");
                    String updateName = scanner.nextLine();
                    System.out.print("New Phone No.: ");
                    String newPhone = scanner.nextLine();
                    System.out.print("New Email: ");
                    String newEmailInput = scanner.nextLine();
                    addressBook.updateContact(updateName, newPhone, newEmailInput);
                    break;
                case 3:
                    System.out.print("Name of the contact to delete: ");
                    String deleteName = scanner.nextLine();
                    addressBook.deleteContact(deleteName);
                    break;
                case 4:
                    addressBook.displayContacts();
                    break;
                case 5:
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
