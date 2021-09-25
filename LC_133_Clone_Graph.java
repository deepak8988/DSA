/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
Iterative DFS:
class Solution {
    public Node cloneGraph(Node node) {
        if(node==null)
            return null;
        
        Stack<Node>S=new Stack<>();
        HashMap<Integer,Node> map=new HashMap<>();
        
        Node root=new Node(node.val);
        map.put(node.val,root);
        S.push(node);
        
        while(!S.isEmpty()){
            Node curEle=S.pop();
            for(Node n:curEle.neighbors){
                if(!map.containsKey(n.val)){
                    Node clone=new Node(n.val);
                    S.push(n);
                    map.put(n.val,clone);
                }
                map.get(curEle.val).neighbors.add(map.get(n.val));       
            }
            
        }
        return root;
    }
}


BFS:
class Solution {
    public Node cloneGraph(Node node) {
        if(node==null)
            return null;
        
        Queue<Node>q=new LinkedList<>();
        HashMap<Integer,Node> map=new HashMap<>();
        
        Node root=new Node(node.val);
        map.put(node.val,root);
        q.add(node);
        
        while(!q.isEmpty()){
            Node curEle=q.poll();
            for(Node n:curEle.neighbors){
                if(!map.containsKey(n.val)){
                    Node clone=new Node(n.val);
                    q.add(n);
                    map.put(n.val,clone);
                }
                map.get(curEle.val).neighbors.add(map.get(n.val));       
            }
            
        }
        return root;
    }
}

Recursive DFS:
class Solution {
    private HashMap<Integer,Node> map=new HashMap<>();
    
    public Node cloneGraph(Node node) {
        if(node==null)
            return null;      
        return clone(node);
    }
    
    private Node clone(Node n){
        if(map.containsKey(n.val))
            return map.get(n.val);
        
        Node clonenode=new Node(n.val);
        map.put(n.val,clonenode);
        
        for(Node i:n.neighbors){
            map.get(n.val).neighbors.add(clone(i));
        }
        
        return clonenode;
    }
}
