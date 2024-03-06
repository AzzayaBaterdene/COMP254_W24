public class singlyListedList {
    private Node head;
    private Node tail;
    private Node data;

    public singlyListedList(){
        this.head = tail;
        this.tail = null;
    };
    
    public  void insertionAtFront(Node data){
        if(head == tail){
            this.head = data;  
            data = tail;  
        } else {
            // list = [head -> 1 -> 2 -> 3 -> tail]
            // new node = 4
            // head -> 4 -> 1
            // data = data.setNext(head.getNext());

        }
    }


}
