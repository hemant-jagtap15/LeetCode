class RandomizedSet {
    HashSet<Integer> set;
    public RandomizedSet() {
        this.set = new HashSet<>();
    }
    
    public boolean insert(int val) {
        if(!set.contains(val)) {
            set.add(val);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        if(set.contains(val)) {
            set.remove(val);
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int val : set) {
            arr.add(val);
        }
        return arr.get((int)(Math.random() * arr.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */