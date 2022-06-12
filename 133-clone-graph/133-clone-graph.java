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

class Solution {
    public Node cloneGraph(Node node) {
        // look at each of the old nodes
        // create clone of the node in hashmap,
        // retrieve the new cloned node
        HashMap<Node, Node> map = new HashMap<>();
        HashSet<Node> visited = new HashSet<>();
        
        return copy(node, map, visited);
    }
    
    private Node copy(Node node, HashMap<Node, Node> map, HashSet<Node> visited) {
        if (node == null) {
            return null;
        }
        
        visited.add(node);
        
        if (!map.containsKey(node)) {
            map.put(node, new Node(node.val));
        }
        
        Node clone = map.get(node);
        for (Node neighbor : node.neighbors) {
            if (!map.containsKey(neighbor)) {
                map.put(neighbor, new Node(neighbor.val));
            }
            Node neighborClone = map.get(neighbor);
            clone.neighbors.add(neighborClone);
            if (!visited.contains(neighbor)) {
                copy(neighbor, map, visited);
            }
        }
        
        return clone;
    }
}