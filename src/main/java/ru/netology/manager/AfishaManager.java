package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.netology.domain.Film;
import ru.netology.repository.AfishaRepository;

@NoArgsConstructor
@AllArgsConstructor
public class AfishaManager {
    private AfishaRepository repository;

    private Film[] films = new Film[0];
    int currentLength = 10;
    int newLength;

    public AfishaManager(AfishaRepository repository) {
        this.repository = repository;
    }

    public AfishaManager(AfishaRepository repository, int newLength) {
        this.repository = repository;
        this.currentLength = newLength;
    }


    public void add(Film film) {
        repository.save(film);
    }

    public Film[] getAll() {
        Film[] films = repository.findAll();
        Film[] result = new Film[newLength];

        if (newLength > currentLength) {
            newLength = currentLength;
        }
        if (newLength < 0) {
            newLength = 0;
        }
        if (films.length < newLength) {
            newLength = films.length;
        }
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
