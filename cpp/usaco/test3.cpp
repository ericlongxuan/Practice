#include <vector>
#include <set>
#include <iostream>
using namespace std;

int main(int argc, char const *argv[])
{
	set<int> v;
	for (int i = 0; i < 250; ++i)
	{
		for (int j = 0; j < 250; ++j)
		{
			v.insert(i*i + j*j);
		}
	}
	set<int>::iterator it;
	for (it = v.begin(); it != v.end(); ++it)
	{
		cout << *it << endl;
	}
	return 0;
}