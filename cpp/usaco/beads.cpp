/*
ID: weichen3
PROG: beads
LANG: C++
*/

#include <iostream>
#include <fstream>
#include <string>
#include <vector>

using namespace std;


struct Info
{
	int rr;
	int br;
	int rl;
	int bl;
};

int main()
{
	ofstream fout ("beads.out");
	ifstream fin ("beads.in");
	
	string s;
	int n;

	int b=0, w=0;

	char last_color= EOF;

	fin>>n>>s;

	s = s+s;

	vector<Info> infos;
	Info head_info={0,0,0,0};

	infos.push_back(head_info);

	for (int i = 0; i < n * 2; ++i)
	{	
		Info info={0,0,0,0};

		if(s[i]=='r')
		{
			info.rl= infos[i].rl + 1;
			info.bl= 0;
		}
		else if(s[i]=='b')
		{
			info.rl= 0;
			info.bl= infos[i].bl + 1;
		}
		else
		{
			info.rl= infos[i].rl + 1;
			info.bl= infos[i].bl + 1;
		}

		infos.push_back(info);
	}

	Info end_info={0,0,0,0};
	infos.push_back(head_info);

	for (int i = n*2 -1; i >=0; --i)
	{
		if(s[i]=='r')
		{
			infos[i+1].rr = infos[i+2].rr + 1;
			infos[i+1].br = 0;
		}
		else if(s[i]=='b')
		{
			infos[i+1].rr = 0;
			infos[i+1].br = infos[i+2].br + 1;
		}
		else
		{
			infos[i+1].rr = infos[i+2].rr + 1;
			infos[i+1].br = infos[i+2].br + 1;
		}	
	}

	int position=0;
	int max_length=0;

	for (int i = 0; i < n*2; ++i)
	{
		int length = ((infos[i].rl > infos[i].bl) ? infos[i].rl : infos[i].bl) + ((infos[i+1].rr > infos[i+1].br) ? infos[i+1].rr : infos[i+1].br);
		if (length>max_length)
		{
			max_length = length;
			position = i;
		}
	}

	fout << ((max_length > n)? n: max_length) << endl;
	

	return 0;
}