grammar Gramatica;

root : line root    # RootMultiLine
    | EOF           # RootNone
    ;

line : 'var' ID '=' exprE ';'               # VarAssign
    | 'func' ID '(' params ')' exprE ';'    # FuncDefinition
    ;

params : ID ',' params # ParamsMulti
    | ID               # ParamsID
    |                  # ParamsNone
    ;

paramsCall : paramValue ',' paramsCall # ParamsCallMulti
    | paramValue                       # ParamsCallSingle
    |                             # ParamsCallNone
    ;

paramValue : NUM        # paramValueNum
    | ID                # paramValueID
    ;

exprE : exprT           # ExprEConversion
    | exprE '+' exprT   # ExprESum
    | exprE '-' exprT   # ExprESub
    ;

exprT : exprF           # ExprTConversion
    | exprT '*' exprF   # ExprTMul
    | exprT '/' exprF   # ExprTDiv
    ;

exprF : '(' exprE ')'       # ExprFParen
    | ID '(' paramsCall ')' # ExprFFunc
    | value                 # ExprFVal
    ;

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
