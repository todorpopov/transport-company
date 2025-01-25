package db.interfaces;

import java.util.List;

public interface IService<DTO> {
    void saveOne(DTO dto);
    DTO getOne(Long id);
    List<DTO> getAll();
    void updateOne(DTO dto);
    void deleteOne(Long id);
}
