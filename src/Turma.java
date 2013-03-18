
import java.util.ArrayList;


public class Turma {
    private int codigo;
    private String descricao;
    private ArrayList<Aluno> alunos = new ArrayList<Aluno>();

    public Turma(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    // Quantidade de Alunos
    public int quantidadeAlunos(){
        return alunos.size();
    }
    // Quantidade de Alunos aprovados
    public int quandidadeAlunosAprovados(){
        int quant = 0;
        int x;
        for(x = 0; x<= alunos.size(); x ++){
            if (alunos.get(x).media() >= 7){
                quant++;
            }
        }
        return quant;
    }
    public int quantidadeAlunosReprovados(){
         return quantidadeAlunos() - quandidadeAlunosAprovados();
    }
    public float percentualAlunosAprovados(){
        return quantidadeAlunos()/100*quandidadeAlunosAprovados();
    }
    public float percenturalAlunosReprovados(){
        return quantidadeAlunos()/100*quantidadeAlunosReprovados();
    }
    public float mediaGeral(){
        float media =0;
        
        if (alunos.size()>0){
            for(Aluno al:alunos){
                media += al.media();
            }
            
        }return media/alunos.size();
    }
    public void matricula(Aluno aluno){
        alunos.add(aluno);
        aluno.setTurma(this);
    }       
    public void cancelarMatricula(Aluno aluno){
        alunos.remove(aluno);
        aluno.setTurma(null);
    }
}

