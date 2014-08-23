/*
ID: weichen3
PROG: gift1
LANG: C++
*/

#include <iostream>
#include <fstream>
#include <string>
#include <map>
#include <vector>

using namespace std;

int main()
{
	ofstream fout ("gift1.out");
	ifstream fin ("gift1.in");
	
	int people_num;
	map<string,int> people_money; 
	std::vector<string> names;


	fin>>people_num;
	string tmp;
	for (int i = 0; i < people_num; ++i)
	{
		fin>>tmp;
		people_money[tmp]=0;
		names.push_back(tmp);
	}

	int gross_amout;
	int giving_people_amout;
	int giving_money_personal;
	string giving_person, receiving_person;

	for (int i = 0; i < people_num; ++i)
	{
		fin>>giving_person;
		fin>>gross_amout>>giving_people_amout;
		if(giving_people_amout==0)
			continue;
		giving_money_personal = gross_amout/giving_people_amout;
		people_money[giving_person]-=giving_money_personal*giving_people_amout;

		for (int j = 0; j < giving_people_amout; ++j)
		{
			fin>>receiving_person;
			people_money[receiving_person]+=giving_money_personal;
		}
	}


	vector<string>::iterator it;
	for (it = names.begin(); it!= names.end(); ++it)
	{
		fout << *it<<" "<<people_money[(*it)]<<endl;
	}

	return 0;
}