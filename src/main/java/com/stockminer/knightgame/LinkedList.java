package com.stockminer.knightgame;

public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private Integer size = 0;

    public void addToTail(T data) {
        Node<T> newNode = new Node<T>(data);
        if (head == null) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
        tail.setNext(head);
        size++;
    }

    public void deleteNode(T data) {
        Node<T> currentNode = head;

        if (head != null) {
            if (currentNode.getData().equals(data)) {
                head = head.getNext();
                tail.setNext(head);
                size--;
            } else {
                do {
                    Node<T> nextNode = currentNode.getNext();
                    if (nextNode.getData().equals(data)) {
                        if (tail == nextNode){
                            tail = currentNode;
                        }
                        currentNode.setNext(nextNode.getNext());
                        size--;
                        break;
                    }
                    currentNode = currentNode.getNext();
                } while (currentNode != head);
            }
        }
    }

    public Node<T> get(Integer index) {
        int counter = 0;
        Node<T> node = null;
        Node<T> currentNode = head;
        if (size >= index) {
            while (counter != index) {
                currentNode = currentNode.getNext();
                counter++;
            }
            node = currentNode;
        }
        return node;
    }

    public Integer size(){
        return size;
    }
}
