Function updaterooms%()
    Local local0.rooms
    Local local1%
    For local0 = Each rooms
        hideentity(local0\Field2)
        local0\Field73 = $00
    Next
    For local1 = $01 To server\Field11 Step $01
        If (playeroptimize[local1]\Field55 <> 0) Then
            multiplayer_updateplayerroom(playeroptimize[local1])
        EndIf
        If (playeroptimize[local1]\Field32 < $C8) Then
            local0 = room[playeroptimize[local1]\Field32]
            If (local0 <> Null) Then
                If (local0\Field73 = $00) Then
                    showentity(local0\Field2)
                    local0\Field73 = $01
                    For local1 = $00 To $03 Step $01
                        If (local0\Field32[local1] <> Null) Then
                            showentity(local0\Field32[local1]\Field2)
                            local0\Field32[local1]\Field73 = $01
                        EndIf
                    Next
                EndIf
            EndIf
        EndIf
    Next
    Return $00
End Function
