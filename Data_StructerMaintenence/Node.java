package Data_StructerMaintenence;

//Emre Karaburu

public class Node {
    
    Node next;
    Node prev;
    Country data;
   

    public Node(Country data) {
        
        this.prev = null;
        this.next = null;
        this.data = data;
   } 
}