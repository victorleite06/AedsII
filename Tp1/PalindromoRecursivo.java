class PalindromoRecursivo{
	
	public static boolean Palindromo(String in,int i,boolean ehPalin){
		if(i < in.length()/2){
			if(in.charAt(i) != in.charAt(in.length()-1-i)){
				ehPalin = false;
				i = in.length();
			}
			i++;
			Palindromo(in,i,ehPalin);
		}
		return ehPalin;
	}

	public static void main(String[] args){
		String in = MyIO.readLine();
		boolean ehPalin;
		while(!(in.length() == 3 && in.charAt(0) == 'F' && in.charAt(1) == 'I' && in.charAt(2) == 'M')){
			ehPalin = true;
			ehPalin = Palindromo(in,0,ehPalin);
			if(ehPalin)
				MyIO.println("SIM");
			else
				MyIO.println("NAO");
			in = MyIO.readLine();
		}
	}
}
