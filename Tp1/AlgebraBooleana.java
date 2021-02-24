class AlgebraBooleana{
	public static void Algebra(int var,int x[],String in){
		int cont = 0;
		for(int i = 0;i < in.length();i++){
			if(in.charAt(i) == '(')
				cont++;
		}
	}

	public static void main(String[] args){
		int var = MyIO.readInt();
		while(var > 0){
			int x[] = new int[var];
			for(int i = 0;i < var;i++)
				x[i] = MyIO.readInt();
			String in = MyIO.readLine();
			Algebra(var,x,in);
			var = MyIO.readInt();
		}
	}
}
