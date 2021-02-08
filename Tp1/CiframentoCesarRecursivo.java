class CiframentoCesarRecursivo{
	public static void Cifrar(String in){
		Cifrar(in,"",0);
	}

	public static void Cifrar(String in,String cifrado,int i){
		if(i < in.length()){
			cifrado += (char)(in.charAt(i)+3);
			i++;
			Cifrar(in,cifrado,i);
			if(i == in.length())
				MyIO.println(cifrado);
		}
	}

	public static void main(String[] args){
		String in = MyIO.readLine();
		while(!(in.length() == 3 && in.charAt(0) == 'F' && in.charAt(1) == 'I' && in.charAt(2) == 'M')){
			Cifrar(in);
			in = MyIO.readLine();
		}
	}
}
