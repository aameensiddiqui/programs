#include <stdio.h>

int main(void){
  int numb[10];
  int cnt;

  for(int i = 0; i < 10; ++i){
    printf("Enter a number: ");
    scanf("%d", &numb[i]);
  }

  printf("\n");

  for(int i = 0; i < 10; ++i){
    printf("numb[%d] = %d\n", i, numb[i]);
  }
  
  printf("\nSearching for entries equal to 100\n\n");

  for(int i = 0; i < 10; ++i){
    if(numb[i] == 100){
      printf("Found 100 at %d\n", i);
      ++cnt;
    }
  }

  printf("\nFound %d entries with 100\n", cnt);
  
  return 0;
}
