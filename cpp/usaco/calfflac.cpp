//the get from cin

#include <iostream>
#include <string>
#include <fstream>
#include <vector>

using namespace std;

bool isCharacter(char c)
{
	if((c<='z'&&c>='a')||(c<='Z'&&c>='A'))
		return true;
	else
		return false;
}

bool equal(char chars[], int position1, int position2)
{//cout<<position1<<" <-> "<<position2<<endl;
	if(position1 < position2 && position1 >= 0)
	{
		if (position1!=EOF && chars[position2]!=EOF)
		{
			if (chars[position1]==chars[position2] || chars[position1]-chars[position2] == 'A'-'a'
				|| chars[position1]-chars[position2] == 'a'-'A')
			{
				return true;
			}
		}
	}
	return false;
}


bool inScanList(vector<int> &v, int position1, int position2)
{
	if(position1<position2 && position1>=0 && position2<v.size())
		return true;
	else 
		return false;
}


int main(int argc, char const *argv[])
{
	ofstream fout ("calfflac.out");
	ifstream fin ("calfflac.in");

	std::vector<int> char_position;
	char chars[20001]={EOF};
	string s;

	char c;
	int position = 0;
	while ((c = fin.get())!=EOF)          // loop while extraction from file is possible
  	{
  		chars[position]=c; 
  		if(isCharacter(c))
  		{//cout<<c;
  			char_position.push_back(position);
  		}
  		position++;	
  	}

  	//until now, the the positions of characters are recorded. We just deal with these positions
  	
  	int max_length = 0;
  	int start = 0, end = 0;
  	for (int i = 0; i < char_position.size(); ++i)
  	{
  		int position1 = i;
  		int position2 = i+1;

  		//even
  		while(inScanList(char_position,position1,position2) && equal(chars, char_position[position1], char_position[position2]))
  		{
  			if(char_position[position2]-char_position[position1]+1>max_length)
  			{
  				max_length = position2-position1+1;
  				start = char_position[position1];
  				end = char_position[position2];
  			}
  			position1 -=1;
  			position2 +=1;
  		}

  		//odd
  		position1 = i;
  		if (max_length==0)
  		{
  			max_length = 1;
  			start = char_position[position1];
  			end = char_position[position1];
  		}
  		position1 = i-1;
  		position2 = i+1;
  		while(inScanList(char_position,position1,position2) && equal(chars, char_position[position1], char_position[position2]))
  		{
  			if(char_position[position2]-char_position[position1]+1>max_length)
  			{
  				max_length = position2-position1+1;
  				start = char_position[position1];
  				end = char_position[position2];
  			}
  			position1 -=1;
  			position2 +=1;
  		}
  	}

  	fout<<max_length<<endl;

  	for (int i = start; i <= end; ++i)
  	{
  		fout<<chars[i];
  	}
  	fout<<endl;
  	


	return 0;
}