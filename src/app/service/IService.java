package crud.service;

public interface IService<T> {
    T create(T t);
    T read(Integer id);
    T[] read();
    T update(Integer id, T t);
    boolean delete(Integer id);
}
