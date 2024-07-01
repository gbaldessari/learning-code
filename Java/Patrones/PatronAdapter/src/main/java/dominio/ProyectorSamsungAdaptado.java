package dominio;

public class ProyectorSamsungAdaptado implements ProyectorAdapter{
    private ProyectorSamsung proyectorSamsung;
    public ProyectorSamsungAdaptado() {
        proyectorSamsung = new ProyectorSamsung();
    }
    @Override
    public void start() {
        proyectorSamsung.turnOn();
    }
}
