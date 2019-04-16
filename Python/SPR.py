v = []

def sumExists(sum):
    if sum == 0:
        return True

    for i in v:
        if i <= sum and sumExists(sum - i):
            return True

    return False

def iteration():
    v.sort()
    for i in range(99, 1, -1):
        if not sumExists(i):
            return i
    return 0

f = open("input.txt", 'r')

next(f)

for i in f:
    v.append(int(i))

f = open("output.txt", 'w')
f.write(str(iteration()))
