package trending.github.com.data.repository.parameters

import android.support.annotation.StringDef

class GithubParameters {
    companion object {
        @StringDef(STARS, FORKS, UPDATED)
        @Retention(AnnotationRetention.SOURCE)
        annotation class SortType
        const val STARS = "stars"
        const val FORKS = "forks"
        const val UPDATED = "updated"


        @StringDef(ASC, DESC)
        @Retention(AnnotationRetention.SOURCE)
        annotation class OrderType
        const val ASC = "asc"
        const val DESC = "desc"
    }
}