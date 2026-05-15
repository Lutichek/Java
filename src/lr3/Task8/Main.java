package lr3.Task8;


public class Main {
    private static Node head;

    public static void createHead() {
        head = null;
        for (int i = 0; i < 5; i++) {
            Node newNode = new Node(i);
            newNode.setNext(head);
            head = newNode;
        }
    }

    public static void createTail() {
        head = null;
        Node tail = null;
        for (int i = 0; i < 5; i++) {
            Node newNode = new Node(i);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.setNext(newNode);
                tail = newNode;
            }
        }
    }

    public static String toString(Node node) {
        StringBuilder result = new StringBuilder();
        while (node != null) {
            result.append(node.getValue()).append(" - ");
            node = node.getNext();
        }
        result.append("null");
        return result.toString();
    }

    public static void addFirst(int value) {
        Node newNode = new Node(value);
        newNode.setNext(head);
        head = newNode;
    }

    public static void addLast(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(newNode);
    }

    public static void insert(int index, int value) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Индекс должен быть неотрицательным числом");
        }
        if (index == 0) {
            addFirst(value);
            return;
        }
        Node newNode = new Node(value);
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            if (current == null) {
                throw new IndexOutOfBoundsException("Индекс находится за пределами списка");
            }
            current = current.getNext();
        }
        if (current == null) {
            throw new IndexOutOfBoundsException("Индекс находится за пределами списка");
        }
        newNode.setNext(current.getNext());
        current.setNext(newNode);
    }

    public static void removeFirst() {
        if (head != null) {
            head = head.getNext();
        }
    }

    public static void removeLast() {
        if (head == null || head.getNext() == null) {
            head = null;
            return;
        }
        Node current = head;
        while (current.getNext().getNext() != null) {
            current = current.getNext();
        }
        current.setNext(null);
    }

    public static void remove(int index) {
        if (index < 0 || head == null) {
            return;
        }
        if (index == 0) {
            head = head.getNext();
            return;
        }
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            if (current.getNext() == null) {
                return;
            }
            current = current.getNext();
        }
        if (current.getNext() != null) {
            current.setNext(current.getNext().getNext());
        }
    }

    // Тесты
    public static void main(String[] args) {
        System.out.println("Ввод с головы:");
        createHead();
        System.out.println(toString(head));

        System.out.println("\nВвод с хвоста:");
        createTail();
        System.out.println(toString(head));

        System.out.println("\nДобавление элемента в начало списка:");
        addFirst(-1);
        System.out.println(toString(head));

        System.out.println("\nДобавление элемента в конец списка:");
        addLast(5);
        System.out.println(toString(head));

        System.out.println("\nВставка элемента в список с указанным номером:");
        insert(3, 100);
        System.out.println(toString(head));

        System.out.println("\nУдаление элемента с головы списка:");
        removeFirst();
        System.out.println(toString(head));

        System.out.println("\nУдаление последнего элемента списка:");
        removeLast();
        System.out.println(toString(head));

        System.out.println("\nУдаление элемента с указанным номером:");
        remove(2);
        System.out.println(toString(head));
    }
}