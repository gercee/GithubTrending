package trending.github.com.data.repository

import com.github.trending.model.GithubRepos
import io.reactivex.Single
import trending.github.com.data.model.ReadMe

interface GithubRepository {
     fun getTrending(query: String, language: String) : Single<GithubRepos>
     fun getReadme(owner: String, repo: String) : Single<ReadMe>
}