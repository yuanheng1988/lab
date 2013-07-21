
'''
Created on 2012-12-6

@author: xukexin
'''

number = 23
running = True

while running:
    guess = int(raw_input('Enter an integer:'))
    if guess == number:
        print 'Congratulations, you got it'
        print '(but you don\'t have any prizes)'
        running = False
    elif guess > number:
        print 'sorry, higher'
    else:
        print 'sorry, lower'

print 'the while loop is over'
print 'Done'

for i in range(1,5):
    print i
print 'Done'

while True:
    s=raw_input('Please enter a string:')
    if s == 'quit':
        break
    if len(s)<3:
        continue
    print 'The length of the string is:',len(s)
else:
    print 'show'
print 'Done'

def sayhello():
    '''
    A docString demo.
    
    Say hello to the world.
    '''
    print 'helloworld'
sayhello()
print sayhello.__doc__


