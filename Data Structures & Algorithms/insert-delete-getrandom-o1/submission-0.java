class RandomizedSet {
    // map --> O(1) lookup & insert and O(n) get Random
    // list --> O(1) get random and O(n) insert
    Map<Integer, Integer> map;
    List<Integer> list;
    Random random = new Random();

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        map.put(val, list.size());
        list.add(val);

        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }

        int idxOfValue = map.get(val);
        int lastElementValue = list.get(list.size() - 1);

        list.set(idxOfValue, lastElementValue);
        list.set(list.size() - 1, val);
        map.put(lastElementValue, idxOfValue);
        map.remove(val);
        list.remove(list.size() - 1);
        return true;
    }
    
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */