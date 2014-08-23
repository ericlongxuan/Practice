/*
ID: weichen3
PROG: namenum
LANG: C++
*/

#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <map>
#include <list>

using namespace std;

struct Name
{
	string name_string;
	string name_index;
};


struct dic_compare
{
	bool operator() (const Name &a, const Name &b)
	{
		return a.name_string < b.name_string;
	}
};

struct index_compare
{
	bool operator() (const Name &a, const Name &b)
	{
		return a.name_index < b.name_index;
	}
};


void read_dict(map<string, list<string> > &name_map)
{
	ifstream name_list_fin ("dict.txt");
	string name;
	string index;
	while(name_list_fin >> name)
	{
		char index_c_str[14]={0};
		
		/* 2: A,B,C     5: J,K,L    8: T,U,V
          3: D,E,F     6: M,N,O    9: W,X,Y
          4: G,H,I     7: P,R,S*/
        for (int i = 0; i < name.length(); ++i)
        {
        	char c = name[i];
        	char c2;
        	if(c=='A'||c=='B'||c=='C')
        		c2 = '2';
        	else if(c=='D'||c=='E'||c=='F')
        		c2 = '3';
        	else if(c=='G'||c=='H'||c=='I')
        		c2 = '4';
        	else if(c=='J'||c=='K'||c=='L')
        		c2 = '5';
        	else if(c=='M'||c=='N'||c=='O')
        		c2 = '6';
        	else if(c=='P'||c=='R'||c=='S')
        		c2 = '7';
        	else if(c=='T'||c=='U'||c=='V')
        		c2 = '8';
        	else if(c=='W'||c=='X'||c=='Y')
        		c2 = '9';

        	index_c_str[i] = c2;
        }
        index_c_str[name.length()]='\0';
        index.assign(index_c_str);

        if(name_map.find(index)==name_map.end())
        {
        	list<string> temp;
        	name_map[index] = temp;
        }

        name_map[index].push_back(name);
	}
}

int main()
{
	ofstream fout ("namenum.out");
	ifstream fin ("namenum.in");
	

	map<string,list<string> > name_map;

	read_dict(name_map);


	string index;
	fin >> index;

	map<string,list<string> >::iterator it;

	it = name_map.find(index);
	if(it != name_map.end())
	{
		list<string> same_index_names = (*it).second;
		list<string>::iterator same_index_it;
		for (same_index_it = same_index_names.begin(); same_index_it != same_index_names.end(); ++same_index_it)
		{
			fout<<*same_index_it<<endl;
		}
	}
	else
	{
		fout << "NONE"<<endl;
	}

	for(it = name_map.begin(); it != name_map.end(); ++it)
	{
		list<string> same_index_names = (*it).second;
		list<string>::iterator same_index_it;

		cout<<(*it).first<<"->";
		for (same_index_it = same_index_names.begin(); same_index_it != same_index_names.end(); ++same_index_it)
		{
			cout<<*same_index_it<<" ";
		}
		cout << endl;
		
	} 
	

	fout.close();
	fin.close();

	return 0;
}