
class Node{
        int value ;
        Node next;
        Node(int value){
            this.value = value;
            this.next = null;
        }
     }
class MyLinkedList {
     Node head=null;
     int size=0;
    public MyLinkedList() {
        
    }
    
    public int get(int index) {
        if(index<0 || index>size){
            return -1;
        }
        Node temp= head;
        if(head==null){
            return -1;
        }
        int cnt =0;
        while((temp!=null) || (cnt<=index)){
              if(cnt==index){
                return temp.value;
              }
              temp = temp.next;
              cnt++;
        }
     return -1;

    }
    
    public void addAtHead(int val) {
         Node temp = new Node(val);
        if(head==null){
           head=temp;
           return;  
        }else{
            temp.next = head;
            head= temp;
        }
        size++;
    }
    
    public void addAtTail(int val) {
        Node temp = new Node(val);
        if(head==null){
           head=temp; 
        }else{
            Node t = head;
            while(t.next!=null){
                   t= t.next;
            }
            t.next=temp;
        }
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        Node t =new Node(val);
        if(index<0 || index>size){
            return;
        }
        if(index==0){
            addAtHead(val);
        }else if(index==size){
            addAtTail(val);
        }else{
          int cnt =0;
        Node temp = head;
        while(temp.next!=null && cnt<index-1){
            temp= temp.next;
            cnt++;
        }
        t.next=temp.next;
           temp.next=t;
           size++;
        }
        
    }
    
    public void deleteAtIndex(int index) {
        if(index<0 || index>=size|| head==null){
            return;
        }
        Node temp = head;
        if(index==0){
            head = head.next;
        }else {
            for(int i =0 ;i<index-1;i++){
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
        size--;
        
    }
    public void print(){
        Node temp = head;
        if(temp==null){
            System.out.println("[]");
            return ;
        }
        while(temp != null){
       System.out.print("["+temp.value+"]"+",");
       temp = temp.next;
        }
    }
    public static void main(String[] args) {
        MyLinkedList ls = new MyLinkedList();
        ls.print();
        ls.addAtHead(24);
        ls.addAtTail(23);
        ls.addAtTail(22);
        ls.addAtHead(21);
        ls.addAtIndex(0, 55);
        ls.print();
        System.out.println();
       int a = ls.get(3);
       ls.deleteAtIndex(0);
       ls.print();
       System.out.println(a);
    }
}
/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
