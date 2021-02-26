class Is{
	public static void main(String[] args){
		String str = MyIO.readString();
		while(!(str.length() == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M')){
			str = str.toLowerCase();
			boolean	x1 = soVogais(str);
			boolean x2 = soConsoan(str);
			boolean x3 = numInt(str);
			boolean x4 = numReal(str);
			if(x1){
				MyIO.print("SIM ");
			}else{
				MyIO.print("NAO ");
			}
			if(x2){
				MyIO.print("SIM ");
			}else{
				MyIO.print("NAO ");
			}
			if(x3){
                MyIO.print("SIM ");
            }else{
               	MyIO.print("NAO ");
            }
			if(x4){
               	MyIO.print("SIM \n");
            }else{
               	MyIO.print("NAO \n");
            }
			str = MyIO.readLine();
		}
	}
	public static boolean soVogais(String stri){
		boolean soVogais = true;
		for(int i = 0;i < stri.length();i++){
			if((stri.charAt(i) != 'e' && stri.charAt(i) != 'a' && stri.charAt(i) != 'i' && stri.charAt(i) != 'o' && stri.charAt(i) != 'u') || (stri.charAt(i) >= '0' && stri.charAt(i) <= '9')){
				soVogais = false;
			}
		}
		return soVogais;
	}
	public static boolean soConsoan(String stri){
		boolean soConsoan = true;
		for(int i = 0;i < stri.length();i++){
            if((stri.charAt(i) == 'e' || stri.charAt(i) == 'a' || stri.charAt(i) == 'i' || stri.charAt(i) == 'o' || stri.charAt(i) == 'u') || (stri.charAt(i) >= '0' && stri.charAt(i) <= '9')){
                soConsoan = false;
            }
        }
		return soConsoan;
	}
	public static boolean numInt(String stri){
		boolean numInt = true;
		for(int i = 0;i < stri.length();i++){
			if(stri.charAt(i) >= 'a' && stri.charAt(i) <= 'z'){
				numInt = false;
			}
			if(stri.charAt(i) == '.'){
				numInt = false;
			}
		}
		return numInt;
	}
	public static boolean numReal(String stri){
		boolean numReal = true;
		for(int i = 0;i < stri.length();i++){
			if(stri.charAt(i) >= 'a' && stri.charAt(i) <= 'z'){
				numReal = false;
			}
			if(stri.charAt(i) != '.'){
				numReal = false;
			}
		}
		return numReal;
	}
}
