package com.bridgelabz.orderedlist;


public class OrderedList<T> {
    Node<T> head;
    Node<T> tail;

    public int size(){         // size of the linkedList   UC9
        int size = 0;
        Node ptr = head;
        while(ptr != null){
            size++;
            ptr = ptr.next;
        }
        return size;
    }

    public boolean search(T search){      // find node with value 30  UC7

        Node ptr = head;
        while(ptr!=null){
            if(ptr.key == search){
                System.out.println("Element " + search + " is present in linked list");
                return true;
            }
            ptr = ptr.next;
        }
        return false;
    }



    public void popLast(){       // delete the last element  UC6
        Node ptr = head;
        Node prev = head;
        while(ptr.next != null){
            prev = ptr;
            ptr = ptr.next;
        }
        if(ptr != prev){
            prev.next = null;
            tail = prev;
        } else{
            tail = null;
            head = null;
        }
        display_OL();
    }


    public T pop(){                        // delete first element UC5
        Node ptr = head;
        Node prev = head;
        if(!this.isEmpty()){
            while(ptr!=tail){
                prev=ptr;
                ptr = ptr.next;
            }
        }

        prev.next = null;
        T removedValue = tail.key;
        tail=prev;

        return removedValue;
    }




    public void insert(T key, T search){      // search and insert  UC5
        Node ptr = head;
        Node<T> newNode = new Node(key);
        if(head == null){
            head = newNode;
            tail = newNode;
        } else {
            while (ptr.key != search && ptr.next != null){
                ptr = ptr.next;
            }
            newNode.next = ptr.next;
            ptr.next = newNode;
        }
        display_OL();
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void remove(T search){      // search and insert  UC4
        Node ptr = head;
        Node prev = ptr;
        while(ptr!=null){
            if(ptr.key == search) {
                if(ptr==prev){
                    head=null;
                    tail=null;
                }
                if(ptr == tail){
                    tail = prev;
                }
                prev.next = ptr.next;
                ptr.next = null;
                System.gc();
                this.display_OL();
                return;
            }
            prev = ptr;
            ptr=ptr.next;
        }
        System.out.println("Element not found");
    }


    public void append(T key){                       // appending  UC3
        Node ptr = head;
        Node<T> newNode = new Node(key);
        if(head == null){
            head = newNode;
            tail = head;
        } else {
            System.out.println(tail.key);
            tail.next = newNode;
            tail = newNode;
        }
        this.display_OL();
    }

    public int index(T key){
        int index = 0;
        Node ptr = head;

        while(ptr!=null){
            if(ptr.key == key){
                return index;
            }
            index++;
            ptr = ptr.next;
        }
        return -1;
    }


    public void add(T key) {                   // prepending    UC2
        Node<T> newNode = new Node(key);
        if(head == null){
            head = newNode;
            tail = head;
        } else {
            newNode.next = head;
            head = newNode;
        }
        this.display_OL();
    }


    public void display_OL(){              // UC1
        System.out.println("Linked list after operation is");
        Node ptr = head;   // ptr = pointer
        if(head==null){
            System.out.println("Empty");
        }
        while(ptr != null){
            if(ptr.next !=null){
                System.out.print(ptr.key + "->");
            } else{
                System.out.print(ptr.key);
            }
            ptr = ptr.next;
        }

        System.out.println("");
    }
}