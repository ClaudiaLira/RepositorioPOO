package Projeto;

import java.util.Scanner;

public class Program {
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        s.useDelimiter("\\n");
        RepositorioClientes repo = new RepositorioClientes(50);
        System.out.println("=========================================");
        System.out.println("Bem vindo ao Banco POO");
        System.out.println("=========================================");

        Cliente pessoa1 = new Cliente("Ana", "2", "013.912.621-02", "ana@gmail.com", 329);
        Cliente pessoa2 = new Cliente("Claudia", "3", "124.156.412-00", "claudia@hotmail.com", 101);
        Cliente pessoa3 = new Cliente("Maria", "4", "103.421.124-23", "maria@outlook.com", 64);
        Cliente pessoa4 = new Cliente("Lina", "5", "276.346.768-70", "lina@gmail.com", 13);

        repo.inserir(pessoa1);
        repo.inserir(pessoa2);
        repo.inserir(pessoa3);
        repo.inserir(pessoa4);

        int menu;

        do{
            System.out.println("Digite: ");
            System.out.println("1 - inserir");
            System.out.println("2 - atualizar");
            System.out.println("3 - consultar");
            System.out.println("4 - remover");
            System.out.println("0 - sair");
            menu = s.nextInt();
            switch (menu){
                case 1:{
                    System.out.println("Digite os dados para a inserção");

                    System.out.println("Nome: ");
                    String nome = s.next();

                    System.out.println("Numero: ");
                    String numero = s.next();

                    System.out.println("CPF: ");
                    String cpf = s.next();

                    System.out.println("Email: ");
                    String email = s.next();

                    System.out.println("Saldo: ");
                    double saldo = s.nextDouble();

                    Cliente c = new Cliente(nome, numero, cpf, email, saldo);
                    if(repo.inserir(c)) {
                        System.out.println("Inseriu com sucesso.");
                    }

                    System.out.println("=========================================");

                }break;
                case 2:{
                    System.out.println("Digite o número do cliente para atualizar");
                    String numero = s.next();
                    Cliente c = repo.procurar(numero);
                    if(c != null){
                        System.out.println(c);
                        char entrada;
                        String nome, cpf, email;
                        double saldo;

                        System.out.println("Modificar nome? (s/n): ");
                        entrada = s.next().charAt(0);
                        if(entrada == 's') {
                            System.out.print("Digite o novo nome: ");
                            nome = s.next();
                        }
                        else
                            nome = c.getNome();

                        System.out.println("Modificar CPF? (s/n): ");
                        entrada = s.next().charAt(0);
                        if(entrada == 's') {
                            System.out.print("Digite o novo cpf: ");
                            cpf = s.next();
                        }
                        else
                            cpf = c.getCpf();

                        System.out.println("Modificar email? (s/n): ");
                        entrada = s.next().charAt(0);
                        if(entrada == 's') {
                            System.out.print("Digite o novo email: ");
                            email = s.next();
                        }
                        else
                            email = c.getEmail();

                        System.out.println("Modificar saldo? (s/n): ");
                        entrada = s.next().charAt(0);
                        if(entrada == 's') {
                            System.out.print("Digite o novo saldo: ");
                            saldo = s.nextDouble();
                        }
                        else saldo = c.getSaldo();

                        Cliente atualizado = new Cliente(nome, numero, cpf, email, saldo);
                        System.out.println(atualizado);
                        System.out.println("Confirmar? (s/n)");
                        entrada = s.next().charAt(0);
                        if(entrada == 's')
                            if(repo.atualizar(atualizado)){
                                System.out.println("Atualizado com êxito.");
                            }
                        else
                                System.out.println("Cancelado pelo usuário.");
                    }
                    System.out.println("=========================================");
                }break;
                case 3:{
                    System.out.println("Digite o número do cliente para buscar: ");
                    String numero = s.next();
                    Cliente c = repo.procurar(numero);
                    if(c != null){
                        System.out.println(c);
                    }
                    System.out.println("=========================================");
                }break;
                case 4:{
                    System.out.println("Digite o número do cliente a ser removido: ");
                    String numero = s.next();
                    Cliente c = repo.procurar(numero);
                    if(c!= null){
                        System.out.println(c);
                        System.out.println("Remover (s/n)?");
                        char entrada = s.next().charAt(0);
                        if(entrada == 's'){
                            if(repo.remover(numero)){
                                System.out.println("Removido com sucesso.");
                            }
                        }
                        else
                        {
                            System.out.println("Cancelado pelo usuário.");
                        }
                    }
                    System.out.println("=========================================");
                }break;
            }

        }while(menu != 0);

        System.out.println("Finalizado.");

        System.out.println(repo);
    }
}
