/*
ID: weichen3
PROG: transform
LANG: C++
*/

#include <iostream>
#include <fstream>
#include <string>
#include <set>
#include <algorithm>
#include <string.h>

using namespace std;


string m1(string a, string b, int n)
{
	char temp[101];
	char *p = temp;
	for (int j = 0; j < n; ++j)
	{
		for (int i = n*(n-1); i >= 0; i=i-n)
		{
			*p = a[i+j];
			p++;
		}
	}
	*p='\0';
	string s = temp;
	return s;
}

string m2(string a, string b, int n)
{
	reverse(a.begin(),a.end());
	return a;
}


string m3(string a, string b, int n)
{
	char temp[101];
	char *p = temp;
	for (int j = n-1; j >= 0; --j)
	{
		for (int i = 0; i < n*n; i+=n)
		{
			*p = a[i+j];
			p++;
		}
	}
	*p='\0';
	string s = temp;
	return s;
}


string m4(string a, string b, int n)
{
	char temp[101];
	strcpy(temp,a.c_str());

	char c;
	for (int j = 0; j < n; ++j)
	{
		for (int i = 0; i < n/2; ++i)
		{
			c = temp[j*n+i];
			temp[j*n+i]=temp[j*n+(n-1-i)];
			temp[j*n+(n-1-i)]=c;
		}
	}
	string s = temp;
	//cout<<s<<endl;
	return s;
}

string m5(string a, string b, int n)
{
	string s;
	s = m4(a,b,n);
	if ((s=m1(s,b,n))==b)
	{
		return s;
	}
	else if ((s=m2(s,b,n))==b)
	{
		return s;
	}
	else if ((s=m3(s,b,n))==b)
	{
		return s;
	}
	else return "\n";
}


int main()
{
	ofstream fout ("transform.out");
	ifstream fin ("transform.in");
	
	int n;
	string a;
	string b;
	set<string> viewed;
	fin>>n;


	for (int i = 0; i < n; ++i)
	{
		string temp;
		fin>>temp;
		a += temp;
	}
	for (int i = 0; i < n; ++i)
	{
		string temp;
		fin>>temp;
		b += temp;
	}

	if(m1(a,b,n)==b)
		fout<<1<<endl;
	else if(m2(a,b,n)==b)
		fout<<2<<endl;
	else if(m3(a,b,n)==b)
		fout<<3<<endl;
	else if(m4(a,b,n)==b)
		fout<<4<<endl;
	else if(m5(a,b,n)==b)
		fout<<5<<endl;
	else if(a==b)
		fout<<6<<endl;
	else
		fout<<7<<endl;

	fout.close();
	fin.close();
	return 0;
}