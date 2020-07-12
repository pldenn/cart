package ru.netology.manager;

import ru.netology.domain.Film;
import ru.netology.repository.AfishaRepository;

public class AfishaManager {
    private AfishaRepository repository;
    private int currentLength = 10;
    private int newLength;

    public AfishaManager(AfishaRepository repository) {
        this.repository = repository;
    }

    public AfishaManager(AfishaRepository repository, int newLength) {
        this.repository = repository;
        this.newLength = newLength;
    }

    public void add(Film film) {
        repository.save(film);
    }

    public Film[] getAll() {
        Film[] films = repository.findAll();

        if (newLength <= 0 || newLength > currentLength) {
            newLength = currentLength;
        }
        if (films.length < newLength) {
            newLength = films.length;
        }

        Film[] result = new Film[newLength];

        for (int i = 0; i < result.length; i++) {
            int index = films.length - i - 1;
            result[i] = films[index];
        }
        return result;
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public void findById(int id) {
        repository.findById(id);
    }

    public void removeAll() {
        repository.removeAll();
    }
}
