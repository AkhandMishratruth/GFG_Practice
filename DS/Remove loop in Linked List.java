/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


/*Complete The function
Node is as follows:
class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}*/
class GfG{
	  int removeTheLoop(Node head) {
      Node slow = head, fast = head;
      while(slow!=null || fast!=null || fast.next!=null ){
        slow = slow.next;
        fast = fast.next.next;
        if(slow==fast)
            break;
      }
      slow = head;
      while(slow!=null || fast!=null){
          if(slow.next==fast.next)
            break;
        slow=slow.next;
        fast=fast.next;
      }
      fast.next=null;
      return 1;
    }
}
