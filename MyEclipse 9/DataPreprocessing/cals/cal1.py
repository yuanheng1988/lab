#coding=utf-8
'''
Created on 2012-12-19

@author: xukexin
'''

a = 0
b = 0
c = 0
count = 0
count1 = 0
mark = 0
for a in range(0,5):
    for b in range(0,5):
        c = 4-a-b;
        if c<0:
            break
        if 2 in [a,b,c]:
            index = [a,b,c].index(2)
            for t in range(0,3):
                mark = 0
                if t == index:
                    continue
                if [a,b,c][t] == 2:
                    mark = 1
                    break
            if mark != 1:
                count1 += 1
        count += 1
print count
print count1