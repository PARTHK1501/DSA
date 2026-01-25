public class LRUCache {

    Map<Integer, int[]> map;
    int order = 0;
    int size;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        size = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            int[] arr = map.get(key);
            map.put(key, new int[] { arr[0], order++ });
            return arr[0];
        }

        return -1;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {
            map.put(key, new int[] { value, order++ });
            return;
        }

        if (map.size() < size) {
            map.put(key, new int[] { value, order++ });
        } else {
            int minKey = -1;
            int minOrder = Integer.MAX_VALUE;
            for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
                int keyValue = entry.getKey();
                int[] arr = entry.getValue();
                if (arr[1] < minOrder) {
                    minKey = keyValue;
                    minOrder  = arr[1];
                }
            }

            if(minKey != -1){
                map.remove(minKey);
            }
            
            map.put(key, new int[] { value, order++ });
        }
    }
}



// 2nd - Method for it.


public class LRUCache {
    // 1. Define a Doubly Linked List Node
    class Node {
        int key;
        int value;
        Node prev;
        Node next;
    }

    private Map<Integer, Node> map = new HashMap<>();
    private int size;
    private int capacity;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;

        // Dummy head and tail to avoid null checks
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null)
            return -1;

        // Move the accessed node to the head (most recently used)
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);

        if (node == null) {
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;

            map.put(key, newNode);
            addNode(newNode);
            size++;

            if (size > capacity) {
                // Pop the tail (least recently used)
                Node last = popTail();
                map.remove(last.key);
                size--;
            }
        } else {
            // Update the value and move to head
            node.value = value;
            moveToHead(node);
        }
    }

    // --- Helper Methods for List Manipulation ---

    private void addNode(Node node) {
        // Always add the new node right after head
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }

    private Node popTail() {
        Node res = tail.prev;
        removeNode(res);
        return res;
    }
}
