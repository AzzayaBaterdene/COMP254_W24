package doublyLinkedList;

// Used Nested Class structure
public class DoublyLinkedList {
    private static class Node {
        private Integer data;
        private Node prev;
        private Node next;

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
        trailer = new Node(null, header, null);
        header.setNext(trailer);
        size = 0;
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public void addFirst(Integer data) {
        addBetween(data, header, header.getNext());
    }

    public void addLast(Integer data) {
        addBetween(data, trailer.getPrev(), trailer);
    }

    private void addBetween(Integer data, Node prev, Node next) {
        Node newNode = new Node(data, prev, next);
        prev.setNext(newNode);
        next.setPrev(newNode);
        size++;
    }

    // Add between nodes based on its position
    public void addBetween(Integer data, int position) throws IndexOutOfBoundsException {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }

        Node current;
        // Decide whether to traverse from the beginning or end based on the position
        if (position <= size / 2) {
            current = header;
            for (int i = 0; i < position; i++) {
                current = current.getNext();
            }
        } else {
            current = trailer;
            for (int i = size; i > position; i--) {
                current = current.getPrev();
            }
        }
        addBetween(data, current, current.getNext());
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
    
    private void removeNode(Node node) {
        Node prev = node.getPrev();
        Node next = node.getNext();

        prev.setNext(next);
        next.setPrev(prev);

        size--;
    }

    // Concatenating/Linking two doubly list
    public void concatenate(DoublyLinkedList secondList) {
        if (secondList == null || secondList.isEmpty()) {
            return;
        }

        // Connect the end of this list to the beginning of the other list
        Node lastNodeThisList = trailer.getPrev();
        Node firstNodesecondList = secondList.header.getNext();

        lastNodeThisList.setNext(firstNodesecondList);
        firstNodesecondList.setPrev(lastNodeThisList);

        // Update the size after concatenation
        size += secondList.size;

        // Clear the other list
        secondList.header.setNext(secondList.trailer);
        secondList.trailer.setPrev(secondList.header);
        secondList.size = 0;
    }


    public static void main(String[] args) {
        DoublyLinkedList myDoublyLinkedList = new DoublyLinkedList();

        myDoublyLinkedList.addLast(10);
        myDoublyLinkedList.addLast(20);
        myDoublyLinkedList.addFirst(1);
        myDoublyLinkedList.addLast(30);
        myDoublyLinkedList.addBetween(16, 2);

        System.out.println("Initial insertion:");
        myDoublyLinkedList.displayList();

        myDoublyLinkedList.removeFromBeginning();
        myDoublyLinkedList.removeFromLast();
        myDoublyLinkedList.displayList();
        
        //concatenating 2 doubly linked list
        System.out.println("Concatenating 2 doubly linked list");
        DoublyLinkedList L_List = new DoublyLinkedList();
        L_List.addLast(10);
        L_List.addLast(20);
        L_List.addLast(30);

        DoublyLinkedList M_List = new DoublyLinkedList();
        M_List.addLast(40);
        M_List.addLast(50);

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
