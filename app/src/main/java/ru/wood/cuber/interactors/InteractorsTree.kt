package ru.wood.cuber.interactors

import ru.wood.cuber.Loger
import ru.wood.cuber.data.*
import ru.wood.cuber.interactors.ParamsClasses.Limit
import ru.wood.cuber.interactors.ParamsClasses.NewParams
import ru.wood.cuber.repositories.RepositoryTrees
import javax.inject.Inject

class LoadTrees @Inject constructor(val repository: RepositoryTrees): UseCase<List<TreePosition>, Long?>(){

    override suspend fun run(params: Long?): List<TreePosition> {
        return repository.loadList(params!!)
    }
}

class SimpleLoadTrees @Inject constructor(val repository: RepositoryTrees): UseCase<List<TreePosition>, Long?>(){

    override suspend fun run(params: Long?): List<TreePosition> {
        return repository.loadSimpleList(params!!)
    }
}

class SaveOneTree @Inject constructor(val repository: RepositoryTrees): UseCase<Long, TreePosition>(){

    override suspend fun run(params: TreePosition) :Long{
        val idOfConteiner=repository.saveOne(params)
        Loger.log("id of saved position $idOfConteiner")
        return idOfConteiner
    }
}

class SaveTreeContent @Inject constructor(val repository: RepositoryTrees): UseCase<Boolean, ContainerContentsTab>(){

    override suspend fun run(params: ContainerContentsTab) :Boolean{
        val ok=repository.saveContent(params)
        Loger.log("id of saved position $ok")
        return ok!=0L
    }
}


class DeleteOneTree @Inject constructor(val repository: RepositoryTrees): UseCase<Boolean, TreePosition>() {

    override suspend fun run(params: TreePosition): Boolean {
        val length=params.length
        val diameter=params.diameter
        val ok = repository.delete(length,diameter)
        Loger.log("id of saved position $ok")
        return ok > 0
    }
}

class ClearOneContain @Inject constructor(val repository: RepositoryTrees): UseCase<Boolean, Long>() {

    override suspend fun run(params: Long): Boolean {
        val ok = repository.deleteContent(params)
        Loger.log("id of saved position $ok")
        return ok > 0
    }
}

class UpdateTreeLength @Inject constructor(val repository: RepositoryTrees): UseCase<Boolean, NewParams>() {
    override suspend fun run(params: NewParams): Boolean{
        val container=params.containerOfTrees
        val length=params.length
        val ok = repository.updateLength(container,length)
        return ok>0
    }
}

