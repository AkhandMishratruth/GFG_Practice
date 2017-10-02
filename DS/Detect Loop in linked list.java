/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


/* Node is defined as 
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }*/
class GfG
{
 int detectLoop(Node head){
     
        Node second = head;
        while(true){
            if(head==null || second==null)
                return 0;
            if(head.next==null)
                return 0;
            if(head.next==head)
                return 1;
            if(second.next==null || second.next.next==null)
                return 0;
            head=head.next;
            second=second.next.next;
            if(head==second)
                return 1;
        }
    }
}
