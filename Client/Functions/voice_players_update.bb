Function voice_players_update%()
    Local local0.players
    For local0 = Each players
        local0\Field63 = max(0.0, (local0\Field63 - fpsfactor))
        local0\Field66 = max(0.0, (local0\Field66 - fpsfactor))
        local0\Field62 = max(0.0, (local0\Field62 - fpsfactor))
        If (1.0 > local0\Field66) Then
            local0\Field45 = $00
        EndIf
        If (((0.0 >= local0\Field61) Or local0\Field86) <> 0) Then
            If (voice_player_getavail(local0) <> $00) Then
                If (voice_get_player_channels(local0) = $00) Then
                    voice_release_player(local0)
                    resizebank(local0\Field60, $00)
                    local0\Field86 = $00
                    local0\Field61 = 0.0
                EndIf
            EndIf
        ElseIf (voice_player_getavail(local0) >= ((voice_getbytes() Shl $05) / ($BB80 / voice\Field5))) Then
            voice_release_player(local0)
            resizebank(local0\Field60, $00)
        Else
            local0\Field61 = (local0\Field61 - fpsfactor)
        EndIf
    Next
    Return $00
End Function
