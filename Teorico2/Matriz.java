class Matriz{
	public static void main(String[] args){
		int tam = MyIO.readInt();
		int x[][] = new int[tam][tam];
		int soma[] = new int[tam];
		for(int i = 0;i < tam;i++){
			soma[i] = 0;
		}
		for(int i = 0;i < tam;i++){
			for(int j = 0;j < tam;j++){
				x[i][j] = MyIO.readInt();
				soma[j] += x[i][j];
			}
		}
		MyIO.print("\n");
		for(int i = 0;i < tam;i++){
			MyIO.print(soma[i] + " ");
		}
		MyIO.print("\n");
	}
}
