# compiler and directories
JAVAC = javac
JAVA = java
SRC_DIR = src
BIN_DIR = bin

# find all .java files
SOURCES := $(wildcard $(SRC_DIR)/*.java)
CLASSES := $(patsubst $(SRC_DIR)/%.java,$(BIN_DIR)/%.class,$(SOURCES))

# default target
all: $(CLASSES)

# rule to compile .java files to .class files in bin/
$(BIN_DIR)/%.class: $(SRC_DIR)/%.java
	@mkdir -p $(BIN_DIR)
	$(JAVAC) -d $(BIN_DIR) -cp $(BIN_DIR) $<

# run the main class
run: all
	$(JAVA) -cp $(BIN_DIR) Main

# clean compiled class files
clean:
	rm -rf $(BIN_DIR)/*.class
