class Palindromo{
	public static void main(String[] args){
		int i = -1;
		String in[] = new String[1000];
		boolean ehPalin = true;
		
		do{
			i++;
			in[i] = MyIO.readLine();
		}while(!(in[i].length() == 3 && in[i].charAt(0) == 'F' && in[i].charAt(1) == 'I' && in[i].charAt(2) == 'M'));

		for(int j = 0;j < i;j++){
			for(int h = 0;h < in[j].length()/2;h++){
				if(in[j].charAt(h) != in[j].charAt(in[j].length()-1-h)){
					ehPalin = false;
					h = in[j].length();
				}
				if(ehPalin)
					MyIO.println("SIM");
				else
					MyIO.println("NAO");
			}
		}
	}
}
