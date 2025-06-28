#include<stdio.h>
#include<math.h>

int main(){
    double a,b,c,x1,x2;
    a = 1;
    b = 2;
    c = 8;

    printf("\nValue for a: %.1lf\n", a);
    printf("Value for b: %.1lf\n", b);
    printf("Value for c: %.1lf\n", c);
    
    x1 = (-(b) + (sqrt((b*b) - (4*a*c)))) / (2*a);
    x2 = (-(b) - (sqrt((b*b) - (4*a*c)))) / (2*a);
    // x2 = (-(b) - (b*b) - (4*a*c)) / (2*a);

    printf("First root: %.1lf\n", x1);
    printf("Second root: %.1lf\n", x2);
    return 0;
}