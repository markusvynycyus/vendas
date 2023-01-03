package domain.service;

import api.dto.VendaDiariaDTO;
import domain.filter.VendaDiariaFilter;

import java.util.List;

public interface VendaQueryService {

    List<VendaDiariaDTO> consultarVendasDiarias(VendaDiariaFilter filtro, String timeOffset);
}
