#include "token.h"
#include <stdio.h>
#include <stdlib.h>

extern int yylex();
extern int line_count;

char *yytext;

int yyerror(char *s) {
    printf("ERROR yy\n");
    (void)s;
    return 0;
}

int main() {
    char format[] = "%s %s\n";
    enum token_id code;

    do {
        code = yylex();
        switch(code) {
            case T_ERROR:
                printf("%s line %d\n", token_name[code], line_count);
                return -1;
                break;
            default:
                printf("%s %s\n", token_name[code], yytext);
                break;
        }
    } while (code != T_EOF);
    printf("lines:%d\n", line_count);
    return 0;
}
