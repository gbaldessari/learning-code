package cl.ucn.modelo;

public class HerramientasClima {

    public static final double PELIGROSO_VELOCIDADVIENTO = 70.0;
    public static final double PELIGROSO_LLUVIA = 6.0;
    public static final double PREOCUPACION_VELOCIDADVIENTO = 45.0;
    public static final double PREOCUPACION_LLUVIA = 4.0;

    /**
     * Este método retorná "CANCELAR", "ADVERTENCIA", o "TODO CLARO".
     *
     * "CANCELAR" retornará solo si se cumple cualquiera de las siguientes
     *  condiciones:
     *
     * <ul>
     * <li>Mas de 6 pulgadas de lluvia son pronosticadas dentro de las siguientes 24 hours.</li>
     * <li>La velocidad del viento pronosticada es mayor a 70.0 mph dentro de las siguientes 24 horas.</li>
     * <li> Se predice que habrá mas de 4.0 pulgadas de lluvia  y la velocidad del viento será sobre las 45.0 mph.</li>
     * </ul>
     *
     * Si "CANCELAR" no es retornado, entonces "ADVERTENCIA" será retornado si se cumple cualquiera de las siguientes
     * condiciones:
     *
     * <ul>
     * <li>Predicción del viento es por sobre los 45.0 mph.</li>
     * <li>Predicción de lluvias es por sobre las 4.0 pulgadas.</li>
     * </ul>
     *
     * En cualquier otro caso el método retornará "Todo Claro".
     *
     * @param velocidadViento velocidad del viento en millas por hora
     * @param lluvia cantidad de lluvias en pulgadas
     * @return "CANCELAR", "ADVERTENCIA", o "TODO CLARO"
     * @throws IllegalArgumentException si cualquier argumento tiene valor negativo
     */
    public static String consejoClimatico(double velocidadViento, double lluvia) {
        if (velocidadViento < 0 || lluvia < 0) {
            throw new IllegalArgumentException();
        }

        String consejo = "TODO CLARO";

        if (velocidadViento > PELIGROSO_VELOCIDADVIENTO
                || lluvia > PELIGROSO_LLUVIA
                || (velocidadViento > PREOCUPACION_VELOCIDADVIENTO
                && lluvia > PREOCUPACION_LLUVIA)) {
            consejo = "CANCELAR";
        } else if (velocidadViento > PREOCUPACION_VELOCIDADVIENTO
                || lluvia > PREOCUPACION_LLUVIA) {
            consejo = "ADVERTENCIA";
        }

        return consejo;
    }
}
