class LRUCache {
    Map<Integer, Node> map;
    DoublyLinkedList list;
    int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        list = new DoublyLinkedList();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            moveNodeToFront(key);
            return map.get(key).val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(this.capacity == 0){
            return;
        }
        if(map.containsKey(key)){
           map.get(key).val = value; 
           moveNodeToFront(key);
        }else{
            if(map.size() == capacity){
                Node node = removeNodeFromLast();
                map.remove(node.key);
            }
            Node node = insertAtHead(key, value);
            map.put(key, node);
        }
    }

    public void moveNodeToFront(int key){
        Node node = map.get(key);
        if(node.prev == list.head){
            return;
        }
        Node head = list.head;
        Node temp = head.next;
        node.prev.next = node.next;
        node.next.prev = node.prev;

        head.next = node;
        node.prev = head;
        node.next = temp;
        temp.prev = node;
    }

    public Node insertAtHead(int key, int value){
        Node head = list.head;
        Node temp = head.next;
        Node node = new Node(key, value);
        head.next = node;
        node.prev = head;
        node.next = temp;
        temp.prev = node;
        return node;
    }
    public Node removeNodeFromLast(){
        Node tail = list.tail;
        Node temp = tail.prev;
        temp.prev.next = tail;
        tail.prev = temp.prev;
        temp.next = null;
        temp.prev = null;

        return temp;
    }
}

class DoublyLinkedList{
    Node head;
    Node tail;

    DoublyLinkedList(){
        this.head = new Node();
        this.tail = new Node();
        this.head.next = tail;
        this.tail.prev = head;
    }
}

class Node {
    int key;
    int val;
    Node next;
    Node prev;

    Node(){}
    Node(int key, int val){
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}