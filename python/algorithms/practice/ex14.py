from sys import argv
script, user_name = argv

print argv[1]
prompt = '> '

print "HI %s, I am the %s script" %(user_name,script)
print "I wanna ask you some questions"
print "Do you like me? %s" %user_name
likes = raw_input(prompt)

print "Where do you live %s" %user_name
lives = raw_input(prompt)

print"""
alright, you said
%r and %r. Nice""" %(likes, lives)