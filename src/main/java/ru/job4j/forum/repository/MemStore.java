package ru.job4j.forum.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.forum.model.Post;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;



@Repository
public class MemStore {
    private AtomicInteger id = new AtomicInteger(0);
    private HashMap<Integer, Post> posts = new HashMap<>();

    public MemStore() {
        Post post = Post.of("Продаю машину ладу 01.");
        post.setId(id.incrementAndGet());
        posts.put(id.get(), post);
    }

    public Post save(Post post) {
        if (!posts.containsKey(post.getId())) {
            post.setId(id.incrementAndGet());
            posts.put(id.get(), post);
        } else {
            posts.replace(post.getId(), post);
        }
        return post;

    }

    public List<Post> getPosts() {
        return new ArrayList<>(posts.values());
    }

    public Post findById(int id) {
        return posts.get(id);
    }
}
