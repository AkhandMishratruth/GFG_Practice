import java.util.*;
import java.io.*;

class TwoStack{
    int top1,top2,size;
    int[] ar;
    TwoStack(int n){
        size = n;
        ar = new int[n];
        top1=-1;
        top2=n;
    }
    void push1(int x){
        if(top1<top2-1)
            ar[++top1]=x;
        else
            System.out.println("OverFlow");
    }
    void push2(int x){
        if(top1<top2-1)
            ar[--top2]=x;
        else
            System.out.println("OverFlow");
    }
    int pop1(){
        if(top1>=0)
            return ar[top1--];
        else
            System.our.println("UnderFlow");
        return Integer.MIN_VALUE;
    }
    int pop2(){
        if(top2<size)
            return ar[top2++];
        else
            System.out.println("UnderFlow");
        return Integer.MIN_VALUE;
    }
}

