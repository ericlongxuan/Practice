#print "Hello World"
print "Hello Again"
print "I like typing this."
print "What is 3+3", 3+3, 3+3<5
car =100
print car
print "#" * 10
print "you name id %r" % "hh", "and age id %r" %round(2.324)
months = "Jan\nFeb\nMar\nApr\nMay\nJun\nJul\nAug"
print months;
print "%r" %months
cat = """
I am a "cat"
you know
"""
print cat;
bad_cat = '''
I am a bad 

"cat"
you know
'''

print bad_cat;


name = raw_input("Hello, your name?")
print "age?"
age = int(raw_input())
print "oh you are %r and %d years old" %(name,age)