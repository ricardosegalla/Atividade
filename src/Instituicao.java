
import java.util.ArrayList;


public class Instituicao {
   private ArrayList <Turma> turmas = new ArrayList<Turma>();
   private String descricao;
   
   public void novaTurma(Turma turma){
    turmas.add(turma);
}
   public Instituicao(String  descricao){
       this.descricao = descricao;
   }
}
