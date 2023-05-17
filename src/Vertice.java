import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
public class Vertice {
    String nomeCidade;
    ArrayList<Vertice> vizinhanca = new ArrayList<>();
    ArrayList<Aresta> conexoes = new ArrayList<>();

    //public Vertice(){}
    public Vertice(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }
    public void InfoVizinhos(){
        int[] distancias = new int[conexoes.size()];

        if(vizinhanca != null){
            int i,j, aux;
            for(i = 0; i < distancias.length; i++){
                distancias[i] = conexoes.get(i).distancia;
            }

            // Bubble Sort
            for(i = 0; i < distancias.length; i++){
                for(j = 0; j< distancias.length -1; j++){
                    if(distancias[j] > distancias[j+1]){
                        aux = distancias[j];
                        distancias[j] = distancias[j+1];
                        distancias[j+1] = aux;
                    }
                }
            }

            for(i = 0; i < distancias.length; i++){
                for(j = 0; j < distancias.length; j++){
                    if(conexoes.get(j).distancia == distancias[i]){
                        conexoes.get(j).Info();
                    }
                }
            }

        }else{
            System.out.println("Não há vizinhança.");
        }
    }
    public void InfoConexoes(){
        if(conexoes != null){
            System.out.println("Conexões:");
            this.conexoes.forEach(Aresta::Info);
        }else{
            System.out.println("Não há conexões.");
        }
    }

    public void InfoVertice(){
        System.out.println("Cidade: " + this.nomeCidade);
        System.out.println("Vizinhos: ");
        vizinhanca.forEach(v -> {
            System.out.println(v.nomeCidade);
        });
        System.out.println("Conexões: ");
        InfoConexoes();
    }

    public boolean TemVizinho(String nome){
        boolean achou = false;
        int i;
        if(vizinhanca == null){
            return false;
        }
        for(i = 0; i < vizinhanca.size(); i++){
            if(vizinhanca.get(i).nomeCidade.equals(nome)){
                achou = true;
                break;
            }
        }
        return achou;
    }
}
