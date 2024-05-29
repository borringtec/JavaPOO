import java.util.*;

public class Dev {

    private String nome;
    private List<Conteudo> listaConteudos = new ArrayList<>();

    public void inscreverBootcamp(Bootcamp bootcamp){
        this.listaConteudos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }

    public void progredir() {
        Optional<Conteudo> conteudo = this.listaConteudos.stream().findFirst();
        if(conteudo.isPresent()) {
            conteudo.get().setConcluido("Concluído");
        } else {
            System.err.println("Você não está matriculado em nenhum conteúdo!");
        }
    }

    public double calcularTotalXp() {
        Iterator<Conteudo> iterator = this.listaConteudos.iterator();
        double soma = 0;
        while(iterator.hasNext()){
            double next = iterator.next().calcularXp();
            soma += next;
        }
        return soma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Conteudo> getListaConteudos() {
        return listaConteudos;
    }

    public void setListaConteudos(List<Conteudo> listaConteudos) {
        this.listaConteudos = listaConteudos;
    }



}
