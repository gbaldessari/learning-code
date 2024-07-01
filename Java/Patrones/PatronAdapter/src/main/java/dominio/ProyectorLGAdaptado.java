package dominio;

public class ProyectorLGAdaptado implements ProyectorAdapter{
    private ProyectorLG proyectorLG;
    public ProyectorLGAdaptado() {
        proyectorLG = new ProyectorLG();
    }

    @Override
    public void start() {
        proyectorLG.enable();
    }
}
