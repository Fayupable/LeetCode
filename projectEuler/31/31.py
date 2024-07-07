#Coin Sums
#how many different ways can £2 be made using any number of coins?

def coinSums(n):
    coin=[1,2,5,10,20,50,100,200]
    ways=[0]*(n+1)
    ways[0]=1
    for i in range(len(coin)):
        for j in range(coin[i],n+1):
            ways[j]+=ways[j-coin[i]]
    return ways[n]

print(coinSums(200))