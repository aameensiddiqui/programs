#include <stdio.h>

void calPay(float *p, float r, float h);

int main(void) {
  int emp;
  float rate;
  float hrs;
  float pay;


  while(1){
    printf("Enter time record: ");
    scanf("%d %f %f", &emp, &rate, &hrs);
    if(emp == 0){
      //printf("%d %d %d\n", 0, 0, 0);
      break;
    }
    calPay(&pay, rate, hrs);
    printf("Employee=%d Hours=%.2f Rate=%.2f Pay=%.2f\n", emp, hrs, rate, pay);
  }
  return 0;
}

void calPay(p, r, h)
     float *p;
     float r;
     float h;
{
  if(h <= 40){
    *p = (r) * (h);
  } else { 
    *p = (r*40.00) + ((h - 40.00) * r * 1.5); /* overtime */
  }
}
