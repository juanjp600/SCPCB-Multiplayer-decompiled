Function updatescreens%()
    Local local0.screens
    If (selectedscreen <> Null) Then
        Return $00
    EndIf
    If (selecteddoor <> Null) Then
        Return $00
    EndIf
    playerintercom\Field3 = $00
    For local0 = Each screens
        If (local0\Field3 = playerroom) Then
            If (1.2 > entitydistance(collider, local0\Field0)) Then
                entitypick(camera, 1.2)
                If (((pickedentity() = local0\Field0) And (local0\Field1 <> "")) <> 0) Then
                    If ((((networkserver\Field15 And ((multiplayer_isascp(myplayer\Field51) = $00) Or multiplayer_breach_isa049(myplayer\Field51))) And (playerroom\Field7\Field11 = "room2ccont")) And (player_isdead() = $00)) <> 0) Then
                        playerintercom\Field3 = $01
                    EndIf
                    drawhandicon = $01
                    If (mousehit1 <> 0) Then
                        If ((((playerroom\Field7\Field11 = "room2ccont") And (networkserver\Field15 = $01)) And ((multiplayer_isascp(myplayer\Field51) = $00) Or multiplayer_breach_isa049(myplayer\Field51))) <> 0) Then
                            useintercom()
                        Else
                            selectedscreen = local0
                            If (local0\Field2 = $00) Then
                                local0\Field2 = loadimage_strict(("GFX\screens\" + local0\Field1))
                                local0\Field2 = resizeimage2(local0\Field2, (Int ((Float imagewidth(local0\Field2)) * menuscale)), (Int ((Float imageheight(local0\Field2)) * menuscale)))
                                maskimage(local0\Field2, $FF, $00, $FF)
                            EndIf
                            playsound_strict(buttonsfx)
                        EndIf
                        mousehit1 = $00
                    EndIf
                EndIf
            EndIf
        EndIf
    Next
    Return $00
End Function
