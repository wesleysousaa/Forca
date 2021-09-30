package jogo.da.forca;
public class JogoForca {
    private String[] dicionario;
    private int posicaoSorteada;
    private String gabarito;

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
    
    
    public void sortear(){
        posicaoSorteada = (int)(Math.random()*dicionario.length);
        for(int i = 0;dicionario[posicaoSorteada]==null;i++){
            posicaoSorteada = (int)(Math.random()*dicionario.length);
        }
        String palavraS = dicionario[posicaoSorteada];
        for(int i = 0;i<=palavraS.length();i++){
            gabarito += "?";
        }
        
        
    }
    public boolean testarLetra(char letra){
        String palavraS = ""+letra;
        String letraa = dicionario[posicaoSorteada];
        for(int i = 0;i<=dicionario[posicaoSorteada].length();i++){
            
            if(palavraS.charAt(i) == letraa.charAt(i)){
                String letraaa = ""+palavraS.charAt(i);
                gabarito.charAt(i) = letraaa;
            }
        }
    }
}
