#include<stdio.h>
#include<conio.h>
#include<string.h>
void main(){
	int i, j,count=0,nl;
	char str[100];
	clrscr();
	printf("enter the bit string:  ");
	gets(str);
	for (i=0;i<strlen(str);i++){
		count=0;
		for (j=i;j<=(i+5);j++){
			if(str[j]=='1'){
				count++;
			}
		}

		if(count==6){
			nl=strlen(str)+2;
			for (;nl>=(i+5);nl--){
				str[nl]=str[nl-1];
			}
			str[i+5]='0';
			i=i+7;
		}
	}
    printf("The stuffed bit string:  ");
    puts(str);
}
