class CiframentoCesar{
	public static String Cifrar(String in){
		String cifrado = "";
		char novLetra;
		for(int i = 0;i < in.length();i++){
			novLetra = (char)(in.charAt(i)+3);
			cifrado += novLetra;
		}
		return cifrado;
	}

	public static void main(String[] args){
		String in = MyIO.readLine();
		String cifrado;
		while(!(in.length() == 3 && in.charAt(0) == 'F' && in.charAt(1) == 'I' && in.charAt(2) == 'M')){
			cifrado = Cifrar(in);
			MyIO.println(cifrado);
			in = MyIO.readLine();
		}
	}
}
