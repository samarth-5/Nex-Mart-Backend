package com.samarth_dev.service;

import com.samarth_dev.modal.Home;
import com.samarth_dev.modal.HomeCategory;

import java.util.List;

public interface HomeService {

    public Home createHomePageData(List<HomeCategory> allCategories);
}
