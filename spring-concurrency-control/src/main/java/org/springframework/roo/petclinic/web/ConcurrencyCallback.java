package org.springframework.roo.petclinic.web;

/**
 * Callback interface for concurrency code. Used with {@link ConcurrencyTemplate}'s
 * {@code executeWithOcc} method, often as anonymous class within a method implementation.
 *
 * @param <T>
 */
@FunctionalInterface
public interface ConcurrencyCallback<T> {

    /**
     * Gets called by {@link ConcurrencyTemplate#executeWithOcc(ConcurrencyCallback)}.
     *
     * @return a result object, or {@code null}
     */
    T doInConcurrency();
}
