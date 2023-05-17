import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grafo {

    Scanner k = new Scanner(System.in);
    ArrayList<Vertice> cidades = new ArrayList<>();
    ArrayList<Aresta> conexoes = new ArrayList<>();

    // Array List utilizado para pegar distâncias e organizar de menor a maior
    ArrayList<Integer> distancias = new ArrayList<Integer>();
    public void InfoCidades(){
        System.out.println("Cidades:");
        ArrayList<String> nomes = new ArrayList<>();
        cidades.forEach(c -> {
            nomes.add(c.nomeCidade);
        });
        Collections.sort(nomes);
        nomes.forEach(System.out::println);
    }
    public void InfoConexoes(){
        if(conexoes != null){
            System.out.println("Conexões:");
            if(!this.distancias.isEmpty()) this.distancias.clear();
            int i;
            this.conexoes.forEach(c -> {
                this.distancias.add(c.distancia);
            });
            quickSort();
            this.distancias.forEach(d ->{
                this.conexoes.forEach(c  -> {
                    if(d == c.distancia) c.Info();
                });
            });
        }else{
            System.out.println("Não há conexões.");
        }
    }

    public void InfoCidadesVizinhas(String nome){
        int i;
        boolean achou = false;
        for(i = 0; i < cidades.size(); i++){
            if(cidades.get(i).nomeCidade.equals(nome)){
                cidades.get(i).InfoVizinhos();
                achou = true;
                break;
            }
        }
        if(!achou){System.out.println("Cidade não encontrada.");}
    }
    public void CadastraCidade(String nome){
        if(cidades == null){
            cidades.add(new Vertice(nome));
            return;
        }
        int i;
        boolean achou = false;
        for(i = 0; i < cidades.size(); i++){
            if(cidades.get(i).nomeCidade.equals(nome)){
                System.out.println("A cSidade já existe!");
                achou = true;
            }
        }
        if(!achou){
            cidades.add(new Vertice(nome));
        }
    }
    public void CadastraConexao(String nome1, String nome2, int dist){
        Vertice cid1 = null;
        Vertice cid2 = null;
        if(!nome1.equals(nome2)){
            int i;
            for(i = 0; i < cidades.size(); i++){
                if(cidades.get(i).nomeCidade.equals(nome1)){
                    cid1 = cidades.get(i);
                }
                if(cidades.get(i).nomeCidade.equals(nome2)){
                    cid2 = cidades.get(i);
                }
            }
            if(cid1 != null && cid2 != null){
                if(!cid1.TemVizinho(cid2.nomeCidade)){
                    cid1.vizinhanca.add(cid2);
                    cid2.vizinhanca.add(cid1);

                    Aresta a = new Aresta(cid1, cid2, dist);
                    conexoes.add(a);

                    cid1.conexoes.add(a);
                    cid2.conexoes.add(a);
                }else{
                    System.out.println("Cidades já são vizinhas.");
                }
            }else{
                System.out.println("Uma ou mais cidades não foram encontradas.");
            }
        }else{
            System.out.println("Escolha cidades diferentes!");
        }
    }

    public void quickSort(){
        Quick(0, this.conexoes.size() - 1);
    }
    public void Quick(int low, int high){
        if(low < high){
            int partitionIndex = partition(low, high);
            Quick(low, partitionIndex - 1);
            Quick(partitionIndex + 1, high);
        }
    }
    public int partition(int low, int high) {
        int pivot = this.distancias.get(high);
        int i = (low - 1);

        for(int j = low; j <= high - 1; j++) {

            if (this.distancias.get(j) < pivot) {
                i++;
                Swap(i, j);
            }
        }
        Swap(i + 1, high);
        return (i + 1);
    }

    void Swap(int i, int j) {
        int temp = this.distancias.get(i);

        this.distancias.set(i, this.distancias.get(j));
        this.distancias.set(j, temp);

    }
}
