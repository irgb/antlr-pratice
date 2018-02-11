### Generate code
antlr4 -no-listener -visitor Calculator.g4
### Compile
javac Calculator*.java Main.java
### Run
echo "((1+2) * 2 + 2)/( 1 + 1 )" | java Main

### Reference
- [ANTLR4 calculator examples](https://github.com/ouyi/antlr4calc)
-[comment in antlr rules](https://stackoverflow.com/a/7074214/5432806)
