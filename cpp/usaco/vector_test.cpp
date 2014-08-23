#include <iostream>
#include <vector>
#include <numeric>
#include <algorithm>
using namespace std;

bool compare(const int &a, const int &b)
{
	return a>b; 
}

int main()
{
	//the declaration of vector
	vector<int> v;
	int i;

	//add element at the end of vector
	for (int i = 0; i < 10; ++i)
	{
		v.push_back(i);
	}
	for (std::vector<int>::iterator it=v.begin(); it!=v.end(); it++)
	{
		cout<<*it<<" ";
	}
	cout<<endl;

	//accumulate the vector
	cout<<accumulate(v.begin(),v.end(),0)<<endl;

	//delete one element
	v.erase(v.begin()+2);
	for (std::vector<int>::iterator it=v.begin(); it!=v.end(); it++)
	{
		cout<<*it<<" ";
	}
	cout<<endl;

	//reverse part of the vector
	reverse(v.begin(),v.end()-2);
	for (std::vector<int>::iterator it=v.begin(); it!=v.end(); it++)
	{
		cout<<*it<<" ";
	}
	cout<<endl;

	//sort the vector
	sort(v.begin(),v.end());
	for (std::vector<int>::iterator it=v.begin(); it!=v.end(); it++)
	{
		cout<<*it<<" ";
	}
	cout<<endl;

	//set the compare strategy.
	sort(v.begin(),v.end(),compare);
	for (std::vector<int>::iterator it=v.begin(); it!=v.end(); it++)
	{
		cout<<*it<<" ";
	}
	cout<<endl;

	//vector.size()
	cout<<v.size()<<endl;

	//vector.empty() to see if it is empty
	cout<<v.empty()<<endl;


	//vector.clear() to delete all elements
	v.clear();
	cout<<v.empty()<<endl;

	return 0;
}