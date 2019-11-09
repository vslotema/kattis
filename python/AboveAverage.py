c = int(input())

def getAVG( someA, div ):
    sum = 0
    for i in someA[1:]:
        sum += int(i)
    return sum/div

def getPercentage(someA,avg,div):
    count = 0
    for i in someA[1:]:
        x = float(i)
        if x > avg:
            count += 1
    return count/div

while c > 0:
    A = input().split(" ")
    divide = int(A[0])
    avg = getAVG(A,divide)
    perc = getPercentage(A,avg,divide)*100
    print('{:.3f}'.format(perc) + '%')
    c -= 1
