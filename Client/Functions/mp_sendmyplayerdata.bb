Function mp_sendmyplayerdata%()
    Local local0.mp_player
    Local local1%
    Local local2%
    If (mp_isconnected() = $00) Then
        Return $00
    EndIf
    ue_server\Field5 = (ue_server\Field5 + mp_gettimestep())
    If (1.166667 < ue_server\Field5) Then
        local0 = ue_players[mp_getmyindex()]
        If (local0 <> Null) Then
            mp_writebyte($04)
            mp_writebyte(mp_getmyindex())
            mp_writefloat(local0\Field7)
            mp_writefloat(local0\Field8)
            mp_writefloat(local0\Field9)
            mp_writeshort(convertfloattoshort(local0\Field10, 10.0))
            mp_writeshort(convertfloattoshort(local0\Field11, 10.0))
            mp_writebyte(local0\Field14)
            mp_writebyte(local0\Field22)
            mp_writebyte((((((((1.01 <= local0\Field28) + ((2.0 <= local0\Field28) Shl $01)) + (wi\Field7 Shl $02)) + ((myplayerlogic\Field4 <> Null) Shl $03)) + ((myplayerlogic\Field5 <> Null) Shl $04)) + ((myplayerlogic\Field2 > $00) Shl $05)) + ((local0\Field26 > $00) Shl $06)))
            mp_writebyte(((keydown(key\Field8) + ((-1.0 >= me\Field41) Shl $01)) + ((1.0 <= me\Field41) Shl $02)))
            mp_writebyte((Int me\Field31))
            mp_writeshort((Int me\Field14))
            local1 = $00
            If (myplayerlogic\Field4 <> Null) Then
                local1 = myplayerlogic\Field4\Field0\Field11[myplayerlogic\Field4\Field1]
                mp_writebyte(myplayerlogic\Field4\Field0\Field31)
                mp_writebyte(myplayerlogic\Field4\Field1)
                mp_writeshort(convertfloattoshort(entityroll(local1, $01), 10.0))
            EndIf
            If (myplayerlogic\Field5 <> Null) Then
                local1 = myplayerlogic\Field5\Field0\Field13[myplayerlogic\Field5\Field1]\Field0
                mp_writebyte(myplayerlogic\Field5\Field0\Field31)
                mp_writebyte(myplayerlogic\Field5\Field1)
                mp_writeshort(convertfloattoshort(entitypitch(local1, $01), 10.0))
            EndIf
            If (myplayerlogic\Field2 > $00) Then
                mp_writebyte(myplayerlogic\Field2)
                mp_writeshort(myplayerlogic\Field3)
            EndIf
            If (local0\Field26 > $00) Then
                mp_writeshort(local0\Field26)
            EndIf
            For local2 = $00 To $04 Step $01
                mp_writeshort(myplayerlogic\Field1[local2])
            Next
            mp_sendtoserver()
            ue_server\Field5 = 0.0
        EndIf
    EndIf
    Return $00
End Function
