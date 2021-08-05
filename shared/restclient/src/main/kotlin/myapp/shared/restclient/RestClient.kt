package myapp.shared.restclient

import com.fasterxml.jackson.databind.ObjectMapper
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response

abstract class RestClient {
    protected inline fun <reified T>fetch(request: Request): T? {
        val response = client
            .newCall(request)
            .execute()

        ensureResponseIsOk(response)

        return ObjectMapper().readValue(response.body?.string(), T::class.java)
    }

    protected fun <T>requestBody(data: T): RequestBody {
        return ObjectMapper().writeValueAsString(data).toRequestBody()
    }

    protected fun ensureResponseIsOk(response: Response) {
        if (!response.isSuccessful) {
            throw Exception("HTTP request failed with: ${response.code} ${response.message}")
        }
    }

    protected val client = OkHttpClient()
}