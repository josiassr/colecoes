import java.util.ArrayList;

public class Clientela {
    private ArrayList<Cliente> clientes;

    public Clientela() {
        clientes = new ArrayList<Cliente>();
    }

    public boolean cadastrarCliente(Cliente c) {
        clientes.add(c);
        return true;
    }

    public Cliente consultarClientePorNome(String nome) {
        for(Cliente cliente : clientes){
            if(cliente.getNome().equals(nome)){
                return cliente;
            }
        }
        return null;
    }
    
    public ArrayList<Cliente> consultarTodosClientes(){
        ArrayList<Cliente> aux = new ArrayList<Cliente>();
        for (Cliente cliente : clientes){
            aux.add(cliente);
        }
        return aux;
    }
}