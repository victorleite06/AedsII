class DonaMonica{
	public static void main(String[] args){
		int M,f1,f2,f3;
		M = MyIO.readInt();
		while(M > 0){
			f1 = MyIO.readInt();
			f2 = MyIO.readInt();
			f3 = M - (f1+f2);
			if(f1 > f2 && f1 > f3)
				MyIO.println(f1);
			if(f2 > f1 && f2 > f3)
				MyIO.println(f2);
			if(f3 > f1 && f3 > f2)
				MyIO.println(f3);
			M = MyIO.readInt();
		}
	}
}
