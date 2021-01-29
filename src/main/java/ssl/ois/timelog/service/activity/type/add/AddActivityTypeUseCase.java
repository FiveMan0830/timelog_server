package ssl.ois.timelog.service.activity.type.add;

import org.springframework.stereotype.Service;

import ssl.ois.timelog.model.activity.type.ActivityType;
import ssl.ois.timelog.model.unit.Unit;
import ssl.ois.timelog.model.user.User;
import ssl.ois.timelog.service.exception.DatabaseErrorException;
import ssl.ois.timelog.service.exception.activity.ActivityTypeNotExistException;
import ssl.ois.timelog.service.exception.activity.DuplicateActivityTypeException;
import ssl.ois.timelog.service.repository.user.UserRepository;

@Service
public class AddActivityTypeUseCase {
    private UserRepository userRepository;

    public AddActivityTypeUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void execute(AddActivityTypeUseCaseInput input, AddActivityTypeUseCaseOutput output)
            throws DatabaseErrorException, DuplicateActivityTypeException, ActivityTypeNotExistException {
        User user = this.userRepository.findByUserID(input.getUserID());
        ActivityType activityType = new ActivityType(input.getActivityTypeName(), input.getIsEnable(), input.getIsPrivate(), input.getIsDeleted());

        user.addActivityType(activityType);
        this.userRepository.addActivityType(user);

        output.setActivityTypeName(activityType.getName());
    }
}
