.POSIX:
.SUFFIXES: .java

JAVAC := javac
JFLAGS :=
JAVA := java
JVMFLAGS := -ea

OUT_DIR := ../target/classes

SOURCES_PATH := ../src/main/java/game
SOURCES := $(SOURCES_PATH)/Main.java
SOURCES += $(SOURCES_PATH)/mobs/Element.java
SOURCES += $(SOURCES_PATH)/mobs/Mob.java
SOURCES += $(SOURCES_PATH)/mobs/Enemy.java
SOURCES += $(SOURCES_PATH)/mobs/Tower.java

TEST_SOURCES_PATH := ../src/test
TEST_SOURCES := $(TEST_SOURCES_PATH)/game/ImplementationTest.java

CLS = $(SOURCES:$(SOURCES_PATH)/%.java=$(OUT_DIR)/java/%.class)
TEST_CLS = $(TEST_SOURCES:$(TEST_SOURCES_PATH)/%.java=$(OUT_DIR)/%.class)

JAR := ../target/towerDefense.jar
TESTJAR := ../target/testTowerDefense.jar
JUNIT := ../libs/junit-4.13.2.jar
JUNIT_CLASSPATH := org.junit.runner.JUnitCore

HAMCREST := ../libs/hamcrest-core-1.3.jar
HAMCREST_CLASSPATH := org.hamcrest.CoreMatchers

RESOURCESPATH := ../src/main/resources
MANIFEST := $(RESOURCESPATH)/META-INF/MANIFEST.MF

.NOTPARALLEL: $(CLS) $(TEST_CLS)`/
.PHONY: all
all: $(JAR)

$(OUT_DIR)/java/%.class: $(SOURCES_PATH)/%.java
	@ echo "Compiling $<"
	@ mkdir -p $(OUT_DIR)
	$(JAVAC) $(JFLAGS) $< -d $(OUT_DIR) -cp "$(OUT_DIR):$(EXTRA_JAR)"

$(OUT_DIR)/%.class: $(TEST_SOURCES_PATH)/%.java
	@ echo "Compiling $<"
	@ mkdir -p $(OUT_DIR)
	$(JAVAC) $(JFLAGS) $< -d $(OUT_DIR) -cp "$(OUT_DIR):$(EXTRA_JAR)"

$(JAR): $(CLS)
	jar cfm $(JAR) $(MANIFEST) -C $(OUT_DIR) .

$(TESTJAR): $(CLS) $(TEST_CLS)
	jar cfm $(TESTJAR) $(MANIFEST) -C $(OUT_DIR) . -C $(TEST_SOURCES_PATH) .

.PHONY: test
test: EXTRA_JAR := $(JUNIT):$(HAMCREST)
test: $(TEST_CLS)
	$(JAVA) -cp "$(OUT_DIR):$(EXTRA_JAR)" $(JUNIT_CLASSPATH) $(subst /,.,$(TEST_CLS:$(OUT_DIR)/%.class=%))

.PHONY: re
re : fclean all

.PHONY: clean
clean:
	rm -rf $(CLS)

.PHONY: fclean
fclean: clean
	rm -rf $(OUT_DIR)
	rm -f $(JAR)