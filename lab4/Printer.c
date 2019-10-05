#include<stdio.h>
#include <stdlib.h>

extern int start();
extern int sm_main;

int main() {
  start();
  printf("%d\n", sm_main);
  return 0;
}
