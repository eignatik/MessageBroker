package com.deveignatik.MessageBroker.LibKernel;





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
