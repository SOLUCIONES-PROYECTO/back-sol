package edu.bodega.yessy.back_sol.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bodega.yessy.back_sol.dto.dashboard.GananciaMesDTO;
import edu.bodega.yessy.back_sol.dto.dashboard.ProductoMasVendidoDTO;
import edu.bodega.yessy.back_sol.dto.dashboard.ProductoSinMovimientoDTO;
import edu.bodega.yessy.back_sol.dto.dashboard.ProductoStockBajoDTO;
import edu.bodega.yessy.back_sol.dto.dashboard.ResumenDashboardDTO;
import edu.bodega.yessy.back_sol.dto.dashboard.TendenciaProductoDTO;
import edu.bodega.yessy.back_sol.dto.dashboard.VentaMesDTO;
import edu.bodega.yessy.back_sol.models.DetalleEntrada;
import edu.bodega.yessy.back_sol.models.DetalleSalida;
import edu.bodega.yessy.back_sol.models.DocSalida;
import edu.bodega.yessy.back_sol.models.Producto;
import edu.bodega.yessy.back_sol.repositories.DetalleEntradaRepository;
import edu.bodega.yessy.back_sol.repositories.DetalleSalidaRepository;
import edu.bodega.yessy.back_sol.repositories.DocSalidaRepository;
import edu.bodega.yessy.back_sol.repositories.ProductoRepository;

@Service
public class DashboardService {

    @Autowired
    private DocSalidaRepository docSalidaRepository;

    @Autowired
    private DetalleSalidaRepository detalleSalidaRepository;

    @Autowired
    private DetalleEntradaRepository detalleEntradaRepository;

    @Autowired
    private ProductoRepository productoRepository;

    private static final Set<String> TIPOS_VENTA = Set.of("Boleta", "Factura", "Ticket");
    private static final String TIPO_DEVOLUCION = "Devolucion";

