class RandomizedCollection {
    List<Integer> list;
    Map<Integer, Set<Integer>> map;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        list=new ArrayList<>();
        map=new HashMap<>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if(!map.containsKey(val)){
            map.put(val, new HashSet<>());
            map.get(val).add(list.size());
            list.add(val);
            return true;
        }
        else{
            map.get(val).add(list.size());
            list.add(val);
            return false;
        }
        
        
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(map.containsKey(val)){
            if(map.get(val).size()==0){
                return false;
            }
            int index=map.get(val).iterator().next();
            map.get(val).remove(index);
            Collections.swap(list, index, list.size()-1);
            int element=list.get(index);
            map.get(element).add(index);
            map.get(element).remove(list.size()-1);
            list.remove(list.size()-1);
            return true;
        }
        else{
            return false;
        }
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        Random rand=new Random();
        int n=rand.nextInt(list.size());
        return list.get(n);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */