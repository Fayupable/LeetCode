#Distinct Powers
#how many distinc term a^b for 2<=a<=100 and 2<=b<=100

def distinctPowers():
    distinct = []
    for a in range(2,101):
        for b in range(2,101):
            distinct.append(a**b)
    return len(set(distinct))

print(distinctPowers())