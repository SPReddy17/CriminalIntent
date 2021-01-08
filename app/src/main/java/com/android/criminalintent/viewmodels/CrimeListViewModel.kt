package com.android.criminalintent.viewmodels

import androidx.lifecycle.ViewModel
import com.android.criminalintent.model.Crime
import com.android.criminalintent.repository.CrimeRepository

class CrimeListViewModel : ViewModel(){


    private val crimeRepository = CrimeRepository.get()

    val crimeListLiveData = crimeRepository.getCrimes()

    fun addCrime(crime: Crime){
        crimeRepository.addCrime(crime)
    }
}
