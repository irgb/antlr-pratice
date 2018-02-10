### Generate code
antlr4 -no-listener -visitor Calculator.g4
### Compile
javac Calculator*.java Main.java
### Run
echo "((1+2) * 2 + 2)/( 1 + 1 )" | java Main

### Reference
https://github.com/ouyi/antlr4calc