    // ================= RESUMEN GENERAL =================
    public ResumenDashboardDTO obtenerResumen() {

        List<DocSalida> todasLasSalidas = docSalidaRepository.findAll();

        BigDecimal ingresosVentas = todasLasSalidas.stream()
                .filter(d -> TIPOS_VENTA.contains(d.getTipoDocSalida().getNombre()))
                .map(DocSalida::getTotalSalida)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalDevoluciones = todasLasSalidas.stream()
                .filter(d -> TIPO_DEVOLUCION.equalsIgnoreCase(d.getTipoDocSalida().getNombre()))
                .map(DocSalida::getTotalSalida)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal ingresosTotales = ingresosVentas.subtract(totalDevoluciones);

        Long cantidadVentas = todasLasSalidas.stream()
                .filter(d -> TIPOS_VENTA.contains(d.getTipoDocSalida().getNombre()))
                .count();

        List<DetalleEntrada> todasLasEntradas = detalleEntradaRepository.findAll();

        BigDecimal comprasTotales = todasLasEntradas.stream()
                .map(DetalleEntrada::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal gananciaTotal = ingresosTotales.subtract(comprasTotales);

        ResumenDashboardDTO dto = new ResumenDashboardDTO();
        dto.setIngresosTotales(ingresosTotales);
        dto.setComprasTotales(comprasTotales);
        dto.setGananciaTotal(gananciaTotal);
        dto.setCantidadVentas(cantidadVentas);

        return dto;
    }

    // ================= VENTAS POR MES =================
    public List<VentaMesDTO> ventasPorMes(int mesesAtras) {

        Map<YearMonth, BigDecimal> totalesPorMes = inicializarMapaMeses(mesesAtras);

        List<DocSalida> todasLasSalidas = docSalidaRepository.findAll();

        for (DocSalida doc : todasLasSalidas) {
            YearMonth mes = YearMonth.from(doc.getFechaEgreso());

            if (!totalesPorMes.containsKey(mes))
                continue;

            String tipo = doc.getTipoDocSalida().getNombre();

            if (TIPOS_VENTA.contains(tipo)) {
                totalesPorMes.merge(mes, doc.getTotalSalida(), BigDecimal::add);
            } else if (TIPO_DEVOLUCION.equalsIgnoreCase(tipo)) {
                totalesPorMes.merge(mes, doc.getTotalSalida().negate(), BigDecimal::add);
            }
        }

        return mapearAVentaMesDTO(totalesPorMes);
    }

    // ================= GANANCIA POR MES =================
    public List<GananciaMesDTO> gananciaPorMes(int mesesAtras) {

        Map<YearMonth, BigDecimal> ingresosPorMes = inicializarMapaMeses(mesesAtras);
        Map<YearMonth, BigDecimal> comprasPorMes = inicializarMapaMeses(mesesAtras);

        for (DocSalida doc : docSalidaRepository.findAll()) {
            YearMonth mes = YearMonth.from(doc.getFechaEgreso());
            if (!ingresosPorMes.containsKey(mes))
                continue;

            String tipo = doc.getTipoDocSalida().getNombre();

            if (TIPOS_VENTA.contains(tipo)) {
                ingresosPorMes.merge(mes, doc.getTotalSalida(), BigDecimal::add);
            } else if (TIPO_DEVOLUCION.equalsIgnoreCase(tipo)) {
                ingresosPorMes.merge(mes, doc.getTotalSalida().negate(), BigDecimal::add);
            }
        }

        for (DetalleEntrada detalle : detalleEntradaRepository.findAll()) {
            YearMonth mes = YearMonth.from(detalle.getDocEntrada().getFecha_ingreso().toLocalDate());
            if (!comprasPorMes.containsKey(mes))
                continue;

            comprasPorMes.merge(mes, detalle.getSubtotal(), BigDecimal::add);
        }

        List<GananciaMesDTO> resultado = new ArrayList<>();

        for (YearMonth mes : ingresosPorMes.keySet()) {
            BigDecimal ingresos = ingresosPorMes.get(mes);
            BigDecimal compras = comprasPorMes.get(mes);
            BigDecimal ganancia = ingresos.subtract(compras);

            resultado.add(new GananciaMesDTO(formatearMes(mes), ingresos, compras, ganancia));
        }

        return resultado;
    }

    // ================= PRODUCTOS MÁS VENDIDOS =================
    public List<ProductoMasVendidoDTO> productosMasVendidos(int top, int diasAtras) {

        LocalDate desde = LocalDate.now().minusDays(diasAtras);

        List<DetalleSalida> detalles = detalleSalidaRepository.findAll().stream()
                .filter(d -> TIPOS_VENTA.contains(d.getDocSalida().getTipoDocSalida().getNombre()))
                .filter(d -> !d.getDocSalida().getFechaEgreso().isBefore(desde))
                .collect(Collectors.toList());

        Map<Integer, Long> cantidadPorProducto = new LinkedHashMap<>();
        Map<Integer, String> nombrePorProducto = new LinkedHashMap<>();

        for (DetalleSalida d : detalles) {
            Integer idProducto = d.getProducto().getIdproducto();
            cantidadPorProducto.merge(idProducto, d.getCantidad().longValue(), Long::sum);
            nombrePorProducto.putIfAbsent(idProducto, d.getProducto().getNombre());
        }

        return cantidadPorProducto.entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(top)
                .map(e -> new ProductoMasVendidoDTO(e.getKey(), nombrePorProducto.get(e.getKey()), e.getValue()))
                .collect(Collectors.toList());
    }

    // ================= HELPERS =================

    private Map<YearMonth, BigDecimal> inicializarMapaMeses(int mesesAtras) {

        Map<YearMonth, BigDecimal> mapa = new LinkedHashMap<>();
        YearMonth mesActual = YearMonth.now();

        for (int i = mesesAtras - 1; i >= 0; i--) {
            mapa.put(mesActual.minusMonths(i), BigDecimal.ZERO);
        }

        return mapa;
    }

    private List<VentaMesDTO> mapearAVentaMesDTO(Map<YearMonth, BigDecimal> mapa) {
        List<VentaMesDTO> resultado = new ArrayList<>();
        for (Map.Entry<YearMonth, BigDecimal> entry : mapa.entrySet()) {
            resultado.add(new VentaMesDTO(formatearMes(entry.getKey()), entry.getValue()));
        }
        return resultado;
    }

    private String formatearMes(YearMonth mes) {
        return mes.getMonth().getDisplayName(TextStyle.SHORT, new Locale("es", "PE"))
                + " " + mes.getYear();
    }

    // ================= NO VOLVER A COMPRAR =================
    public List<ProductoSinMovimientoDTO> productosSinMovimiento(int diasSinVenta) {

        Map<Integer, LocalDate> ultimaVentaPorProducto = calcularUltimaVentaPorProducto();
        LocalDate limite = LocalDate.now().minusDays(diasSinVenta);

        List<ProductoSinMovimientoDTO> resultado = new ArrayList<>();

        for (Producto p : productoRepository.findByEstado_NombreNot("Eliminado")) {

            boolean stockAlto = p.getStockActual() > (p.getStockMinimo() * 2);

            LocalDate ultimaVenta = ultimaVentaPorProducto.get(p.getIdproducto());
            boolean sinVentaReciente = (ultimaVenta == null) || ultimaVenta.isBefore(limite);

            if (stockAlto && sinVentaReciente) {
                resultado.add(new ProductoSinMovimientoDTO(
                        p.getIdproducto(),
                        p.getNombre(),
                        p.getStockActual(),
                        p.getStockMinimo(),
                        ultimaVenta));
            }
        }

        return resultado;
    }

    // ================= TENDENCIA POR PRODUCTO =================
    public List<TendenciaProductoDTO> tendenciaProductos() {

        YearMonth mesActual = YearMonth.now();
        YearMonth mesAnterior = mesActual.minusMonths(1);

        Map<Integer, Long> ventasMesActual = new LinkedHashMap<>();
        Map<Integer, Long> ventasMesAnterior = new LinkedHashMap<>();
        Map<Integer, String> nombrePorProducto = new LinkedHashMap<>();

        for (DetalleSalida d : detalleSalidaRepository.findAll()) {

            if (!TIPOS_VENTA.contains(d.getDocSalida().getTipoDocSalida().getNombre()))
                continue;

            YearMonth mesVenta = YearMonth.from(d.getDocSalida().getFechaEgreso());
            Integer idProducto = d.getProducto().getIdproducto();

            nombrePorProducto.putIfAbsent(idProducto, d.getProducto().getNombre());

            if (mesVenta.equals(mesActual)) {
                ventasMesActual.merge(idProducto, d.getCantidad().longValue(), Long::sum);
            } else if (mesVenta.equals(mesAnterior)) {
                ventasMesAnterior.merge(idProducto, d.getCantidad().longValue(), Long::sum);
            }
        }

        Set<Integer> productosConMovimiento = new java.util.HashSet<>();
        productosConMovimiento.addAll(ventasMesActual.keySet());
        productosConMovimiento.addAll(ventasMesAnterior.keySet());

        List<TendenciaProductoDTO> resultado = new ArrayList<>();

        for (Integer idProducto : productosConMovimiento) {

            long actual = ventasMesActual.getOrDefault(idProducto, 0L);
            long anterior = ventasMesAnterior.getOrDefault(idProducto, 0L);

            String tendencia;
            Double variacion = null;

            if (anterior == 0) {
                tendencia = actual > 0 ? "Alza" : "Estable";
            } else {
                variacion = ((actual - anterior) / (double) anterior) * 100;
                if (actual > anterior)
                    tendencia = "Alza";
                else if (actual < anterior)
                    tendencia = "Baja";
                else
                    tendencia = "Estable";
            }

            resultado.add(new TendenciaProductoDTO(
                    idProducto,
                    nombrePorProducto.get(idProducto),
                    actual,
                    anterior,
                    tendencia,
                    variacion));
        }

        return resultado;
    }

    // ================= STOCK BAJO =================
    public List<ProductoStockBajoDTO> productosStockBajo() {

        List<ProductoStockBajoDTO> resultado = new ArrayList<>();

        for (Producto p : productoRepository.findByEstado_NombreNot("Eliminado")) {
            if (p.getStockActual() <= p.getStockMinimo()) {
                resultado.add(new ProductoStockBajoDTO(
                        p.getIdproducto(),
                        p.getNombre(),
                        p.getStockActual(),
                        p.getStockMinimo()));
            }
        }

        return resultado;
    }

    // ================= HELPER: última venta por producto =================
    private Map<Integer, LocalDate> calcularUltimaVentaPorProducto() {

        Map<Integer, LocalDate> mapa = new LinkedHashMap<>();

        for (DetalleSalida d : detalleSalidaRepository.findAll()) {

            if (!TIPOS_VENTA.contains(d.getDocSalida().getTipoDocSalida().getNombre()))
                continue;

            Integer idProducto = d.getProducto().getIdproducto();
            LocalDate fecha = d.getDocSalida().getFechaEgreso();

            mapa.merge(idProducto, fecha, (f1, f2) -> f1.isAfter(f2) ? f1 : f2);
        }

        return mapa;
    }

}