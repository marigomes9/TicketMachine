
package br.mackenzie.ticketmachine.core;

import br.mackenzie.ticketmachine.exception.PapelMoedaInvalidException;
import br.mackenzie.ticketmachine.exception.SaldoInsuficienteException;
import java.util.List;

/**
 *
 * @author Mariana Gomes
 */

public class Pagamento {
    private int saldo;
    private final Troco troco;
    
    public Pagamento(){
        saldo = 0;
        troco = new Troco();
    }
    
    public int getSaldo(){
        return saldo;
    }
    
    public void setSaldo(int valor) {
        this.saldo = valor;
    }
    
    public void atualizarSaldo(int quantia) throws PapelMoedaInvalidException{
        PapelMoeda papelMoeda = new PapelMoeda(quantia);
        saldo += papelMoeda.getValor();
    }
    
    public void pagarBilhete(int valor) throws SaldoInsuficienteException{
        if(saldo != 0){
            System.out.println(valor);
            System.out.println(saldo);
            if(saldo >= valor){
                saldo -= valor;
            }   
        }
        else{
            throw new SaldoInsuficienteException("Saldo Insuficiente");
        }
    }
    
    public List<PapelMoeda> solicitarTroco() throws PapelMoedaInvalidException{
        return troco.gerarTroco(saldo);
    }
}