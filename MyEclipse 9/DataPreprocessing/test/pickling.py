'''
Created on 2012-12-10

@author: xukexin
'''

import cPickle as p

shoplistfile = 'shoplist.data'

shoplist = ['apple','orange','banana']

f = file(shoplistfile,'w')
p.dump(shoplist, f)
f.close()

del shoplist

f = file(shoplistfile)
storedfile = p.load(f)
print storedfile
f.close()

f = file(shoplistfile)
while True:
    line = f.readline()
    if len(line) == 0:
        break
    print line,
f.close()

