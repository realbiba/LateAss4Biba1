import data.PostgresDB;
import data.interfaces.IDB;
import org.glassfish.jersey.internal.inject.AbstractBinder;
import repositories.MedicineRepository;
import repositories.interfaces.IMedicineRepositories;

public class MyApplicationBinder extends AbstractBinder {

    @Override
    protected void configure() {
        bind(PostgresDB.class).to(IDB.class);
        bind(MedicineRepository.class).to(IMedicineRepositories.class);
    }
}