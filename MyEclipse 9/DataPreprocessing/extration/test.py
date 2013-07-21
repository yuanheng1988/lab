'''
Created on 2012-11-29

@author: xukexin
'''

import MySQLdb
conn = MySQLdb.Connect(host="127.0.0.1",port=3306,db='eclipse',user='root',passwd='root')
cur = conn.cursor()

sql ='select * from bugs where bug_id=5508'
r = cur.execute(sql)
r = cur.fetchall()
print r

