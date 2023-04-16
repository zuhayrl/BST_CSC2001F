#Zuhayr Loonat
#CSC2001F Assignment 4

JAVAC=/usr/bin/javac
JAVA=/usr/bin/java

#Directries
SRCDIR=src
BINDIR=bin

.SUFFIXES: .java .class

.java.class:
	$(JAVAC) $<

classes: Post.class \
         Account.class \
         BST.class \
		 TikTok.class

default: $(CLASSES)

clean:
	rm *.class