import edu.itplusz.bibliospring.backend.model.User;
import edu.itplusz.bibliospring.backend.repository.DAOFactory;
import edu.itplusz.bibliospring.backend.repository.UserDAO;
import edu.itplusz.bibliospring.backend.services.LoginService;
import edu.itplusz.bibliospring.backend.services.ServiceFactory;
import edu.itplusz.bibliospring.backend.services.impl.LoginServiceImpl;

public class Main {
    public static void main(String[] args) {
        /*
        User u1 = new User();
        u1.setUsername("admin1");
        u1.setPassword("admin1p");
        User u2 = new User();
        u2.setUsername("admin2");
        u2.setPassword("admin2p");

        DAOFactory df = DAOFactory.getInstance();
        UserDAO ud = df.getUserDAO();

        //System.out.println(ud.create(u1));
        //System.out.println(ud.create(u2));
        System.out.println(ud.findById(1L));
        //System.out.println(ud.findAll());
        //ud.delete(u2);
        //System.out.println(ud.findAll());
        System.out.println(ud.findByUsername("admin1"));
        //u1.setUsername("admin11");
        //ud.update(u1);
        System.out.println(ud.findAll());

        */
        LoginService loginService = ServiceFactory.getInstance();
        User u1 = new User();
        u1.setUsername("admin4");
        u1.setPassword("admin4p");

        loginService.register(u1);
        u1.setPassword("admin4p");
        System.out.println(loginService.login(u1));
    }
}