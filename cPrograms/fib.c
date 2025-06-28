#include<stdio.h>

int main(void){
  int a = 0;
  int b = 1;
  int c;
  while(a < 1000000){
    printf("%d\n", a);
    c = a + b;
    a = b;
    b = c;
  }
  return 0;
}
