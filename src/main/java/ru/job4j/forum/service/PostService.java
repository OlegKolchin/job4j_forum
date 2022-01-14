package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.PostRepository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository posts;

    public PostService(PostRepository posts) {
        this.posts = posts;
    }

    public List<Post> getAll() {
        List<Post> rsl = new ArrayList<>();
        posts.findAll().forEach(rsl::add);
        return rsl;
    }

    public Post save(Post post) {
        post.setCreated(Calendar.getInstance());
        return posts.save(post);
    }

    public Post findById(int id) {
        Optional<Post> post = posts.findById(id);
        if (post.isPresent()) {
            return post.get();
        }
        return null;
    }
}