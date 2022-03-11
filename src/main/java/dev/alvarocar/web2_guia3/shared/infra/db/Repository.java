package dev.alvarocar.web2_guia3.shared.infra.db;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface Repository<T, I> {
    List<T> getAll() throws SQLException;
    Optional<T> getById(I id) throws SQLException;
    Boolean add(T entity) throws SQLException;
    Boolean edit(T entity) throws SQLException;
    Boolean deleteById(I id) throws SQLException;
}
