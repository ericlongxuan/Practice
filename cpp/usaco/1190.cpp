#include <iostream>
#include <vector>
using namespace std;
int main(int argc, char const *argv[])
{
	int x = 1*2*3*4*5*6*7*8*9*10*11;
	cout<<x;
	std::vector<int> v;
	for (int i = 2;i <= 10000; ++i)
	{
		int sum=1;
		
		for (int j = 2; j <= i/2 ; ++j)
		{
			if(i%j==0)
			{
				sum+=j;
			}
		}

		if(sum==i)
		{
			v.push_back(i);
		}
	}

	

	int n;
	while(cin>>n)
	{
		cout<<n<<':';
		for (int i = 0; i < v.size(); ++i)
			if(v[i]<=n)
			cout<<' '<<v[i];
		cout<<endl;
	}


	return 0;
}