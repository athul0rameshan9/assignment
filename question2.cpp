#include <vector>
#include <list>
#include <iostream>
using namespace std;

class MyHashMap {
private:
    static const int SIZE = 10007; // A prime number to reduce collisions
    vector<list<pair<int, int>>> buckets;

    int hash(int key) {
        return key % SIZE;
    }

public:
    MyHashMap() {
        buckets.resize(SIZE);
    }

    void put(int key, int value) {
        int idx = hash(key);
        for (auto& pair : buckets[idx]) {
            if (pair.first == key) {
                pair.second = value;
                return;
            }
        }
        buckets[idx].push_back({key, value});
    }

    int get(int key) {
        int idx = hash(key);
        for (const auto& pair : buckets[idx]) {
            if (pair.first == key) return pair.second;
        }
        return -1;
    }

    void remove(int key) {
        int idx = hash(key);
        auto& bucket = buckets[idx];
        for (auto it = bucket.begin(); it != bucket.end(); ++it) {
            if (it->first == key) {
                bucket.erase(it);
                return;
            }
        }
    }
};




int main() {
    MyHashMap obj;
    obj.put(1, 10);
    obj.put(2, 20);
    cout << obj.get(1) << endl;   // Output: 10
    cout << obj.get(3) << endl;   // Output: -1
    obj.put(2, 30);
    cout << obj.get(2) << endl;   // Output: 30
    obj.remove(2);
    cout << obj.get(2) << endl;   // Output: -1
}
