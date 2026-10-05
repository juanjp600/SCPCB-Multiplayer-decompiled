Function voice_players_update%()
    Local local0.players
    For local0 = Each players
        local0\Field61 = max(0.0, (local0\Field61 - fpsfactor))
        local0\Field64 = max(0.0, (local0\Field64 - fpsfactor))
        local0\Field60 = max(0.0, (local0\Field60 - fpsfactor))
        If (1.0 > local0\Field64) Then
            local0\Field43 = $00
        EndIf
        If (((0.0 >= local0\Field59) Or local0\Field84) <> 0) Then
            If (voice_player_getavail(local0) <> $00) Then
                If (voice_get_player_channels(local0) = $00) Then
                    voice_release_player(local0)
                    resizebank(local0\Field58, $00)
                    local0\Field84 = $00
                    local0\Field59 = 0.0
                EndIf
            EndIf
        ElseIf (voice_player_getavail(local0) >= ((voice_getbytes() Shl $05) / ($BB80 / voice\Field5))) Then
            voice_release_player(local0)
            resizebank(local0\Field58, $00)
        Else
            local0\Field59 = (local0\Field59 - fpsfactor)
        EndIf
    Next
    Return $00
End Function
