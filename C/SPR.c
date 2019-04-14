#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

short* v, n;

bool sumExists(short sum){
  if(sum == 0) return true;

  for(short i=0; i<n; i++)
    if(v[i] <= sum && sumExists(sum - v[i])) return true;

  return false;
}

short iteration(void){
  //std::sort(v, v+n);
  for(short found=99; found>0; found--)
    if(!sumExists(found)) return found;
  return 0;
}

int main(void){
  FILE *fio = fopen("input.txt", "r");
  fscanf(fio, "%hd", &n);

  v = malloc(n * sizeof(int));
  for(short i=0; i<n; i++) fscanf(fio, "%hd", &v[i]);
  fclose(fio);

  fio = fopen("output.txt", "w");
  fprintf(fio, "%hd", iteration());
  fclose(fio);
}
