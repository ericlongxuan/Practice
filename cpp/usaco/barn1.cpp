#include <iostream>
#include <string>
#include <fstream>

using namespace std;


int max_and_erase(int a[],int size)
{
   int max=0;
   int index=0;
   for (int i=0;i<size;i++)
   {
      if (a[i]>max)
      {
      	max=a[i];
      	index=i;
      }
   }
   a[index] = 0;
   return max;
}


int main(int argc, char const *argv[])
{
	ofstream fout ("barn1.out");
	ifstream fin ("barn1.in");

	int max_banner_num, barn_num, cow_num;
	fin>>max_banner_num>>barn_num>>cow_num;

	int cow_position[200]={0};
	for (int i = 0; i < cow_num; ++i)
	{
		int index;
		fin>>index;
		cow_position[i]=index;
	}


	int length[200]={0};

	int l = cow_position[cow_num-1] - cow_position[0] + 1;

	for (int i = 1; i < cow_num; ++i)
	{
		
		length[i-1]= cow_position[i]-cow_position[i-1]-1;	
		cout<<length[i-1]<<endl;
	}

	int bb=1;
	while(bb<max_banner_num)
	{
		int cut_l = max_and_erase(length,cow_num);

		cout<<cut_l<<endl;
		l -= cut_l;
		bb++;
	}

	fout<<l;


	return 0;
}