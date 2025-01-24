Function updateplayerattaches%(arg0.mp_player)
    Local local0%
    Local local1.mp_playerattach
    For local0 = $00 To $09 Step $01
        local1 = arg0\Field35\Field21[local0]
        If (local1\Field2 <> local1\Field3) Then
            applyplayerattachattributes(arg0, local0)
        EndIf
        If (((local1\Field0 <> $00) And (local1\Field2 <> Null)) <> 0) Then
            local1\Field5 = (local1\Field5 - fps\Field7[$00])
            If (0.0 > local1\Field5) Then
                If (((local1\Field4 = $00) Lor (channelplaying(local1\Field4) = $00)) <> 0) Then
                    local1\Field4 = $00
                    If (local1\Field2\Field6 > $00) Then
                        local1\Field4 = playsound_strict(local1\Field2\Field8[rand($00, (local1\Field2\Field6 - $01))], $00)
                    EndIf
                EndIf
                local1\Field5 = 35.0
            EndIf
            If (local1\Field4 <> $00) Then
                updatesoundorigin(local1\Field4, camera, local1\Field0, 8.0, 1.0, $00, $01)
            EndIf
        EndIf
    Next
    Return $00
End Function
