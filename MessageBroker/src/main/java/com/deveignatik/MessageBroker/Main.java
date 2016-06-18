package com.deveignatik.MessageBroker;

import com.deveignatik.MessageBroker.LibKernel.Broker;
import com.deveignatik.MessageBroker.LibKernel.ModelDataApp;
import com.deveignatik.MessageBroker.LibKernel.entities.Topic;
import org.apache.log4j.BasicConfigurator;

import java.util.List;

import static com.deveignatik.MessageBroker.LibKernel.Broker.*;

/**
 * 12:39 PM.
 */
public class Main {
    public static void main(String[] args) {
        BasicConfigurator.configure();
        init();
        System.out.println(getMessages(1));
    }
}
