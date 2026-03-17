import java.util.ArrayList;
import java.util.Scanner;

// Aplicação
public class ACMEimobiliaria {
    private Condominio condominio;
    private Scanner input;

    public ACMEimobiliaria() {
        condominio = new Condominio();
        input = new Scanner(System.in);
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
                case 10:
                    alterarEnderecoCasa();
                    break;
                case 99:
                    easterEgg();
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
        System.out.println("[10] Alterar endereço de uma casa");
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
        Casa casa;
        for(int i = 0; i < casasTamanho.size(); i++){
            casa = casasTamanho.get(i);
            System.out.println("Tamanho: " + casa.getTamanho());
            System.out.println("Valor: " + casa.getValor());
            System.out.println("Endereço: " + casa.getEndereco());
            System.out.println("--------------------------");
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

    /**
     * Opcao oculta
     * Pre-cadastra algumas casas
     */
    private void easterEgg() {
        System.out.println("Easter egg!!!");
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

}
