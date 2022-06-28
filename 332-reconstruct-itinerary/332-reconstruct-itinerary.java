class Solution {
    List<List<String>> tickets;

    public List<String> findItinerary(List<List<String>> tickets) {
        this.tickets = tickets;
        HashMap<String, List<String>> map = new HashMap<>();

        Collections.sort(tickets, (a, b) -> a.toString().compareTo(b.toString()));

        for (List<String> ticket : tickets) {
            map.putIfAbsent(ticket.get(0), new ArrayList<>());
            map.get(ticket.get(0)).add(ticket.get(1));
        }
        
        List<String> result = new ArrayList<>();
        result.add("JFK");

        backtrack("JFK", map, result);

        return result;
    }

    private boolean backtrack(String from, HashMap<String, List<String>> map, List<String> result) {
        if (result.size() == tickets.size() + 1) {
            return true;
        }
        
        if (!map.containsKey(from)) {
            return false;
        }
        
        List<String> temp = new ArrayList<>(map.get(from));
        for (int i = 0; i < temp.size(); i++) {
            String dest = temp.get(i);
            map.get(from).remove(i);
            result.add(dest);
            if (backtrack(dest, map, result)) {
                return true;
            }
            result.remove(result.size() - 1);
            map.get(from).add(i, dest);
        }
        
        return false;
    }
}
