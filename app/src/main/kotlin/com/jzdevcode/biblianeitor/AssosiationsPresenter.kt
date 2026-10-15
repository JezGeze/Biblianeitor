package com.jzdevcode.biblianeitor

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AssosiationsPresenter(
        private val viewAs: AssosiationsContract.ContAssosiationsActivity,
        private val modelAs: AssosiationsContract.ContAssosiationsModel
    ) : AssosiationsContract.ContAssosiationsPresenter {
    
    override fun setRecyclerView() {
        viewAs.adaptersInfo(LoadScreenPresenter.referencesEntityList.map{it.text},
                            LoadScreenPresenter.referencesEntityList.map{it.assosiation},
                            LoadScreenPresenter.referencesEntityList.map{it.reference}
                            )
    }
    
    override fun deleteAssosiation(index: Int){
        val id = LoadScreenPresenter.referencesEntityList[index].id
        
        CoroutineScope(Dispatchers.IO).launch{
            modelAs.deleteAssosiationFromDB(id)
            
            withContext(Dispatchers.Main){
                viewAs.showMessage("Asosiación Borrada")
                viewAs.refreshScreen()
            }
        }
    }
    
}
