import java.util.*;

public class ContactBook {
    private static class Contact {
        private String name;
        private String phone;
        private String email;
        private Contact next;


        public Contact(String name, String phone, String email) {
            this.name = name;
            this.phone = phone;
            this.email = email;
            this.next = null;
        }
    }
    Scanner sc = new Scanner(System.in);

    private Contact head = null;

    public void addContact() {
        System.out.print("Insert Name: ");
        String name = sc.next();
        System.out.print("Insert Phone Number: ");
        String number = sc.next();
        System.out.print("Insert Email Address: ");
        String email = sc.next();

        Contact newContact = new Contact(name, number, email);

        if (head == null){
            head = newContact;
        } else {
            Contact currentContact = head;
            while (currentContact.next != null){
                currentContact = currentContact.next;
            }
            currentContact.next = newContact;
        }
        System.out.println("Add contact successful!\n");
    }

    public void nameSearch(){
        System.out.print("Enter the name to search: ");
        String name = sc.next();
        Contact currentContact = head;
        boolean found = false;
        while (currentContact != null) {
            if(currentContact.name.equals(name)){
                System.out.println("\nName: " + currentContact.name);
                System.out.println("Phone Number: " + currentContact.phone);
                System.out.println("Email: " + currentContact.email + "\n");
                found = true;
                break;
            } else {
                currentContact = currentContact.next;
            }
        }

        if (found != true){
            System.out.println("This name is not found in the contact book");
        }
    }

    public void emailSearch(){
        System.out.print("Enter the email to search: ");
        String email = sc.next();
        Contact currentContact = head;
        boolean found = false;
        while (currentContact != null) {
            if(currentContact.email.equals(email)){
                System.out.println("\nName: " + currentContact.name);
                System.out.println("Phone Number: " + currentContact.phone);
                System.out.println("Email: " + currentContact.email + "\n");
                found = true;
                break;
            } else {
                currentContact = currentContact.next;
            }
        }

        if (found != true){
            System.out.println("This email is not found in the contact book");
        }
    }

    public void deleteContact(){
        Contact currentContact = head;
        if (head == null){
            System.out.println("You have no contact saved\n");
        } else {
            System.out.printf("Choose how you want to delete the contact: \n1. By Name\n2. By Phone Number\n3. By Email\n\nType the number: ");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    System.out.print("Enter the name you want to delete: ");
                    String name = sc.next();
                    if (head.name.equals(name)){
                        head = head.next;
                        System.out.println("Contact is successfully deleted!\n");
                        break;
                    }
                    while (currentContact != null){
                        if (currentContact.next != null && currentContact.next.name.equals(name)) {
                            currentContact.next = currentContact.next.next;
                            System.out.println("Contact is successfully deleted!\n");
                        }
                        currentContact = currentContact.next;
                    }
                    System.out.println("There is no contact found named " + name + "\n");
                    break;

                case 2:
                    System.out.print("Enter the phone number you want to delete: ");
                    String number = sc.next();
                    if (head.phone.equals(number)){
                        head = head.next;
                        System.out.println("Contact is successfully deleted!\n");
                        break;
                    } else {
                        while (currentContact != null){
                            if (currentContact.next != null && currentContact.next.phone.equals(number)) {
                                currentContact.next = currentContact.next.next;
                                System.out.println("Contact is successfully deleted!\n");
                            }
                            currentContact = currentContact.next;
                        }
                    }
                    System.out.println("There is no contact found with phone number " + number + "\n");
                    break;

                case 3:
                    System.out.print("Enter the email you want to delete: ");
                    String email = sc.next();
                    if (head.email.equals(email)){
                        head = head.next;
                        System.out.println("Contact is successfully deleted!\n");
                        break;
                    } else {
                        while (currentContact != null){
                            if (currentContact.next != null && currentContact.next.email.equals(email)) {
                                currentContact.next = currentContact.next.next;
                                System.out.println("Contact is successfully deleted!\n");
                            }
                            currentContact = currentContact.next;
                        }
                    }
                    System.out.println("There is no contact found with email " + email + "\n");

                default:
                    System.out.println("Choose a valid option\n");
                    break;
            }
        }
    }

    public void printList() {
        if (head != null) {
            Contact currentContact = head;
            while (currentContact != null) {
                System.out.println("\nName: " + currentContact.name);
                System.out.println("Phone Number: " + currentContact.phone);
                System.out.println("Email: " + currentContact.email);
                currentContact = currentContact.next;
            }
        } else {
            System.out.println("No contact saved.");
        }
        System.out.println("");
    }
}