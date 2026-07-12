class LFUCache {
    Map<Integer, Node> map;
    Map<Integer, DoublyLL> freqMap;
    int capacity;
    int minFreq;

    public LFUCache(int capacity) {
        this.map = new HashMap<>();
        this.freqMap = new HashMap<>();
        this.capacity = capacity;
        this.minFreq = 0;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }

        Node node = map.get(key);
        increaseFrequency(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(capacity == 0){
            return;
        }
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            increaseFrequency(node);
            return;
        }else{
            if(this.capacity == map.size()){
                DoublyLL minFreqList = freqMap.get(minFreq);
                Node nodeToRemove = minFreqList.removeLast();
                map.remove(nodeToRemove.key);
            }
            Node node = new Node(key, value);
            map.put(key, node);
            freqMap.putIfAbsent(1, new DoublyLL());
            freqMap.get(1).addFirst(node);
            minFreq = 1;
        }
    }

    public void increaseFrequency(Node node){
       int oldFreq = node.freq;

       DoublyLL oldList = freqMap.get(oldFreq);
       oldList.remove(node);

       if(oldFreq == minFreq && oldList.size == 0){
        minFreq++;
       }
       node.freq++;
       freqMap.putIfAbsent(node.freq, new DoublyLL());
       freqMap.get(node.freq).addFirst(node);
    }
    
}

class DoublyLL{
    Node head;
    Node tail;
    int size;

    DoublyLL(){
        this.head = new Node();
        this.tail = new Node();
        this.head.next = tail;
        this.tail.prev = head;
        this.size = 0;
    }

    public void addFirst(Node node){
        Node temp = head.next;

        head.next = node;
        node.prev = head;
        node.next = temp;
        temp.prev = node;

        size++;
    }

    public void remove(Node node){
        Node before = node.prev;
        Node after = node.next;

        before.next = after;
        after.prev = before;

        node.next = null;
        node.prev = null;

        size--;
    }

    public Node removeLast(){
        Node nodeToRemove = tail.prev;

        remove(nodeToRemove);
        return nodeToRemove;
    }
}

class Node{
    int key;
    int val;
    int freq;

    Node next;
    Node prev;

    Node(){}
    Node(int key, int val){
        this.key = key;
        this.val = val;
        this.freq = 1;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */