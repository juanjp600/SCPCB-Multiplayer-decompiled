Function mp_server_sendeventsdata%()
    Local local0.events
    Local local1.mp_player
    mp_flushbuffer(mp_getdatabuffer())
    blitz_mp_writebyte0(mp_getdatabuffer(), isblackout)
    blitz_mp_writebyte0(mp_getdatabuffer(), soundtransmission)
    blitz_mp_writebyte0(mp_getdatabuffer(), remotedooron)
    For local0 = Each events
        If (local0\Field19 = $00) Then
            blitz_mp_writebyte0(mp_getdatabuffer(), local0\Field24)
            blitz_mp_writebyte0(mp_getdatabuffer(), (((0.0 <> local0\Field2) + ((0.0 <> local0\Field3) Shl $01)) + ((0.0 <> local0\Field4) Shl $02)))
            If (0.0 <> local0\Field2) Then
                blitz_mp_writefloat0(mp_getdatabuffer(), local0\Field2)
            EndIf
            If (0.0 <> local0\Field3) Then
                blitz_mp_writefloat0(mp_getdatabuffer(), local0\Field3)
            EndIf
            If (0.0 <> local0\Field4) Then
                blitz_mp_writefloat0(mp_getdatabuffer(), local0\Field4)
            EndIf
        EndIf
    Next
    blitz_mp_writebyte0(mp_getdatabuffer(), $00)
    For local1 = Each mp_player
        If (local1\Field5 > $01) Then
            mp_writebyte($06)
            mp_writebyte($04)
            mp_writebuffer(mp_getdatabuffer(), $00)
            mp_send(local1\Field0, local1\Field1)
        EndIf
    Next
    Return $00
End Function
