class AlgebraBooleana{
	public static String replace(String in,String x,char change){
		boolean repl;
		String aux = "";
		for(int i = 0;i < in.length();i++){
			repl = true;
			if(in.charAt(i) == x.charAt(0)){
				for(int j = 0;j < x.length();j++){
					if(!(in.charAt(j) == x.charAt(j))){
						repl = false;
					}
				}
				if(repl)
					aux += change;
				i += x.length();
			}
			aux += in.charAt(i);
		}
		return aux;
	}

	public static void main(String[] args){
		int var = MyIO.readInt();
		while(var > 0){
			int x[] = new int[var];
			for(int i = 0;i < var;i++)
				x[i] = MyIO.readInt();
			String in = MyIO.readLine();
			in = replace(in,"A",(char)(x[0]));
			in = replace(in,"B",(char)(x[1]));
			if(var == 3)
				in = replace(in,"C",(char)(x[3]));
			in = replace(in,"not(0)",'1');
			in = replace(in,"not(1)",'0');
			in = replace(in,"and(0 , 0)",'0');
			in = replace(in,"and(1 , 0)",'0');
			in = replace(in,"and(1 , 1)",'1');
			in = replace(in,"and(0 , 1)",'0');
			in = replace(in,"or(1 , 0)",'1');
			in = replace(in,"or(1 , 1)",'1');
			in = replace(in,"or(0 , 0)",'0');
			in = replace(in,"or(0 , 1)",'1');
			in = replace(in,"and(1 , 1, 1)",'1');
			in = replace(in,"and(1 , 0, 1)",'0');
			in = replace(in,"and(1 , 1, 0)",'0');
			in = replace(in,"and(1 , 0, 0)",'0');
			in = replace(in,"and(0 , 1, 1)",'0');
			in = replace(in,"and(0 , 1, 0)",'0');
			in = replace(in,"and(0 , 0, 1)",'0');
			in = replace(in,"and(0 , 0, 0)",'0');
			in = replace(in,"or(1 , 1, 1)",'1');
			in = replace(in,"or(1 , 0, 1)",'1');
			in = replace(in,"or(1 , 1, 0)",'1');
			in = replace(in,"or(1 , 0, 0)",'1');
			in = replace(in,"or(0 , 1, 1)",'1');
			in = replace(in,"or(0 , 1, 0)",'1');
			in = replace(in,"or(0 , 0, 1)",'1');
			in = replace(in,"or(0 , 0, 0)",'0');
			MyIO.println(in);
			var = MyIO.readInt();
		}
	}
}
