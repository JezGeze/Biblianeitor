package com.jzdevcode.biblianeitor

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
    
}
