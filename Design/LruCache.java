public class LRUCache {

	class DLinkedNode {
		int key;
		int value;
		DLinkedNode prev;
		DLinkedNode next;
	}
	
	private void addNode(DLinkedNode node) {
		node.prev = head;
		node.next = head.next;
		
		head.next.prev = node;
		head.next = node;	
	}
	
	private void removeNode(DLinkedNode node) {
		DLinkedNode prev =node.prev;
		DLinkedNode next = node.next;
		
		prev.next = next;
		next.prev = prev;	
	}
	
	private void moveToHead(DLinkedNode node) {
		removeNode(node);
		addNode(node);
	}
	
	private int popTail() {
		DLinkedNode res = tail.prev;
		removeNode(res);
		return res.key;
	}
	
	private DLinkedNode head, tail;
	private int size;
	private int capacity;
	private Map<Integer, DLinkedNode> cache = new HashMap<>();
	
    public LRUCache(int capacity) {
        head = new DLinkedNode();
		tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
		this.size = 0;
		this.capacity = capacity;		
    }
    
    public int get(int key) {
        DLinkedNode node = cache.get(key);
		if(node == null) return -1;
		moveToHead(node);
		return node.value;
    }
    
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
		if(node == null) {
			DLinkedNode newNode = new DLinkedNode();
			newNode.key = key;
			newNode.value = value;
            cache.put(key, newNode);
			addNode(newNode);
			size++;
			if(size > capacity) {
				cache.remove(popTail());
				size--;
			}
        }
        else {
				node.value = value;
                moveToHead(node);
        }
    }
		
}
