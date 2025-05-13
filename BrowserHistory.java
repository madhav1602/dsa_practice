class BrowserHistory {
    public class Node{
        String url;
        Node next;
        Node prev;
        public Node(String url){
            this.url=url;
            this.next=null;
            this.prev=null;
        }
    }
    Node cur;
    public BrowserHistory(String homepage) {
        this.cur=new Node(homepage);

    }

    public void visit(String url) {
        Node node=new Node(url);
        cur.next=node;
        node.prev=cur;
        cur=node;
    }

    public String back(int steps) {
        int count=steps;
        while(count!=0 && cur.prev!=null){
            cur=cur.prev;
            count--;
        }
        return cur.url;

    }

    public String forward(int steps) {
        int count=steps;
        while(count>0 && cur.next!=null){
            cur=cur.next;
            count--;
        }
        return cur.url;

    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */