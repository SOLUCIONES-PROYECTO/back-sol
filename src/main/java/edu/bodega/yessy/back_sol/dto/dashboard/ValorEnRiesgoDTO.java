package edu.bodega.yessy.back_sol.dto.dashboard;

import java.math.BigDecimal;

public class ValorEnRiesgoDTO {
    private BigDecimal valorVencidos;
    private BigDecimal valorUrgente;
    private BigDecimal valorProximo;
    private BigDecimal valorAdvertencia;
    private BigDecimal valorTotalEnRiesgo;

    public ValorEnRiesgoDTO(BigDecimal valorVencidos, BigDecimal valorUrgente,
            BigDecimal valorProximo, BigDecimal valorAdvertencia,
            BigDecimal valorTotalEnRiesgo) {
        this.valorVencidos = valorVencidos;
        this.valorUrgente = valorUrgente;
        this.valorProximo = valorProximo;
        this.valorAdvertencia = valorAdvertencia;
        this.valorTotalEnRiesgo = valorTotalEnRiesgo;
    }

    public BigDecimal getValorVencidos() { return valorVencidos; }
    public void setValorVencidos(BigDecimal v) { this.valorVencidos = v; }

    public BigDecimal getValorUrgente() { return valorUrgente; }
    public void setValorUrgente(BigDecimal v) { this.valorUrgente = v; }

    public BigDecimal getValorProximo() { return valorProximo; }
    public void setValorProximo(BigDecimal v) { this.valorProximo = v; }

    public BigDecimal getValorAdvertencia() { return valorAdvertencia; }
    public void setValorAdvertencia(BigDecimal v) { this.valorAdvertencia = v; }

    public BigDecimal getValorTotalEnRiesgo() { return valorTotalEnRiesgo; }
    public void setValorTotalEnRiesgo(BigDecimal v) { this.valorTotalEnRiesgo = v; }
}
