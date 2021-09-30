package jogo.da.forca;
public class JogoForca {
    private String[] dicionario;
    private int posicaoSorteada;
    private String gabarito = "";

    public int getPosicaoSorteada() {
        return posicaoSorteada;
    }

    public String getGabarito() {
        return gabarito;
    }

    public String[] getDicionario() {
        return dicionario;
    }

    public void setDicionario(String[] dicionario) {
        this.dicionario = dicionario;
    }
    
    public String pegarDica(){
       
       String []dica = gabarito.split("");
       String palavra = dicionario[posicaoSorteada];
       String pose = "?";
       String pFinal = "";
       int cont=0;
       
       for(int i = 0;i<dica.length;i++){
           
           if(dica[i].equals(pose))
               cont++;
           
           
       }
       int [] duvidas = new int[cont];
       for(int i = 0;i<cont;i++){
           duvidas[i] = pose == dica[i]?i:-1;
           
       }
       int p1 = duvidas[0];
       int p2 = duvidas[0];
       if(cont > 2){
            for(int i = 0;p1==duvidas[i] ;i++){
                p1 = (int)(Math.random()*gabarito.length());
            }
            for(int i = 0;p2==duvidas[i] ;i++){
                p2 = (int)(Math.random()*gabarito.length());
            }
            dica[p1] = ""+palavra.charAt(p1);
            dica[p2] = ""+palavra.charAt(p2);
        }else if(cont == 2){
            for(int i = 0;p1==duvidas[i] ;i++){
                p1 = (int)(Math.random()*gabarito.length());
            }
            dica[p1] = ""+palavra.charAt(p1);
        }
       for(int i=0;i<palavra.length();i++){
           pFinal+=dica[i];
       }
       gabarito = pFinal;
       return cont < 2 ? "SÓ RESTA 1 LETRA":pFinal;
       
    }
    public void sortear(){
        posicaoSorteada = (int)(Math.random()*dicionario.length);
        for(int i = 0;dicionario[posicaoSorteada]==null;i++){
            posicaoSorteada = (int)(Math.random()*dicionario.length);
        }
        String palavraS = dicionario[posicaoSorteada];
        for(int i = 0;i<palavraS.length();i++){
            gabarito += "?";
        }
        
        
    }
    public boolean testarLetra(char letra){
        int cont = 0;
        String gabaritoNew ="";
        if(gabarito.length()==0){
            for(int i = 0;i<dicionario[posicaoSorteada].length();i++){
                gabarito+="?";
            }
        }
        char [] novoGabarito = gabarito.toCharArray();
        char [] palavraCerta = dicionario[posicaoSorteada].toCharArray();
        for(int i = 0;i<gabarito.length();i++){
            
            if(letra == palavraCerta[i]){
                novoGabarito[i] = letra;
                cont++;
            }else if(novoGabarito[i]=='?'){
                novoGabarito[i] = '?';
            }
        }
        for(int i = 0;i<gabarito.length();i++){
            gabaritoNew += novoGabarito[i];        
        }
        gabarito = gabaritoNew;
        return cont>0?true:false;
    }
    public boolean testaSeAcabou(){
        int cont = 0;
        for(int i = 0;i<gabarito.length();i++){
            char l = gabarito.charAt(i);
            cont += l == '?' ?1:0;
        }
        if(cont>0){
            return false;
        }else{
            dicionario[posicaoSorteada] = null;
            posicaoSorteada = -1;
            gabarito = "";
            return true;
        }
    }
}
