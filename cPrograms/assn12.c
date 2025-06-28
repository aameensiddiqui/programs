#include <stdio.h>

int a; int b; /* dono global hai */

int sub1(int q);
int sub2(int x);

int main(void){
  int x; /* local */
  a=1; b=2; x=3;
  printf("Main-1 a=%d b=%d x=%d\n", a, b, x);
  sub1(x);
  printf("Main-2 a=%d b=%d x=%d\n", a, b, x);
  sub2(x);
  printf("Main-3 a=%d b=%d x=%d\n", a, b, x);
  return 0;
}

int sub1(int q)
//int q; /* local */
{
  int b; /* yaha b ki local copy hai */
  a=11; /* a ki global copy hai so value of a changes (modifies global a) */
  b=12; /* b ki value sub1 tak hi change hogi kyunki local copy (modifies local b only) */
  q=50; /* modifies local q (copy of x) */
  printf("In sub1 a=%d b=%d q=%d\n", a, b, q);
  return 0;
}

int sub2(int x)
//int x;
{
  printf("In sub2 before assignment x=%d\n", x);
  x=1000; /* modifies local copy */
  printf("In sub2 after assignment x=%d\n", x);
  return 0;
}
