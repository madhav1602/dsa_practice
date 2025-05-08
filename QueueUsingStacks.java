import java.io.*;
import java.util.*;

public class QueueUsingStacks {
    static Stack<Integer> st1=new Stack<>();
    static Stack<Integer> st2=new Stack<>();

    static void push(int x){
        st1.push(x);
    }

    static int dequeue(){
        if(st2.isEmpty()){
            while(!st1.isEmpty()){
                st2.push(st1.pop());
            }
        }
        return st2.pop();
    }
    static int peek(){
        if(st2.isEmpty()){
            while(!st1.isEmpty()){
                st2.push(st1.pop());
            }
        }
        return st2.peek();
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        Solution q=new Solution();
        for(int i=0;i<n;i++){
            int a=sc.nextInt();
            if(a==1){
                int num=sc.nextInt();
                q.push(num);
            }
            else if(a==2){
                q.dequeue();
            }
            else{
                System.out.println(q.peek());
            }
        }

    }
}