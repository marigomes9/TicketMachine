package br.mackenzie.ticketmachine.core;

import br.mackenzie.ticketmachine.exception.PapelMoedaInvalidException;
import java.util.Arrays;
import java.util.List;
/**
 *
 * @author Mariana Gomes
 */
public class PapelMoeda {

	protected int valor;
        
	public PapelMoeda(int valor) throws PapelMoedaInvalidException {
            verificaValor(valor);
            this.valor = valor;
	}
        
	public int getValor() {
            return valor;
	}
        
        private void verificaValor(int valor) throws PapelMoedaInvalidException{
            List<Integer> valoresPossiveis = Arrays.asList(2,5,10,20,50,100);
            if(valoresPossiveis.contains(valor)){
                
            }else{
                throw new PapelMoedaInvalidException();
            }
        }
}

