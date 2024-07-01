
from itertools import permutations
import time 
start_time = time.time()

def lexicographic_permutations(n):
    perms = list(permutations(range(10)))
    return perms[n-1]

print(lexicographic_permutations(1000000))
print("Time: %s seconds" % (time.time() - start_time))
