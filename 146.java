class LRUCache {
    Map<Integer, Node> map;
    int capacity;
    int count;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        map=new HashMap<>();
        this.capacity=capacity;
        head=new Node(0, 0);
        tail=new Node(0, 0);
        head.next=tail;
        tail.prev=head;
        head.prev=null;
        tail.next=null;
        count=0;
    }
    public void deleteNode(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    public void addToHead(Node node){
        node.next=head.next;
        head.next.prev=node;
        node.prev=head;
        head.next=node;
    }
    public int get(int key) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            int result=node.value;
            deleteNode(node);
            addToHead(node);
            return result;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            map.get(key).value=value;
            deleteNode(node);
            addToHead(node);
        }
        else{
            Node n=new Node(key, value);
            map.put(key, n);
            if(count<capacity){
                count++;
                addToHead(n);
            }
            else{
                map.remove(tail.prev.key);
                deleteNode(tail.prev);
                addToHead(n);
            }
        }
    }
}
class Node{
    int key;
    int value;
    Node prev;
    Node next;
    public Node(int key, int value){
        this.key=key;
        this.value=value;
    }
}