#include <fstream>
//#include <algorithm>

short* v, n;

bool sumExists(short sum){
  if(sum == 0) return true;

  for(short i=0; i<n; i++)
    if(v[i] <= sum && sumExists(sum - v[i])) return true;

  return false;
}

short iteration(){
  //std::sort(v, v+n);
  for(short found=99; found>0; found--)
    if(!sumExists(found)) return found;
  return 0;
}

int main(){
  std::ifstream in("input.txt");
  in>>n;

  v = new short[n];
  for(short i=0; i<n; i++) in>>v[i];
  in.close();

  std::ofstream out("output.txt");
  out<<iteration();
  out.close();
}
