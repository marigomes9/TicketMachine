
package br.mackenzie.ticketmachine.core;

import br.mackenzie.ticketmachine.exception.PapelMoedaInvalidException;
import br.mackenzie.ticketmachine.exception.SaldoInsuficienteException;
import java.util.List;


/**
 *
 * @author Mariana Gomes
 */
public class TicketMachine {
    private final int valor;
    private final Pagamento pagamento;
    
    public TicketMachine(int valor){
        this.valor = valor;
        pagamento = new Pagamento();
    }
    
    public int verificarSaldo() {
        if(pagamento.getSaldo() != 0){
            return pagamento.getSaldo();
        }
        return 0;
    }
    
    public void inserirDinheiro(int quantia) throws PapelMoedaInvalidException{
        pagamento.atualizarSaldo(quantia);
    }
    
    public void emitirBilhete() throws SaldoInsuficienteException{
        pagamento.pagarBilhete(this.valor);
        System.out.println("Bilhete impresso!");
    }
    
    public void devolverTroco() throws PapelMoedaInvalidException{
      if(pagamento.getSaldo() != 0){
            List<PapelMoeda> troco = pagamento.solicitarTroco();
            troco.forEach((papelMoeda) -> {
                System.out.println("Imprimindo papel moeda: R$" + papelMoeda.getValor() + ",00");
             });
            pagamento.setSaldo(0);
       }
      else{
          throw new PapelMoedaInvalidException("Papel moeda insuficiente");
      }
    }

}

