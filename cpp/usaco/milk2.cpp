/*
ID: weichen3
PROG: milk2
LANG: C++
*/

#include <iostream>
#include <fstream>
#include <string>
#include <vector>

using namespace std;


int main()
{
	ofstream fout ("milk2.out");
	ifstream fin ("milk2.in");
	
	string s;
	
	int n;
	bool occupied[1000000] = {false};
	int start=0, end=0;
	fin>>n;

    int max_end = 0;
    int least_start = 10000000;

	for (int i = 0; i < n; ++i)
	{
		fin >> start >> end;
		if (end > max_end)
		{
			max_end = end;
		}
		if(start<least_start)
		{
			least_start = start;
		}
		for (int j = start; j < end; ++j)
		{
			occupied[j] = true;
		}
	}
	
	int max_occupied_length = 0;
	int max_free_length = 0;
	int curr_occupied_length = 0;
	int curr_free_length = 0;

	bool lastOccupied = false;
	for (int i = least_start; i < max_end; ++i)
	{
		if (occupied[i])
		{
			if (occupied[i-1])
			{
				curr_occupied_length+=1;
			}
			else
			{
				if (curr_free_length>max_free_length)
				{
					max_free_length=curr_free_length;
				}
				curr_occupied_length = 1;
				curr_free_length = 0;
			}
		}
		else
		{
			if (occupied[i-1])
			{
				if (curr_occupied_length>max_occupied_length)
				{
					max_occupied_length=curr_occupied_length;
				}
				curr_occupied_length = 0;
				curr_free_length = 1;
			}
			else
			{
				curr_free_length+=1;
			}
		}
	}

	if (curr_free_length>max_free_length)
	{
		max_free_length=curr_free_length;
	}
	if (curr_occupied_length>max_occupied_length)
	{
		max_occupied_length=curr_occupied_length;
	}
	
	fout<<max_occupied_length<<" "<<max_free_length<<endl;
	return 0;
}