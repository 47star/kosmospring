package com.donghoonyoo.practice.kosmospring.controllers

import com.donghoonyoo.practice.kosmospring.entities.Account
import com.donghoonyoo.practice.kosmospring.repositories.AccountRepository
import com.donghoonyoo.practice.kosmospring.utils.HttpStatusCodeException
import com.donghoonyoo.practice.kosmospring.utils.value
import kotlinx.serialization.Serializable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/account")
class AccountController(
    private val accountRepository: AccountRepository,
) {
    @GetMapping("/id")
    fun getAccount(
        @RequestParam
        id: String,
    ): ResponseEntity<String> =
        ResponseEntity.ok(
            accountRepository.findById(id).value?.toString()
                ?: throw HttpStatusCodeException(HttpStatus.NOT_FOUND, "The account does not found.")
        )

    @GetMapping("/email")
    fun getAccountByEmail(
        @RequestParam
        email: String,
    ): ResponseEntity<String> =
        ResponseEntity.ok(
            accountRepository.findByEmail(email).firstOrNull()?.toString()
                ?: throw HttpStatusCodeException(HttpStatus.NOT_FOUND, "The account does not found.")
        )


    @Serializable
    @SuppressWarnings("unused")
    data class CreateAccountRequest(
        val email: String,
        val name: String,
    )

    @PostMapping
    @Transactional
    fun createAccount(
        @RequestBody
        body: CreateAccountRequest,
    ): ResponseEntity<String> =
        ResponseEntity.ok(
            accountRepository.save(Account(body.email, body.name)).id
        )
}