package com.thoughtworks.billing.taxes.criteria;

public interface Criteria<T> {
    boolean matches(T t);
}
