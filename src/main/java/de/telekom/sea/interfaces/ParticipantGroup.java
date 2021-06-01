package de.telekom.sea.interfaces;

public class ParticipantGroup extends BaseObject implements MyList {
    private int LENGTH;
    private Object[] participants;

 public  MyList search(String searchSurname) {
     MyList sublist = new ParticipantGroup(LENGTH);

     for (int i = 0; i < size(); i++) {
         Object obj = participants[i];
         Person person = (Person) obj;
         String surname = person.getSurname();


         if (surname.startsWith(searchSurname)) {
             sublist.add(person);
             System.out.println(surname);

         }
     }
     return sublist;
 }

    public ParticipantGroup(int length) {
        this.LENGTH = length;
        this.participants =new Person[LENGTH];
    }

    public boolean add(Object obj) {
        if (size() == participants.length) {
            System.out.println("Sorry! No more places");
            throw new RuntimeException("RuntimeException. Please check i");
                    }
        if (obj == null) {
            System.out.println("Sorry! Null is not a valid person");
            return false;
        }
        if (!(obj instanceof Person)) {
            System.out.println("It`s not a person");
            return false;
        }
        Person person = (Person) obj;
        for (int i = 0; i < participants.length; i++) {
            if (participants[i] != null && participants[i].equals(person)) {
                System.out.println("Person was already added");
                return false;
            }
        }
        if (size() < participants.length) {
            participants[size()] = person;
            System.out.println(person.getSurname() + " " + person.getName()  + " added to the list under #" + size() + ".");
            return true;
        }
       return false;
    }

    public int size(){
        int i =0;
       while (i<participants.length && participants[i]!=null)   //oder <= hier?
           i++;
       return i;
    }

    public void clear (){
        this.participants = new Person [participants.length];
    }

    public Person get (int i) {
        if (i < participants.length&& i>=0) {
            return (Person) participants[i];
        } else {
            throw new RuntimeException("RuntimeException. Method get");
        }
    }

    public boolean remove (Object obj) {
     System.out.println("Remove person from the list");
        if (obj == null) {
            System.out.println("Person was not added, can not perform delete");
            return false;
        }
        if (!(obj instanceof Person)){
            return false;
        }
        Person person = (Person) obj;
        for (int i = 0; i < participants.length; i++) {
            if (person.equals(participants[i])) {
                System.out.println("Deleting element " + i + "...");
                for (int j = i; j < (participants.length - 1); j++) {

                    participants[j] = participants[j + 1];
                }
                participants[participants.length - 1] = null;
                System.out.println("Element " + i + " was deleted from the list of participants (" + person.getName() + " " + person.getSurname() + ").");
                return true;
            }
        }
        System.out.println("Can't be deleted. " + person.getName() + " " + person.getSurname() + "is not found in the list.");
        return false;
    }
}
