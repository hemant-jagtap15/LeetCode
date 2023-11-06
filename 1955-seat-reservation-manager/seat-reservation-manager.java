class SeatManager {
    PriorityQueue<Integer> pq;
    int cnt;
    public SeatManager(int n) {
        this.cnt = 1;
        this.pq = new PriorityQueue<>();
    }
    
    public int reserve() {
        if(!pq.isEmpty()) {
            return pq.remove();
        }
        return cnt++;
    }
    
    public void unreserve(int seatNumber) {
        pq.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */