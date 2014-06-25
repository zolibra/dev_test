package com.mytest;

import javax.lang.model.element.Element;
import java.util.List;

/**
 * Created by ray on 6/24/14.
 */

class LinkList<T> {


    private class Node<T> {
        public T val;
        public Node next;

        //notic that construcrtor has no return value
        public Node(T val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    private Node<T> head;

    private int length;

    public LinkList() {
        head = new Node<T>(null, null);
        head.next = head;
        length = 0;
    }

    public Node<T> getNode(int index) {
        if (index < 0 | index > length){
            throw new IndexOutOfBoundsException();
        }
        Node<T> node = head;

        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node;
    }

    public Node<T> getFirst() {
        return getNode(0);
    }

    public void insert(T value, int index) {
        Node<T> node = new Node<T>(value,null);
        if (index == 0){
            node.next = head.next;
            head.next = node;
            this.length++;
            return;
        }
        Node<T> prenode = getNode(index - 1);
        Node<T> current = getNode(index);

        prenode.next = node;
        node.next = current;
        this.length++;
        return;

    }

    public void add(T t){
        if (length == 0){
            Node<T> newnode = new Node<T>(t, null);
            head = newnode;
    }else{
        Node<T> last = getNode(length -1);
        Node<T> newnode = new Node<T>(t, null);
        last.next = newnode;
    }
    this.length++;
    }

    public void delete(int index){
        if (index < 0 | index > length){
            throw new IndexOutOfBoundsException();
        }
        if (index == 0){
            head = null;
            head.next = null;
            return;
        }
        Node<T> node = getNode(index);
        Node<T> predecesor = getNode(index - 1);
        predecesor.next = node.next;
        node.next = null;
    }

    public void print() {
        Node<T> node = head;
        for (int i = 0; i < length; i++) {
            if (node != null) {
                System.out.println(node.val);
                node = node.next;
            }

        }

    }
}

public class SingleLinkTest {

    public static void main(String[] args) {
        System.out.println("test begin");
        LinkList<Integer> list = new LinkList<Integer>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.print();
        list.delete(2);
        list.insert(50,1);
        list.print();

    }
}
