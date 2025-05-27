package solidPrincipal;
interface database{
    void  save(String data);
}
class Mysql implements database{

    @Override
    public void save(String data) {
        System.out.println(
                "Executing SQL Query: INSERT INTO users VALUES('"
                        + data + "');"
        );
    }
}

class Mongo implements database{

    @Override
    public void save(String data) {
        System.out.println(
                "Executing MongoDB Function: db.users.insert({name: '"
                        + data + "'})"
        );
    }

}

class  UserService1{
    private  final  database db;

    UserService1(database db) {
        this.db = db;
    }
    public void storeUser(String user) {
        db.save(user);
    }
}
public class dipfolllow {
    public static void main(String[] args) {
        Mysql mysql = new Mysql();
        Mongo mongo = new Mongo();

        UserService1 service1 = new UserService1(mysql);
        service1.storeUser("Aditya");

        UserService1 service2 = new UserService1(mongo);
        service2.storeUser("Rohit");
    }

}
