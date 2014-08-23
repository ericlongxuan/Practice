#include <iostream>
#include <string>
#include <vector>
using namespace std;

void xxx(int a[])
{
	a[0]=1;
	*(a+1)=2;
}

void vector_xxx1(vector<int> a)
{
	a[0]=1;
}

void vector_xxx2(vector<int> &a)
{
	a[0]=2;
}
void vector_xxx3(vector<int> *a)
{
	(*a)[0]=3;
}

int main()
{
	int array_a[5]={0};
	xxx(array_a);
	cout<<array_a[0]<<array_a[1]<<array_a[2]<<array_a[3];

	std::vector<int> v(4,0);
	vector_xxx1(v);
	cout<<endl<<v[0]<<endl;	
	vector_xxx2(v);
	cout<<endl<<v[0]<<endl;	
	vector_xxx3(&v);
	cout<<endl<<v[0]<<endl;	

	int asdf = max(2,3);
	cout <<asdf;
	string aaa= "sdadf";
	cout<<aaa.length();

	bool visit[6];
	memset(visit,false,sizeof(visit));
	for (int i = 0; i < sizeof(visit)/sizeof(bool); ++i)
	{
		/* code */
		cout<<visit[i];
	}
	return 0;



	int a,b;
	cin>>a>>b;
	cout<<a+b<<endl;
	string aString, bString;
	cin>>aString;
	cin>>bString;




	if(aString.length()==bString.length())
	{
		for (int i = 0; i < aString.length(); ++i)
		{
			/* code */
			swap(aString[i],bString[bString.length()-1-i]);
		}
	}
	
	cout<<aString<<bString<<endl;

	int x;cout<<x;
	for (int i = 0; i < 16; ++i)
	{
		x ^= (1<<i);
		//cout<<x<<endl;
	}
	cout<<x;
	
	return 0;
}