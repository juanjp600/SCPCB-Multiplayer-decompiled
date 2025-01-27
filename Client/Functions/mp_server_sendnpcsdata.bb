Function mp_server_sendnpcsdata%()
    Local local0.npcs
    Local local1%
    Local local2%
    Local local3.mp_player
    mp_flushbuffer(mp_getdatabuffer())
    blitz_mp_writebyte0(mp_getdatabuffer(), chs\Field2)
    blitz_mp_writebyte0(mp_getdatabuffer(), me\Field57)
    blitz_mp_writefloat0(mp_getdatabuffer(), mtftimer)
    If (n_i\Field8 <> Null) Then
        blitz_mp_writebyte0(mp_getdatabuffer(), n_i\Field8\Field5)
    Else
        blitz_mp_writebyte0(mp_getdatabuffer(), $00)
    EndIf
    If (n_i\Field9 <> Null) Then
        blitz_mp_writebyte0(mp_getdatabuffer(), n_i\Field9\Field5)
    Else
        blitz_mp_writebyte0(mp_getdatabuffer(), $00)
    EndIf
    For local0 = Each npcs
        If (local0\Field95 = $00) Then
            local1 = ((((((((local0\Field50 <> $00) + ((0.0 <> local0\Field10) Shl $01)) + ((0.0 <> local0\Field11) Shl $02)) + ((0.0 <> local0\Field12) Shl $03)) + ((0.0 <> local0\Field28) Shl $04)) + ((local0\Field34 <> Null) Shl $05)) + ((local0\Field67 <> $00) Shl $06)) + ((0.0 <> local0\Field26) Shl $07))
            local2 = ((((((((0.0 <> local0\Field36) Lor (0.0 <> local0\Field37)) Lor (0.0 <> local0\Field38)) + ((local0\Field62 > $00) Shl $01)) + ((local0\Field65 <> $00) Shl $02)) + ((local0\Field60 > $00) Shl $03)) + ((local0\Field87 <> $00) Shl $04)) + ((local0\Field43 <> $00) Shl $05))
            blitz_mp_writebyte0(mp_getdatabuffer(), local0\Field5)
            blitz_mp_writebyte0(mp_getdatabuffer(), local0\Field4)
            blitz_mp_writebyte0(mp_getdatabuffer(), local1)
            blitz_mp_writebyte0(mp_getdatabuffer(), local2)
            If (0.0 <> local0\Field10) Then
                blitz_mp_writefloat0(mp_getdatabuffer(), local0\Field10)
            EndIf
            If (0.0 <> local0\Field11) Then
                blitz_mp_writefloat0(mp_getdatabuffer(), local0\Field11)
            EndIf
            If (0.0 <> local0\Field12) Then
                blitz_mp_writefloat0(mp_getdatabuffer(), local0\Field12)
            EndIf
            If (0.0 <> local0\Field28) Then
                blitz_mp_writeshort0(mp_getdatabuffer(), convertfloattoshort(local0\Field28, 10.0))
            EndIf
            If (local0\Field34 <> Null) Then
                blitz_mp_writebyte0(mp_getdatabuffer(), local0\Field34\Field5)
            EndIf
            If (local0\Field67 <> $00) Then
                blitz_mp_writebyte0(mp_getdatabuffer(), local0\Field67)
                blitz_mp_writebyte0(mp_getdatabuffer(), local0\Field68)
            EndIf
            If (0.0 <> local0\Field26) Then
                blitz_mp_writeshort0(mp_getdatabuffer(), convertfloattoshort(local0\Field26, 10.0))
            EndIf
            If (readbool(local2, $00) <> 0) Then
                blitz_mp_writefloat0(mp_getdatabuffer(), local0\Field36)
                blitz_mp_writefloat0(mp_getdatabuffer(), local0\Field37)
                blitz_mp_writefloat0(mp_getdatabuffer(), local0\Field38)
            EndIf
            blitz_mp_writefloat0(mp_getdatabuffer(), entityx(local0\Field3, $01))
            blitz_mp_writefloat0(mp_getdatabuffer(), entityy(local0\Field3, $01))
            blitz_mp_writefloat0(mp_getdatabuffer(), entityz(local0\Field3, $01))
            blitz_mp_writeshort0(mp_getdatabuffer(), convertfloattoshort(entityyaw(local0\Field3, $01), 10.0))
            blitz_mp_writeshort0(mp_getdatabuffer(), convertfloattoshort(entityyaw(local0\Field0, $01), 10.0))
            blitz_mp_writeshort0(mp_getdatabuffer(), convertfloattounsignedshort(max(animtime(local0\Field0), 0.0), 10.0))
            blitz_mp_writeshort0(mp_getdatabuffer(), convertfloattounsignedshort(local0\Field84, 10.0))
            blitz_mp_writeshort0(mp_getdatabuffer(), convertfloattounsignedshort(local0\Field85, 10.0))
            blitz_mp_writeshort0(mp_getdatabuffer(), convertfloattoshort(local0\Field86, 100.0))
            If (local0\Field62 > $00) Then
                blitz_mp_writebyte0(mp_getdatabuffer(), local0\Field62)
            EndIf
            If (local0\Field60 > $00) Then
                blitz_mp_writeshort0(mp_getdatabuffer(), local0\Field60)
            EndIf
        EndIf
    Next
    blitz_mp_writebyte0(mp_getdatabuffer(), $00)
    For local3 = Each mp_player
        If (local3\Field5 > $01) Then
            mp_writebyte($06)
            mp_writebyte($03)
            mp_writebuffer(mp_getdatabuffer(), $00)
            mp_send(local3\Field0, local3\Field1)
        EndIf
    Next
    Return $00
End Function
