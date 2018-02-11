grammar Calculator;

expr: expr op=('*'|'/') expr # MulDiv
    | expr op=('+'|'-') expr # AddSub
    | INT                    # Int
    | '('expr')'             # Parens
    ;

comment
    : '#' ~('\r'|'\n')*
    ;
INT: [0-9]+ ;
MUL: '*' ;
DIV: '/' ;
ADD: '+' ;
SUB: '-' ;
WS : [ \t\r\n]+ -> skip ;
