public class MyHashSet {

    private bool[] set;

    /** Initialize your data structure here. */
    public MyHashSet() {
        set = new bool[1000001]; // Initialize a boolean array of size 1000001
    }
    
    /** Add a key to the set. */
    public void Add(int key) {
        set[key] = true;
    }
    
    /** Remove a key from the set. */
    public void Remove(int key) {
        set[key] = false;
    }
    
    /** Returns true if the set contains the specified key. */
    public bool Contains(int key) {
        return set[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.Add(key);
 * obj.Remove(key);
 * bool param_3 = obj.Contains(key);
 */
