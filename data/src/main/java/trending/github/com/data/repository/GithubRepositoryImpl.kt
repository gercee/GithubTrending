package trending.github.com.data.repository

import com.github.trending.model.GithubRepos
import io.reactivex.Single
import trending.github.com.data.model.ReadMe
import trending.github.com.data.repository.parameters.GithubParameters


class GithubRepositoryImpl(private val githubDataSource: GithubDataSource): GithubRepository{
    override fun getTrending(query: String, language: String): Single<GithubRepos> {
        return githubDataSource.getRepositories(q = "$query+language:$language",
                                                sort = GithubParameters.STARS,
                                                order = GithubParameters.DESC)
    }

    override fun getReadme(owner: String, repo: String) : Single<ReadMe> {
        return githubDataSource.getReadme(owner = owner, repo = repo)
    }
}