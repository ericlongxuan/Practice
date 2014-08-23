#include <iostream>
#include <string>
#include <algoritm>
using namespace std;

int main()
{
	string s;


	char ss[5000];
	scanf("%s",&ss);

	//you can assignment a std::string diretly with a char*
	s=ss;
	cout << s.length()<<endl;
	cout<<s<<endl;

	s=s+"q";
	cout<<s<<endl;

	string::iterator it = s.begin();
	s.insert(it,'0');

	cout<<s<<endl;

	s.erase(s.end()-1);
	cout<<s<<endl;

	//delete s[1] s[2]
	s.erase(it+1,it+3);

	//you can get a char* like sting in C using std::string.s_str()
	char* s_c = strdup ( s.c_str() );
	printf("%s\n", s_c);
	delete s_c;

	//the length of string
	cout<<s.length()<<endl;

	cout<<"is the string empty?--- "<<s.empty()<<endl;


	//replace the charactors in a string from s[3]
	s="012345";
	s.replace(3,2,"love");
	//result will be 012love5
	cout<<s<<endl;

	//find subsring
	cout<<s.find("lo")<<endl;

	//compare
	cout<<"larger than aaa?"<<s.compare("aaa")<<endl;

	cout<<int('0')<<int('1')<<int('a')<<endl;


	//reverse
	reverse(s.end()-5,s.end());
	cout<<s<<endl;


	return 0;
}