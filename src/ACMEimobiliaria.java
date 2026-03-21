import java.util.ArrayList;
import java.util.Scanner;

// Aplicação
public class ACMEimobiliaria {
    private Condominio condominio;
    private Scanner input;
    private Clientela clientela;

    public ACMEimobiliaria() {
        condominio = new Condominio();
        input = new Scanner(System.in);
        clientela = new Clientela();
    }

    /**
     * Execucao da aplicacao
     */
    public void executar() {
        System.out.println("Aplicacao ACMEImobiliaria!");
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("========================");
            menu();
            System.out.print("Digite a opcao desejada: ");
            opcao = input.nextInt();
            input.nextLine();
            System.out.println("========================");
            switch (opcao) {
                case 0:
                    break;
                case 1:
                    cadastrarCasa();
                    break;
                case 2:
                    consultarCasaPorEndereco();
                    break;
                case 3:
                    listarTodasCasas();
                    break;
                case 4:
                    removerAcimaDeValor();
                    break;
                case 5:
                    consultarCasaPorTamanho();
                    break;
                case 6:
                    alterarEnderecoCasa();
                    break;
                case 7:
                    cadastrarCliente();
                    break;
                case 8:
                    consultarCliente();
                    break;
                case 9:
                    listarClientela();
                    break;
                case 10:
                    cadastrarCompraCasa();
                    break;
                case 11:
                    listarCasasCompradas();
                    break;
                case 98:
                    easterEggCliente();
                    break;
                case 99:
                    easterEggCasa();
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }
        }

    }

    /**
     * Menu de opcoes para o usuario
     */
    private void menu() {
        System.out.println("Menu de opcoes");
        System.out.println("[1] Cadastrar uma casa");
        System.out.println("[2] Consultar casa por endereço");
        System.out.println("[3] Listar todas as casas");
        System.out.println("[4] Remover casas acima de um valor");
        System.out.println("[5] Consultar casas por tamanho");
        System.out.println("[6] Alterar endereço de uma casa");
        System.out.println("[7] Cadastrar um cliente");
        System.out.println("[8] Consultar cliente");
        System.out.println("[9] Listar todos os clientes");
        System.out.println("[10] Cadastrar a compra de uma casa");
        System.out.println("[11] Listar casas compradas");
        System.out.println("[0] Sair");
    }

    /**
     * Cadastramento de uma casa
     */
    private void cadastrarCasa() {
        System.out.println("Cadastrar uma casa");
        System.out.println("------------------");
        System.out.print("Digite o tamanho: ");
        int tamanho = input.nextInt();
        System.out.print("Digite o valor: ");
        double valor = input.nextDouble();
        input.nextLine();
        System.out.print("Digite o endereco: ");
        String endereco = input.nextLine();
        Casa casa = new Casa(tamanho, valor, endereco);
        boolean resultado = condominio.cadastrarCasa(casa);
        if (resultado)
            System.out.println("Casa cadastrada!");
        else
            System.out.println("Erro no cadastramento!");
    }

    /**
     * Consulta uma casa por endereco
     */
    private void consultarCasaPorEndereco() {
        System.out.println("Consultar uma casa por endereco");
        System.out.println("------------------------------");
        System.out.print("Digite o endereco: ");
        String endereco = input.nextLine();
        Casa casa = condominio.consultarCasaEndereco(endereco);
        if (casa == null)
            System.out.println("Casa nao encontrada.");
        else {
            System.out.println("Tamanho: " + casa.getTamanho());
            System.out.println("Valor: " + casa.getValor());
            System.out.println("Endereco: " + casa.getEndereco());
        }
    }

    /**
     * Lista todos as casas cadastrados
     */
    private void listarTodasCasas() {
        System.out.println("Listar todas as casas");
        System.out.println("----------------------");
        ArrayList<Casa> listaCasas = condominio.consultarTodasCasas();
        if (listaCasas.isEmpty())
            System.out.println("Nenhuma casa cadastrada.");
        else {
            for (int i = 0; i < listaCasas.size(); i++) {
                Casa casa = listaCasas.get(i);
                System.out.println("Tamanho: " + casa.getTamanho());
                System.out.println("Valor: " + casa.getValor());
                System.out.println("Endereco: " + casa.getEndereco());
                System.out.println("--------------------------");
            }
        }
    }

    private void removerAcimaDeValor(){
        System.out.print("Digite o valor a ser usado de parâmetro: R$");
        double x = input.nextDouble();
        input.nextLine();
        int y = condominio.removerAcima(x);
        if (y > 1){
            System.out.println("Foram removidas " + y + " casas.");
        } else if (y == 1){
            System.out.println("Foi removida " + y + " casa.");
        } else {
            System.out.println("Nenhuma casa foi removida.");
        }
        

    }

    private void consultarCasaPorTamanho(){
        System.out.print("Digite o tamanho a ser consultado: ");
        double tamanho = input.nextDouble();
        input.nextLine();
        ArrayList<Casa> casasTamanho = condominio.consultarCasaTamanho(tamanho);
        if (casasTamanho.size() == 0)
            System.out.println("Nenhuma casa encontrada.");
        else {
            for (Casa c : casasTamanho){
                System.out.println("Tamanho: " + c.getTamanho());
                System.out.println("Valor: " + c.getValor());
                System.out.println("Endereço: " + c.getEndereco());
                System.out.println("--------------------------");
            }
        }
    }
    
    private void alterarEnderecoCasa(){
        System.out.print("Digite o endereço que está errado: ");
        String address = input.nextLine();
        Casa casa = condominio.consultarCasaEndereco(address);

        if (casa != null){
            System.out.print("Digite o novo endereço: ");
            String newAd = input.nextLine();
            condominio.alterarEndereco(newAd, casa);
            System.out.println("Endereço alterado com sucesso!");
        } else
            System.out.println("Casa não encontrada.");
        
    }

    /** Opcoes ocultas
     * 
     * Pre-cadastrar algumas casas
     */
    private void easterEggCasa() {
        System.out.println("Easter egg 2!!!");
        Casa casa;
        casa = new Casa(111, 111.11, "Rua Um");
        condominio.cadastrarCasa(casa);
        casa = new Casa(222, 222.22, "Rua Dois");
        condominio.cadastrarCasa(casa);
        casa = new Casa(333, 333.33, "Rua Tres");
        condominio.cadastrarCasa(casa);
        casa = new Casa(444, 444.44, "Rua Quatro");
        condominio.cadastrarCasa(casa);
    }

    /**
     * pre-cadastrar alguns clientes
     * 
     */
    private void easterEggCliente(){
        System.out.println("Easter egg 1!!!");
        Cliente cliente;
        cliente = new Cliente("Josias");
        clientela.cadastrarCliente(cliente);
        cliente = new Cliente("Lorenzo");
        clientela.cadastrarCliente(cliente);
        cliente = new Cliente("Marcelo");
        clientela.cadastrarCliente(cliente);
    }

    private void cadastrarCliente(){
        System.out.print("Digite o nome do cliente: ");
        String nome = input.nextLine();
        Cliente cliente = new Cliente(nome);
        clientela.cadastrarCliente(cliente);
        System.out.println("Cliente cadastrado com sucesso.");
    }

    private void cadastrarCompraCasa(){
        System.out.print("Digite o endereço da casa a ser comprada: ");
        String endereco = input.nextLine();
        Casa casa = condominio.consultarCasaEndereco(endereco);
        if (casa != null){
            System.out.print("Digite o nome do cliente comprador: ");
            String nome = input.nextLine();
            Cliente comprador = clientela.consultarClientePorNome(nome);
            if (comprador != null){
                comprador.comprarCasa(casa);
                System.out.println("O cliente " + comprador.getNome() + " adquiriu o imóvel da " + casa.getEndereco() + ".");
            } else {
                System.out.println("Cliente não encontrado.");
            }
        } else {
            System.out.println("Casa não encontrada.");
        }
    }

    private void listarCasasCompradas(){
        System.out.print("Digite o nome do cliente: ");
        String nome = input.nextLine();
        Cliente cliente = clientela.consultarClientePorNome(nome);
        if (cliente != null){
            ArrayList<Casa> compradas = cliente.consultarCasasCompradas();
            if (compradas.isEmpty()){
                System.out.println("O cliente " + cliente.getNome() + " não possui casa.");
            } else {
                for (Casa casa : compradas) {
                    System.out.println("Tamanho: " + casa.getTamanho());
                    System.out.println("Valor: " + casa.getValor());
                    System.out.println("Endereco: " + casa.getEndereco());
                    System.out.println("--------------------------");
                }
            }
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private void consultarCliente(){
        System.out.print("Digite o nome do cliente: ");
        String nome = input.nextLine();
        Cliente cliente = clientela.consultarClientePorNome(nome);
        if (cliente == null){
            System.out.println("Cliente não encontrado.");
        } else {
            System.out.println("Cliente " + cliente.getNome() + " encontrado.");
        }
    }

    private void listarClientela(){
        ArrayList<Cliente> clientes = clientela.consultarTodosClientes();
        for (Cliente cliente : clientes){
            System.out.println(cliente.getNome() + "\n--------------------");
        }
    }
}
