from sys import argv
from os.path import exists

script, filename = argv

txt = open(filename)

print "Here is your file %r" %filename

print txt.read()
txt.close()

print "we are going to erase it"
print "If you don't want that, hit CTRL-C (^C)."
print "If you do want that, hit RETURN."
raw_input("?")

print "Opening the file..."
target = open(filename, 'w')
print "Truncating the file.  Goodbye!"
target.truncate()
print "Now I'm going to ask you for three lines."
line1 = raw_input("line 1: ")
print "I'm going to write these to the file."
target.write(line1)
target.write("\n")
print "And finally, we close it."
target.close()


txt = open(filename)

print "Here is your file %r" %filename

print txt.read()
txt.close()

print "now I copy the content into another file"
infile = open(filename)
indata = infile.read()
print "The input file is %d bytes long" % len(indata)
if exists("ex15_io2.py"):
	tofile = open("ex15_io2.py", "w")
	tofile.write(indata)
	tofile.close()
infile.close()
	
