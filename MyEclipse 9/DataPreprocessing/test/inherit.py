'''
Created on 2012-12-10

@author: xukexin
'''
#!/usr/bin/python
# Filename: objvar.py

class SchoolMember:
    '''Represents any school member.'''
    def __init__(self,name,age):
        self.name = name
        self.age = age
        print ('Initialized SchoolMember: %s') % self.name
    
    def tell(self):
        '''tell my details.'''
        print 'Name:%s Age:%s' % (self.name,self.age),
    
class Teacher(SchoolMember):
    '''Represents a teacher.'''
    def __init__(self,name,age,salary):
        SchoolMember.__init__(self, name, age)
        self.salary = salary
        print '(Initialized  Teacher: %s)' % self.name
        
    def tell(self):
        SchoolMember.tell(self)
        print 'Salary: %d' % self.salary
        
class Student(SchoolMember):
    '''Represents a student.'''
    def __init__(self,name,age,mark):
        SchoolMember.__init__(self, name, age)
        self.mark = mark
        print '(Initialized Student: %s)' % self.name
        
    def tell(self):
        SchoolMember.tell(self)
        print 'Mark: %d' % self.mark
        
t = Teacher('Mike',40,2032)
s = Student('Joe',23,80)
members = [t,s]
for member in members:
    member.tell()