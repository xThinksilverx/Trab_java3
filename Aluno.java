public class Aluno {
    private static int contadorIdAluno = 1;
    private int idAluno;
    private String nomeAluno;
    private String dataNascimentoAluno;
    private String cpfAluno;
    private Curso cursoAluno;

    public Aluno(String nome, String dataNascimento, String cpf, Curso curso) {
        idAluno = contadorIdAluno++;
        nomeAluno = nome;
        dataNascimentoAluno = dataNascimento;
        cpfAluno = cpf;
        cursoAluno = curso;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public String getDataNascimentoAluno() {
        return dataNascimentoAluno;
    }

    public String getCpfAluno() {
        return cpfAluno;
    }

    public Curso getCursoAluno() {
        return cursoAluno;
    }
}
