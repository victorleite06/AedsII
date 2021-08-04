#include <stdio.h>
#include <stdlib.h>

int main(){
	int M,f1,f2,f3;
	scanf("%i",&M);
	while(M > 0){
		scanf("%i",&f1);
		scanf("%i",&f2);
		f3 = M - (f1 + f2);
		if(f1 > f2 && f1 > f3)
			printf("\n%i\n",f1);
		if(f2 > f1 && f2 > f3)
			printf("\n%i\n",f2);
		if(f3 > f1 && f3 > f2)
			printf("\n%i\n",f3);
		scanf("%i",&M);
	}
	return 0;
}
