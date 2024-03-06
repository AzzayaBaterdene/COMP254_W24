package doublyLinkedList;

// Used Nested Class structure
public class DoublyLinkedList {
    private static class Node {
        private Integer data;
        private Node prev;
        private Node next;

        public Node (int data){
            this.data = data;
            this.prev = this.next = null;
        }

        public Node(Integer data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        public Integer getData() { return data; }
        public Node getPrev() { return prev; }
        public Node getNext() { return next; }

        public void setPrev(Node prev) { this.prev = prev; }
        public void setNext(Node next) { this.next = next; }
    }

    private Node header;
    private Node trailer;
    private int size;

    public DoublyLinkedList() {
        header = new Node(null, null, null);
        trailer = new Node(null, header, null);  // tail is linked to its header
        header.setNext(trailer);
        size = 0;
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public void addFirst(Integer data) {
        // (data, header.setNext, header.getNext.setPrev)
        addBetween(data, header, header.getNext());
    }

    public void addLast(Integer data) {
        addBetween(data, trailer.getPrev(), trailer);
    }

   

    private void addBetween(Integer data, Node prev, Node next) {
        Node newNode = new Node(data, prev, next);
        // System.err.println("next" + next.getData());
        prev.setNext(newNode);
        next.setPrev(newNode);
        size++;
    }

    // Add between nodes based on its index/position
    public void addAfterPosition(Integer data, int position) throws IndexOutOfBoundsException {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }

        Node current;
        // Decide whether to traverse from the beginning or end based on the position
        if (position < size / 2) {
            current = header;
            // best practice was star i=1...!!!
            for (int i = 1; i <= position; i++) {
                current = current.getNext();
            }
        } else {
            current = trailer;
            for (int i = size; i >= position; i--) {
                current = current.getPrev();
            }
        }
        addBetween(data, current, current.getNext());
    }

    private void removeNode(Node node) {
        Node prev = node.getPrev();
        Node next = node.getNext();

        prev.setNext(next);
        next.setPrev(prev);

        size--;
    }
    
    public void removeFromBeginning() {
        if (!isEmpty()) {
            removeNode(header.getNext());
        }
    }

    public void removeFromLast() {
        if (!isEmpty()) {
            removeNode(trailer.getPrev());
        }
    }

    public void displayList() {
        Node current = header.getNext();
        while (current != null && current != trailer) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }
    

    // Concatenating/Linking two doubly list
    public void concatenate(DoublyLinkedList secondList) {
        // checking
        if (secondList == null || secondList.isEmpty()) {
            return;
        }

        // Connect the end of this list to the beginning of the other list
        Node lastNodeOfFirstList = trailer.getPrev();          // header <-> 1 <-> 2 <-> 3(lastNodeofFirstList) <-> trailer 
        Node firstNodeOfSecondList = secondList.header.getNext();  // header <-> 4(firstNodeOfSecondList) <-> 5 <-> 6 <-> trailer 


        // 1st: header -> 1, 3, 4  -> trailer
         // header -> 5, 6, 7 -> trailer
        // referencing to each other/linking
        lastNodeOfFirstList.setNext(firstNodeOfSecondList);
        firstNodeOfSecondList.setPrev(lastNodeOfFirstList);

        size += secondList.size;
    }


    public static void main(String[] args) {
        DoublyLinkedList myDoublyLinkedList = new DoublyLinkedList();

        myDoublyLinkedList.addLast(10);
        myDoublyLinkedList.addLast(20);
        myDoublyLinkedList.addFirst(1);
        myDoublyLinkedList.addLast(30);
        myDoublyLinkedList.addAfterPosition(16, 2);
        myDoublyLinkedList.addLast(88);
        System.out.println("Initial insertion:");
        myDoublyLinkedList.displayList();

        // myDoublyLinkedList.removeFromBeginning();
        // myDoublyLinkedList.removeFromLast();
        System.out.println("After deletion:");
        // myDoublyLinkedList.displayList();
        
        //concatenating 2 doubly linked list
        System.out.println("Concatenating 2 doubly linked list");
        DoublyLinkedList L_List = new DoublyLinkedList();
        L_List.addLast(88);
        L_List.addLast(49);
        L_List.addLast(23);

        DoublyLinkedList M_List = new DoublyLinkedList();
        M_List.addLast(99);
        M_List.addLast(92);

        System.out.println("L List:");
        L_List.displayList();

        System.out.println("M List:");
        M_List.displayList();

        // Concatenate list L and list M
        L_List.concatenate(M_List);

        System.out.println("Result after concatenation! :)");
        L_List.displayList();
    }
}