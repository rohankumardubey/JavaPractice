TOPPATH = ./
LIBPATH = lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar

CLASSPATH = .:..:
BINPATH = $(TOPPATH)bin
JAVAC = javac 
JAVA  = java 

PACKAGES = ch1 ch2

all: test 

datastructs:src/DataStructures/*.java test/DataStructures/*.java
	$(JAVAC) -cp '$(CLASSPATH)bin:$(CLASSPATH)$(LIBPATH)' -d $(BINPATH) $(TOPPATH)src/DataStructures/*.java $(TOPPATH)test/DataStructures/*.java

ch1:datastructs src/Chapter1/*.java test/Chapter1/*.java
	$(JAVAC) -cp '$(CLASSPATH)bin:$(CLASSPATH)$(LIBPATH)' -d $(BINPATH) $(TOPPATH)src/Chapter1/*.java $(TOPPATH)test/Chapter1/*.java

ch2:datastructs src/Chapter2/*.java test/Chapter2/*.java
	$(JAVAC) -cp '$(CLASSPATH)bin:$(CLASSPATH)$(LIBPATH)' -d $(BINPATH) $(TOPPATH)src/Chapter2/*.java $(TOPPATH)test/Chapter2/*.java

main:src/Main.java $(PACKAGES)
	$(JAVAC) -cp '$(CLASSPATH)bin:$(CLASSPATH)$(LIBPATH)' -d $(BINPATH) $(TOPPATH)src/Main.java

test:clean $(PACKAGES) 
	$(JAVAC) -cp '$(CLASSPATH)bin:$(CLASSPATH)$(LIBPATH)' -d $(BINPATH) $(TOPPATH)src/TestRunner.java
	$(JAVA) -cp '$(CLASSPATH)$(LIBPATH):$(CLASSPATH)bin' TestRunner

clean:
	rm -R $(BINPATH)
	mkdir $(BINPATH)
