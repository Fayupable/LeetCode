class MyHashSet {
private:
    vector<bool> set;
public:
    /** Initialize your data structure here. */
    MyHashSet() : set(1000001, false) { }
    
    /** Add a key to the set. */
    void add(int key) {
        set[key] = true;
    }
    
    /** Remove a key from the set. */
    void remove(int key) {
        set[key] = false;
    }
    
    /** Returns true if the set contains the specified key. */
    bool contains(int key) {
        return set[key];
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */
