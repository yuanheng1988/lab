'''
Created on 2012-12-9

@author: xukexin
'''


class Person:
    '''Represents a person.'''
    population = 0
    
    def __init__(self,uname):
        '''Initializes the person's data. '''
        self.name = uname
        print '(Initializing %s)' % self.name
        
        #adds to the population
        Person.population += 1
    
    def __del__(self):
        '''I am dying.'''
        print '%s says bye.' % self.name
        Person.population -= 1
        
        if Person.population == 0:
            print 'I am the last one'
        else:
            print 'There are still %d people left.' % Person.population
        
    def sayHi(self):
        '''Greeting by the person.
        
        Really, that's all it does.'''
        print 'Hi, My name is %s.' % self.name
        
    def howMany(self):
        '''Prints the current population.'''
        if Person.population == 1:
            print 'I am the only person here.'
        else:
            print 'We have %d persons here.' % Person.population

marry = Person('Marry')
marry.sayHi()
marry.howMany()

alice = Person('Bella Alice')
alice.sayHi()
alice.howMany()

marry.sayHi()
marry.howMany()

del alice
del marry

print Person.__doc__
print Person.sayHi.__doc__