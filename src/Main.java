import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Grafo g = new Grafo();
        Scanner k = new Scanner(System.in);

        g.CadastraCidade("poa");
        g.CadastraCidade("canoas");
        g.CadastraCidade("viamao");
        g.CadastraCidade("novo hamburgo");

        g.CadastraConexao("poa", "canoas", 15);
        g.CadastraConexao("canoas", "novo hamburgo", 20);
        g.CadastraConexao("novo hamburgo", "viamao", 100);
        g.CadastraConexao("viamao", "poa", 50);

        String[] menu = new String[] {"*** Menu ***",
                "1 - Cadastrar Cidade",
                "2 - Cadastrar Conexão",
                "3 - Listar Cidades",
                "4 - Listar Conexões",
                "5 - Listar Cidades Vizinhas",
                "0 - Sair"
        };

        int opt;

        do{
            for(String s : menu) System.out.println(s);
            opt = k.nextInt();

            switch (opt){
                case 1 -> {
                    System.out.println("Digite o nome da Cidade: ");
                    k.nextLine();
                    String nome = k.nextLine();
                    g.CadastraCidade(nome);
                }
                case 2 -> {
                    System.out.println("Digite o nome da primeira cidade:");
                    k.nextLine();
                    String nome1 = k.nextLine();
                    System.out.println("Digite o nome da segunda cidade:");
                    String nome2 = k.nextLine();
                    System.out.println("Digite a distância entre as cidades:");
                    int dist = k.nextInt();
                    g.CadastraConexao(nome1, nome2, dist);
                }
                case 3 -> g.InfoCidades();
                case 4 -> g.InfoConexoes();
                case 5 -> {
                    System.out.println("Digite o nome da cidade:");
                    k.nextLine();
                    String nome = k.nextLine();
                    g.InfoCidadesVizinhas(nome);
                }
            }
        }while(opt != 0);

        k.close();
        System.out.println("Programa fechado.");
    }
}