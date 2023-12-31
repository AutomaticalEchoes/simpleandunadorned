package com.AutomaticalEchoes.SimpleAndUnadorned.api.Function;

public class IFunction{
    @FunctionalInterface
    public interface QuadFunction<T, U, V, W, R> {
        R apply(T t, U u, V v, W w);
    }
    @FunctionalInterface
    public interface PentFunction<T, U, V, W, A, R> {
        R apply(T t, U u, V v, W w ,A a);
    }
    @FunctionalInterface
    public interface SixFunction<T, U, V, W, A, O,R> {
        R apply(T t, U u, V v, W w ,A a,O o);
    }

    @FunctionalInterface
    public interface PentConsumer<T, U, V, W, A> {
        void apply(T t, U u, V v, W w ,A a);
    }

    @FunctionalInterface
    public interface QuadConsumer<T, U, V, W> {
        void apply(T t, U u, V v, W w);
    }
    @FunctionalInterface
    public interface SixConsumer<T, U, V, W, A, O> {
        void apply(T t, U u, V v, W w, A a, O o);
    }

}

