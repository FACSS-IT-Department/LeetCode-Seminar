class LRUCache {
    
    private Map<Integer, TListNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private TListNode head;
    private TListNode tail;
    
    
    class TListNode{
        int key;
        int value;
        TListNode next;
        TListNode prev;
    }
    
    public void addNode(TListNode node){
        node.next = head.next;
        node.prev = head;
        
        head.next.prev = node;
        head.next = node;
    }
    
    public void removeNode(TListNode node){
        TListNode prev = node.prev;
        TListNode next = node.next;
        
        prev.next = next;
        next.prev = prev;
        
    }
    public void moveToHead(TListNode node){
        removeNode(node);
        addNode(node);
        
    }
    public TListNode popTail(){
        TListNode res = tail.prev;
        removeNode(res);
        return res;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        
        head = new TListNode();
        tail = new TListNode();
        
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        TListNode node = cache.get(key);
        if(node == null){
            return -1;
        }
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        TListNode node = cache.get(key);
        if(node == null){
            TListNode node2 = new TListNode();
            node2.value = value;
            node2.key = key;
            cache.put(key, node2);
            addNode(node2);
            size++;
            if(size > capacity){
                TListNode node3 = popTail();
                cache.remove(node3.key);
                size--;
                
            }
        }
        else{
            
            moveToHead(node);
            node.value = value;
        }
        
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */