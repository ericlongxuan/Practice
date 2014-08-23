/*
ID: 31440461
LANG: C++
TASK: dualpal
*/
#include<iostream>
#include<fstream>
#include<string>
using namespace std;
 

bool is_plalindrome(string s)
{
 
    for (string::iterator back = s.begin(), forward = s.end()-1;
         back < forward; ++back, --forward) {
        if (*back != *forward)
            return false;
    }
    return true;
}

 
string convert(int n, int b)
{
    string number;
    while (n) {
        number.insert(number.begin(), n%b);
        n /= b;
    }
    return number;
}
 

bool legal(int num)
{
  int times=0;
  for (int base=2;base<=10;base++)
  {
    string s = convert(num,base);
    if(is_plalindrome(s))
      times++;
    if(times>=2)
      return true;
  }
  return false;
}
 
int main()
{
  int s,n;
  ifstream fin("dualpal.in");
  ofstream fout("dualpal.out");
  fin>>n>>s;
  for (int i=s+1;n;i++)
  {
    if (legal(i)) 
    {
      fout<<i<<endl;
      n--;
    }
  }
      
  return 0;
}