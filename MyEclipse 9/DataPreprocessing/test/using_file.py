'''
Created on 2012-12-10

@author: xukexin
'''

peom = '''\
Programming is fun
When the work is done


if you wonna make your work also fun
        use python!
'''

f = file('poem.txt','w')
f.write(peom)
f.close()

f = file('poem.txt')
while True:
    line = f.readline()
    if len(line) == 0:
        break
    print line,
f.close()

f = file('poem.txt','a')
f.write('add this line for trying')
f.close()
