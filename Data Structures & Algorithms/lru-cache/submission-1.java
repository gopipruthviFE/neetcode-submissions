class LRUCache {
    Map<Integer, ListNode> map;
    DoublyLinkedList list;
    int capacity = 0;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        list = new DoublyLinkedList();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        ListNode curr = map.get(key);
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;

        ListNode temp = this.list.head.next;
        this.list.head.next = curr;
        curr.prev = this.list.head;
        curr.next = temp;
        temp.prev = curr;

        return curr.val;
    }
    
    public void put(int key, int value) {
        if(!map.containsKey(key)){
            if(map.size() == this.capacity){
                ListNode temp = this.list.tail.prev;
                temp.prev.next = temp.next;
                this.list.tail.prev = temp.prev;
                map.remove(temp.key);
            }
            ListNode node = new ListNode(key, value);
            ListNode temp = this.list.head.next;
            node.prev = this.list.head;
            this.list.head.next = node;
            node.next = temp;
            temp.prev = node;
            map.put(key, node);
        }else{
            ListNode curr = map.get(key);
            curr.val = value;

            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
            ListNode temp = this.list.head.next;
            this.list.head.next = curr;
            curr.prev = this.list.head;
            curr.next = temp;
            temp.prev = curr;
        }
    }
}

class ListNode{
    int key;
    int val;
    ListNode prev;
    ListNode next;

    ListNode(int key, int val){
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList{
    ListNode head;
    ListNode tail;

    DoublyLinkedList(){
        head = new ListNode(0, 0);
        tail = new ListNode(0, 0);
        head.next = tail;
        tail.prev = head;
    }
}
