#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(){
	char in[500];
	fgets(in,500,stdin);
	while(!(strlen(in) == 4 && in[0] == 'F' && in[1] == 'I' && in[2] == 'M')){
		int cont = 0;
		for(int i = 0;i < strlen(in);i++){
			if(in[i] >= 'A' && in[i] <= 'Z')
				cont++;
		}
		printf("%i\n",cont);
		fgets(in,500,stdin);
	}
	return 0;
}
