package Projeto;

public class RepositorioClientes {
    private Cliente[] clientes;
    private int indice;

    public RepositorioClientes(int tamanho)
    {
        clientes = new Cliente[tamanho];
        indice = 0;
    }

    private int procurarIndice(String numero){
        int ind = -1;
        for(int i = 0; i < indice; i++){
            if(clientes[i].getNumero().equals(numero)) {
                ind = i;
            }
        }
        return ind;
    }

    public Cliente procurar(String numero){
        int ind = procurarIndice(numero);
        if(ind != -1){
            return clientes[ind];
        }
        else{
            System.out.println("Cliente não encontrado.");
            return null;
        }
    }

    public boolean inserir(Cliente c)
    {
        boolean result = false;
        if(c != null){
            if(indice == clientes.length){
                System.out.println("O repositório está cheio.");
            }
            else{
                if(procurarIndice(c.getNumero()) == -1){
                    clientes[indice] = c;
                    indice++;
                    result = true;
                }
                else{
                    System.out.println("O cliente já existe.");
                }
            }
        }
        else{
            System.out.println("Cliente inválido.");
        }
        return result;
    }

    public boolean atualizar(Cliente c){
        boolean result = false;
        if(c != null){
            int ind = procurarIndice(c.getNumero());

            if(ind == -1){
                System.out.println("O cliente não existe.");
            }
            else{
                Cliente cliente = clientes[ind];
                cliente.setNome(c.getNome());
                cliente.setCpf(c.getCpf());
                cliente.setEmail(c.getEmail());
                cliente.setSaldo(c.getSaldo());
                result = true;
            }
        }

        return result;
    }

    public boolean remover(String numero){
        int i = procurarIndice(numero);
        if(i != -1){
            clientes[i] = clientes[indice - 1];
            indice--;
            return true;
        }

        return false;
    }
    public String toString(){
        String result = "";
        for(int i = 0; i < indice; i++){
            result += clientes[i] + "\n";
        }

        return result;
    }

}
