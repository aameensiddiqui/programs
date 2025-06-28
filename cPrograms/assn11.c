#include <stdio.h>
#include <math.h>

double det(double a, double b, double c);

int main(){
  double a, b, c, d=0, x=0;
  printf("Enter the value of a: \n");
	 scanf("%lf", &a);
  printf("Enter the value of b: \n");
	 scanf("%lf", &b);
  printf("Enter the value of c: \n");
	 scanf("%lf", &c);
	 
	 d = det(a, b, c);
	 
	 x = ((-b) + sqrt(d))/ (2*a);
	 printf("First root: %.1lf\n", x);
	 x = ((-b) - sqrt(d))/ (2*a);
	 printf("Second root: %.1lf\n", x);
	 return 0;
}

double det(double a, double b, double c){
  double determinant = (b*b) - (4*a*c);
  return determinant;
}
