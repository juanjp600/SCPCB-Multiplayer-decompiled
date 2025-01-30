Function mp_client_receiveeventsdata%()
    Local local0%
    Local local1.events
    isblackout = mp_readbyte()
    soundtransmission = mp_readbyte()
    remotedooron = mp_readbyte()
    me\Field43 = (mp_readbyte() - $01)
    If ((mp_readbyte() And (me\Field43 <> $FFFFFFFF)) <> 0) Then
        me\Field0 = 1.0
    EndIf
    Repeat
        local0 = mp_readbyte()
        If (local0 = $00) Then
            Exit
        EndIf
        mp_client_receiveevent(local0)
    Forever
    For local1 = Each events
        If (((local1\Field28 = $00) And (local1\Field22 = $00)) <> 0) Then
            removeevent(local1)
        Else
            local1\Field28 = $00
        EndIf
    Next
    event_hasreceive = $01
    Return $00
End Function
