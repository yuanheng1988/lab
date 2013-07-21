#coding=utf-8
'''
Created on 2012-12-12

@author: xukexin
'''

import os

class Node:
    def __init__(self,value = None, parent = None, left = None, right = None):
        self.value = value
        self.parent = parent
        self.left = left
        self.right = right

def wideOrder(n):
    if n == None:
        return
    l = list()
    l.append(n)
    while len(l) > 0:
        tmp = l.pop(0)
        print tmp.value
        if tmp.left != None:
            l.append(tmp.left)
        if tmp.right != None:
            l.append(tmp.right)

def preOrder(n):
    if n == None:
        return
    print n.value
    preOrder(n.left)
    preOrder(n.right)

def midOrder(n):
    if n == None:
        return
    midOrder(n.left)
    print n.value
    midOrder(n.right)
    
def afterOrder(n):
    if n == None:
        return
    afterOrder(n.left)
    afterOrder(n.right)
    print n.value

def getDepth(n):
    if n == None:
        return 0
    n_left = getDepth(n.left)
    n_right = getDepth(n.right)
    
    if n_left >= n_right:
        return n_left + 1
    else:
        return n_right + 1
    
class Tree:
    def __init__(self):
        self.root = None
        self.size = 0
        self.depth = 0
    
    def insert(self, n):
        if n == None:
            return
        
        if self.root == None:
            self.root = n
            self.size = self.size + 1
            self.depth = self.depth + 1
            return
        
        tmp = self.root
        tmpDepth = 1
        while True:
            tmpDepth += 1
            if n.value < tmp.value:
                if tmp.left == None:
                    tmp.left = n
                    n.parent = tmp
                    self.size = self.size + 1
                    self.depth = max(self.depth,tmpDepth)
                    break
                else:
                    tmp = tmp.left
            elif n.value > tmp.value:
                if tmp.right == None:
                    tmp.right = n
                    n.parent = tmp
                    self.size = self.size + 1
                    self.depth = max(self.depth,tmpDepth)
                    break
                else:
                    tmp = tmp.right
                    
    def find(self,v):
        if v == None or self.root == None:
            print 'None'
            return
        tmp = self.root
        while True:
            if v == tmp.value:
                print 'find it', v
                break
            elif v < tmp.value:
                if tmp.left == None:
                    print 'None'
                    break
                else:
                    tmp = tmp.left
            else:
                if tmp.right == None:
                    print 'None'
                    break
                else:
                    tmp = tmp.right
                
tree = Tree()
tree.insert(Node(5))
tree.insert(Node(-3))
tree.insert(Node(2))
tree.insert(Node(-4))
tree.insert(Node(3))
tree.insert(Node(-2))
tree.insert(Node(7))
tree.insert(Node(6))

print u'先序遍历'
preOrder(tree.root)
print u'中序遍历'
midOrder(tree.root)
print u'后续遍历'
afterOrder(tree.root)
print u'广度遍历'
wideOrder(tree.root)        

print 'Classic Depth', getDepth(tree.root)
print 'Tree size %d depth %d' % (tree.size,tree.depth)
                    
                
            
    
        