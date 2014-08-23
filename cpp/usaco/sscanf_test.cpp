#include <iostream>
#include <string>

using namespace std;

int main()
{
	string s1,s2,s3;
	char sa[100],sb[100],sc[100];

	sscanf("abc 123 pc", "%s %s %s", sa,sb,sc);

	s1=sa;
	s2=sb;
	s3=sc;

	cout<<s1<<" "<<s2<<" "<<s3<<endl;

	int a,b,c;
	//scanf from a string=> sscanf
	//convert a string to int(using C)
	sscanf("12 23 34","%d %d %d",&a,&b,&c);
	cout<<a<<" "<<b<<" "<<c<<endl;

	sscanf("12,23$34","%d,%d$%d",&a,&b,&c);
	printf("%d %d %d\n",a,b,c );

	string s4 = "1 12 123";
	char *c_s4 = strdup(s4.c_str());
	sscanf(c_s4,"%d %d %d",&a,&b,&c);
	printf("%d %d %d\n",a,b,c );

	string s5 = "i love you";
	char *c_s5 = strdup(s5.c_str());
	char sub[100],verb[100],obj[100];
	sscanf(c_s5,"%s %s %s",sub,verb,obj);
	printf("%s\n", verb);

	//convert a int to string(using C)
	char c_s6[100];
	sprintf(c_s6,"%d",a);
	printf("%s\n", c_s6);

}