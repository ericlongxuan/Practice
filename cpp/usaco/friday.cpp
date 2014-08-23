/*
ID: weichen3
PROG: friday
LANG: C++
*/

#include <iostream>
#include <fstream>
#include <string>
#include <vector>

using namespace std;

int main()
{
	ofstream fout ("friday.out");
	ifstream fin ("friday.in");
	
	int weekdays[7] = {0};

	int N;
	fin>>N;

	int gap = 12;
	int days_of_month[] = {31,28,31,30,31,30,31,31,30,31,30,31};
	for (int y = 1900; y <= N+1900-1; ++y)
	{
		for (int m = 1; m <= 12; ++m)
		{
			weekdays [gap % 7] += 1;
			gap = gap % 7;
			gap += days_of_month[m-1];
			if(m == 2)
			{
				if(y % 100 != 0 && y % 4 == 0)
					gap += 1;
				else if(y % 100 == 0 && y % 400 == 0)
					gap += 1;
			}		
		}
		
	}

	for (int i = 5; i <= 6; ++i)
	{
		fout <<weekdays[i]<<" ";
	}

	for (int i = 0; i <= 3; ++i)
	{
		fout << weekdays[i]<<" ";
	}
	fout << weekdays[4]<<endl;
	return 0;
}