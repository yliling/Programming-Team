# -*- coding: utf-8 -*-
"""
Created on Sat Sep  7 13:12:50 2019

@author: Liling Yuan
"""
n = input()
rec = []
for i in range(0, (int)(n)):
    a, b, c = map(int, input().split())
    newRec = []
    if a >= b and a >= c:
        newRec.append(a)
        if b >= c:
            newRec.append(b)
            newRec.append(c)
        else:
            newRec.append(c)
            newRec.append(b)
        rec.append(newRec)
    elif b >= a and b >=c:
        newRec.append(b)
        if a >= c:
            newRec.append(a)
            newRec.append(c)
        else:
            newRec.append(c)
            newRec.append(a)
        rec.append(newRec)
    else:
        newRec.append(c)
        if a >= b:
            newRec.append(a)
            newRec.append(b)
        else:
            newRec.append(b)
            newRec.append(a)
        rec.append(newRec)
        
Max = 0

def find(baseA, baseB, total):
    global Max
    if Max < total:
        Max = total
    for i in range(0, N):
        if visit[i] == 0:
            currRec = rec[i]
            currA = currRec[0]
            currB = currRec[1]
            currC = currRec[2]
            if baseA >= currA and baseB >= currB:
                visit[i] = 1
                find(currA, currB, total + 1)
                visit[i] = 0
            if baseA >= currA and baseB >= currC:
                visit[i] = 1
                find(currA, currC, total + 1)
                visit[i] = 0
            if baseA >= currB and baseB >= currC:
                visit[i] = 1
                find(currB, currC, total + 1)
                visit[i] = 0
                
N = (int)(n)
visit = [0] * N
find(21, 21, 0)
print(Max)





        


