class node{
    int data;
    node next;

    node(int data){
       this.data=data;
       this.next=null;
    }
}
class linkedlist{
    node head;
    public void insert(int data){
        node newnode=new node(data);
        if(head==null){
            head=newnode;

        }else{
            node temp =new node(data);
            while(temp.next!=null){temp=temp.next;
            temp.next = newnode;}
        }
    }
}