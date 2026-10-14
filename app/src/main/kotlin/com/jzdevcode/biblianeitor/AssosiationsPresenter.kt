package com.jzdevcode.biblianeitor

class AssosiationsPresenter(
        private val viewAs: AssosiationsContract.ContAssosiationsActivity,
        private val modelAs: AssosiationsContract.ContAssosiationsModel
    ) : AssosiationsContract.ContAssosiationsPresenter {
    
    private var titlesList = emptyList<String>()
    private var index = 0
    
    override fun getAllTextsColumns(){
            titlesList = LoadScreenPresenter.referencesEntityList.map{it.text}
            setRecyclerView()
        }
    
    /*override fun getAllTextsColumns(){
        CoroutineScope(Dispatchers.IO).launch{
                textsList = modelAs.getAllTextsColumnsFromDB()
                
                withContext(Dispatchers.Main){
                    setRecyclerView()
                }
            }
        }*/
    
    //Si referencesEntityList esta vacio, entonces este metodo hara crashear la app
    //screenText() se implementa dentro de getAllColumnsForValidate(), y lo que hace es pintar en pantalla las citas biblicas
    
    override fun setRecyclerView() {
        viewAs.adaptersInfo(LoadScreenPresenter.referencesEntityList.map{it.text},
                            LoadScreenPresenter.referencesEntityList.map{it.assosiation},
                            LoadScreenPresenter.referencesEntityList.map{it.reference}
                            )
    }
    
    /*override suspend fun setRecyclerView() {
        var counter = 0
        do{
            if (textsList.isEmpty()){
                counter++
                //viewTTR.showMessage("Cargando")
                delay(1000)
            } else if (textsList.isNotEmpty()){
                viewAs.adaptersInfo(textsList)
                counter = 11
            }
        }while(counter <= 10)
    }*/
    
}
