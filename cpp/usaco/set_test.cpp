#include <set>
#include <iostream>
using namespace std;


int main(int argc, char const *argv[])
{
	set<int> s;
	s.insert(18);
	s.insert(1);
	s.insert(12);
	s.insert(6);
	s.insert(8);


	set<int>::iterator it;
	//inorder,   from smallest to biggest
	for (it = s.begin(); it != s.end(); ++it)
	{
		cout<<*it<<" ";
	}
	//from biggest to smallest
	set<int>::reverse_iterator rit;
	for (rit = s.rbegin(); rit != s.rend(); ++rit)
	{
		cout<<*rit<<" ";
	}

	it=s.find(8);
	if(it!=s.end())
		cout<<"\nI find it!"<<endl;
	else
		cout<<"\nNo this value"<<endl;
	s.erase(it);

	s.erase(6);
	for (it = s.begin(); it != s.end(); ++it)
	{
		cout<<*it<<" ";
	}

	return 0;
}