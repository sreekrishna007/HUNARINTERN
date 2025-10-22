import java.util.*;

public class DeleteLastOccurrence {
    public static class Node{

        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static class LinkedList{
        Node head;

        public void add(int data){
            Node newNode=new Node(data);
            if(head==null){
                head=newNode;
                return;
            }
            Node current=head;
            while(current.next!=null){
                current=current.next;
            }
            current.next=newNode;
        }
        public void display(){
            if(head==null){
                  System.out.println("List is empty.");
                  return;
            }
            Node current=head;
            while(current!=null){
                System.out.print(current.data+" ");
                current=current.next;
            }
            System.out.println();
        }
        public void deleteLastOccurrence(int key){
            Node current=head,prev=null;
            Node lastOcc=null,lastOccPrev=null;

            while(current!=null){
                if(current.data==key){
                    lastOcc=current;
                    lastOccPrev=prev;
                }
                prev=current;
                current=current.next;
            }
            if(lastOcc==null){
                System.out.println("Element "+key+" not found in the list.");
                return;
            }
            if(lastOcc==head){
                head=head.next;
            }
            else{
                lastOccPrev.next=lastOcc.next;
            }
            System.out.println("Deleted last occurrence of element: "+key);
        }

    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        LinkedList list=new LinkedList();

        list.add(20);
        list.add(40);
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        System.out.println("Original List: ");
        list.display();

        System.out.println("\nEnter the element to delete its last occurrence: ");
        int key=sc.nextInt();
        list.deleteLastOccurrence(key);
        System.out.println("After deleting last occurrence of "+key+":");
        list.display();

        System.out.println("\nEnter the element to delete its last occurrence: ");
        int key2=sc.nextInt();
        list.deleteLastOccurrence(key2);
        System.out.println("After deleting last occurrence of "+key2+":");
        list.display();
        System.out.println("\nEnter the element to delete its last occurrence: ");
        int key3=sc.nextInt();
        list.deleteLastOccurrence(key3);
        System.out.println("After deleting last occurrence of "+key3+":");
        list.display();
    }
    
}
