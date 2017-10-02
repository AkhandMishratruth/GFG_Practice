/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


//function Template for Java
/* Return reference of new head of the reverse linked list 
 class Node {
     int value;
    Node next;
    Node(int value) {
        this.value = value;
    }
} */
class gfg
{
    // This function should reverse linked list and return
   // head of the modified linked list.
   Node reverse(Node head)
   {
        // add code here
        //System.out.println("a");
        Node next=null, last = null;
        Node cur=head;
        while(cur!=null){
            next = cur.next;
            cur.next = last;
            last = cur;
            cur = next;
            //System.out.println("a");
        }
        return last;
   }
}
