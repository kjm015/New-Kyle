package io.github.kjm015.newkyle.warthunder.model

import com.fasterxml.jackson.annotation.JsonProperty

class WarThunderStats {
    var nick: String = ""
    var rank: String = ""

    @JsonProperty("last_stat")
    var lastStat: String? = ""

    @JsonProperty("pre_last_stat")
    var previousLastStat: String? = ""

    @JsonProperty("a")
    var arcadeStats: WarThunderGameStats = WarThunderGameStats()

    @JsonProperty("r")
    var realisticStats: WarThunderGameStats = WarThunderGameStats()

    @JsonProperty("s")
    var simulatorStats: WarThunderGameStats = WarThunderGameStats()

    fun displayStats(): String {
        return """
            ```
                --------------------------------------
                $nick's War Thunder stats
                --------------------------------------
                Rank                | $rank
                AB Efficiency       | ${arcadeStats.efficiency}%
                AB Wins             | ${arcadeStats.wins}
                AB Deaths           | ${arcadeStats.deaths}
                AB Missions         | ${arcadeStats.missions}
                AB Win Ratio        | ${arcadeStats.winRate}%
                AB Kills per Battle | ${arcadeStats.killsPerBattle}
                AB Kill/Death Ratio | ${arcadeStats.killDeathRatio}
                AB Average Lifetime | ${arcadeStats.lifetime} minutes
                --------------------------------------
                [Stats as of $lastStat]
                Source: https://thunderskill.com/en/stat/$nick
            ```
            Full profile: https://warthunder.com/en/community/userinfo?nick=$nick
        """.trimIndent()
    }
}