package com.example.nearbystoreclone.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.nearbystoreclone.domain.CategoryModel
import com.example.nearbystoreclone.domain.StoreModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query
import com.google.firebase.database.ValueEventListener

class ResultsRepository {
    private val firebaseDatabase = FirebaseDatabase.getInstance()

    fun loadSubCategory(id: String): LiveData<MutableList<CategoryModel>> {

        val listData = MutableLiveData<MutableList<CategoryModel>>()
        val ref = firebaseDatabase.getReference("SubCategory")
        val query: Query = ref.orderByChild("CategoryId").equalTo(id)
        query.addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val lists = mutableListOf<CategoryModel>()
                for(childSnapshot in snapshot.children) {
                    val list = childSnapshot.getValue(CategoryModel::class.java)
                    if(list != null) {
                        lists.add(list)
                    }
                }
                listData.value = lists
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        } )

        return listData
    }

    fun loadPopular(id: String): LiveData<MutableList<StoreModel>> {

        val listData = MutableLiveData<MutableList<StoreModel>>()
        val ref = firebaseDatabase.getReference("Stores")
        val query: Query = ref.orderByChild("CategoryId").equalTo(id)
        query.addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val lists = mutableListOf<StoreModel>()
                for(childSnapshot in snapshot.children) {
                    val list = childSnapshot.getValue(StoreModel::class.java)
                    if(list != null) {
                        lists.add(list)
                    }
                }
                listData.value = lists
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        } )

        return listData
    }

    fun loadNearest(id: String): LiveData<MutableList<StoreModel>> {
        val listData = MutableLiveData<MutableList<StoreModel>>()
        val ref = firebaseDatabase.getReference("Nearest")
        val query: Query = ref.orderByChild("CategoryId").equalTo(id)
        query.addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val lists = mutableListOf<StoreModel>()
                for(childSnapshot in snapshot.children) {
                    val list = childSnapshot.getValue(StoreModel::class.java)
                    if(list != null) {
                        lists.add(list)
                    }
                }
                listData.value = lists
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        } )

        return listData
    }
}