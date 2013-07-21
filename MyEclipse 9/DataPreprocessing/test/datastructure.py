'''
Created on 2012-12-7

@author: xukexin
'''

#list test
shoplist = ['apple','mango','carrot','banana']

print 'I have',len(shoplist),'items to purchase'

print 'This items are:',
for i in shoplist:
    print i,

print '\nI also have to buy rice.'
shoplist.append('rice')
print sorted(shoplist)      #sorted(list)不改变list本身，list.sort()改变本身
print 'My shoplist is now',shoplist

print 'I will sort my list now'
shoplist.sort();
print 'Sorted shopping list is',shoplist

print 'The first thing I will buy is',shoplist[0]
olditem = shoplist[0]
del shoplist[0]
print 'I bought the',olditem
print 'My shopping list is now',shoplist

#tuple test 
zoo = ('wolf','elephant','penguin')
print 'Number of animals in the zoo is',len(zoo)

new_zoo = ('monkey','dolphin',zoo)
print 'Number of animals in the new zoo is',len(new_zoo)
print 'All animals in the new zoo are',new_zoo
print 'Animals bought from the old zoo are',new_zoo[2]
print 'Last animal bought from the old zoo is',new_zoo[2][2]

#string
myString = 'hehe'
myString = 'heihei'
print myString

#using_dic.py
#ab is short for 'a'dress'b'ook
ab = {
        'Swaroop':'swaroop@byteofpython.info',
        'Larry':'larry@wall.org',
        'Matt':'matt@ruby-lang.org',
        'Spammer':'spammer@hotmail.com'
      }
print "Swaroop's address is %s" % ab['Swaroop']

#Adding a key/value pair
ab['Guido'] = 'guido@python.org'

#Deleting a key/vaule pair
del ab['Spammer']

print '\nThere are %d contacts in the address-book\n' % len(ab)

for name,address in ab.items():
    print 'Contact %s at %s' % (name,address)

if 'Guido' in ab:
    print "\nGuido's address is %s" % ab['Guido']

if ab.has_key('Larry'):                                   #Two methods to find value through key
    print "\nLarry's address is %s" % ab['Larry']

mylist1 = shoplist
mylist2 = shoplist[:]
print 'mylist1 is',mylist1
print 'mylist2 is',mylist2

del shoplist[0];
print 'shoplist is',shoplist
print 'mylist1 is',mylist1
print 'mylist2 is',mylist2

del mylist2[0];
print 'shoplist is',shoplist
print 'mylist2 is',mylist2

