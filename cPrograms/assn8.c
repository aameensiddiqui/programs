#include <stdio.h>

int main(){	
  float sum = 0, temp;

  for(int i = 1 ; i <= 5 ; i++){
    printf("Enter number %d: \n", i);    
    scanf("%f", &temp);
    sum += temp;
  }

  printf("The total is: %.1f\n", sum);
  printf("The average is: %.1f\n", sum/5);
  return 0;
}

/*
#include <stdio.h>

int main(){	
  float a = 0;
  float b = 0;
  float c = 0;
  float d = 0;
  float e = 0;

  printf("Enter the first number: \n");
        scanf("%f", &a);
  printf("Enter the second number: \n");
	scanf("%f", &b);
  printf("Enter the third number: \n");
	scanf("%f", &c);
  printf("Enter the fourth number: \n");
	scanf("%f", &d);
  printf("Enter the fifth number: \n");
        scanf("%f", &e);

  printf("The total is: %.1f\n", a+b+c+d+e);
  printf("The average is: %.1f\n", ((a+b+c+d+e))/5);
  return 0;
}
*/
