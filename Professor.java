public class Professor {
    private static int contadorIdProfessor = 1;
    private int idProfessor;
    private String nomeProfessor;
    private String departamentoProfessor;

    public Professor(String nome, String departamento) {
        idProfessor = contadorIdProfessor++;
        nomeProfessor = nome;
        departamentoProfessor = departamento;
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public String getDepartamentoProfessor() {
        return departamentoProfessor;
    }
}
