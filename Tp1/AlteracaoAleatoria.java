import java.util.Random;

class AlteracaoAleatoria{
	public static void main(String[] args){
		String in = MyIO.readLine();
		while(!(in.length() == 3 && in.charAt(0) == 'F' && in.charAt(1) == 'I' && in.charAt(2) == 'M')){
			String alt = alterar(in);
			MyIO.println(alt);
			in = MyIO.readLine();
		}
	}

	public static String alterar(String in){
		String aux = new String();
		Random gerador = new Random();
		gerador.setSeed(4);
		char letr = ((char)('a' + (Math.abs(gerador.nextInt()) % 26)));
		char subs = ((char)('a' + (Math.abs(gerador.nextInt()) % 26)));
		for(int i = 0;i < in.length();i++){
			if(in.charAt(i) == letr){
				aux += subs;	
			}else{
				aux += in.charAt(i);
			}
		}
		return aux;
	}
}
