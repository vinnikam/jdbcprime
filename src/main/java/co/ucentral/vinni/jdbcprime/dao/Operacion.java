package co.ucentral.vinni.jdbcprime.dao;

interface Operacion<T> {
    public boolean guardar(T dato);
}
