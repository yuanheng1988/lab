#coding=utf-8
'''
Created on 2012-12-11

@author: xukexin
'''

''' Additional functions:
    1. plus <quit function> while input person info.
    2. can quit without saving
'''

import cPickle as p
abdict = {}
filename = 'addressbook.txt'

class Person():
    def __init__(self,name,phone,email,address):
        self.name = name
        self.phone = phone
        self.email = email
        self.address = address

def abAdd(a):
    while True:
        name = raw_input('Enter a name for Adding:')
        if name == 'Q':
            break
        if abdict.has_key(name):
            print '%s has already been in the address book.' % name
        else:
            phone = raw_input('Phone:')
            email = raw_input('Email:')
            address = raw_input('Address:')
            person = Person(name,phone,email,address)
            abdict[name] = person
            print '%s added, total: %d.' % (name,len(abdict))   #1 also could use abdict.__len__()
        if a != 'A':
            break
            
def abRemove(b):
    while True:
        name = raw_input('Enter a name for Deleting:')
        if name == 'Q':
            break
        if not abdict.has_key(name):
            print '%s not in address book' % name
        else:
            del abdict[name]
            print '%s removed.' % name
        if b!='R':
            break    
    
def abList(l):
    if l == 'l':
        for key in abdict.keys():   #2 print abdict.keys() returns a list, such as['hy', 'hp', 'ds2', 'xcm', 'xukexin', 'xkx', 'hjf']
            print key
    elif l == 'L':
        for name in abdict.keys():
            print 'name:'.rjust(12),abdict[name].name,         #3 print abdict[name] returns an instance address, such as <__main__.Person instance at 0x01A64580>
            print 'phone:'.rjust(12),abdict[name].phone,
            print 'email:'.rjust(12),abdict[name].email,
            print 'address:'.rjust(12),abdict[name].address
    print 'total: %d' % len(abdict)
    
def abSearch(s):
    while True:
        name = raw_input('Enter a name for Searching:')
        if name == 'Q':
            break
        if abdict.has_key(name):
            print 'name:'.rjust(12),abdict[name].name,         
            print 'phone:'.rjust(12),abdict[name].phone,
            print 'email:'.rjust(12),abdict[name].email,
            print 'address:'.rjust(12),abdict[name].address
        else:
            print 'No %s is found in the address book.' % name
        if s != 'S':
            break
        
def abModify(m):
    while True:
        name = raw_input('Enter a name for Modifying:')
        if name == 'Q':
            break
        if abdict.has_key(name):
            print '%s exists, Please enter the values you want to change:' % name
            newname = raw_input('Name:')
            newphone = raw_input('Phone:')
            newemail = raw_input('Email:')
            newaddress = raw_input('Address:')
#            if newname == name:
#                person = Person(name,newphone,newemail,newaddress)   #4 
#                abdict[name] = person
#            elif abdict.has_key(newname)
#                print '%s already exists., modification failed.' % newname
#                break
#            else:
#                del abdict[name]
#                person = Person(newname,newphone,newemail,newaddress)
#                abdict[newname] = person
            person = Person(newname,newphone,newemail,newaddress)    #DataStructure 'dictionary' can cover
            abdict[newname] = person
            if newname != name:
                del abdict[name]
            
            print '%s modified.' % name
        else:
            print '%s not exists' % name
        if m != 'M':
            break

def abUsage():
    print '''
Usage:
    a/A --> add a new person/loop add
    l/L --> list all names/list all details
    r/S --> remove one/loop remove
    s/S --> search/loop search
    q/Q --> quit & save/quit (loop) but not save
    '''

def abQuit():
    f = file(filename,'w')
    p.dump(abdict, f)
    print 'Saved.'

def abStart():
    abUsage()
    while True:
        print 'Ready to work!'
        c = raw_input('Please enter what you want:')
        if c == 'a' or c == 'A':
            abAdd(c)
        elif c == 'r' or c == 'R':
            abRemove(c)
        elif c == 'l' or c == 'L':
            abList(c)
        elif c == 's' or c == 'S':
            abSearch(c)
        elif c == 'm' or c == 'M':
            abModify(c)
        elif c == 'q' or c == 'Q':
            abQuit()
            break
        else:
            print 'Please enter a valid value.'

try:
    f = file(filename)
    abdict = p.load(f)
except IOError:
    print 'hehe'
    pass
abStart()            
                
            