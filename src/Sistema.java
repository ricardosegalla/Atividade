import com.sun.xml.internal.ws.message.saaj.SAAJHeader;
import java.util.Scanner;

public class Sistema {
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        int x=0;
        Instituicao instituicao = new Instituicao("Uniseps");
        Aluno aluno = null;
        
        int quantAluno = 1;
        int quantTurma = 1;
        sistema:while (x==0){
            System.out.println("1-Gerenciar alunos; 2-Gerenciar turmas; 0-Fim;");
           
            int y = sc.nextInt();
            if (y == 1){
                System.out.println("1-Matricular Aluno; 2-Cancelar matricula; 3-Alterar dados; 0-Voltar");
                y = sc.nextInt();
                if(y==1){
                    System.out.println("Para prosseguir com a matricula voce deve ter pelo menos 1 turma cadastrada");
                    System.out.println("Voce tem "+ instituicao.numeroTurmas()+ "Turmas cadastradas");
                    if ( instituicao.numeroTurmas() > 0){
                        
                        System.out.println("Matricula");
                        System.out.println("Digite o nome: ");
                        sc = new Scanner(System.in);
                        String nome = sc.nextLine();
                        System.out.println("Ra do Aluno "+ quantAluno);
                        //sc = new Scanner(System.in);
                        //int ra = sc.nextInt();
                        System.out.println("Digite a nota da G1: ");
                        sc = new Scanner(System.in);
                        float g1 = sc.nextFloat();
                        System.out.println("Digite a nota da G2: ");
                        sc = new Scanner(System.in);
                        float g2 = sc.nextFloat();
                        int ra = quantAluno;
                        aluno= new Aluno(ra,nome);
                        aluno.setG1(g1);
                        aluno.setG2(g2);
                        quantAluno ++;
                        instituicao.turmasCadastradas();
                        System.out.println("Em qual turma voce deseja cadastrar o Aluno? (digite o Codigo)");
                        sc = new Scanner(System.in);
                        ra = sc.nextInt();
                        for (Turma tur: instituicao.getTurmas()){
                            if (tur.getCodigo() == ra){
                                tur.matricula(aluno);
                                
                                System.out.println("\nAluno Cadastrado!");
                                
                            }
                                
                        }
                    }
                         
                }
                else if(y==2){
                    System.out.println("Cancelar");
                    
                    instituicao.turmasCadastradas();
                        System.out.println("Em qual turma voce deseja procurar o Aluno? (digite o Codigo)");
                        int ra = sc.nextInt();
                        for (Turma tur: instituicao.getTurmas()){
                            if (tur.getCodigo() == ra){
                                tur.alunosCadastrados();
                                System.out.println("Qual aluno voce deseja cancelar a matricula? ( digite o codigo)");
                                ra = sc.nextInt();
                                for (Aluno alu: tur.getAlunos()){
                                    if (alu.getRa() == ra){
                                        tur.cancelarMatricula(alu);
                                    }
                                }
                            }
                                
                        }
                }
                else if(y==3){
                    System.out.println("Alterar notas");
                    
                    instituicao.turmasCadastradas();
                        System.out.println("Em qual turma voce deseja procurar o Aluno? (digite o Codigo)");
                        int ra = sc.nextInt();
                        for (Turma tur: instituicao.getTurmas()){
                            if (tur.getCodigo() == ra){
                                tur.alunosCadastrados();
                                System.out.println("Qual aluno voce deseja alterar dados? ( digite o codigo)");
                                ra = sc.nextInt();
                                for (Aluno alu: tur.getAlunos()){
                                    if (alu.getRa() == ra){
                                        System.out.println("Qual dado vc deseja alterar? (nome = 1; G1 = 2; G2 = 3)");
                                        ra = sc.nextInt();
                                        if (ra ==1){
                                            System.out.println("Digite o nome:");
                                            String nome = sc.nextLine();
                                            alu.setNome(nome);
                                        }
                                        if (ra == 2){
                                            System.out.println("Digite a nota da G1: ");
                                            float g1 = sc.nextFloat();
                                            alu.setG1(g1);
                                            
                                        }
                                        if (ra == 3){
                                            System.out.println("Digite a nota da G2: ");
                                            float g2 = sc.nextFloat();
                                            alu.setG2(g2);
                                            
                                        }
                                        
                                    }
                                }
                            }
                                
                        }
                    
                }
            }else if(y==2){
                System.out.println("1-Nova Turma; 2-Remover turma;3-Informações; 0-Voltar");
                y = sc.nextInt();
                if (y==1){
                    sc = new Scanner(System.in);
                    System.out.println("numero da Turma: " + quantTurma);
                    
                    int codigo = quantTurma;
                    System.out.println("Digite a Descrição da Turma "+ quantTurma+": ");
                    sc = new Scanner(System.in);
                    quantTurma ++;
                    String descricao = sc.nextLine();
                    Turma turma = new Turma(codigo, descricao);
                    instituicao.novaTurma(turma);
                    System.out.println("Turma cadastrada!");
                    
                }
                else if (y==2){
                    instituicao.turmasCadastradas();
                    System.out.println("Em qual turma voce deseja remover? (digite o Codigo)");
                        int ra = sc.nextInt();
                        for (Turma tur: instituicao.getTurmas()){
                            if (tur.getCodigo() == ra){
                                instituicao.removerTurma(tur);
                            }
                                
                        }
                    
                    
                }
                else if (y==3){
                    System.out.println("1-Quantidade de turmas; 2- Informações da Turma;");
                    y = sc.nextInt();
                    if (y==1){
                        System.out.println("A Instituição possui "+ instituicao.numeroTurmas()+ " Turmas");
                    }
                    else if( y==2){
                        instituicao.turmasCadastradas();
                        System.out.println("Em qual turma voce deseja consultar? (digite o Codigo)");
                        int ra = sc.nextInt();
                        for (Turma tur: instituicao.getTurmas()){
                            if (tur.getCodigo() == ra){
                                 System.out.println("A Turma possui "+ tur.quantidadeAlunos()+ " Alunos");
                                 tur.alunosCadastrados();
                                 System.out.println("Quantidade de Alunos Aprovados: "+ tur.quandidadeAlunosAprovados());
                                 System.out.println("Quantidade de Alunos Reprovados: "+ tur.quantidadeAlunosReprovados());
                                 System.out.println("Porcentual de Alunos aprovados: "+ tur.percentualAlunosAprovados());
                                 System.out.println("Porcentual de Alunos Reprovados: "+ tur.percenturalAlunosReprovados());
                                 System.out.println("Media da Turma: "+ tur.mediaGeral());
                            }
                                
                        }
                    }
                    
                    
                }
            }
            else if(y==0){
                break sistema;
            }
        }
    }
    
}