Function mp_client_receiveeventsdata%()
    Local local0%
    Local local1.events
    isblackout = mp_readbyte()
    soundtransmission = mp_readbyte()
    remotedooron = mp_readbyte()
    Repeat
        local0 = mp_readbyte()
        If (local0 = $00) Then
            Exit
        EndIf
        mp_client_receiveevent(local0)
    Forever
    For local1 = Each events
        If (((local1\Field25 = $00) And (local1\Field19 = $00)) <> 0) Then
            removeevent(local1)
        Else
            local1\Field25 = $00
        EndIf
    Next
    event_hasreceive = $01
    Return $00
End Function
