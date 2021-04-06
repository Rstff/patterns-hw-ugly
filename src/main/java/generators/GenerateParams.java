package generators;

abstract class GenerateParams<T> {
    public final T generate(final int code) {
        T result;
        generateParams(code);
        result = buildResponse();
        return  result;
    }
    protected abstract void generateParams(int code);
    protected abstract T buildResponse();
}
