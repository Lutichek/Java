package lr3.Task4;

public class Main {
    public static void main(String[] args) {
        Node node0 = new Node(0, null);
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null);

        node0.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);

        Node ref = node0;
        while (ref != null) {
            System.out.println(" " + ref.getValue());
            ref = ref.getNext();
        }
    }
}