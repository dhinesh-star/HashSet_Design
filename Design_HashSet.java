import java.util.Scanner;
import java.util.ArrayList;
class Node{
    int data;
    Node nxt;
    Node(int data){
        this.data = data;
    }
}
class LinkedList{
    Node head,tail;
    LinkedList(){
        this.head=null;
        this.tail=null;
    }
    void add(int value){
        boolean preCheck = contains(value);
        if(preCheck==false) {
            Node newNode = new Node(value);
            if (head == null) {
                head = newNode;
                tail = newNode;
                return;
            }
            tail.nxt = newNode;
            tail = newNode;
        }
    }
    boolean contains(int value){
        Node curr=head;
        while(curr!=null){
            if(value==curr.data)
                return true;
            curr=curr.nxt;
        }
        return false;
    }
    boolean remove(int value){
        Node curr=head;
        Node prev=null;
        while(curr!=null){
            if(value== curr.data){
                if(curr==head){
                    head=null;
                    return true;
                }
                prev.nxt=curr.nxt;
                return true;
            }
            prev=curr;
            curr=curr.nxt;
        }
        return false;
    }
    void print(){
        Node curr = head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.nxt;
        }
        System.out.println();
    }
}
class Hashset{
    int loadFactor;
    int prevLoadFactor;
    ArrayList<LinkedList> set;
    Hashset(int loadFactor,int prevLoadFactor){
        this.prevLoadFactor=prevLoadFactor;
        this.loadFactor=loadFactor;
        set = new ArrayList<>(loadFactor);
        for(int i=0;i<loadFactor;i++){
            System.out.println("Hello");
            set.add(new LinkedList());
        }
    }
    void add(int value){
        int currLoadFactor = (int)(0.8*value);
        int idx = Math.abs(value%loadFactor);
        System.out.println(idx);
        LinkedList ll = set.get(idx);
        ll.add(value);
    }
    boolean remove(int value){
        int removeIdx=Math.abs(value%loadFactor);
        LinkedList removeList = set.get(removeIdx);
        return (removeList.remove(value));
    }
    boolean contains(int value){
        int idx = Math.abs(value%loadFactor);
        LinkedList ll = set.get(idx);
        return(ll.contains(value));
    }
    void printing(){
        for(LinkedList ll:set){
            ll.print();
        }
    }
}
public class Design_HashSet {
    /*Used to implement design of hashset
    * It is using chaining type of open hashing*/
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of element of array:- ");
        int n=sc.nextInt();
        int[] arr = new int[n];
        int max=Integer.MIN_VALUE;
        System.out.println("Enter the array elements");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
            max=Math.max(arr[i],max);
        }
        int loadFactor=Math.abs((int)(0.8*max));
        if(loadFactor<=0){
            loadFactor=max;
        }
        System.out.println("loadFactor:- "+loadFactor);
        Hashset set = new Hashset(loadFactor,0);
        for(int i:arr){
            set.add(i);
        }
        System.out.print("Enter the value to be add:- ");
        int value2=sc.nextInt();
        set.add(value2);
        System.out.print("Enter the value to be checked:- ");
        int value=sc.nextInt();
        System.out.println("set.contains("+value+"):- "+set.contains(value));
        System.out.print("Enter the value to be delete:- ");
        int value1=sc.nextInt();
        System.out.println("set.contains("+value1+"):- "+set.remove(value1));
        set.printing();
    }
}