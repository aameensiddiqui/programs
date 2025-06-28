#include <stdio.h>
#include <math.h>

int main(){
  float a = 0;
  float b = 0;
  float c = 0;
  printf("Enter the value for a:\n");
  scanf("%f", &a);
  printf("Enter the value for b:\n");
  scanf("%f", &b);
  printf("Enter the value for c:\n");
  scanf("%f", &c);
  printf("a = %f, b = %f, c = %f\n", a, b, c);
  
  float x = 0;
  float rootPart = (b*b) - (4*a*c);
  printf("rootPart: %f\n",rootPart);
  if(rootPart >= 0){
    x = (-b + sqrt(rootPart)) / (2*a);
    printf("first root: %.1f\n", x);
    x = (-b - sqrt(rootPart)) / (2*a);
    printf("second root: %.1f\n", x);
  } else {
    printf("-9999\n");
  }
  return 0;
}
