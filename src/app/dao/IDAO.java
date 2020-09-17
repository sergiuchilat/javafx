package app.dao;

public interface IDAO<T> {
    T create(T t);
    T read(Integer id);
    T[] read();
    T update(Integer id, T t);
    boolean delete(Integer id);
}
