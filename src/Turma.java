
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
       
        for (Aluno alu: alunos){
            if (alu.media() >= 7) {
                quant++;
            }
        }
        
        return quant;
    }
    public int quantidadeAlunosReprovados(){
    
         return quantidadeAlunos() - quandidadeAlunosAprovados();
         
    }
    public float percentualAlunosAprovados(){
        return (100*quandidadeAlunosAprovados()/quantidadeAlunos());
    }
    public float percenturalAlunosReprovados(){
       
            return (100*quantidadeAlunosReprovados()/ quantidadeAlunos());
        
    }
    public float mediaGeral(){
        float media =0;
        
        if (quantidadeAlunos()>0){
            for(Aluno alu:alunos){
                media += alu.media();
            }
            
        }return media/quantidadeAlunos();
    }
    public void matricula(Aluno aluno){
        alunos.add(aluno);
        aluno.setTurma(this);
    }       
    public void cancelarMatricula(Aluno aluno){
        alunos.remove(aluno);
        aluno.setTurma(null);
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }
    public void alunosCadastrados(){
        System.out.println("Alunos Cadastrados");
        int x =0;
        for (Aluno alu: alunos){
            System.out.println(alu.getRa()+ " - " + alu.getNome()+" - Media: "+alu.media());
        }
    }
}

