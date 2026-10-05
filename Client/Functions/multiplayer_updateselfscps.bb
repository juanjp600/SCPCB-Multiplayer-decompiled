Function multiplayer_updateselfscps%()
    Local local0.players
    For local0 = Each players
        Select local0\Field49
            Case model_966
                If (multiplayer_isafriend(myplayer\Field49, local0\Field49) = $00) Then
                    If (2.5 > entitydistance(collider, local0\Field13)) Then
                        staminaeffect = 2.0
                        staminaeffecttimer = 30.0
                        myplayer\Field105 = (millisecs() + $3E8)
                    EndIf
                EndIf
            Case model_zombie
                If (overlaysenabled <> 0) Then
                    showentity(infectoverlay)
                    entityalpha(infectoverlay, 0.25)
                EndIf
        End Select
    Next
    If (((myplayer\Field105 < millisecs()) And (myplayer\Field105 <> $00)) <> 0) Then
        stamina = 1.0
        staminaeffect = 1.0
        myplayer\Field105 = $00
        staminaeffecttimer = 0.0
    EndIf
    Return $00
End Function
