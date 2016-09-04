package cz.tomanjir.service;

import cz.tomanjir.model.Animal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

public class AnimalRentalServiceImpl implements AnimalRentalService {

    private static final Logger LOG = LoggerFactory.getLogger(AnimalRentalServiceImpl.class);

    private final Set<Animal> availableAnimals = new HashSet<>();

    private static final AnimalRentalServiceImpl INSTANCE = new AnimalRentalServiceImpl();

    public AnimalRentalServiceImpl() {
    }

    public static AnimalRentalServiceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public void init() {
        LOG.info("Initializing..");
        //Implement if needed
        LOG.info("Initialized.");
    }

    @Override
    public void close() {
        LOG.info("Closing..");
        unregisterAllAnimals();
        LOG.info("Closed.");
    }

    @Override
    public boolean registerAnimal(Animal animal) {
        boolean result = false;

        if (animal != null) {
            result = availableAnimals.add(animal);
            if (result) {
                LOG.info("Registered animal={}.", animal);
            } else {
                LOG.warn("Failed to register animal={}! This animal has already been registered.", animal);
            }
        } else {
            LOG.warn("Failed to register animal=null! This service does not accept such kind of animals.");
        }

        return result;
    }

    @Override
    public boolean unregisterAnimal(Animal animal) {
        boolean result = false;

        if (animal != null) {
            result = availableAnimals.remove(animal);
            if (result) {
                LOG.info("Unregistered animal={}.", animal);
            } else {
                LOG.warn("Failed to unregister animal={}! There is no such animal registered.", animal);
            }
        } else {
            LOG.warn("Failed to unregister animal=null! This service does not accept such kind of animals.");
        }

        return result;
    }

    @Override
    public void unregisterAllAnimals() {
        LOG.info("Closing..");
        availableAnimals.clear();
    }

    @Override
    public int getNumberOfRegisteredAnimals() {
        return availableAnimals.size();
    }
}