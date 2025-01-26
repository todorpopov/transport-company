package db.dtos;

import db.entities.company.Company;
import db.entities.company.dtos.CompanyDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCompanyDTOs {
    @Test
    public void givenEntity_whenCreateDTO_thenCorrect() {
        Company company = new Company("Microsoft", null, null, null, null);
        CompanyDTO dto = CompanyDTO.toDTO(company);

        Assertions.assertNotNull(dto);
        Assertions.assertEquals(company.getName(), dto.getName());
    }
}
