#include <iostream>
#include <vector>
using namespace std;


struct Info
{
	short int year;
	short int month;
	short int day;
	short int week;
};

std::vector<Info> v;

bool isLeap(int year)
{
	if((year%4==0&&year%100!=0)||year%400==0)
	{
		return true;
	}
	else
		return false;
}


int main(){
	int week = 5;
	int flag=0;
	int p;
	Info info;

	int i,j,k;

	for (int i = 2000; i <= 9999; ++i)
	{
		for (int j = 1; j <= 12; ++j)
		{
			for (int k = 1; k <= 31; ++k)
			{
				if ((j==1)||(j==3)||(j==5)||(j==7)||(j==8)||(j==10)||(j==12))
				{
					p++;
				}
				else if((j==4)||(j==6)||(j==9)||(j==11))
				{
					if(k!=31) p++;
					else break;
				}
				else if(j==2)
				{
					if(isLeap(i))
					{
						if(k!=30&&k!=31) p++;
							else break;
					}
					else
					{
						if(k!=29&&k!=30&&k!=31) p++;
							else break;
					}
				}

				info.year=i;
				info.month=j;
				info.day=k;
				week++;
				if(week==8) week=1;
				info.week=week;
				v.push_back(info);

			}
			
		}
	}


	int n;
	while(cin>>n&&n>=0)
	{
		cout<<v[n].year<<"-";
		if (v[n].month<10)
			cout<<"0"<<v[n].month<<"-";
		else
			cout<<v[n].month<<"-";

		if(v[n].day<10)
			cout<<"0"<<v[n].day<<" ";
		else
			cout<<v[n].day<<" ";

		switch(v[n].week)
		{
			case 1:
			cout<<"Monday"<<endl;
			break;

			case 2:
			cout<<"Tuesday"<<endl;
			break;

			case 3:
			cout<<"Wednesday"<<endl;
			break;

			case 4:
			cout<<"Thursday"<<endl;
			break;

			case 5:
			cout<<"Friday"<<endl;
			break;

			case 6:
			cout<<"Saturday"<<endl;
			break;

			case 7:
			cout<<"Sunday"<<endl;
			break;			
		}

	}
}