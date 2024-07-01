#1000-digit Fibonacci Number
import time

start_time = time.time()
def fibonacci():
    a, b = 0, 1
    count = 0
    while True:
        a, b = b, a + b
        count += 1
        if len(str(a)) == 1000:
            return count

print(fibonacci())
print("Time: ", time.time() - start_time)