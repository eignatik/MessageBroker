package com.deveignatik.MessageBroker.LibKernel;





import com.deveignatik.MessageBroker.LibKernel.entities.Message;
import com.deveignatik.MessageBroker.LibKernel.entities.Topic;

import java.util.List;

import static com.deveignatik.MessageBroker.LibKernel.ModelDataApp.*;

/**
 * 12:40 PM.
 */
public class Broker {

    public static void init() {
        initialize();
        createTables();
    }
    public static List<Topic> getTopics(){
        return getTopicList();
    }

    public static String getTopicName(int id){
        return getTopics().get(id).getTitle();
    }

    public static List<Message> getMessages(){
        return getMessagesList();
    }

    /**
     *
     * @param id - id сообщения в базе
     * @return текст сообщения по id
     */
    public static String getMessage(int id){
        return getMessagesList().get(id).getMessage();
    }

    /**
     *
     * @param idtopic id темы
     * @return
     */
    public static List<Message> getMessages(int idtopic){
        return getMessagesList(idtopic);
    }

    public static void subscribe(){

    }

    public static void addTopic(String topicTitle){
        createTopic(topicTitle);
    }

    public static void publish(String message, int idTopic){
        if(hasTopic(idTopic)){
            createMessage(message, idTopic);
        } else {
            return;
        }
    }

    private static void sendNotSended(){

    }
}
