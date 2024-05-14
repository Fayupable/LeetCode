#include <stdbool.h>
#include <stdlib.h>

typedef struct {
    bool* set;
} MyHashSet;


MyHashSet* myHashSetCreate() {
    MyHashSet* obj = (MyHashSet*)malloc(sizeof(MyHashSet));
    obj->set = (bool*)calloc(1000001, sizeof(bool)); // Initialize a boolean array of size 1000001
    return obj;
}

void myHashSetAdd(MyHashSet* obj, int key) {
    obj->set[key] = true;
}

void myHashSetRemove(MyHashSet* obj, int key) {
    obj->set[key] = false;
}

bool myHashSetContains(MyHashSet* obj, int key) {
    return obj->set[key];
}

void myHashSetFree(MyHashSet* obj) {
    free(obj->set);
    free(obj);
}

/**
 * Your MyHashSet struct will be instantiated and called as such:
 * MyHashSet* obj = myHashSetCreate();
 * myHashSetAdd(obj, key);
 * myHashSetRemove(obj, key);
 * bool param_3 = myHashSetContains(obj, key);
 * myHashSetFree(obj);
*/
