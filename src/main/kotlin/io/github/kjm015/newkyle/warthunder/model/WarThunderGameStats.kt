package io.github.kjm015.newkyle.warthunder.model

import com.fasterxml.jackson.annotation.JsonProperty

class WarThunderGameStats {
    @JsonProperty("kpd")
    var efficiency: Double = -1.0

    @JsonProperty("prev_kpd")
    var previousEfficiency: Double = -1.0

    @JsonProperty("win")
    var wins: Long = -1L

    @JsonProperty("prev_win")
    var previousWins: Long = -1L

    @JsonProperty("death")
    var deaths: Long = -1L

    @JsonProperty("prev_death")
    var previousDeaths: Long = -1L

    @JsonProperty("mission")
    var missions: Long = -1L

    @JsonProperty("prev_mission")
    var previousMissions: Long = -1L

    @JsonProperty("winrate")
    var winRate: Double = -1.0

    @JsonProperty("prev_winrate")
    var previousWinRate: Double = -1.0

    @JsonProperty("kb")
    var killsPerBattle: Double = -1.0

    @JsonProperty("prev_kb")
    var previousKillsPerBattle: Double = -1.0

    @JsonProperty("kb_air")
    var airKillsPerBattle: Double = -1.0

    @JsonProperty("prev_kb_air")
    var previousAirKillsPerBattle: Double = -1.0

    @JsonProperty("kb_ground")
    var groundKillsPerBattle: Double = -1.0

    @JsonProperty("prev_kb_ground")
    var previousGroundKillsPerBattle: Double = -1.0

    @JsonProperty("kd")
    var killDeathRatio: Double = -1.0

    @JsonProperty("prev_kd")
    var previousKillDeathRatio: Double = -1.0

    @JsonProperty("kd_air")
    var airKillDeathRatio: Double = -1.0

    @JsonProperty("prev_kd_air")
    var previousAirKillDeathRatio: Double = -1.0

    @JsonProperty("kd_ground")
    var groundKillDeathRatio: Double = -1.0

    @JsonProperty("prev_kd_ground")
    var previousGroundKillDeathRatio: Double = -1.0

    var lifetime: Double = -1.0

    @JsonProperty("prev_lifetime")
    var previousLifetime: Double = -1.0
}
