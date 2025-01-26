package db.interfaces;

import java.util.List;

public interface IService<DTO, CreateDTO> {
    void saveOne(CreateDTO createDto);

    DTO getOne(Long id);

    List<DTO> getAll();

    void updateOne(CreateDTO createDto);

    void deleteOne(Long id);
}
