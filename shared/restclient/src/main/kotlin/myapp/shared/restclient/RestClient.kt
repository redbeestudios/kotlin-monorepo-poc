package myapp.shared.restclient

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response

abstract class RestClient {
    protected val client = OkHttpClient()

    protected inline fun <reified T>fetch(request: Request): T? {
        val responseBody = fetchResponseBody(request) ?: return null
        return jacksonObjectMapper().readValue(responseBody)
    }

    protected fun <T>requestBody(data: T): RequestBody {
        return jacksonObjectMapper().writeValueAsString(data).toRequestBody()
    }

    protected fun ensureResponseIsOk(response: Response) {
        if (!response.isSuccessful) {
            throw Exception("HTTP request failed with: ${response.code} ${response.message}")
        }
    }

    protected fun fetchResponseBody(request: Request): String? {
        val response = client
            .newCall(request)
            .execute()

        ensureResponseIsOk(response)

        return response.body?.string()
    }
}