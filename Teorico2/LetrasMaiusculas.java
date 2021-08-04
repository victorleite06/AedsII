class LetrasMaiusculas{
	public static void main(String[] args){
		String in = MyIO.readLine();
		while(!(in.length() == 3 && in.charAt(0) == 'F' && in.charAt(1) == 'I' && in.charAt(2) == 'M')){
			int cont = 0;
			for(int i = 0;i < in.length();i++){
				if(in.charAt(i) >= 'A' && in.charAt(i) <= 'Z')
					cont++;
			}
			MyIO.println(cont);
			in = MyIO.readLine();
		}
	}
}
