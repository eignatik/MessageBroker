package com.deveignatik.MessageBroker;

import com.deveignatik.MessageBroker.LibKernel.Broker;
import com.deveignatik.MessageBroker.LibKernel.ModelDataApp;
import com.deveignatik.MessageBroker.LibKernel.entities.Message;
import com.deveignatik.MessageBroker.LibKernel.entities.Topic;
import org.apache.log4j.BasicConfigurator;

import java.util.ArrayList;
import java.util.List;

import static com.deveignatik.MessageBroker.LibKernel.Broker.*;

/**
 * 12:39 PM.
 */
public class Main {
    public static void main(String[] args) {
        BasicConfigurator.configure();
        init();
//        addTopic("MainTopic");
//        addTopic("TwoTopic");
//        publish("Some message", 1);
        List<Message> list = getMessages();
        for(Message mesIter : list){
            System.out.println(mesIter);
        }

    }
}
