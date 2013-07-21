'''
Created on 2012-12-10

@author: xukexin
'''

import sys

try:
    s = raw_input('Enter something -->')
except EOFError:
    print '\nWhy did you do an EOF on me?'
    sys.exit()
except:
    print 'Something error/exception occurred.'
    
print 'Done'