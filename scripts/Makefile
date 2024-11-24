.POSIX:
.SUFFIXES: .java

JAVAC := javac
JFLAGS :=
JAVA := java
JVMFLAGS := -ea
OUT_DIR := ../target/classes

SOURCESPATH := ../src/main/java/game
SOURCES := $(SOURCESPATH)/Main.java
SOURCES += $(SOURCESPATH)/mobs/Element.java
SOURCES += $(SOURCESPATH)/mobs/Mob.java
SOURCES += $(SOURCESPATH)/mobs/Enemy.java
SOURCES += $(SOURCESPATH)/mobs/Tower.java

CLS := $(SOURCES:.java=.class)
MAIN := ../src/main/java/Main.java
JAR := ../target/towerDefense.jar

RESOURCESPATH := ../src/main/resources
MANIFEST := $(RESOURCESPATH)/META-INF/MANIFEST.MF

all: $(JAR)

%.class: %.java
	echo "Compiling $<"
	@mkdir -p $(OUT_DIR)
	$(JAVAC) $(JFLAGS) $< -d $(OUT_DIR) -cp $(OUT_DIR) -sourcepath $(SOURCESPATH)

$(JAR): $(CLS)
	jar cfm $(JAR) $(MANIFEST) -C $(OUT_DIR) .

re : fclean all

.PHONY: clean
clean:
	rm -rf $(CLS)

.PHONY: fclean
fclean: clean
	rm -f $(JAR)