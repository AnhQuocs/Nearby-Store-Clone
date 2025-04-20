package com.example.nearbystoreclone.viewmodel

import androidx.lifecycle.LiveData
import com.example.nearbystoreclone.domain.CategoryModel
import com.example.nearbystoreclone.domain.StoreModel
import com.example.nearbystoreclone.repository.ResultsRepository

class ResultsViewModel {
    private val repository = ResultsRepository()

    fun loadSubCategory(id: String):LiveData<MutableList<CategoryModel>> {
        return repository.loadSubCategory(id)
    }

    fun loadPopular(id: String):LiveData<MutableList<StoreModel>> {
        return repository.loadPopular(id)
    }

    fun loadNearest(id: String):LiveData<MutableList<StoreModel>> {
        return repository.loadNearest(id)
    }
}