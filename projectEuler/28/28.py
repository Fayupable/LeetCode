#Number Spiral Diagonals
#Problem 28

#sum of diagonals 1001 by 1001 spiral
def spiral_diagonals(n):
    if n == 1:
        return 1
    else:
        return 4*n**2 - 6*(n-1) + spiral_diagonals(n-2)
    
print(spiral_diagonals(1001))

