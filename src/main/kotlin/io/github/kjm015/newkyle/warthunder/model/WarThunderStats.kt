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
            https://thunderskill.com/userbars/k/j/$nick/en-1-combined-a.png
            ```
                --------------------------------------
                $nick's War Thunder stats
                Rank - $rank
                --------------------------------------
                Arcade Battles
                --------------------------------------
                Efficiency         | ${arcadeStats.efficiency}%
                Wins               | ${arcadeStats.wins}
                Aircraft Destroyed | ${(arcadeStats.missions * arcadeStats.airKillsPerBattle).toULong()}
                Deaths             | ${arcadeStats.deaths}
                Missions           | ${arcadeStats.missions}
                Win Ratio          | ${arcadeStats.winRate}%
                Kills per Battle   | ${arcadeStats.airKillsPerBattle}
                Kill/Death Ratio   | ${arcadeStats.killDeathRatio}
                Average Lifetime   | ${arcadeStats.lifetime} minutes
                --------------------------------------
                [Stats as of $lastStat]
                Source: https://thunderskill.com/en/stat/$nick
            ```
            Full profile: https://warthunder.com/en/community/userinfo?nick=$nick
        """.trimIndent()
    }
}