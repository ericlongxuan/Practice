#include <iostream>
#include <stack>
using namespace std;

int main(int argc, char const *argv[])
{
	int n;
	bool isNegitve = false;
	stack<bool> s;

	while(cin>>n)
	{
		if(n==0)
		{
			cout<<0<<endl;
			continue;
		}

		if(n<0)
		{
			isNegitve=true;	
			n=-n;
		}

		while(n!=0)
		{
			s.push(n%2);
			n/=2;
		}

		if(isNegitve)
		{
			cout<<'-';
			isNegitve=false;
		}
			
		while(!s.empty())
		{
			cout<<s.top();
			s.pop();
		}
		cout<<endl;
	}


	return 0;
}