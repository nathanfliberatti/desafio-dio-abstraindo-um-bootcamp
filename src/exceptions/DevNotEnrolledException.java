package exceptions;

public class DevNotEnrolledException extends RuntimeException {
    public DevNotEnrolledException(String nomeDev) {
        super(String.format("Dev %s não está inscrito em nenhum bootcamp.", nomeDev));
    }
}
