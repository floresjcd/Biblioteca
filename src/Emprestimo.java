import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Emprestimo {
    private Livro livro;
    private Usuario usuario;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    public Emprestimo(Livro livro, Usuario usuario, int diasEmprestimo) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucao = dataEmprestimo.plusDays(diasEmprestimo);
        livro.setDisponivel(false);
    }

    // Getters
    public Livro getLivro() {
        return livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getDataEmprestimoFormatada() {
        return formatarData(dataEmprestimo);
    }

    public String getDataDevolucaoFormatada() {
        return formatarData(dataDevolucao);
    }

    private String formatarData(LocalDate data) {
        return data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    @Override
    public String toString() {
        return "Empréstimo: " + livro.getTitulo() + " para " + usuario.getNome() + 
               "\nData: " + getDataEmprestimoFormatada() + 
               " → " + getDataDevolucaoFormatada();
    }
}