package com.donghoonyoo.practice.kosmospring.repositories

import com.azure.spring.data.cosmos.repository.CosmosRepository
import com.azure.spring.data.cosmos.repository.Query
import com.donghoonyoo.practice.kosmospring.entities.Account
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface AccountRepository : CosmosRepository<Account, String> {
    @Query("select * from c where c.email = @email")
    fun findByEmail(
        @Param("email")
        email: String,
    ): List<Account>
}