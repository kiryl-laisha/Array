package com.laisha.array.creator;

import com.laisha.array.entity.UserArray;
import com.laisha.array.entity.UserArrayStatistics;

import java.util.Optional;

public interface UserArrayStatisticsCreator {

    Optional<UserArrayStatistics> createUserArrayStatistics(UserArray userArray);
}
