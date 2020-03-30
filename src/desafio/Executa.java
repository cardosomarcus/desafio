package desafio;

import desafio.NoArvore; //Importação da classe que representa a Árvore.
import javax.swing.JOptionPane;

/**
 *
 * @author Marcus Vinicius Cardoso de Melo
 */
public class Executa implements MetodosAnimais<NoArvore> {

    /*Variáveis estáticas*/
    public static int index = 1;
    public static NoArvore raiz;

    /*Métodos sobrescritos da classe Metodos Animais*/
    @Override
    public NoArvore getArvore() {
        return raiz;
    }

    @Override
    public void setArvore(NoArvore no) {
        raiz = no;
    }

    @Override
    public void inserir(NoArvore no) {
        //Guarda na variável 'animal' o valor digitado na caixa de texto.
        String animal = JOptionPane.showInputDialog(null, "Qual o animal que você pensou?");

        //Se o botão "Cancelar" for acionado, aparece a mensagem pedindo para informar algum valor.
        while (animal == null) {
            JOptionPane.showMessageDialog(null, "Informe algum valor");
            animal = JOptionPane.showInputDialog(null, "Qual o animal que você pensou?");
        }

        //Guarda na variável 'verbo' o valor digitado na caixa de texto.
        String verbo = JOptionPane.showInputDialog("Um(a) " + animal + "______ mas um " + no.valor + " não.");

        //Se o botão "Cancelar" for acionado, aparece a mensagem pedindo para informar algum valor.
        while (verbo == null) {
            JOptionPane.showMessageDialog(null, "Informe algum valor");
            verbo = JOptionPane.showInputDialog("Um(a) " + animal + "______ mas um " + no.valor + " não.");
        }

        //Cria a variável 'temp' para receber o valor que está em 'no.valor'
        //Exemplo: Se 'no.valor' tem "Macaco" armazenado, agora a variável 'temp' terá "Macaco" armazenado.
        String temp = no.valor;

        //'no.valor' passa a receber a variável 'verbo'. Exemplo: Digamos que 'verbo' tenha armazenado "Late"
        no.valor = verbo;

        //'no.noDireito' armazena o valor de animal criando um novo nó a direita. Exemplo: Animal tenha recebido "Cachorro".
        no.noDireito = new NoArvore(++index, animal);

        //'no.noEsquerdo' armazena o valor da variável 'temp'("Macaco", por exemplo) criando um novo nó a esquerda.
        no.noEsquerdo = new NoArvore(++index, temp);
    }

    @Override
    public void perguntar(NoArvore no) {
        //Mostra na pergunta o "verbo" que a pessoa digitou quando chamou o método inserir.

        int pergunta;

       //Condição para mudar o enunciado da pergunta
        if ((no.noDireito == null) && (no.noEsquerdo == null)) {
            pergunta = JOptionPane.showConfirmDialog(null, "O animal que você pensou é o(a) " + no.valor + "?", "Confirme",
                       JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        } else {
            pergunta = JOptionPane.showConfirmDialog(null, "O animal que você pensou " + no.valor + "?", "Confirme",
                       JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        }
        //Se a pergunta estiver correta (for igual a '0') mostra a mensagem 'Eu venci'.
        if (pergunta == 0) {
            if (no.noDireito == null) {
                JOptionPane.showMessageDialog(null, "Eu venci", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            } //Caso o retorno da pergunta seja "Não" (1). Faz a pergunta novamente com o valor que está no nó da direita.
            else {
                System.out.println(no.noDireito);
                perguntar(no.noDireito);

            }

        } /*Se o retorno da pergunta for "Não", verifica se o nó da esquerda está nulo e insere um novo nó.
         Se não estiver vazio, chama o método perguntar  */
        else {
            if (no.noEsquerdo == null) {
                inserir(no);

            } else {
                perguntar(no.noEsquerdo);
            }
        }
    }

    public static void main(String[] args) {
        Executa executa = new Executa();
        int opcao = 0;

        while (opcao == 0) {
            //Pergunta que inicia o jogo.
            opcao = JOptionPane.showConfirmDialog(null, "Pense em um animal.", "Jogo dos animais", JOptionPane.OK_CANCEL_OPTION);

            //Se o retorno for "OK" (0), insere os valores abaixo nos nós.
            if (opcao == 0) {

                //Verifica se a Árvore está vazia
                if (executa.getArvore() == null) {
                    executa.setArvore(new NoArvore(index, "vive na água?"));
                    executa.getArvore().noEsquerdo = new NoArvore(++index, "Macaco");
                    executa.getArvore().noDireito = new NoArvore(++index, "Tubarão");
                }

                //Com a Árvore já populada, concatena o valor que tem na variável 'valor' da Árvore.
                int resposta = JOptionPane.showConfirmDialog(null, "O animal que você pensou " + executa.getArvore().valor,
                        "Confirme", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (resposta == 0) {
                    executa.perguntar(executa.getArvore().noDireito);
                } else {
                    executa.perguntar(executa.getArvore().noEsquerdo);
                }
            }

        }
    }

}
