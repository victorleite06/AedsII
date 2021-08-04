class Cometa{
	public static void main(String[] args){
		int ano = MyIO.readInt();
		int x = 1986;
		while(ano != 0){
			while(x <= ano){
				x += 76;
			}
			MyIO.println(x);
			ano = MyIO.readInt();
		}
	}
}
