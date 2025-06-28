#include <stdio.h>

int main(void){
  long a = 0;
  long b = 1;
  long c;
  while(a < 100000000000000000){
    printf("%ld\n", a);
    c = a+b;
    a = b;
    b = c;
  }
  // printf("Hello, World!\n");
  return 0;
}

// this is a comment
/*
  this is another comment
 */
// wassup!
