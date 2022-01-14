package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.MemStore;

import java.util.List;

@Service
public class PostService {

    private final MemStore store = new MemStore();

    public List<Post> getAll() {
        return store.getPosts();
    }

    public Post save(Post post) {
        return store.save(post);
    }

    public Post findById(int id) {
        return store.findById(id);
    }
}