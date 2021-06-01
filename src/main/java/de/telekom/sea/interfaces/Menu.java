package de.telekom.sea.interfaces;


import java.io.Closeable;
import java.io.IOException;
import java.util.Scanner;

public class Menu implements MyMenu, Closeable {
    private MyList myList;

    public void close () throws IOException {
        System.out.println("is closed");
    }

    public Menu(MyList myList) {
        this.myList = myList;
    }

    public void testListe(){
        MyList subliste = new ParticipantGroup(3);
        Person person1 =new Person("Anna","Frank");
        subliste.add(person1);
        Person person2 =new Person("Anka","Frank");
        subliste.add(person2);
        Person person3 =new Person("Alfred","Rank");
        subliste.add(person3);
    };
    public void setMyList(MyList myList) {
        this.myList = myList;
        System.out.println("Method setMyList was successfully performed: " + myList);

    }

    public void keepAsking() {
        String result;
        do {
            showMenu();
            result = checkMenu();
        }
        while (!result.equals("0"));

    }


    public void showMenu() {
        System.out.println("1 - input person");
        System.out.println("2 - show size");
        System.out.println("3 - list all persons");
        System.out.println("4 - remove all");
        System.out.println("5 - remove person");
        System.out.println("6 - search person by surname");
        System.out.println("0 - exit");
    }

    public void inputPerson() {
        System.out.println("Enter Name of person.");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Enter Surname of person.");
        String surname = scanner.nextLine();
        Person person = new Person();
        person.setName(name);
        person.setSurname(surname);
        myList.add(person);
        System.out.println("Your person" + name + " " + surname + " was added");
    }

    public void inputSearch() {
        System.out.println("Enter Surname of person.");
        Scanner scanner = new Scanner(System.in);
        String surname = scanner.nextLine();
        MyList sublist = myList.search(surname);
        this.listAllPersons();
    }


    public void listAllPersons() {

        System.out.println("############### Persons List ###############");
        for (int i = 0; i < myList.size();  i++){
            Object obj = myList.get(i);
            if (obj != null) {
                Person person = (Person) obj;
                System.out.println((i+1) + ". " + person.getSurname() + " " + person.getName());
            }
        }
        System.out.println("Persons count: " + myList.size() + ".");

    }

    public void removeAll() {
        myList.clear();
    }

    public void removePerson() {
       System.out.println("Input person's index to delete: ");
       int i = Integer.parseInt(inputLine());
       myList.remove(i);
    }


    public String checkMenu() {
        String result;
        result = inputLine();
        switch (result) {
            case "1":
                System.out.println("It's 1. Input person.");
                inputPerson();
                break;
            case "2":
                System.out.println("It's 2. Show size.");
                showSize();
                break;
            case "3":
                System.out.println("It's 3. List all persons.");
                listAllPersons();
                break;
            case "4":
                System.out.println("It's 4. Remove all.");
                removeAll();
                break;
             case "5":
                 System.out.println("It's 5. Remove one person from the list.");
                 removePerson();
                 break;
            case "6":
                System.out.println("It's 6. Search person from the list.");
                inputSearch();
                break;
            case "0":
                System.out.println("It's 0. Exit.");
                break;
            default:
                System.out.println("Please chose an valid number. To show all options input 1. 0 to exit.");
        }
        return result;
    }

    public String inputLine() {

        String result = "";
        Scanner scanner = new Scanner(System.in);
        result = scanner.nextLine();
        return result;
    }

    public void showSize() {
        System.out.println("There are " + myList.size() + " element(s) in the list.");
    }
}