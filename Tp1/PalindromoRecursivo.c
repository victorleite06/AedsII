#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

bool Palindromo(char in[],int i,bool ehPalin){
	if(i < (strlen(in)-1)/2){
		if(in[i] != in[strlen(in)-2-i]){
			ehPalin = false;
			i = strlen(in);
		}
		i++;
		Palindromo(in,i,ehPalin);
	}
	return ehPalin;
}

int main(){
	char in[500];
	bool ehPalin;
	fgets(in,500,stdin);
	while(!(strlen(in) == 4 && in[0] == 'F' && in[1] == 'I' && in[2] == 'M')){
		bool ehPalin = Palindromo(in,0,true);
		if(ehPalin)
			printf("SIM\n");
		else
			printf("NAO\n");
		fgets(in,500,stdin);
	}
	return 0;
}