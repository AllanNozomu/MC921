grammar Summer;

root : root line    # RootMultiLine
    | line          # RootSingleLine
    ;

line : 'var' ID '=' value ';'               # VarAssign
     | 'func' ID '(' params ')' expr ';'    # FuncDefinition
    ;

expr : value '+' value '*' value
    ;

params : value (',' value)+
    | value ?              
    ;

// exprE : exprT           # ExpreEConversion
//     | exprE '+' exprT   # ExpreESum
//     | exprE '-' exprT   # ExpreESub
//     ;

// exprT : exprF           # ExpreTConversion
//     | exprT '*' exprF   # ExpreTMul
//     | exprT '/' exprF   # ExpreTDiv
//     ;

// exprF : '(' exprE ')'   # ExpreFParen
//     | value             # ExpreFVal
//     ;

value : NUM             # ValueNum
    | ID                # ValueID
    ;
    
NUM : [0-9]+
    ;

ID  : [a-zA-Z_][a-zA-Z_0-9]*
    ;

ADD : '+'
    ;

WS  : [ \t\r\n]+ -> skip // avoid producing a token
    ;