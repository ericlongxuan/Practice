#include <iostream>
#define MAX_NUM 100
#define MAX(A,B) (A>B?A:B)

using namespace std;


void one_zero_knapsack_unit(int cost, int value, int V, int arr_ans[])
{
	for (int i = V; i >= cost; --i)
	{
		arr_ans[i] = MAX(arr_ans[i-cost]+value, arr_ans[i]);
	}
}


void one_zero_knapsack(int N, int V, int arr_cost[], int arr_value[], int arr_ans[])
{
	for (int i = 0; i < N; ++i)
	{
		one_zero_knapsack_unit(arr_cost[i],arr_value[i],V,arr_ans);
	}
}

int main(int argc, char const *argv[])
{
	int N, V;
	int arr_ans[MAX_NUM], arr_cost[MAX_NUM], arr_value[MAX_NUM];

	cout<<"The number of objects:"<<endl<<"The volume of the knapsack:"<<endl;


	cin>>N>>V;
	//initiation
	memset(arr_ans, 0, sizeof(int));
	for (int i = 0; i < N; ++i)
	{
		cout<<"Please create an object with its cost and value (c, v):"<<endl;
		cin>>arr_cost[i]>>arr_value[i];
	}

	one_zero_knapsack(N,V,arr_cost,arr_value,arr_ans);

	cout<<"The answer is:"<<arr_ans[V];
	return 0;
}