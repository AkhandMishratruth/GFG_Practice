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
