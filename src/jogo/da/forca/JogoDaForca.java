
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
            palavra.setPalavra(leitor.nextLine());
            dicionario[i] = palavra.getPalavra();
            System.out.println("Digite a dica dessa palavra: ");
            palavra.setDica(leitor.nextLine());
            dicas[i] = palavra.getDica();
            
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
                System.out.println("DICA DA PALAVRA:"+dicas[novoJogo.getPosicaoSorteada()]);
                System.out.println("PALAVRA: "+novoJogo.getGabarito());
                
                if(dica == 1){
                    System.out.println("GOSTARIA DE PEDIR UMA DICA? VOCÊ SÓ TEM CHANCE A 1 DICA POR PALAVRA\n1- SIM\n2- NÃO");
                    resposta = Integer.parseInt(leitor.next());
                    
                }
                if(resposta == 1 && dica == 1){
                    novoJogo.pegarDica();
                    dica = 0;
                    
                }
                System.out.println("DIGITE UMA LETRA: ");
                String letra = leitor.next();
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
    }
    
}
