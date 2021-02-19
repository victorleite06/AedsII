import java.io.*;
import java.net.*;

class LeituraDePaginaHTML{

	public static String getHTML(String endereco){
		URL url;
		InputStream is = null;
		BufferedReader br;
		String resp = "", line;

		try{
			url = new URL(endereco);
			is = url.openStream();
			br = new BufferedReader(new InputStreamReader(is));

			while((line = br.readLine()) != null){
				resp += line.toLowerCase() + "\n";
			}
		} catch(MalformedURLException mue){
			mue.printStackTrace();
		} catch(IOException ioe){
			ioe.printStackTrace();
		}

		try{
			is.close();
		} catch(IOException ioe){}
		
		return resp;
	}
	
	public static void main(String[] args){
		MyIO.setCharset("UTF-8");
		String nome,endereco, html;
		nome = MyIO.readLine();
		int cons = 0, a = 0, e = 0, i = 0, o = 0, u = 0, a1 = 0, e1 = 0, i1 = 0, o1 = 0, u1 = 0;
		int a2 = 0, e2 = 0, i2 = 0, o2 = 0, u2 = 0, a3 = 0, o3 = 0, a4 = 0, e3 = 0, i3 = 0, o4 = 0, u3 = 0;
		int br = 0, table = 0;
		while(!(nome.length() == 3 && nome.charAt(0) == 'F' && nome.charAt(1) == 'I' && nome.charAt(2) == 'M')){
			endereco = MyIO.readLine();
			html = getHTML(endereco);
			for(int j = 0;j < html.length();j++){
				if(html.charAt(j) == 'a')
					a++;
				if(html.charAt(j) == 'e')
					e++;
				if(html.charAt(j) == 'i')
					i++;
				if(html.charAt(j) == 'o')
					o++;
				if(html.charAt(j) == 'u')
					u++;
				if(html.charAt(j) == 225)
					a1++;
				if(html.charAt(j) == 233)
					e1++;
				if(html.charAt(j) == 237)
					i1++;
				if(html.charAt(j) == 243)
					o1++;
				if(html.charAt(j) == 250)
					u1++;
				if(html.charAt(j) == 224)
					a2++;
				if(html.charAt(j) == 232)
					e2++;
				if(html.charAt(j) == 236)
					i2++;
				if(html.charAt(j) == 242)
					o2++;
				if(html.charAt(j) == 249)
					u2++;
				if(html.charAt(j) == 227)
					a3++;
				if(html.charAt(j) == 245)
					o3++;
				if(html.charAt(j) == 226)
					a4++;
				if(html.charAt(j) == 234)
					e3++;
				if(html.charAt(j) == 238)
					i3++;
				if(html.charAt(j) == 244)
					o4++;
				if(html.charAt(j) == 251)
					u3++;
				if(!(html.charAt(i) >= 'a' && html.charAt(i) <= 'z'))
					cons++;	
				if(html.charAt(j) == '<' && html.charAt(j+1) == 'b' && html.charAt(j+2) == 'r' && html.charAt(j+3) == '>'){
					br++;
					j = j + 3;
				}
				if(html.charAt(j) == '<' && html.charAt(j+1) == 't' && html.charAt(j+2) == 'a' && html.charAt(j+3) == 'b' && html.charAt(j+4) == 'l' && html.charAt(j+5) == 'e' && html.charAt(j+6) == '>'){
					table++;
					j = j + 6;
				}
			}
			MyIO.println("a(" + a + ") e(" + e + ") i(" + i + ") o(" + o + ") u(" + u + ") "+  (char)(225) +"(" + a1 + ") " + (char)(233) + "(" + e1 + ") " + (char)(237) + "(" +
					i1 + ") " + (char)(243) + "(" + o1 + ") " + (char)(250) + "(" + u1 + ") " + (char)(224) + "(" + a2 + ") " + (char)(232) + "(" + e2 + ") " + (char)(236) +
				       	"(" + i2 + ") " + (char)(242) + "(" + o2 + ") " + (char)(249) + "(" + u2 + ") " + (char)(227) + "(" + a3 + ") " + (char)(245) + "(" + o3 +
				       	") " + (char)(226) + "(" + a4 + ") " + (char)(234) + "(" + e3 + ") " + (char)(238) + "(" + i3 + ") " + (char)(244) + "(" + o4 + ") " + (char)(251)+ "(" + u3 + 
					") consoante(" + cons + ") <br>(" + br + ") <table>(" + table + ") " + nome);
			nome = MyIO.readLine();
		}
	}
}
