#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

void Palindromo(char in[],int i,bool ehPalin){
	if(i < strlen(in)/2){
		if(in[i] != in[strlen(in)-1-i]){
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
	char in[1000];
	scanf("%s",in);
	while(!(strlen(in) == 3 && in[0] == 'F' && in[1] == 'I' && in[2] == 'M')){
		Palindromo(in,0,true);
		scanf("%s",in);
	}
	return 0;
}
