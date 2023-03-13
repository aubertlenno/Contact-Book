import java.util.*;

public class Main {
    public static void main(String[] args)
    {
        ContactBook contactBook = new ContactBook();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("***************************");
            System.out.println("(A)dd");
            System.out.println("(D)elete");
            System.out.println("(E)mail Search");
            System.out.println("(P)rint List");
            System.out.println("(S)earch");
            System.out.println("(Q)uit");
            System.out.println("***************************");

            System.out.print("Please enter a command: ");

            char command = sc.next().charAt(0);
            switch (command) {
                case 'A':
                    contactBook.addContact();
                    break;
                case 'D':
                    contactBook.deleteContact();
                    break;
                case 'E':
                    contactBook.emailSearch();
                    break;
                case 'P':
                    contactBook.printList();
                    break;
                case 'S':
                    contactBook.nameSearch();
                    break;
                case 'Q':
                    System.out.println("Thank you for using this phone book");
                    System.exit(0);
                default:
                    System.out.println("Please enter a valid command!");
                    break;
            }
        }
    }
}