
package desafio;

/**
 *
 * @author Marcus Vinícius Cardoso de Melo
 */
public class NoArvore {
        
        public int elemento;
	public NoArvore noEsquerdo;
	public NoArvore noDireito;
	public String valor;

        /*Construtor da classe vazio */
        public NoArvore() {

	}
        
	/** Construtor que recebe o número do elemento e o respectivo valor.
         Necessário para a inicialização da árvore*/
        
	public NoArvore(int elemento, String valor) {
		this.elemento = elemento;
		this.valor = valor;
	}

	
}
