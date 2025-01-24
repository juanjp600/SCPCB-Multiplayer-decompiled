Function updatemyplayer%()
    Local local0.mp_player
    Local local1%
    local0 = ue_players[mp_getmyindex()]
    If (((local0 <> Null) And (0.0 = me\Field0)) <> 0) Then
        local0\Field7 = entityx(me\Field60, $00)
        local0\Field8 = entityy(me\Field60, $00)
        local0\Field9 = entityz(me\Field60, $00)
        local0\Field10 = entitypitch(camera, $00)
        local0\Field11 = entityyaw(camera, $00)
        local0\Field28 = me\Field42
        If (playerroom <> Null) Then
            local0\Field22 = playerroom\Field31
        EndIf
        local0\Field26 = $00
        If (selecteditem <> Null) Then
            local0\Field26 = selecteditem\Field19
        EndIf
        local0\Field29 = (((-16.0 < me\Field10) And (-6.0 > me\Field10)) Lor wi\Field7)
        For local1 = $00 To $04 Step $01
            myplayerlogic\Field1[local1] = $00
        Next
        If (i_427\Field0 <> 0) Then
            myplayerlogic\Field1[$03] = mp_findinventoryitem($14)
            If (myplayerlogic\Field1[$03] = $00) Then
                i_427\Field0 = $00
            EndIf
        EndIf
        If (i_714\Field0 > $00) Then
            myplayerlogic\Field1[$04] = mp_findinventoryitem(((i_714\Field0 + $1A) - $01))
            If (myplayerlogic\Field1[$04] = $00) Then
                i_714\Field0 = $00
            EndIf
        EndIf
        If (wi\Field2 > $00) Then
            myplayerlogic\Field1[$01] = mp_findinventoryitem(((wi\Field2 + $3C) - $01))
            If (myplayerlogic\Field1[$01] = $00) Then
                wi\Field2 = $00
            EndIf
            If (myplayerlogic\Field1[$01] = local0\Field26) Then
                local0\Field26 = $00
            EndIf
            Return $00
        EndIf
        If (wi\Field0 > $00) Then
            myplayerlogic\Field1[$00] = mp_findinventoryitem(((wi\Field0 + $38) - $01))
            If (myplayerlogic\Field1[$00] = $00) Then
                wi\Field0 = $00
            EndIf
        ElseIf (wi\Field5 > $00) Then
            myplayerlogic\Field1[$00] = mp_findinventoryitem(((wi\Field5 + $40) - $01))
            If (myplayerlogic\Field1[$00] = $00) Then
                wi\Field5 = $00
            EndIf
        ElseIf (wi\Field9 > $00) Then
            myplayerlogic\Field1[$00] = mp_findinventoryitem(((wi\Field9 + $43) - $01))
            If (myplayerlogic\Field1[$00] = $00) Then
                wi\Field9 = $00
            EndIf
        EndIf
        If (wi\Field3 > $00) Then
            myplayerlogic\Field1[$01] = mp_findinventoryitem(((wi\Field3 + $27) - $01))
            If (myplayerlogic\Field1[$01] = $00) Then
                wi\Field3 = $00
            EndIf
        EndIf
        If (wi\Field4 <> 0) Then
            myplayerlogic\Field1[$02] = mp_findinventoryitem($26)
            If (myplayerlogic\Field1[$02] = $00) Then
                wi\Field4 = $00
            EndIf
        ElseIf (i_268\Field0 > $00) Then
            myplayerlogic\Field1[$02] = mp_findinventoryitem(((i_268\Field0 + $0D) - $01))
            If (myplayerlogic\Field1[$02] = $00) Then
                i_268\Field0 = $00
            EndIf
        EndIf
        For local1 = $00 To $04 Step $01
            If (((myplayerlogic\Field1[local1] > $00) And (myplayerlogic\Field1[local1] = local0\Field26)) <> 0) Then
                local0\Field26 = $00
                Exit
            EndIf
        Next
    EndIf
    Return $00
End Function
