# Lab Project 2

## Running the project.

First, compile and run tests:

```
mvn verify
```

Then, you can run individual actions by passing a
command line argument.

```
mvn compile exec:java -q -Dexec.args="hello"
```

## Generic Maven Commands

Try the following commands:

```
mvn verify
mvn test
mvn checkstyle:checkstyle
mvn exec:java
mvn clean
```
