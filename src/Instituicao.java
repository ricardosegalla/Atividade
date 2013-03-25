
import java.util.ArrayList;


public class Instituicao {
   private ArrayList <Turma> turmas = new ArrayList<Turma>();
   private String descricao;

    public ArrayList<Turma> getTurmas() {
        return turmas;
    }

    public String getDescricao() {
        return descricao;
    }
   
   
   public void novaTurma(Turma turma){
    turmas.add(turma);
}
   public Instituicao(String  descricao){
       this.descricao = descricao;
   }

    public void setTurmas(ArrayList<Turma> turmas) {
        this.turmas = turmas;
    }
    public int numeroTurmas(){
        return turmas.size();
    }
    public void turmasCadastradas(){
        System.out.println("Turmas Cadastradas");
        int x =0;
        for (Turma tur: turmas){
            System.out.println(tur.getCodigo()+ " - " + tur.getDescricao());
        }
    }
    public void removerTurma(Turma turma){
        turmas.remove(turma);
        
    }
}
