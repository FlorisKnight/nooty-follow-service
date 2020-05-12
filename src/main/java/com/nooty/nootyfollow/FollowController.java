package com.nooty.nootyfollow;

import com.nooty.nootyfollow.models.Follow;
import com.nooty.nootyfollow.viewmodels.CreateViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/follow")
public class FollowController {
    @Autowired
    private FollowRepo followRepo;

    @PostMapping(path = "/create/{id}", produces = "application/json")
    public ResponseEntity create(@RequestBody CreateViewModel createViewModel, @PathVariable String id) {
        Follow follow = new Follow();
        follow.setUserId(id);
        follow.setFolloweeId(createViewModel.getUserId());

        this.followRepo.save(follow);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity getFolleesFromId(@PathVariable String id) {
        List<String> followeeIds = new ArrayList<>();
        this.followRepo.findAllByUserId(id).forEach( f -> {
            followeeIds.add(f.getFolloweeId());
        });

        return ResponseEntity.ok(followeeIds);
    }

    @DeleteMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity delete(@PathVariable String id, @RequestBody CreateViewModel createViewModel) {
        Optional<Follow> followOptional = this.followRepo.findByUserIdAndFolloweeId(id, createViewModel.getUserId());
        if (!followOptional.isPresent()) {
            return ResponseEntity.status(404).build();
        }
        Follow follow = followOptional.get();
        this.followRepo.delete(follow);

        return ResponseEntity.ok().build();
    }
}
