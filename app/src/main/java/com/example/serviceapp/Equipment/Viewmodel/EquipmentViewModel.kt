package com.example.serviceapp.Equipment.Viewmodel

import android.net.Uri
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.serviceapp.Equipment.Model.EquipmentModel
import com.example.serviceapp.LanourJob.Model.jobdetailsmodel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.ktx.storage
import kotlinx.coroutines.launch
import java.util.UUID


class EquipmentViewModel : ViewModel() {
    private val storage = Firebase.storage
    private val firestore = FirebaseFirestore.getInstance()

    // LiveData for managing state
    val equpmentDataList = mutableStateListOf<EquipmentModel>()

    // Function to submit the form
    fun submitForm(formData: EquipmentModel) {
        val formMap = hashMapOf(
            "title" to formData.title,
            "address" to formData.address,
            "imageUrl" to formData.imageUrl,
            "price" to formData.price,
            "ownerName" to formData.ownerName,
            "call" to formData.call,

        )

        formData.imageUrl?.let { uri ->
            val imageRef = storage.reference.child("images/${System.currentTimeMillis()}.jpg")
            imageRef.putFile(uri)
                .addOnSuccessListener {
                    imageRef.downloadUrl.addOnSuccessListener { downloadUrl ->
                        formMap["imageUrl"] = downloadUrl.toString()
                        // Save to Firestore
                        firestore.collection("equipment")
                            .add(formMap)
                            .addOnSuccessListener {
                                // Form successfully saved
                            }
                            .addOnFailureListener {
                                // Handle error
                            }
                    }
                }
                .addOnFailureListener {
                    // Handle image upload failure
                }
        } ?: run {
            // Save without image if no image was selected
            firestore.collection("equipment")
                .add(formMap)
                .addOnSuccessListener {
                    // Form successfully saved
                }
                .addOnFailureListener {
                    // Handle error
                }
        }
    }

    // Function to retrieve form data from Firestore
    fun getFormData() {
        firestore.collection("forms")
            .get()
            .addOnSuccessListener { querySnapshot ->
                equpmentDataList.clear()
                querySnapshot.documents.forEach { document ->
                    val title = document.getString("title") ?: ""
                    val call = document.getString("call") ?: ""
                    val address = document.getString("address") ?: ""
                    val imageUrl = document.getString("imageUrl") ?: ""
                    val description = document.getString("description") ?: ""
                    val price = document.getString("price") ?: ""
                    val ownerName = document.getString("ownerName") ?: ""
                    val formData = EquipmentModel(title,description,price,address,imageUrl= null,call,ownerName)
                    equpmentDataList.add(formData)
                }
            }
            .addOnFailureListener {
                // Handle error
            }
    }
}