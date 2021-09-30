
package jogo.da.forca;

import java.util.Scanner;

public class JogoDaForca {
    public static void main(String[] args) {
        JogoForca novoJogo = new JogoForca();
        Palavra palavra = new Palavra();
        Scanner leitor = new Scanner(System.in);
        String []dicas = new String[5];
        String []dicionario = new String[5];
        int vidas = 3;
        int numPalavras = 0;
        System.out.println("Digite 5 palavras");
        int h = 0;
        int k = 0;
        for(int i = 0;i<5;i++){
            h++;
            System.out.println("Digite a "+h+"º palavra");
            palavra.setPalavra(leitor.nextLine().toUpperCase());
            dicionario[i] = palavra.getPalavra().toUpperCase();
            System.out.println("Digite a dica dessa palavra: ");
            palavra.setDica(leitor.nextLine().toUpperCase());
            dicas[i] = palavra.getDica().toUpperCase();
            
        }
        novoJogo.setDicionario(dicionario);
        
        for(int i = 0;i<5 && vidas > 0;i++){
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
                    System.out.println("GOSTARIA DE PEDIR UMA DICA? VOCÊ SÓ TEM CHANCE A 1 DICA POR PALAVRA\nDIGITE 1 PARA SIM\nDIGITE 2 PARA NÃO");
                    System.out.println("CASO HAJA APENAS 1 LETRA FALTANDO, VOCÊ NÃO OBTERÁ UMA NOVA DICA");
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
