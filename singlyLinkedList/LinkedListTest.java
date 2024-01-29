package singlyLinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedListImplementation myLinkedList =  new LinkedListImplementation();
        myLinkedList.addAtEnd(10);
        myLinkedList.addAtEnd(30);
        myLinkedList.addAtEnd(16);
        myLinkedList.addAtEnd(28);
        myLinkedList.addAtEnd(72);
        myLinkedList.display();
        myLinkedList.addAtBeginning(99);
        myLinkedList.display();
        myLinkedList.addInBetween(23, 2);
        myLinkedList.display();

        // myLinkedList.deleteFromEnd();
        // myLinkedList.display();
        // myLinkedList.deleteFromBeginning();
        // myLinkedList.display();
        // myLinkedList.deleteInBetween(1);
        // myLinkedList.display();
        // myLinkedList.deleteInBetween(2);
        // myLinkedList.display();
        // myLinkedList.deleteInBetween(0);
        // myLinkedList.display();
        // myLinkedList.swapNodes(3, 4);

        System.out.println("Before Swap Nodes");
        myLinkedList.display();
        myLinkedList.swapNodes(3, 6);
        System.out.println("After Swap Nodes");
        myLinkedList.display();
    }
}
