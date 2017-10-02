/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


/*
  Return the no. of times search_for value is there in a linked list.
  The input list will have at least one element  
  Node is defined as 
  struct node
  {
     int data;
     struct node *next;
  }
*/
int count(struct node* head, int search_for)
{
//add your code here
int toRet = 0;
while(head!=NULL){
    if(head->data==search_for)
        toRet++;
    head=head->next;
}
return toRet;
}
