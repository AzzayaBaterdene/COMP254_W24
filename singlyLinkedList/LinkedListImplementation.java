package singlyLinkedList;

public class LinkedListImplementation {
    // Instance variables for the Singly linked list
    private Node head;
    private Node tail;
    private int size;  // number of nodes in the linked list

    // Constructor

    public LinkedListImplementation(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Adding a node at the end 
    // parameter is just integer data
    public void addAtEnd(int data){
        // Creating a new Node
        Node newNode = new Node(data);
        if(head == null){
            this.head = newNode;
            this.tail = newNode;
            size++;
        } else {
            this.tail.setNext(newNode);
            this.tail = newNode; //point the tail to the new setted node! IMPORTANT
            size++;
        }
    }

    public void addAtBeginning(int data){
        Node newNode = new Node(data);
        if(head == null){
            this.head = newNode;
            this.tail = newNode;
            size++;
        } else {
            newNode.setNext(head);
            this.head = newNode;
            size++;
        }
    }

    public void addInBetween(int data, int index){
        Node newNode = new Node(data);
        if(head == null || index <= 0){
            this.head = newNode;
            this.tail = newNode;
            size++;
        } else {
            Node curr = head; //curr will be used for traversing 
            for(int i=0; i<index; i++){
                curr = curr.getNext();
            }

            if(curr != null){
                newNode.setNext(curr.getNext());
                curr.setNext(newNode);
            }
            size++;
        }
    }

    public void deleteFromEnd(){
        if(head == null){
            return;
        }
        if (head == tail) {
            // Only one node in the list
            head = tail = null;
            size--;
            return;
        }

        Node curr = head;
        while(curr.getNext() != tail){
            curr = curr.getNext();
        }

        curr.setNext(null);
        tail = curr;
        size--;
    }

    public void deleteFromBeginning(){
        if (head == null){
            return;
        }

        if(head == tail){
            head = tail = null;
            size--;
        }else {
            head = head.getNext();
            size--;
        }
    }

    public void deleteInBetween(int index){
        if (head == null){
            return;
        }

        if(head == tail || index == 0){
            deleteFromBeginning();
        }else {
            Node curr = head;
            for(int i=0; i<index-1; i++){
                curr = curr.getNext();
            }
            curr.setNext(curr.getNext().getNext());
            if (curr.getNext() == null) {
                // If the removed node was the last node, update tail
                tail = curr;
            }
            size--;
        }
    }
    
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println("\nTotal numbers of nodes in the list: " + size);
    }

    public void swapNodes(int position1, int position2) {
        // Check positions 
        if (position1 <= 0 || position2 <= 0 || position1 > size || position2 > size || position1 == position2) {
            return;
        }

        // Find the nodes at their positions
        Node prev1 = null, curr1 = head;  // Dummy node
        for (int i = 1; i < position1; i++) {
            prev1 = curr1;
            curr1 = curr1.getNext();
        }

        Node prev2 = null, curr2 = head;
        for (int i = 1; i < position2; i++) {
            prev2 = curr2;
            curr2 = curr2.getNext();
        }

        // Swap nodes 
        if (prev1 != null) {
            prev1.setNext(curr2);
        } else {
            head = curr2;
        }

        if (prev2 != null) {
            prev2.setNext(curr1);
        } else {
            head = curr1;
        }

        // Link nodes to the next node to make link complete 
        Node temp = curr1.getNext();
        curr1.setNext(curr2.getNext());
        curr2.setNext(temp);

        // Update tail if necessary
        if (tail == curr1) {
            tail = curr2;
        } else if (tail == curr2) {
            tail = curr1;
        }
    }
}
