#include <iostream> 
#include <vector>
#include <set>
#include <stack>

using namespace std;

struct Info
{
	int value;
	int length;
	set<Info *> parents;
};

vector<Info> v;


void DFS(std::vector<Info> v; Info curr)
{
	stack<Info *> s;
	set<Info *>::Iterator it;

	for (it = curr.parents.begin(); it != curr.parents.end(); ++it)
	{
		s.push(*it);
	}
	
	while(!s.empty())
	{
		uuu
	}w3w3ddd
}


int main(int argc, char const *argv[])
{
	int n;
	int value;
	
	cin>>n;

	for (int i = 0; i < n; ++i)
	{
		cin>>value;
		Info info;
		info.value = value;
		info.length = 0;
		set<Info *> pp;
		info.parents = pp;

		if(n==0)
		{
			info.length = 1;
			v.push_back(info);
			continue;
		}
			
		int max_s_len = 0;
		Info *parent = &(v[0]);
		for (int k = 0; k < n; ++k) 
		{

			if(v[k].value < value)
			{
				if (max_s_len < v[k].length)
				{
					max_s_len = v[k].length;
				}
			}
		}
		for (int k = 0; k < n; ++k)
		{
			if (v[k].value<value && v[k].length==max_s_len)
			{
				parent = &(v[k]);
				v[k].parents.insert(parent);
			}
		}
		info.value = value;
		info.length = max_s_len + 1;
			
	}

	int max_len = 0;
	for (int i = 0; i < n; ++i)
	{
		if(v[i].length>max_len)
			max_len = v[i].length;
	}
	
	for (int i = 0; i < n; ++i)
	{
		if(v[i].length==max_len)
			DFS(v,v[i]);
	}

	return 0;
}