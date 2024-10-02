public class Curso {
    private static int contadorIdCurso = 1;
    private int idCurso;
    private String nomeCurso;
    private int cargaHorariaCurso;
    private Professor professorCurso;

    public Curso(String nome, int cargaHoraria, Professor professor) {
        idCurso = contadorIdCurso++;
        nomeCurso = nome;
        cargaHorariaCurso = cargaHoraria;
        professorCurso = professor;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public int getCargaHorariaCurso() {
        return cargaHorariaCurso;
    }

    public Professor getProfessorCurso() {
        return professorCurso;
    }
}
