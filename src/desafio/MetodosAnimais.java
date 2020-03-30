/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desafio;

/**
 *
 * @author Escrivá
 */
public interface MetodosAnimais<Arvore> {
    
        public Arvore getArvore(); //Método para "recuperar" os dados nos 'nós' da Árvore.

	public void setArvore(Arvore no); //Método utilizado para iniciar a árvore.
    
        public void inserir(Arvore no); //Método para inserir os valores nos 'nós' da Árvore.

	public void perguntar(Arvore no); //Método para conferir as respostas.

	
    
}
