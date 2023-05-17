public class Aresta {
    Vertice cidade1;
    Vertice cidade2;
    int distancia;

    public Aresta(Vertice cidade1, Vertice cidade2, int distancia) {
        this.cidade1 = cidade1;
        this.cidade2 = cidade2;
        this.distancia = distancia;
    }
    public void Info(){
        System.out.println(this.cidade1.nomeCidade + " ↔ " + this.distancia + "km ↔ " + this.cidade2.nomeCidade);
    }
}
