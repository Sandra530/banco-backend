public class TransferenciaService {
    private CuentaService cuentaService;

    public TransferenciaService(CuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    public boolean realizarTransferencia(String numeroCuentaOrigen, String numeroCuentaDestino, double monto) {
        Cuenta cuentaOrigen = cuentaService.obtenerCuentaPorNumero(numeroCuentaOrigen);
        Cuenta cuentaDestino = cuentaService.obtenerCuentaPorNumero(numeroCuentaDestino);

        if (cuentaOrigen != null && cuentaDestino != null && cuentaOrigen.getSaldo() >= monto) {
            cuentaOrigen.setSaldo(cuentaOrigen.getSaldo() - monto);
            cuentaDestino.setSaldo(cuentaDestino.getSaldo() + monto);
            return true; // Transferencia exitosa
        } else {
            return false; // Transferencia fallida
        }
    }
}

