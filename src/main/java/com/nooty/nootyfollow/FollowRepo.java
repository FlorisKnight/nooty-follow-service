package com.nooty.nootyfollow;

import com.nooty.nootyfollow.models.Follow;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FollowRepo extends CrudRepository<Follow, String> {

    Iterable<Follow> findAllByUserId(String userId);

    Iterable<Follow> findAllByFolloweeId(String id);

    Optional<Follow> findByUserIdAndFolloweeId(String userId, String followeeId);
}
