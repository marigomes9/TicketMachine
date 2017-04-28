package br.mackenzie.ticketmachine.core;

import br.mackenzie.ticketmachine.exception.PapelMoedaInvalidException;
import br.mackenzie.ticketmachine.exception.SaldoInsuficienteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mariana Gomes
 */
public class Troco {
    private final List<Integer> valoresPossiveis;
    private final List<PapelMoeda> papeisMoeda;
    
    public Troco(){
        valoresPossiveis = Arrays.asList(100,50,20,10,5,2);
        papeisMoeda = new ArrayList();
    }
    
    public List<PapelMoeda> gerarTroco(int saldo) throws PapelMoedaInvalidException {
        calcularPapeisMoeda(saldo);
        return papeisMoeda;
    }
    
        private void calcularPapeisMoeda(int saldo) throws PapelMoedaInvalidException{
            for(int valor : valoresPossiveis){
                if(saldo >= valor){
                    PapelMoeda papelMoeda = new PapelMoeda(valor);
                    papeisMoeda.add(papelMoeda);
                    saldo -= valor;
                    break;
                }
            }
                    if(saldo > 0){
                calcularPapeisMoeda(saldo);
            }
        }
       

}
