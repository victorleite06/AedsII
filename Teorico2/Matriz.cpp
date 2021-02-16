#include <stdio.h>
#include <stdlib.h>

int main(){
	int tam;
	scanf("%i",&tam);
	int x[tam][tam];
	int soma[tam];
	for(int i = 0;i < tam;i++){
		soma[i] = 0;
	}
	for(int i = 0;i < tam;i++){
		for(int j = 0;j < tam;j++){
			scanf("%i",&x[i][j]);
			soma[j] += x[i][j];
		}
	}
	printf("\n");
	for(int i = 0;i < tam;i++){
		printf("%i ",soma[i]);
	}
	printf("\n");
	return 0;
}
