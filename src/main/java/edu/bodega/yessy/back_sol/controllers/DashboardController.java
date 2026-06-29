package edu.bodega.yessy.back_sol.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.bodega.yessy.back_sol.dto.dashboard.GananciaMesDTO;
import edu.bodega.yessy.back_sol.dto.dashboard.ProductoMasVendidoDTO;
import edu.bodega.yessy.back_sol.dto.dashboard.ProductoSinMovimientoDTO;
import edu.bodega.yessy.back_sol.dto.dashboard.ProductoStockBajoDTO;
import edu.bodega.yessy.back_sol.dto.dashboard.ResumenDashboardDTO;
import edu.bodega.yessy.back_sol.dto.dashboard.TendenciaProductoDTO;
import edu.bodega.yessy.back_sol.dto.dashboard.VentaMesDTO;
import edu.bodega.yessy.back_sol.services.DashboardService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/resumen")
    public ResumenDashboardDTO resumen() {
        return dashboardService.obtenerResumen();
    }

    @GetMapping("/ventas-por-mes")
    public List<VentaMesDTO> ventasPorMes(@RequestParam(defaultValue = "6") int meses) {
        return dashboardService.ventasPorMes(meses);
    }

    @GetMapping("/ganancia-por-mes")
    public List<GananciaMesDTO> gananciaPorMes(@RequestParam(defaultValue = "6") int meses) {
        return dashboardService.gananciaPorMes(meses);
    }

    @GetMapping("/productos-mas-vendidos")
    public List<ProductoMasVendidoDTO> productosMasVendidos(
            @RequestParam(defaultValue = "5") int top,
            @RequestParam(defaultValue = "90") int dias) {
        return dashboardService.productosMasVendidos(top, dias);
    }

    @GetMapping("/no-comprar")
    public List<ProductoSinMovimientoDTO> noComprar(@RequestParam(defaultValue = "45") int dias) {
        return dashboardService.productosSinMovimiento(dias);
    }

    @GetMapping("/tendencias")
    public List<TendenciaProductoDTO> tendencias() {
        return dashboardService.tendenciaProductos();
    }

    @GetMapping("/stock-bajo")
    public List<ProductoStockBajoDTO> stockBajo() {
        return dashboardService.productosStockBajo();
    }
}