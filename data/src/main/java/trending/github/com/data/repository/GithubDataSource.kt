package trending.github.com.data.repository

import com.github.trending.model.GithubRepos
import trending.github.com.data.repository.parameters.GithubParameters.Companion.SortType
import trending.github.com.data.repository.parameters.GithubParameters.Companion.OrderType
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import trending.github.com.data.model.ReadMe

interface GithubDataSource{
    @GET("search/repositories")
    fun getRepositories(@Query(value = "q") q : String,
                        @Query("sort") @SortType sort : String,
                        @Query("order") @OrderType order : String) : Single<GithubRepos>

    @GET("repos/{owner}/{repo}/contents/README.md")
    fun getReadme(@Path(value = "owner", encoded = true) owner : String,
                  @Path(value = "repo", encoded = true) repo : String) : Single<ReadMe>
}