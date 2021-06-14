package Design;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Qian
 * @create 2021-04-255:51 下午
 */
public class LRUCache {
        final Node head = new Node();
        final Node tail = new Node();

        Map<Integer,Node> mapNode;
        int capacity;

        public LRUCache(int capacity) {
            this.mapNode = new HashMap(capacity);
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = this.mapNode.get(key);
        if(node == null){
            return -1;
        }
        removeNode(node);
        addNode(node);
        return node.val;
    }

    public void put(int key, int value) {
        Node node = this.mapNode.get(key);
        if(node != null){
            node.val = value;
            removeNode(node);
            addNode(node);
        }else{
            if(mapNode.size() == capacity){
                mapNode.remove(tail.prev.key);
                removeNode(tail.prev);
            }

            node = new Node();
            node.key = key;
            node.val = value;
            mapNode.put(key,node);
            addNode(node);
        }
    }

    public void addNode(Node node){
        node.prev = head;
        head.next.prev = node;
        node.next = head.next;
        head.next = node;
    }

    public void removeNode(Node node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    class Node{
        int key;
        int val;
        Node prev;
        Node next;
    }
}
