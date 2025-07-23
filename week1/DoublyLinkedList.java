// File: DoublyLinkedList.java

class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class DoublyLinkedList {
    Node head;
    Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    // **** INSERTION ****
    public void insertAtEnd(int newData) {
        Node newNode = new Node(newData);
        if (tail == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public void insertAtBeginning(int newData) {
        Node newNode = new Node(newData);
        newNode.next = head;
        if (head != null) {
            head.prev = newNode;
        }
        head = newNode;
        if (tail == null) {
            tail = newNode;
        }
    }
    
    public void insertAfter(Node prevNode, int newData) {
        if (prevNode == null) return;
        Node newNode = new Node(newData);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
        newNode.prev = prevNode;
        if (newNode.next != null) {
            newNode.next.prev = newNode;
        } else {
            tail = newNode;
        }
    }

    // **** DELETION ****
    public void deleteNode(Node nodeToDelete) {
        if (nodeToDelete == null || head == null) return;
        if (head == nodeToDelete) head = nodeToDelete.next;
        if (tail == nodeToDelete) tail = nodeToDelete.prev;
        if (nodeToDelete.next != null) nodeToDelete.next.prev = nodeToDelete.prev;
        if (nodeToDelete.prev != null) nodeToDelete.prev.next = nodeToDelete.next;
    }

    // **** TRAVERSAL ****
    public void displayForward() {
        Node current = head;
        System.out.print("Forward: head -> ");
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void displayBackward() {
        Node current = tail;
        System.out.print("Backward: tail -> ");
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.prev;
        }
        System.out.println("null");
    }

    // Main method to test the functions
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        System.out.println("--- Inserting at End ---");
        dll.insertAtEnd(10);
        dll.insertAtEnd(20);
        dll.insertAtEnd(30);
        dll.displayForward(); // Forward: head -> 10 <-> 20 <-> 30 <-> null
        dll.displayBackward(); // Backward: tail -> 30 <-> 20 <-> 10 <-> null

        System.out.println("\n--- Inserting at Beginning ---");
        dll.insertAtBeginning(5);
        dll.displayForward(); // Forward: head -> 5 <-> 10 <-> 20 <-> 30 <-> null

        System.out.println("\n--- Inserting After Node ---");
        // Insert 15 after the node with data 10 (which is at head.next)
        dll.insertAfter(dll.head.next, 15);
        dll.displayForward(); // Forward: head -> 5 <-> 10 <-> 15 <-> 20 <-> 30 <-> null

        System.out.println("\n--- Deleting a Node ---");
        // Delete the node with data 20 (dll.head.next.next.next)
        dll.deleteNode(dll.head.next.next.next);
        dll.displayForward(); // Forward: head -> 5 <-> 10 <-> 15 <-> 30 <-> null
        dll.displayBackward(); // Backward: tail -> 30 <-> 15 <-> 10 <-> 5 <-> null
    }
}