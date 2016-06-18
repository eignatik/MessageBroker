package com.deveignatik.MessageBroker.LibKernel;

import com.deveignatik.MessageBroker.LibKernel.entities.Client;
import com.deveignatik.MessageBroker.LibKernel.entities.Message;
import com.deveignatik.MessageBroker.LibKernel.entities.Topic;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.ArrayList;
import java.util.List;

import static com.deveignatik.MessageBroker.Log.log;

/**
 * 3:57 PM.
 */
public final class ModelDataApp {

    private static final String DRIVER = "";
    private static final String URL_DB = "jdbc:h2:./messagebroker";
    private static final String USER = "sa";
    private static final String PASS = "";

    private static  Sql2o db;

    protected static Sql2o initialize(){
        if(getDB()==null) {
            db = new Sql2o(URL_DB, USER, PASS);
        }
        return db;
    }
    protected static Sql2o getDB(){ return db;}

    protected static Connection getConnection(){
        Connection connection = null;
        try {
            connection = getDB().open();
        } catch (Exception e){
            log.error("" + e);
        }
        return connection;
    }


    /**
     * Автоматически проверяет наличие таблиц.
     * @return false в случае не успешного создания таблиц
     */
    protected static boolean createTables(){
        if(!isCreatedTableTopic()){
            if(!createTableTopic()){
                return false;
            }
        }

        if(!isCreatedTableMessage()){
            if(!createTableMessage()){
                return false;
            }
        }

        if(!isCreatedTableClient()){
            if(!createTableClient()){
                return false;
            }
        }

        if(!isCreatedTableSubscribe()){
            if(!createTableSudscribe()){
                return false;
            }
        }
        return true;
    }

    protected static Topic createTopic(String name){
        String query = "insert into topic (name) values(:name);";
        Topic res = null;
        try(Connection con =  getDB().beginTransaction()){
            Long key = (Long) con.createQuery(query).addParameter("name", name).executeUpdate().getKey();
            con.commit();
            if(key != null){
                res = getTopic(key);
            }
            log.info("\nTopic added\n");
        } catch(Exception e){
            log.error("Can't update TOPIC ", e);
        }
        return res;
    }

    protected static Message createMessage(String message, int idTopic){
        String query = "insert into message (message, sended, idtopic) values(:message, 0, :id);";
        Message res = null;
        try(Connection con =  getDB().beginTransaction()){
            Long key = (Long) con.createQuery(query).addParameter("message", message).addParameter("id", idTopic).executeUpdate().getKey();
            con.commit();
            if(key != null){
                res = getMessage(key);
            }
            log.info("\nMessage added\n");
        } catch(Exception e){
            log.error("Can't update TOPIC ", e);
        }
        return res;
    }

    protected static Client createClient(String name, int topicid){
        String query = "insert into client (name, lastmesid) values(:name, 0);";
        Client res = null;
        try(Connection con =  getDB().beginTransaction()){
            Long key = (Long) con.createQuery(query).addParameter("name", name).executeUpdate().getKey();
            con.commit();
            if(key != null){
                res = getClient(key);
            }
            log.info("\nClient added\n");
        } catch(Exception e){
            log.error("Can't update TOPIC ", e);
        }
        return res;
    }
    protected static List<Topic> getTopicList(){
        List<Topic> list = new ArrayList<>();
        String query = "select * from topic;";
        try(Connection con =  getDB().beginTransaction()){
            list.addAll(con.createQuery(query)
                    .addColumnMapping("id", "id")
                    .addColumnMapping("name", "name")
                    .executeAndFetch(Topic.class));
        } catch(Exception e){
            log.error("Can't update TOPIC ", e);
        }
        return list;
    }


    protected static List<Message> getMessagesList(){
        List<Message> list = new ArrayList<>();
        String query = "select * from message;";
        try(Connection con =  getDB().beginTransaction()){
            list.addAll(con.createQuery(query)
                    .addColumnMapping("id", "id")
                    .addColumnMapping("name", "name")
                    .addColumnMapping("sended", "sended")
                    .addColumnMapping("idtopic", "idtopic")
                    .executeAndFetch(Message.class));
        } catch(Exception e){
            log.error("Can't update TOPIC ", e);
        }
        return list;
    }

