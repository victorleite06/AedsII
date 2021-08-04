#include <stdio.h>
#include <stdlib.h>

int main(){
	int ano;
	scanf("%i",&ano);
	int x = 1986;
	while(ano != 0){
		while(x <= ano){
			x += 76;
		}
		printf("%i\n",x);
		scanf("%i",&ano);
	}
	return 0;
}
