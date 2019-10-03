#include<stdio.h>
#include <stdlib.h>

extern int start();
extern int sm_main;

int main() {
  printf("%d\n", sm_main);
  return 0;
}
