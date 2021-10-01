
package jogo.da.forca;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class JogoDaForca {
    public static void main(String[] args) {
        Path localP = Paths.get("palavras.txt");
        Path LocalD = Paths.get("dicas.txt");
        String [] listaD = null;
        String [] listaP = null;
        try{
            byte[] dadosP = Files.readAllBytes(localP);
            byte[] dadosD = Files.readAllBytes(LocalD);
            String tudoP = new String(dadosP).toUpperCase();
            String tudoD = new String(dadosD).toUpperCase();
            listaP = tudoP.split(",");
            listaD = tudoD.split(",");
            
                
            
        }catch(Exception erro){
            System.out.println("erro ao encontrar o diretório");
        }
        
        
        JogoForca novoJogo = new JogoForca();
        Palavra palavra = new Palavra();
        Scanner leitor = new Scanner(System.in);
        String []dicas = listaD;
        String []dicionario = listaP;
        
        
        
        int vidas = 3;
        int numPalavras = 0;
        
        
        int k = 0;
        
        novoJogo.setDicionario(dicionario);
        
        for(int i = 0;i<novoJogo.getDicionario().length && vidas > 0;i++){
            k++;
            vidas = 3;
            novoJogo.sortear();
            int dica = 1;
            int resposta = 0;
            System.out.println("---------- PALAVRA "+k+" ----------");
            System.out.println("VOCÊ TERÁ 3 VIDAS PARA CADA PALAVRA");
            
            for(int j = 0;0<vidas && novoJogo.testaSeAcabou() == false;j++){
                System.out.println("VIDAS: "+vidas);
                System.out.println("DICAS: "+dica);
                System.out.println("DICA DA PALAVRA:"+dicas[novoJogo.getPosicaoSorteada()]);
                System.out.println("PALAVRA: "+novoJogo.getGabarito());
                
                if(dica == 1){
                    System.out.println("CASO HAJA APENAS 1 LETRA FALTANDO, VOCÊ NÃO OBTERÁ UMA NOVA DICA");
                    System.out.println("GOSTARIA DE PEDIR UMA DICA? VOCÊ SÓ TEM CHANCE A 1 DICA POR PALAVRA\nDIGITE 1 PARA SIM\nDIGITE 2 PARA NÃO");
                    resposta = Integer.parseInt(leitor.next());
                    
                }
                if(resposta == 1 && dica == 1){
                    novoJogo.pegarDica();
                    System.out.println("DICA DA PALAVRA:"+dicas[novoJogo.getPosicaoSorteada()]);
                    System.out.println("PALAVRA: "+novoJogo.getGabarito());
                    dica = 0;
                    
                }
                System.out.println("DIGITE UMA LETRA: ");
                String letra = leitor.next().toUpperCase();
                char letraa = letra.charAt(0);
                if(novoJogo.testarLetra(letraa) == false){
                    System.out.println("NÃO HÁ ESTA LETRA NA PALAVRA");
                    vidas-=1;
                }
                if(novoJogo.testaSeAcabou() && vidas>0){
                    numPalavras +=1;
                    break;
                }
            }
            
            
        }
        System.out.println("---------- FIM DE JOGO ----------");
        System.out.println("VOCÊ ACERTOU "+numPalavras+" PALAVRAS");
    }
    
}
