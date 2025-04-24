package com.lacheln.dcms.utilities;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.lacheln.dcms.entity.*;
 
public class HibernateUtil {
    private static SessionFactory sessionFactory;
     
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            // loads configuration and mappings
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
            configuration.addAnnotatedClass(Patients.class); // this is important           
            configuration.addAnnotatedClass(TreatmentPlans.class); // this is important
            /*configuration.addAnnotatedClass(Plans.class); // this is important
            configuration.addAnnotatedClass(Treatments.class); // this is important
            configuration.addAnnotatedClass(TreatmentMaster.class); // this is important
            configuration.addAnnotatedClass(WorkdoneMaster.class); // this is important
*/            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            // builds a session factory from the service registry
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);           
        }
         
        return sessionFactory;
    }
}