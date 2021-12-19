package com.codesodja.crypto.framework.data.remote.dto

import com.codesodja.core.domain.TeamMember


data class TeamMember(
    val id: String,
    val name: String,
    val position: String
){
    fun toTeamMember(): TeamMember = TeamMember(
        id = id,
        name = name,
        position = position
    )
}