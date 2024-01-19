Function multiplayer_updateselfscps%()
    Local local0.players
    Local local1%
    For local0 = Each players
        local1 = local0\Field51
        If (local1 = model_966) Then
            If (multiplayer_isafriend(myplayer\Field51, local0\Field51) = $00) Then
                If (2.5 > entitydistance(collider, local0\Field13)) Then
                    staminaeffect = 3.0
                    staminaeffecttimer = 30.0
                    myplayer\Field105 = (millisecs() + $3E8)
                EndIf
            EndIf
        EndIf
    Next
    If (((myplayer\Field105 < millisecs()) And (myplayer\Field105 <> $00)) <> 0) Then
        stamina = 1.0
        staminaeffect = 1.0
        myplayer\Field105 = $00
        staminaeffecttimer = 0.0
    EndIf
    Return $00
End Function
