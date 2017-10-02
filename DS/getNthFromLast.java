/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


/* Structure of node
class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}
*/
class GfG
{
    int getNthFromLast(Node head, int n)
    {
        int len = 0;
        Node cur = head;
	while(cur!=null){
	    len++;cur=cur.next;
	}
	if(len<n) return -1;
	int pos=1;
	while(pos!=len-n+1){
	    head=head.next;pos++;
	}
	return head.data;
    }
}
	
