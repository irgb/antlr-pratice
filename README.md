### Generate and Compile Visitor code

```
antlr4 -no-listener -visitor Calculator.g4
javac -d ./bin Calculator*.java MainVisitor.java
echo "((1+2) * 2 + 2)/( 1 + 1 )" | java -classpath "./bin:$CLASSPATH" MainVisitor
java -classpath "./bin:$CLASSPATH" MainVisitor data.txt
```

### Generate and Compile Listner code

```
antlr4 Calculator.g4
javac -d ./bin Calculator*.java MainListener.java
echo "((1+2) * 2 + 2)/( 1 + 1 )" | java -classpath "./bin:$CLASSPATH" MainListener
java -classpath "./bin:$CLASSPATH" MainListener data.txt
```

### Reference
- [ANTLR4 calculator examples](https://github.com/ouyi/antlr4calc)
- [comment in antlr rules](https://stackoverflow.com/a/7074214/5432806)
