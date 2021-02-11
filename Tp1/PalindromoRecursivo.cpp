#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

void Palindromo(char in[],int i,bool ehPalin){
	if(i < (strlen(in)-1)/2){
		if(in[i] != in[strlen(in)-2-i]){
			ehPalin = false;
			i = strlen(in);
		}
		i++;
		if(ehPalin)
			printf("SIM\n");
		else
			printf("NAO\n");
	}
}

int main(){
	char in[500];
	fgets(in,500,stdin);
	while(!(strlen(in) == 4 && in[0] == 'F' && in[1] == 'I' && in[2] == 'M')){
		Palindromo(in,0,true);
		fgets(in,500,stdin);
	}
	return 0;
}