    /**
     *
     * @param id - id темы
     * @return
     */
    protected static List<Message> getMessagesList(int id){
        List<Message> list = new ArrayList<>();
        String query = "select * from message where idtopic=:idtopic;";
        try(Connection con =  getDB().beginTransaction()){
            list.addAll(con.createQuery(query)
                    .addParameter("idtopic",id)
                    .addColumnMapping("id", "id")
                    .addColumnMapping("name", "name")
                    .addColumnMapping("sended", "sended")
                    .addColumnMapping("idtopic", "idtopic")
                    .executeAndFetch(Message.class));
        } catch(Exception e){
            log.error("Can't update TOPIC ", e);
        }
        return list;
    }

    protected static boolean hasTopic(int id){
        boolean check = true;
        try(Connection con =  getDB().open()){
            con.createQuery("select id from topic where id=:id").addParameter("id", id).executeScalar();
        } catch(Exception e){
            check = false;
        }
        return check;
    }

    protected static Topic getTopic(long id){
        Topic res = null;
        try(Connection con =  getDB().open()){
            res = con.createQuery("select * from topic where id=:id").addParameter("id", id).executeAndFetchFirst(Topic.class);
        } catch(Exception e){
            log.error("Error of recieve - ", e);
        }
        return res;
    }

    /**
     *
     * @param id
     * @return
     */
    protected static Message getMessage(long id){
        Message res = null;
        try(Connection con =  getDB().open()){
            res = con.createQuery("select * from message where id=:id").addParameter("id", id).executeAndFetchFirst(Message.class);
        } catch(Exception e){
            log.error("Error of recieve - ", e);
        }
        return res;
    }

    protected static Client getClient(long id){
        Client res = null;
        try(Connection con =  getDB().open()){
            res = con.createQuery("select * from client where id=:id").addParameter("id", id).executeAndFetchFirst(Client.class);
        } catch(Exception e){
            log.error("Error of recieve - ", e);
        }
        return res;
    }


    private static boolean createTableTopic(){
        String createTopic = "create table topic(id BIGINT AUTO_INCREMENT, name VARCHAR(255));";
        boolean check = true;
        try(Connection con =  getDB().beginTransaction()){
            con.createQuery(createTopic).executeUpdate();
            con.commit();
        } catch(Exception e){
            log.error("Can't create topic table ", e);
            check = false;
        }

        return check;
    }

    private static boolean createTableMessage(){
        String createMessage = "create table message(id BIGINT AUTO_INCREMENT, message TEXT(255), sended TINYINT(3), idtopic INTEGER(10));";
        boolean check = true;
        try(Connection con =  getDB().beginTransaction()){
            con.createQuery(createMessage).executeUpdate();
            con.commit();
        } catch(Exception e){
            log.error("Cant create Message Table ", e);
            check = false;
        }
        return check;
    }
    private static boolean createTableClient(){
        String createMessage = "create table client(id BIGINT AUTO_INCREMENT, name VARCHAR(30), lastmesid BIGINT);";
        boolean check = true;
        try(Connection con =  getDB().beginTransaction()){
            con.createQuery(createMessage).executeUpdate();
            con.commit();
        } catch(Exception e){
            log.error("Cant create Client Table ", e);
            check = false;
        }
        return check;
    }

    private static boolean createTableSudscribe(){
        String createMessage = "create table subscribe(id BIGINT AUTO_INCREMENT, idclient INTEGER(10), idtopic INTEGER(10));";
        boolean check = true;
        try(Connection con =  getDB().beginTransaction()){
            con.createQuery(createMessage).executeUpdate();
            con.commit();
        } catch(Exception e){
            log.error("Cant create Subscribe Table ", e);
            check = false;
        }
        return check;
    }
    private static boolean isCreatedTableTopic(){
        boolean check = true;
        try(Connection con =  getDB().open()){
            con.createQuery("select id from topic where id=1").executeScalar(Integer.class);
        } catch(Exception e){
            check = false;
        }
        return check;
    }


    private static boolean isCreatedTableMessage(){
        boolean check = true;
        try(Connection con =  getDB().open()){
            con.createQuery("select id from message where id=1").executeScalar(Integer.class);
        } catch(Exception e){
            check = false;
        }
        return check;
    }

    private static boolean isCreatedTableClient(){
        boolean check = true;
        try(Connection con =  getDB().open()){
            con.createQuery("select id from client where id=1").executeScalar(Integer.class);
        } catch(Exception e){
            check = false;
        }
        return check;
    }

    private static boolean isCreatedTableSubscribe(){
        boolean check = true;
        try(Connection con =  getDB().open()){
            con.createQuery("select id from subscribe where id=1").executeScalar(Integer.class);
        } catch(Exception e){
            check = false;
        }
        return check;
    }
}
