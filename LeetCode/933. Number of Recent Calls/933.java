class RecentCounter {
    private Queue<Integer> requests;

    public RecentCounter() {
        requests = new LinkedList<>();
    }

    public int ping(int t) {
        requests.add(t);

        while (requests.peek() < t - 3000) {
            requests.poll(); 
        }

        return requests.size();
    }
}

/**
 * Example Usage:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */