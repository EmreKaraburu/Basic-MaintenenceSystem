package Data_StructerMaintenence;

//Emre Karaburu


public class DoublyLinkedList {

    Node head;
    Node tail;

    public void addCountry(Country data) {
        Node Country = new Node(data);

        if (head == null) {
            head = Country;
            tail = Country;
        } else {
            tail.next = Country;
            Country.prev = tail;
            tail = Country;
        }
    }

    public void deleteCountry(String countryName) {
        Node current = head;

        while (current != null) {
            if (current.data.getName().equalsIgnoreCase(countryName)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }

                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }

                return;
            }
            current = current.next;
        }
    }

    public void printAllCountries() {
        Node current = head;
        int i = 1;

        while (current != null) {
            System.out.println(i + ". " + current.data.getName() + " " + current.data.getPopulation() + " " + current.data.getCapitalCity() + " " + current.data.getLargestCity() + " " + current.data.getCurrency());
            i++;
            current = current.next;
        }
    }
}
