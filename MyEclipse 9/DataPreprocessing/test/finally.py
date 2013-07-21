'''
Created on 2012-12-10

@author: xukexin
'''
import time

try:
    f = file('poem.txt')
    while True:
        line = f.readline()
        if len(line) == 0:
            break
        time.sleep(2)
        print line,
finally:
    f.close()
    print '\nCleaning up...closed the file'
    