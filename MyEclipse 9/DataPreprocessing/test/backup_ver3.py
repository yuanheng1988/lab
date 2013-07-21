'''
Created on 2012-12-9

@author: xukexin
'''
import os
import time

source =['C:\\Users\\xukexin\\Workspaces','C:\\Users\\xukexin\\Downloads']
target_dir = 'E:\\backup\\'

today = target_dir + time.strftime('%Y%m%d')
now = time.strftime('%H%M%S')

if not os.path.exists(today):
    os.mkdir(today)
    print 'Successfully created directory',today

comment = raw_input('Enter a comment -->')
if len(comment) == 0:
    target = today + os.sep + now + '.zip'
else:
    target = today + os.sep + now + '_'+\
        comment.replace(' ', '_')+'.zip'


zip_command = "rar a %s %s" % (target,' '.join(source))

if os.system(zip_command) == 0:
    print 'Successfully backup to',target
else:
    print 'backup failed'

print os.getcwd()
