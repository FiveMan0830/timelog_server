package ssl.ois.timelog.service.repository.activityType;

import ssl.ois.timelog.model.activity.type.ActivityTypeList;
import ssl.ois.timelog.service.exception.activityType.GetActivityTypeErrorException;
import ssl.ois.timelog.service.exception.activityType.SaveActivityTypeErrorException;

public interface ActivityTypeListRepository {
    public void save(ActivityTypeList activityTypeList) throws SaveActivityTypeErrorException;
    public ActivityTypeList findByUserID(String userID) throws GetActivityTypeErrorException;
    public void update(ActivityTypeList activityTypeList) throws GetActivityTypeErrorException, SaveActivityTypeErrorException;
}