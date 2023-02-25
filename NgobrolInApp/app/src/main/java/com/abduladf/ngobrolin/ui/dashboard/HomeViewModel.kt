package com.abduladf.ngobrolin.ui.dashboard

import androidx.lifecycle.ViewModel
import com.abduladf.ngobrolin.model.ApiRepository

class HomeViewModel : ViewModel() {
    val creators = ApiRepository().getCreators()
}