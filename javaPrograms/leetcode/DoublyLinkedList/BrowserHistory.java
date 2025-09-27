class Node {
    String url;
    Node next;
    Node prev;
    Node(String url) {
        this.url = url;
        this.next = null;
        this.prev = null;
    }
}

class BrowserHistory2 {
    Node curr;
    public BrowserHistory2(String homepage) {
        curr = new Node(homepage);
    }
    public String visit(String url) {
        String prevUrl = curr.url;
        curr.next = new Node(url);
        curr.next.prev = curr;
        curr = curr.next;
        return "You are in "+ prevUrl + "Visit " + curr.url + "\"";
    }
    public String back(int steps) {
        String startUrl = curr.url;
        int moved = 0;
        while(curr.prev != null && steps-- > 0) {curr = curr.prev; moved++;}
        return "You are in " + startUrl + ", move back " + moved + " step(s) to "
            + curr.url + ". Return " + curr.url + "\"";
    }
    public String forward(int steps) {
        String startUrl = curr.url;
        int moved = 0;
        while(curr.next != null && steps-- > 0) {curr = curr.next; moved++;}
        if(moved == 0)
            return "You are in " + startUrl + ", you cannot move forward any steps. Current: " + curr.url + "\"";
        return  "You are in " + startUrl + ", move forward " + moved + " step(s) to "
            + curr.url + ". Return " + curr.url + "\"";
    }
    
}

class BrowserHistory {
    public static void main(String[]args) {
        BrowserHistory2 browserHistory = new BrowserHistory2("leetcode.com");

        log.info(browserHistory.visit("google.com"));
        // You are in "leetcode.com". Visit "google.com"

        log.info(browserHistory.visit("facebook.com"));
        // You are in "google.com". Visit "facebook.com"

        log.info(browserHistory.visit("youtube.com"));
        // You are in "facebook.com". Visit "youtube.com"

        log.info(browserHistory.back(1));
        // You are in "youtube.com", move back to "facebook.com" return "facebook.com"

        log.info(browserHistory.back(1));
        // You are in "facebook.com", move back to "google.com" return "google.com"

        log.info(browserHistory.forward(1));
        // You are in "google.com", move forward to "facebook.com" return "facebook.com"

        log.info(browserHistory.visit("linkedin.com"));
        // You are in "facebook.com". Visit "linkedin.com"

        log.info(browserHistory.forward(2));
        // You are in "linkedin.com", you cannot move forward any steps.

        log.info(browserHistory.back(2));
        // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"

        log.info(browserHistory.back(7));
        // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"
    }
    private static final Log log = new Log();
}
