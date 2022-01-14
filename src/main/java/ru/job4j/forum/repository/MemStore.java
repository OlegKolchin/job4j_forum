package ru.job4j.forum.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.forum.model.Post;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemStore {
    private List<Post> posts = new ArrayList<>();

    public MemStore() {
        Post post = Post.of("Продаю машину ладу 01.");
        post.setId(1);
        posts.add(post);
    }

    public Post save(Post post) {
        for (Post p : posts) {
            if (p.getId() == post.getId()) {
                p.setName(post.getName());
                p.setCreated(post.getCreated());
                p.setDescription(post.getDescription());
                return post;
            }
        }
        post.setId(posts.size() + 1);
        posts.add(post);
        return post;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public Post findById(int id) {
        return posts.stream().filter(p -> p.getId() == id)
                .findFirst().get();
    }
}
