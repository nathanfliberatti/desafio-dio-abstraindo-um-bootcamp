package exceptions;

public class NoSubscribedContentException extends RuntimeException {
    public NoSubscribedContentException(String nomeDev) {
        super(String.format("Dev %s não está matriculado em nenhum conteúdo", nomeDev));
    }
}
