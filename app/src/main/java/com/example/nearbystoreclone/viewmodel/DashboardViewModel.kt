package com.example.nearbystoreclone.viewmodel

import androidx.lifecycle.LiveData
import com.example.nearbystoreclone.domain.BannerModel
import com.example.nearbystoreclone.domain.CategoryModel
import com.example.nearbystoreclone.repository.DashboardRepository

class DashboardViewModel {
    private val repository = DashboardRepository()

    fun loadCategory(): LiveData<MutableList<CategoryModel>> {
        return repository.loadCategory()
    }

    fun loadBanner(): LiveData<MutableList<BannerModel>> {
        return repository.loadBanner()
    }
}