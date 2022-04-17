import java.util.ArrayList;
import java.util.LinkedList;

public class DoublyLinkedList implements List {
    private static final int DEFAULT_SIZE = 2;
    class Node {
        int data;
        Node prev;
        Node next;

        public Node(int data) {

            this.data = data;

            prev = null;
            next = null;

        }
    }
    private int[] elements;
    private int size;

    public DoublyLinkedList() {
        elements = new int[DEFAULT_SIZE];
        size = 0;
    }
    private Node tail;
    private Node head;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0; //возвращает либо тру либо фолс
    }

    @Override
    public boolean contains(int data) {
        Node node = head;
        while (node != null) {
            if (node.data == data) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public int[] toArray() {
        int[] array = new int[size];
        Node node = head;

        for (int i = 0; i < size; i++) {
            array[i] = node.data;
            node = node.next;
        }
        return array;
    }

    @Override
    public void add(int e) {
        Node node = new Node(e);
        if (head == null) {
            head = node;
        } else {
            tail.next = node;
            node.prev = tail;
        }
        tail = node;
        size++;
    }

    @Override
    public void add(int index, int element) {
        if (index < size) {
            int count = 0;
            Node newNode = new Node(element);
            Node node = head;

            while (count != index) {
                count++;
                node = node.next;
            }
            newNode.prev = node.prev;
            newNode.next = node;
            node.prev.next = newNode;
            node.prev = newNode;
        }
        size++;
    }

    @Override
    public void clear() {
        for (Node node = head; node != null; node = node.next) {
            node.data = 0;
            node.next = null;
            node.prev = null;
        }
        head = tail = null;
        size = 0;
    }

    @Override
    public int get(int index) {
        if (index < size) {
            int count = 0;
            Node node = head;

            while (count != index) {
                count++;
                node = node.next;
            }
            return node.data;
        }
        return 0;
    }

    @Override
    public int remove(int index) {
        if (index < size) {
            int count = 0;
            Node node = head;
            while (count != index) {
                count++;
                node = node.next;
            }
            Node prevNode = node.prev;
            Node nextNode = node.next;

            if (prevNode != null) {
                node.prev.next = nextNode;
            } else {
                head = node.next;
            }

            if (nextNode != null) {
                node.next.prev = prevNode;
            } else {
                tail = node.prev;
            }
            size--;
            return node.data;
        }
        return 0;
    }

    @Override
    public int indexOf(int data) {
        int count = 0;
        Node node = head;
        while (node != null) {
            if (node.data == data) {
                return count;
            }
            count++;
            node = node.next;
        }
        return 0;
    }

    public String toString() {
        StringBuffer str = new StringBuffer();
        str.append("[");
        for (int i = 0; i < elements.length; ++i) {
            str.append(elements[i]).append(",");
        }
        str.delete(str.length() - 1, str.length());
        if (str.length() != 0) {
            str.append("]");
        }
        return str.toString();
    }
}


//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.Objects;
//
//public class DoublyLinkedList implements List {
//    private static final int DEFAULT_SIZE = 2;
//
//    class Node {
//        int data;
//        Node prev;
//        Node next;
//
//        public Node(int data) {
//
//            this.data = data;
//
//            prev = null;
//            next = null;
//
//        }
//    }
//
//    private int[] elements;
//    private int size;
//
//    public DoublyLinkedList() {
//        elements = new int[DEFAULT_SIZE];
//        size = 0;
//    }
//
//    private Node tail;
//    private Node head;
//
//    @Override
//    public int size() {
//        return size;
//    }
//
//    @Override
//    public boolean isEmpty() {
//        return size == 0; //возвращает либо тру либо фолс
//    }
//
//    @Override
//    public boolean contains(int data) {
//        Node node = head;
//        while (node != null) {
//            if (node.data == data) {
//                return true;
//            }
//            node = node.next;
//        }
//        return false;
//    }
//
//    @Override
//    public int[] toArray() {
//        int[] array = new int[size];
//        Node node = head;
//
//        for (int i = 0; i < size; i++) {
//            array[i] = node.data;
//            node = node.next;
//        }
//        return array;
//    }
//
//    @Override
//    public void add(int e) {
//        Node node = new Node(e);
//        if (head == null) {
//            head = node;
//        } else {
//            tail.next = node;
//            node.prev = tail;
//        }
//        tail = node;
//        size++;
//    }
//
//    @Override
//    public void add(int index, int element) {
//        if (index < size) {
//            int count = 0;
//            Node newNode = new Node(element);
//            Node node = head;
//            for (int i = 0; i < index; ++i) {
//                node = node.next;
//            }
//            Node a;
//            node.next = newNode;
//            node = node.next;
//            for (int i = index; i < size; ++i) {
//                a = node.next;
//                node = a;
//                node = node.next;
//            }
//
//            while (count != index) {
//                count++;
//                node = node.next;
//            }
//            newNode.prev = node.prev;
//            newNode.next = node;
//            node = newNode;
//            node.prev = newNode;
//        }
//        size++;
//    }
//
//    @Override
//    public void clear() {
//        for (Node node = head; node != null; node = node.next) {
//            node.data = 0;
//            node.next = null;
//            node.prev = null;
//        }
//        head = tail = null;
//        size = 0;
//    }
//
//    @Override
//    public int get(int index) {
//        if (index < size) {
//            int count = 0;
//            Node node = head;
//
//            while (count != index) {
//                count++;
//                node = node.next;
//            }
//            return node.data;
//        }
//        return 0;
//    }
//
//    @Override
//    public int remove(int index) {
//        if (index < size) {
//            int count = 0;
//            Node node = head;
//            while (count != index) {
//                count++;
//                node = node.next;
//            }
//            Node prevNode = node.prev;
//            Node nextNode = node.next;
//
//            if (prevNode != null) {
//                node.prev.next = nextNode;
//            } else {
//                head = node.next;
//            }
//
//            if (nextNode != null) {
//                node.next.prev = prevNode;
//            } else {
//                tail = node.prev;
//            }
//            size--;
//            return node.data;
//        }
//        return 0;
//    }
//
//    @Override
//    public int indexOf(int data) {
//        int count = 0;
//        Node node = head;
//        while (node != null) {
//            if (node.data == data) {
//                return count;
//            }
//            count++;
//            node = node.next;
//        }
//        return 0;
//    }
//
//    @Override
//    public String toString() {
//        StringBuffer str = new StringBuffer();
//        str.append("[");
//        for (int i = 0; i < elements.length; ++i) {
//            str.append(elements[i]).append(",");
//        }
//        str.delete(str.length() - 1, str.length());
//        if (str.length() != 0) {
//            str.append("]");
//        }
//        return str.toString();
//    }
//}
