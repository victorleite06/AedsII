#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

void Palindromo(char in[]){
	bool ehPalin = true;
	for(int i = 0;i < strlen(in)/2;i++){
		if(in[i] != in[strlen(in)-1-i]){
			ehPalin = false;
			i = strlen(in);
		}
	}
	if(ehPalin)
		printf("SIM\n");
	else
		printf("NAO\n");
}

int main(){
	char in[1000];
	scanf("%s",in);
	while(!(strlen(in) == 3 && in[0] == 'F' && in[1] == 'I' && in[2] == 'M')){
		Palindromo(in);
		scanf("%s",in);
	}
	return 0;
}
