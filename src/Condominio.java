import java.util.ArrayList;

public class Condominio {
    private ArrayList<Casa> casas;

    public Condominio() {
        casas = new ArrayList<Casa>();
    }

    //operação "C" (create) - criar ou cadastrar
    public boolean cadastrarCasa(Casa c) {
        return casas.add(c);
    }

    //operação "R" (read) - consultar | ler
    public Casa consultarCasaEndereco(String endereco){
        for (int i = 0; i<casas.size(); i++){
            Casa aux = casas.get(i);
            if (aux.getEndereco().equalsIgnoreCase(endereco))
                return aux;
        }

        return null;
    }

    public ArrayList<Casa> consultarTodasCasas() {
        // ArrayList auxiliar para o retorno
        ArrayList<Casa> aux = new ArrayList<>();
        for(int i=0; i< casas.size(); i++) {
            Casa casa = casas.get(i);
            aux.add(casa);
        }
        return aux;
    }

    public int removerAcima(double valorI){
        int x = 0;
        Casa aux;
        for (int i = 0; i < casas.size(); i++){
            aux = casas.get(i);
            if (valorI < aux.getValor()){
                casas.remove(i);
                x++;
                i--;
            }
        }

        return x;        
    }

    public ArrayList<Casa> consultarCasaTamanho(double tamanho){
        ArrayList<Casa> aux = new ArrayList<Casa>();
        for (Casa c : casas){
            if (c.getTamanho() == tamanho)
                aux.add(c);
        }
        
        return aux;
    }

    public void alterarEndereco(String address, Casa casa){
        casa.setEndereco(address);
    }
}
