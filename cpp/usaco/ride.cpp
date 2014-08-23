/*
ID: weichen3
PROG: ride
LANG: C++
*/

#include <iostream>
#include <fstream>
#include <string>

using namespace std;

int main()
{
	ofstream fout ("ride.out");
	ifstream fin ("ride.in");
	string a,b;


	fin>>a>>b;

	int ra=1, rb=1;

	for (int i = 0; i < a.size(); ++i)
	{
		ra*=a[i]-'A'+1;
	}

	for (int i = 0; i < b.size(); ++i)
	{
		rb*=b[i]-'A'+1;
	}

	if (ra%47==rb%47)
		fout<<"GO"<<endl;
	else
		fout<<"STAY"<<endl;

	return 0;
}