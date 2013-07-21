#coding=utf-8
'''
Created on 2012-12-11

@author: xukexin
'''
#列表综合test
listone = [2,3,4]
listtwo = [2*i for i in listone if i > 2]   #列表综合
listthree =[]
print listtwo

for i in listone:
    if i > 2:
        listthree.append(i*2)
    else:
        listthree.append(i)
print listthree,len(listthree)

#*agrs对应元组和**args对应字典test
def powersum(power,*args):
    '''Return the sum of each argument raised to specified power.'''
    total = 0
    for i in args:
        total += pow(i,power)
    return total

print powersum(2,3,4)
print powersum(2,10)

#lambda test
print 'ok'*2

def make_repeater(n):
    return lambda s: s*n
twice = make_repeater(2)

print twice('work')
print twice('5')        

#assert test,需要在shell下才有反应
mylist = ['item']
assert len(mylist) >= 1
mylist.pop()
assert len(mylist) >= 1