#include <iostream>
#include <string>
#include <vector>
#include <set>

using namespace std;

struct Compare
{
	bool operator() (const string &s1, const string &s2)
	{
		if(s1.length()<s2.length())
			return 1;
		else return 0;
	}
};

bool com(const string &s1, const string &s2)
{
	if(s1.length()<s2.length())
		return 1;
	else return 0;
}

int main(){
	vector<string> ss;
	multiset<string,Compare> mss; 


	string s;
	while(cin>>s&&s!="end")
	{
		ss.push_back(s);
		mss.insert(s);
	}

	std::vector<string>::iterator it;
	for (it = ss.begin(); it!= ss.end(); ++it)
	{
		cout<<*it<<" ";
	}
	cout<<endl;

	//sort(ss.begin(),ss.end(),Compare());
	sort(ss.begin(),ss.end(),com);

	for (it = ss.begin(); it != ss.end(); ++it)
	{
		cout<<*it<<" ";
	}
	cout<<endl;

	std::set<string,Compare>::iterator sit;
	for (sit = mss.begin(); sit != mss.end(); ++sit)
	{
		cout<<*sit<<" ";
	}

	cout<<endl;

	return 0;
}
