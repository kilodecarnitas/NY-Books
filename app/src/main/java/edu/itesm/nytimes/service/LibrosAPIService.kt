package edu.itesm.nytimes.service

import edu.itesm.nytimes.response.NewResponse
import retrofit2.Call
import retrofit2.http.GET

interface LibrosAPIService {
    @GET("hardcover-fiction.json?api-key=FQngXMrxO7lDeQFGIgdnEqa0tm3ciIrp")
    fun getBooks():
            Call<NewResponse>
}