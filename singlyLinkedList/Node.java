package singlyLinkedList;

public class Node {
    private int data;
    private Node nextItem;  //self-referential data type!

    public Node (){};

    public Node (int _data){
        this.data = _data;
        this.nextItem = null;
    }

    public Node(int _data, Node _next){
        this.data = _data;
        this.nextItem = _next;
    }

    //Getter and setter methods for data
    public int getData(){
        return this.data;
    }
    public void setData(int _data){
        this.data = _data;
    }

    //Getter and setter methods for next element
    public Node getNext(){
        return nextItem;
    }
    public void setNext(Node _nextItem){
        this.nextItem = _nextItem;
    }
}
