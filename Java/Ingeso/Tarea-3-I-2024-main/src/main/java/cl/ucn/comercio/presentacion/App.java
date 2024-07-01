package cl.ucn.comercio.presentacion;

import cl.ucn.comercio.modelo.*;
import jakarta.persistence.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class App
{
    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main( String[] args ) throws InterruptedException {

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String key = "Laboratorio I";
        Random rnd = new Random(key.hashCode());
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("comercioApp");
        EntityManager em = emf.createEntityManager();


        int rut = 29916399;
        Cliente cliente = em.find(Cliente.class,rut);

        logger.info("El cliente: " + cliente.getNombre() + " con rut " + cliente.getRut() + " comienza la compra.");
        Thread.sleep(2000);
        logger.info("El cliente ha escogido los siguientes productos: ");

        int sn1 = rnd.nextInt(10) + 1;
        String jpql = "SELECT p from Producto p WHERE p.serialNumber = :sn1";
        TypedQuery<Producto> query1 = em.createQuery(jpql, Producto.class);
        query1.setParameter("sn1", sn1);
        Producto p1 = query1.getSingleResult();

        sn1 = rnd.nextInt(10) + 1;
        jpql = "SELECT p from Producto p WHERE p.serialNumber = :sn1";
        TypedQuery<Producto> query2 = em.createQuery(jpql, Producto.class);
        query2.setParameter("sn1", sn1);
        Producto p2 = query2.getSingleResult();

        logger.info("Celulares con marca: " + p1.getMarca() + " y " + p2.getMarca());
        Thread.sleep(2000);
        logger.info("Verificamos la lista de proveedores y a quien pertenecen los productos escogidos: ");
        jpql = "SELECT p from Proveedor p";
        TypedQuery<Proveedor> query3 = em.createQuery(jpql, Proveedor.class);
        List<Proveedor> listaProveedor = query3.getResultList();
        for (Proveedor proveedor : listaProveedor)
        {
            logger.info("Nombre: " + proveedor.getNombre() + " Rut: " + proveedor.getRutProveedor());
            List<Producto> listaProducto1 = proveedor.getAcmeCelularesMarca(p1.getMarca());
            List<Producto> listaProducto2 = proveedor.getAcmeCelularesMarca(p2.getMarca());
            for (Producto p: listaProducto1)
                if (p.getSerialNumber() == p1.getSerialNumber())
                    logger.info("El proveedor para producto 1 es " + proveedor.getNombre());

            for (Producto p: listaProducto2)
                if (p.getSerialNumber() == p2.getSerialNumber())
                    logger.info("El proveedor para producto 2 es " + proveedor.getNombre());
        }
        Thread.sleep(2000);
        logger.info("Se crea el carro de compras con los productos escogidos. ");
        CarroCompra carroCompra = new CarroCompra();
        carroCompra.anhadirProducto(p1);
        carroCompra.anhadirProducto(p2);
        carroCompra.setFecha(formatter.format(new Date()));
        logger.info("Fecha: " + carroCompra.getFecha());

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        logger.info("Se asocia el carro de compra al cliente. ");
        em.persist(carroCompra);
        cliente.setCarroCompra(carroCompra);
        logger.info("Se crea una orden de compra y se confirma la compra ");
        Orden orden = new Orden();
        orden.setConfirmado(true);
        em.persist(orden);
        cliente.setOrden(orden);
        logger.info("Se persisten los datos de cliente ");
        em.persist(cliente);
        tx.commit();
        Thread.sleep(2000);

        logger.info("El status de la orden cambia a enviado ");
        cliente = em.find(Cliente.class,rut);
        orden = cliente.getOrden();
        orden.setEnviado(true);
        tx.begin();
        em.persist(orden);
        cliente.setOrden(orden);
        tx.commit();
        Thread.sleep(2000);

        logger.info("El status de la orden cambia a entregado ");
        cliente = em.find(Cliente.class,rut);
        orden = cliente.getOrden();
        orden.setEntregado(true);
        tx.begin();
        em.persist(orden);
        cliente.setOrden(orden);
        tx.commit();
        em.close();
        emf.close();
    }
}