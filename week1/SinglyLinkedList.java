// File: SinglyLinkedList.java

// Node class
class Node {
    int data;
    Node next;

    // Constructor
    Node(int d) {
        data = d;
        next = null;
    }
}

// LinkedList class
public class SinglyLinkedList {
    Node head;

    // Constructor
    public SinglyLinkedList() {
        head = null;
    }

    // **** INSERTION ****

    public void insertAtBeginning(int newData) {
        Node newNode = new Node(newData);
        newNode.next = head;
        head = newNode;
    }

    public void insertAtEnd(int newData) {
        Node newNode = new Node(newData);
        if (head == null) {
            head = newNode;
            return;
        }
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;
    }

    public void insertAtPosition(int newData, int position) {
        Node newNode = new Node(newData);
        if (position == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node previous = head;
        for (int i = 0; previous != null && i < position - 1; i++) {
            previous = previous.next;
        }
        if (previous == null) {
            System.out.println("Position out of bounds");
            return;
        }
        newNode.next = previous.next;
        previous.next = newNode;
    }

    // **** DELETION ****

    public void deleteFromBeginning() {
        if (head != null) {
            head = head.next;
        }
    }

    public void deleteFromEnd() {
        if (head == null || head.next == null) {
            head = null;
            return;
        }
        Node secondLast = head;
        while (secondLast.next.next != null) {
            secondLast = secondLast.next;
        }
        secondLast.next = null;
    }

    public void deleteByKey(int key) {
        Node current = head;
        Node prev = null;
        if (current != null && current.data == key) {
            head = current.next;
            return;
        }
        while (current != null && current.data != key) {
            prev = current;
            current = current.next;
        }
        if (current == null) {
            System.out.println("Key not found.");
            return;
        }
        prev.next = current.next;
    }

    // **** UTILITY ****

    public boolean search(int key) {
        Node current = head;
        while (current != null) {
            if (current.data == key) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void display() {
        Node current = head;
        System.out.print("Linked List: ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Main method to test the functions
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        System.out.println("--- Inserting ---");
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.display(); // Linked List: 10 -> 20 -> null

        list.insertAtBeginning(5);
        list.display(); // Linked List: 5 -> 10 -> 20 -> null

        list.insertAtPosition(15, 2); // Insert 15 at index 2
        list.display(); // Linked List: 5 -> 10 -> 15 -> 20 -> null

        System.out.println("\n--- Deleting ---");
        list.deleteByKey(10);
        list.display(); // Linked List: 5 -> 15 -> 20 -> null

        list.deleteFromBeginning();
        list.display(); // Linked List: 15 -> 20 -> null

        list.deleteFromEnd();
        list.display(); // Linked List: 15 -> null

        System.out.println("\n--- Searching ---");
        System.out.println("Does 15 exist? " + list.search(15)); // true
        System.out.println("Does 99 exist? " + list.search(99)); // false
    }
}