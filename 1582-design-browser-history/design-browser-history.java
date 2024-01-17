class Node {
    String data;
    Node next;
    Node prev;
    Node(String data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
class BrowserHistory {
    Node curr;
    public BrowserHistory(String homepage) {
        this.curr = new Node(homepage);
    }
    
    public void visit(String url) {
        Node newNode = new Node(url);
        curr.next = newNode;
        newNode.prev = curr;
        curr = newNode;
    }
    
    public String back(int steps) {
        while(steps > 0) {
            if(curr.prev != null) {
                curr = curr.prev;
                steps--;
            } else {
                break;
            }
        }
        return curr.data;
    }
    
    public String forward(int steps) {
        while(steps > 0) {
            if(curr.next != null) {
                curr = curr.next;
                steps--;
            } else {
                break;
            }
        }
        return curr.data;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */