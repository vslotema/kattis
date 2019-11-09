from sys import stdin, stdout

num = stdin.readline().split(" ")
let = stdin.readline()

def sortNum(num):
    New = []
    for i in num:
        New.append(int(i))
    New.sort()
    return New

n = sortNum(num)

abc = list(let)

res = []
for i in abc:
    if i == 'A': res.append(str(n[0]))
    if i == 'B': res.append(str(n[1]))
    if i == 'C': res.append(str(n[2]))

stdout.write(res[0] + " " + res[1] + " "+ res[2])
