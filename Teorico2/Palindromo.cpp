#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

int main(){
	char in[500];
	bool ehPalin;
	fgets(in,500,stdin);
	while(!(strlen(in) == 4 && in[0] == 'F' && in[1] == 'I' && in[2] == 'M')){
		ehPalin = true;
		for(int i = 0;i < strlen(in)-1;i++){
			if(in[i] != in[strlen(in)-2-i]){
				ehPalin = false;
				i = strlen(in);
			}
		}
		if(ehPalin)
			printf("SIM\n");
		else
			printf("NAO\n");
		fgets(in,500,stdin);
	}
	return 0;
}
