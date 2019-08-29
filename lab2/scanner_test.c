#include "token.h"
#include <stdio.h>
#include <stdlib.h>

extern int yylex();

char *yytext;

int yyerror(char *s) {
    printf("ERROR yy\n");
    (void)s;
    return 0;
}

int main() {
    char format[] = "%s %s\n";
    enum token_id code;
    int line_count = 0;

    do {
        code = yylex();
        switch(code) {
            case 1:
                line_count++;
                break;
            case T_ERROR:
                printf(">>>>>>>>>>>>>>>>>>> %s\n", yytext);
                break;
            default:
                printf("%s %s\n", token_name[code], yytext);
                break;
        }
    } while (code != T_EOF);
    printf("lines:%d\n", line_count);
    return 0;
}
