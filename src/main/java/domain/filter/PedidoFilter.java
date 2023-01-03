package domain.filter;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.OffsetDateTime;

public class PedidoFilter {

    private Long clienteId;

    private Long vendedorId;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime dataCriacaoInicio;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime dataCriacaoFim;
}
