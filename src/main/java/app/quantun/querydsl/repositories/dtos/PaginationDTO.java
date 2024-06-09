package app.quantun.querydsl.repositories.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaginationDTO {
    private int page = 0; // Default to page 0
    private int size = 10; // Default to size 10
}
